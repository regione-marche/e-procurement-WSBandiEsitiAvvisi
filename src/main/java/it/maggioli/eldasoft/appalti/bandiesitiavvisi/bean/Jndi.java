package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bean;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

/**
 * Classe che crea i bean di tutti gli Environment specificati nel context e che crea il DataSource
 * @author cmantini
 *
 */
@Configuration
public class Jndi {

	@Autowired
	private Environment template;
	
	@Bean
	public String authenticationToken() {
		return template.getProperty("authentication.token");
	}
	@Bean
	public String obbStazioneAppaltante() {
		return template.getProperty("stazioneAppaltante.filtro.obbligatorio");
	}
	@Bean
	public String areaShared() {
		return template.getProperty("application.filesystem.shared");
	}
	@Bean
	public String multiStazioneAppaltante() {
		return template.getProperty("rss.xml.multiStazioneAppaltante");
	}
	@Bean
	public String rssQuartzCronExpression() {
		return template.getProperty("rss.quartz.cronExpression");
	}
	@Bean
	public String urlWSPortale() {
		return template.getProperty("portaleAppalti.ws");
	}
	@Bean
	public String deltaGiorniBandi() {
		return template.getProperty("deltaGiorni.bandi");
	}
	@Bean
	public String rssFilenameBandi() {
		return template.getProperty("rss.filename.bandi");
	}
	@Bean
	public String channelLink() {
		return template.getProperty("rss.channel.link.bandi");
	}
	@Bean
	public String patternItemLink() {
		return template.getProperty("rss.item.linkTemplate.bandi");
	}
	@Bean
	public String deltaGiorniBandiScaduti() {
		return template.getProperty("deltaGiorni.bandiScaduti");
	}
	@Bean
	public String rssFilenameBandiScaduti() {
		return template.getProperty("rss.filename.bandiScaduti");
	}
	@Bean
	public String rssChannelLinkBandiScaduti() {
		return template.getProperty("rss.channel.link.bandiScaduti");
	}
	@Bean
	public String rssItemLinkTemplateBandiScaduti() {
		return template.getProperty("rss.item.linkTemplate.bandiScaduti");
	}
	@Bean
	public String templateLinkBeneficiari() {
		return template.getProperty("beneficiari.linkTemplate");
	}
	@Bean
	public String templateLinkConsulenti() {
		return template.getProperty("consulenti.linkTemplate");
	}

	@Bean
	public DataSource dataSource(@Value("${jndi.jndiName}") String jndiName) {
	    final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
	    dsLookup.setResourceRef(true);
	    return dsLookup.getDataSource(jndiName);
	} 
	
}
