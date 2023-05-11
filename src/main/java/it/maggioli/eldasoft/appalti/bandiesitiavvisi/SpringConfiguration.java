package it.maggioli.eldasoft.appalti.bandiesitiavvisi;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * Classe di configurazione:
 * <ul>
 * 	<li><strong>@ComponentScan:</strong> Scansiona tutte le classi nella folder della classe corrente
 *  e delle sottocartella alla ricerca di bean da istanziare</li>
 *  <li><strong>@EnableScheduling:</strong> Abilita la schedulazione di thread (vedi: @Scheduled)</li>
 *  <li><strong>@EnableTransactionManagement:</strong> Abilita la gestione delle transazioni tramite annotation (Vedi: @Transactional)</li>
 *  <li><strong>@PropertySource:</strong> Carica il file di properties specificato</li>
 *  <li><strong>@MapperScan:</strong> Scansiona i package e sottopacke del percorso specificato 
 *  alla ricerca di @Mapper MyBatis da caricare in memoria</li>
 * </ul>
 * 
 * 
 * @author cmantini
 *
 */
@Configuration
@ComponentScan
@EnableScheduling
@EnableTransactionManagement
@PropertySource("WEB-INF/classes/systemParams.properties")
@MapperScan("it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.mapper")
public class SpringConfiguration {

	@Autowired
	private DataSource dataSource;
	
	/**
	 * L'annotation @EnableTransactionManagement si aspetta questo bean.
	 * @return
	 */
	@Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
	
}
