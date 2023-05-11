package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.QuartzLockDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class QuartzLockManager {

	private static final Logger logger = LoggerFactory.getLogger(QuartzLockManager.class);
	
	@Autowired
	private QuartzLockDao quartzLockDao;
	
	/**
	 * Tenta di ottenere il lock esclusivo sull'esecuzione del job di Quartz in
	 * input.
	 * 
	 * @param codapp
	 *            codice applicazione
	 * @param jobClass
	 *            classe (comprensiva di package) del job da porre in esecuzione
	 * @param jobMethod
	 *            metodo della classe da porre in esecuzione
	 * @param server
	 *            indirizzo del server
	 * @param node
	 *            eventuale istanza in caso di pi&uagrave; nodi
	 * @return true se il lock esclusivo viene ottenuto inserendo l'occorrenza
	 *         in W_QUARTZLOCK, false altrimenti (&egrave; in corso l'esecuzione
	 *         da parte di un altro nodo/server)
	 */
	public synchronized boolean insertQuartzLock(String codapp,
			String jobClass, String jobMethod, String server, String node) {
		logger.debug("insertQuartzLock: inizio metodo");
		boolean lock = false;

		String job = jobClass + "." + jobMethod;

		try {
			// serve per comprendere se e' possibile procedere con la insert del lock esclusivo
			boolean isReleased = true;
			// serve per comprendere se esiste una riga nella tabella per il dato job
			boolean isLocked = this.quartzLockDao.isQuartzLock(codapp, job);
			if (isLocked) {
				// si calcola la massima data lock per la quale si procede in automatico
				// alla cancellazione se esiste il record: si suppone che un task attivo
				// da 2h sia stato fermato da un riavvio del server
				Calendar maxDataLock = Calendar.getInstance();
				maxDataLock.add(Calendar.HOUR, -2);
				// si rimuove l'eventuale lock esistente da piu' di 2 ore
				isReleased = this.quartzLockDao.deleteQuartzLockByDate(codapp,
						job, maxDataLock.getTime());
			}
			if (isReleased) {
				// si procede con l'ottenimento del lock esclusivo
				try {
					this.quartzLockDao.insertQuartzLock(codapp, job, new Date(),
							server, node);
				} catch (SQLException s) {
					logger.debug("lock presente non eseguo");
				}
				lock = true;
				// NOTA: la insert potrebbe andare in errore pur avendo
				// verificato l'assenza dell'occorrenza, in quanto ad esempio su
				// Oracle la insert effettuata da un'altra transazione non
				// ancora chiusa non causa il lock sul record in attesa dello
				// sblocco della transazione bensi' non si estrae alcuna
				// occorrenza
			} else {
				logger.debug("Esecuzione in corso {} su altro nodo", job);
			}
		} catch (DataIntegrityViolationException e) {
			logger.debug("Esecuzione in corso {} su altro nodo: {}", job, e.getMessage());
		} catch (DeadlockLoserDataAccessException e) {
			logger.error(
					String.format(
						"Interrotto causa deadlock l'ottenimento del lock esclusivo per %s",
								job)
					, e);
		}
		logger.debug("insertQuartzLock: fine metodo");
		return lock;
	}

	/**
	 * Rimuove il lock esclusivo per il job di Quartz in input.
	 * 
	 * @param codapp
	 *            codice applicazione
	 * @param jobClass
	 *            classe (comprensiva di package) del job da porre in esecuzione
	 * @param jobMethod
	 *            metodo della classe da porre in esecuzione
	 */
	public synchronized void deleteQuartzLock(String codapp, String jobClass,
			String jobMethod) {
		logger.debug("deleteQuartzLock: inizio metodo");
		this.quartzLockDao.deleteQuartzLock(codapp, jobClass + "." + jobMethod);
		logger.debug("deleteQuartzLock: fine metodo");
	}

}
