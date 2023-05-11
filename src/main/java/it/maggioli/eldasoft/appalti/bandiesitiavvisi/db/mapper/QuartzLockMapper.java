package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.Date;

/**
 * Interfaccia che rappresenta in java il QuartzLockMapper.xml, facendo l'autowired
 * è possibile effettuare le SELECT/INSERT/UPDATE... delle query nell'xml
 *  
 * @author cmantini
 *
 */
@Mapper
public interface QuartzLockMapper {

	public int isQuartzLock(
			  @Param("codapp") String codApp
			, @Param("job") String job);
	
	public int insertQuartzLock(
			  @Param("codapp") String codApp
			, @Param("job") String job
			, @Param("lockDate") Date lockDate
			, @Param("server") String server
			, @Param("node") String node) throws SQLException;
	
	public int deleteQuartzLock(
			  @Param("codapp") String codApp
			, @Param("job") String job);
	
	public int deleteQuartzLockByDate(
			@Param("codapp") String codApp
			, @Param("job") String job
			, @Param("maxLockDate") String maxLocDate);	//Il controllo è differente a seconda del db, quindi gli passo il controllo corretto
	
}
