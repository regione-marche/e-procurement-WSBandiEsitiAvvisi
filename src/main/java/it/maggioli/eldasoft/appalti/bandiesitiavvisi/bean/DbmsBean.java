package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.utils.DBMSSpecs;

/**
 * Semplice bean per mettere il tipo di database (ORA, POS, MSQ...) in un bean
 * @author cmantini
 *
 */
@Configuration
public class DbmsBean {

	@Autowired
	private DBMSSpecs dbmsSpecs;
	
	@Bean(name = "dbms")
	public String getDbms() {
		return dbmsSpecs.getInternalDbmsCode();
	}
	
}
