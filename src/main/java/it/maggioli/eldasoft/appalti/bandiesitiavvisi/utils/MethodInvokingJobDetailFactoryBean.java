/*
 * Created on 12/feb/2018
 *
 * Copyright (c) Maggioli S.p.A. - ELDASOFT
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di Maggioli S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di
 * aver prima formalizzato un accordo specifico con Maggioli.
 */
package it.maggioli.eldasoft.appalti.bandiesitiavvisi.utils;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl.QuartzLockManager;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl.tasks.GeneralRssFeedBandi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

// SORGENTE COPIATO DA it.eldasoft.gene.commons.web.spring.MethodInvokingJobDetailFactoryBean
/**
 * Wrapper dell'invoker di Spring per Quartz a cui si aggiunge la gestione della
 * mutua esclusione e unicit&agrave; delle esecuzioni in caso di pi&ugrave; nodi
 * (cluster) o pi&ugrave; server che eseguono gli stessi task a partire dallo
 * stesso DB.
 * 
 * @author Stefano.Sabbadin
 */
@Component
public class MethodInvokingJobDetailFactoryBean {

	private static final Logger logger = LoggerFactory.getLogger(MethodInvokingJobDetailFactoryBean.class);

	@Autowired
	private QuartzLockManager quartzLockManager;
	@Autowired
	private GeneralRssFeedBandi generalRssFeedBandi;

	/**
	 * Questo metodo viene fatto partire ogni volta che c'è un match con la cron specificata nel bean rssQuartzCronExpression
	 * che nel nostro caso è un Environment del context del tomcat.
	 */
	@Scheduled(cron = "#{@rssQuartzCronExpression}")
	public void invoke() {
		// si cerca di ottenere il nome del package+classe puro, e non il proxy
		// transazionale costruito da spring, altrimenti potrei non gestire
		// correttamente la mutua esclusione se il nome generato in altri nodi
		// risulta diverso
		String jobMethod = "refreshRssFeed";
		String jobClass = generalRssFeedBandi.getClass().getSimpleName();
		logger.debug("invoke(): inizio metodo per invocare il metodo {} sull'istanza di {}", jobMethod, jobClass);

		String codapp = "WSBEA";

		boolean locked = false;

		try {
			// indirizzo del nodo che esegue il task
			String server = InetAddress.getLocalHost().getHostName();
			// nome istanza del nodo che esegue il task nel caso di cluster, se
			// valorizzato con un parametro -DjvmRoute=...
			// NOTA: non ho trovato alcun modo per leggere l'attributo jvmRoute
			// definito nel server.xml di tomcat, pertanto l'unica
			// strada percorribile sarebbe introdurre ANCHE il valore mediante
			// parametro -D allo startup di tomcat
			String node = System.getProperty("jvmRoute");

			// tentare inserimento lock esclusivo
			locked = quartzLockManager.insertQuartzLock(codapp, jobClass, jobMethod,
					server, node);
			if (locked) {
				logger.debug("I've locked the quartz lock");
				// solo in caso di ottenimento del lock esclusivo si processa il
				// task, altrimenti se lo sta facendo un altro nodo viene
				// bypassata l'esecuzione
				generalRssFeedBandi.refreshRssFeed();
			} else
				logger.debug("Quartz lock has been already locked from someone");
		} catch (UnknownHostException e) {
			logger.error("Impossibile procedere all'esecuzione del task a causa di problemi di reperimento del nome server");
		} finally {
			if (locked) {
				quartzLockManager.deleteQuartzLock(codapp, jobClass, jobMethod);
				logger.debug("I've deleted the lock that i put on the quartz lock");
			}
		}

		logger.debug("invoke(): fine metodo");
	}
	
}
