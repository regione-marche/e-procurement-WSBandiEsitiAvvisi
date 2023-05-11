package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.mybatis;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.QuartzLockDao;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.mapper.QuartzLockMapper;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.utils.DBMSSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe di appoggio per l'esecuzione delle interazioni con la tabella
 * W_QUARTZLOCK.
 */
@Component
public class SqlMapQuartzLockDao implements QuartzLockDao {

	@Autowired
	private QuartzLockMapper quartzLockMapper;
	
    /** tipologia di DBMS da property */
	@Resource
    private String dbms;

    public boolean isQuartzLock(String codapp, String job) {
		int numRow = quartzLockMapper.isQuartzLock(codapp, job);
		// se si aggiorna in modo fittizio una riga allora vuol dire che esiste, altrimenti non esiste
		return numRow == 1;
	}

	public void insertQuartzLock(String codapp, String job, Date lockDate,
			String server, String node) throws SQLException {
		quartzLockMapper.insertQuartzLock(codapp, job, lockDate, server, node);
	}

	public void deleteQuartzLock(String codapp, String job) {
		quartzLockMapper.deleteQuartzLock(codapp, job);
	}

	public boolean deleteQuartzLockByDate(String codapp, String job, Date maxLockDate) {
		// http://www-01.ibm.com/support/docview.wss?uid=swg21207965
		// le statement sql per sql server funzionano, le prepared statement creano dei deadlock in caso di esecuzione concorrente pertanto si creano gli sql esatti
		String maxLockDateAsString =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(maxLockDate);
		String maxLockDateSQL = null;
		if (DBMSSpecs.DATABASE_SQL_SERVER.equals(this.dbms)) {
			// SQL SERVER
			maxLockDateSQL = "CONVERT(DATETIME, '" + maxLockDateAsString + "', 120)";
	    } else if (DBMSSpecs.DATABASE_DB2.equals(this.dbms)) {
	        // DB2
	    	maxLockDateSQL = "TIMESTAMP_FORMAT('" + maxLockDateAsString + "', 'RRRR-MM-DD HH24:MI:SS')";
		} else {
			// ORACLE
			// POSTGRESQL
			maxLockDateSQL = "TO_DATE('" + maxLockDateAsString + "', 'YYYY-MM-DD HH24:MI:SS')";
		}
		int numRow = quartzLockMapper.deleteQuartzLockByDate(codapp, job, maxLockDateSQL);
		// se e' stata cancellata la riga allora e' stato rimosso il lock
		return numRow == 1;
	}
}
