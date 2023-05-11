package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao;

import java.sql.SQLException;
import java.util.Date;

/**
 * Interfaccia DAO per l'accesso ai dati della tabella W_QUARTZLOCK.
 * 
 */
public interface QuartzLockDao {

	/**
	 * Testa la presenza del lock sul task indicato mediante update fittizia.
	 * 
	 * @param codapp
	 *            codice applicazione
	 * @param job
	 *            job Spring/Quartz
	 * @return true se il record esiste, false altrimenti
	 * @throws DataAccessException
	 */
	boolean isQuartzLock(String codapp, String job);
	
	/**
	 * Il nodo ottiene il lock esclusivo sul task da eseguire.
	 * 
	 * @param codapp
	 *            codice applicazione
	 * @param job
	 *            job Spring/Quartz da eseguire
	 * @param lockDate
	 *            data/ora di ottenimento del lock
	 * @param server
	 *            indirizzo del server
	 * @param node
	 *            eventuale istanza in caso di pi&uagrave; nodi
	 * @throws DataAccessException
	 *             eccezione ritornata nel caso di chiave duplicata e pertanto
	 *             lock gi&agrave; ottenuto da un altro nodo in esecuzione
	 */
	void insertQuartzLock(String codapp, String job, Date lockDate,
			String server, String node) throws SQLException;

	/**
	 * Rilascia il lock esclusivo sul task terminato.
	 * 
	 * @param codapp
	 *            codice applicazione
	 * @param job
	 *            job Spring/Quartz eseguito
	 * @throws DataAccessException
	 */
	void deleteQuartzLock(String codapp, String job);

	/**
	 * Rimuove il lock sul task iniziato prima di una certa data/ora e mai
	 * terminato.
	 * 
	 * @param codapp
	 *            codice applicazione
	 * @param job
	 *            job Spring/Quartz eseguito
	 * @param maxLockDate
	 *            data massima di ottenimento del lock
	 * 
	 * @return true se il record era presente ed e' stato rimosso, false se non
	 *         e' stato rimosso (non esistente oppure iniziato oltre la data/ora
	 *         in input)
	 *
	 * @throws DataAccessException
	 */
	boolean deleteQuartzLockByDate(String codapp, String job, Date maxLockDate);
}