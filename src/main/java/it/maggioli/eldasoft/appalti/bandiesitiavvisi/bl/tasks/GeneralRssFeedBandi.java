package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl.tasks;

import it.eldasoft.www.PortaleAlice.EsitoOutType;
import it.eldasoft.www.PortaleAlice.PortaleAliceProxy;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
public class GeneralRssFeedBandi implements ServletContextAware {

	private static final Logger logger = LoggerFactory.getLogger(GeneralRssFeedBandi.class);

	private static final String ZIP_FILENAME = "feedRSS.zip";
	
	@Autowired
	@Qualifier(value = "RssFeedBandi")
	private AbstractRssFeedBandi rssBandi;
	@Autowired
	@Qualifier(value = "RssFeedBandiScaduti")
	private AbstractRssFeedBandi rssBandiScaduti;

	/** 
	 * Path in cui salvare i feed RSS in caso non si scegliesse il path di default
	 * **/
	@Resource
	private String areaShared;
	@Resource
	private String urlWSPortale;
	
	
	private ServletContext context;

	public void setServletContext(ServletContext context) {
		this.context = context;

	}

	/**
	 * Metodo che permette di aggiornare i feed RSS per bandi attivi e bandi
	 * scaduti.
	 * <ul>
	 * <li>FASE 1 : backup degli ultimi feed validi</li>
	 * <li>FASE 2 : generazione dei feed e loro scrittura a file system e/o file
	 * zip</li>
	 * <li>FASE 3 : a seguito della generazione dei nuovi feed RSS l'area di
	 * backup viene pulita</li>
	 * <li>FASE 4 : invio a portale dei feed generati</li>
	 * </ul>
	 * 
	 * @return boolean esito dell'operazione di refresh dei feed RSS
	 */
	public void refreshRssFeed() {
		List<String> zipEntries = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		boolean esitoOK = true;

		logger.debug("refreshRssFeed: inizio metodo");
		
		// FASE 1 : Backup di tutti i file della struttura shared
		// se tutto è andato bene mi troverò con una cartella di backup e una di destinazione per i feed
		esitoOK = backupShared();  

		// FASE 2 : generazione dei feed
		if (esitoOK) {
			if (StringUtils.isNotEmpty(this.urlWSPortale)) {
				// Creo l'oggetto zip in cui andare a inserire i file gi� pronti
				// per l'invio con la corretta alberatura
				try {
					ZipOutputStream zos = new ZipOutputStream(baos);
					zipEntries = new ArrayList<>();
					// Setto il nome del file zip
					zos.putNextEntry(new ZipEntry(ZIP_FILENAME));

					// genero i feed opportunamente
					esitoOK = this.rssBandi.refreshRssFeed(zos, zipEntries)
							&& this.rssBandiScaduti.refreshRssFeed(zos,
									zipEntries);

					// Chiusura dello zip
					zos.close();
				} catch (IOException e) {
					esitoOK = false;
					logger.error("Errore nella creazione dello zip : impossibile creare il file {}", ZIP_FILENAME);
				}

			} else {
				// Nessuna integrazione con portale => restano scritti su file system
				esitoOK = this.rssBandi.refreshRssFeed(null, null) && this.rssBandiScaduti.refreshRssFeed(null, null);
			}
		}

		//FASE 3 : pulizia backup dei feed RSS oppure ripristino dei file precedenti
		File dirBackup = new File(new File(this.getBasePath()).getPath() + "_backup");
		if (esitoOK) {
			try {
				FileUtils.deleteDirectory(dirBackup);
			} catch (IOException e) {
				logger.error(
						"Errore durante la rimozione della cartella di backup " + dirBackup.getPath(), e);
			}
		} else {
			File dirDestinazione = new File(this.getBasePath());
			dirDestinazione.delete();
			if (dirBackup.exists()) {
				dirBackup.renameTo(new File(this.getBasePath()));
			}
		}

		//FASE 4 : invio dati in formato compresso (zip) 
		if(esitoOK && StringUtils.isNotEmpty(this.urlWSPortale)){
			//invio se presente integrazione con portale
			PortaleAliceProxy proxy = new PortaleAliceProxy();
			proxy.setEndpoint(this.urlWSPortale);
			try {
				EsitoOutType esitoWS = proxy.uploadRssBandi(baos.toByteArray());
				if (esitoWS.getCodiceErrore() != null) {
					logger.error("Errore durante la chiamata al servizio portale appalti : {}", esitoWS.getCodiceErrore()); 
					esitoOK = false; 
				}
			} catch (RemoteException e) {
				logger.error("Errore inaspettato durante la chiamata al servizio portale appalti", e); 
				esitoOK = false; 
			} 
		}
		logger.debug("refreshRssFeed: fine metodo");
	}

	/** Metodo che permette di effettuare il backup dei feed precedentemente creati
	 * @return boolean
	 * 		esito dell'operazione di backup 
	 **/
	private boolean backupShared(){
		boolean esito = true;

		synchronized (this) {
			
			File dirDestinazione = new File(this.getBasePath());
			File dirBackup = null;
			boolean esisteDirDestinazione = dirDestinazione.isDirectory();

			if (esisteDirDestinazione) {
				// backup del contenuto rinominando il nome della cartella
				dirBackup = new File(dirDestinazione.getPath()+"_"+"backup");
				if (!dirDestinazione.renameTo(dirBackup)) {
					logger.error("Impossibile spostare la cartella {} in {}", dirDestinazione.getPath(), dirBackup.getPath());
					esito = false;
				} else {
					// ricreo la referenza alla cartella destinazione, che ora
					// non esistera' piu'
					dirDestinazione = new File(this.getBasePath());
				}
			}

			if (esito) {
				// si crea la cartella
				if (!dirDestinazione.mkdirs()) {
					esito = false;
				}
			}
		}

		return esito;
	}

	private String getBasePath(){
		if(StringUtils.isEmpty(this.areaShared)){
			return this.context.getRealPath("/rss");
		}
		return this.areaShared;	
	}
}
