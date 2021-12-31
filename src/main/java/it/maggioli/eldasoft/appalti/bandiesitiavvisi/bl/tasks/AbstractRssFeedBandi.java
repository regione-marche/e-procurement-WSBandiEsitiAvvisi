/*
 * Created on 28/set/11
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */
package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl.tasks;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl.BandiEsitiAvvisiManager;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo.CostantiBando;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.web.context.ServletContextAware;

import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

/**
 * Classe astratta per la definizione dell'algoritmo di produzione del file xml
 * per i feed rss sui bandi. Il feed rss &egrave; 2.0 in italiano.
 * 
 * @author Stefano.Sabbadin
 */
abstract class AbstractRssFeedBandi implements ServletContextAware {

	Logger logger = Logger.getLogger(AbstractRssFeedBandi.class);

	private ServletContext context;

	/** Manager per l'accesso ai dati su bandi/esiti/avvisi */
	private BandiEsitiAvvisiManager bandiManager;

	/**
	 * filename feed rss
	 */
	private String rssFilenameBandi;

	/** 
	 * Path in cui salvare i feed RSS in caso non si scegliesse il path di default
	 * **/
	private String areaShared;

	/**
	 * 1 = si gestiscono pi&ugrave; stazioni appaltanti in un file, 0 ogni
	 * stazione appaltante avr&agrave; in file per se stessa
	 */
	private String multiStazioneAppaltante;
	
	/**
	 * link alla pagina dell'applicativo fruitore del servizio per l'apertura
	 * della lista dei dati contenuti nel canale
	 */
	private String channelLink;

	/** titolo del canale */
	private String channelTitle;

	/** descrizione del canale */
	private String channelDescription;

	/**
	 * pattern del link per l'apertura del dettaglio di una news (item) del
	 * canale all'interno dell'applicativo fruitore del servizio
	 */
	private String patternItemLink;

	/** Lista dei codici fiscali delle stazioni appaltanti per cui generare i file. */
	private List<String> listaStazioniAppaltanti = new ArrayList<String>();

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	/**
	 * @return the manager
	 */
	public BandiEsitiAvvisiManager getBandiManager() {
		return bandiManager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setBandiManager(BandiEsitiAvvisiManager manager) {
		this.bandiManager = manager;
	}

	/**
	 * @param filenameRssFeed
	 *            the filenameRssFeed to set
	 */
	public void setRssFilenameBandi(String rssFilenameBandi) {
		this.rssFilenameBandi = rssFilenameBandi;
	}
	/**
	 * @param areaShared
	 *            the areaShared to set
	 */
	public void setAreaShared(String areaShared) {
		this.areaShared = areaShared;
	}

	//
	public void setMultiStazioneAppaltante(String multiStazioneAppaltante) {
		this.multiStazioneAppaltante = multiStazioneAppaltante;
	}

	/**
	 * @param channelLink
	 *            the channelLink to set
	 */
	public void setChannelLink(String channelLink) {
		this.channelLink = channelLink;
	}

	/**
	 * @param channelTitle
	 *            the channelTitle to set
	 */
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	/**
	 * @param channelDescription
	 *            the channelDescription to set
	 */
	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}

	/**
	 * @param patternItemLink
	 *            the patternItemLink to set
	 */
	public void setPatternItemLink(String patternItemLink) {
		this.patternItemLink = patternItemLink;
	}

	/**
	 * Genera ed aggiorna i feed rss
	 * 
	 * @param ZipOutputStream 
	 * 		stream eventuale di scrittura per il file zip
	 * @param List<String>
	 * 		eventuale lista delle stazioni appaltanti già memorizzate com directory all'interno del file zip
	 * 
	 * @return boolean
	 * 		esito dell'operazione di refresh dei feed RSS
	 **/
	public boolean refreshRssFeed(ZipOutputStream zos, List<String> zipEntries) {

		boolean esito = true;

		try {
			// si estraggono gli elementi da porre come item del canale
			List<DettaglioBandoType> bandi = null;

			if ("0".equals(this.multiStazioneAppaltante)) {
				//recupero la lista dei codici fiscali delle stazioni appaltanti
				listaStazioniAppaltanti = this.getElencoStazioniAppaltanti();

				for (int k = 0; k < listaStazioniAppaltanti.size(); k++) {

					// Recupero i bandi per la stazione appaltante corrente
					bandi = this.getElencoBandi(listaStazioniAppaltanti.get(k));
					SyndFeed feed = this.createRssFeedChannel();
					List<SyndEntry> entries = new ArrayList<SyndEntry>();

					for (int i = 0; i < bandi.size(); i++) {
						this.addRssFeedItem(bandi.get(i), entries);
					}
					feed.setEntries(entries);
					esito = esito && this.updateRssFileSingolaStazioneAppaltante(
							feed, listaStazioniAppaltanti.get(k), zos, zipEntries);
				}
			} else {
				bandi = this.getElencoBandi(null);

				// si crea il canale del feed rss
				SyndFeed feed = this.createRssFeedChannel();

				// si estrae il dettaglio di ogni bando
				if (bandi != null) {
					List<SyndEntry> entries = new ArrayList<SyndEntry>();
					for (Iterator<DettaglioBandoType> iterator = bandi.iterator(); iterator
							.hasNext();) {
						this.addRssFeedItem(iterator.next(), entries);
					}
					feed.setEntries(entries);
				}

				// si salva su file xml il feed rss
				this.updateRssFile(zos,feed,zipEntries);
			}
		} catch (DataAccessException e) {
			logger.error("Impossibile produrre il feed rss "
					+ this.rssFilenameBandi
					+ " per problemi di interrogazione della base dati", e);
			esito = false;
		} catch (UnsupportedEncodingException e) {
			// questa eccezione non dovrebbe verificarsi mai in quanto la
			// codifica del file da scrivere e' fissata da codice
			logger.error("Impossibile produrre il feed rss "
					+ this.rssFilenameBandi + " per problemi di encoding", e);
			esito = false;
		} catch (FileNotFoundException e) {
			logger.error(
					"Impossibile produrre il feed rss "
							+ this.rssFilenameBandi
							+ " per problemi di path del file; ricontrollare la configurazione nel file WEB-INF/classes/systemParams.properties",
							e);
			esito = false;
		} catch (IOException e) {
			logger.error("Impossibile produrre il feed rss "
					+ this.rssFilenameBandi
					+ " per problemi di scrittura del file", e);
			esito = false;
		} catch (FeedException e) {
			logger.error(
					"Impossibile produrre il feed rss "
							+ this.rssFilenameBandi
							+ " per problemi di serializzazione dell'xml contenente il feed rss",
							e);
			esito = false;
		}

		return esito;
	}


	/** Metodo per estrarre l'elenco degli elementi da porre nel canale rss 
	 *
	 *@param String
	 *		codice fiscale della stazione appaltante per cui estrarre i bandi
	 *@return List<DettaglioBandoType>
	 *		lista dei bandi relativi alla stazione appaltante  
	 **/
	public abstract List<DettaglioBandoType> getElencoBandi(String codiceFiscaleAmministrazione);

	/** Metodo per estrarre l'elenco delle stazioni appaltanti
	 * 
	 * @return List<String>
	 * 		Lista contenente i codici fiscali delle stazioni appaltanti
	 **/
	public List<String> getElencoStazioniAppaltanti(){
		return this.getBandiManager().getElencoStazioniAppaltanti();
	}

	/** -WE746 **/

	/**
	 * Crea la testata del feed rss
	 * 
	 * @return testata del feed rss rappresentante il canale
	 */
	private SyndFeed createRssFeedChannel() {
		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType("rss_2.0");
		feed.setLanguage("it");
		feed.setTitle(this.channelTitle);
		feed.setDescription(this.channelDescription);
		feed.setLink(this.channelLink);
		return feed;
	}

	/**
	 * Aggiunge all'interno del feed rss il bando in input.
	 * 
	 * @param bando
	 *            dettaglio del bando da inserire nel feed rss
	 * @param entries
	 *            elenco delle entries del feed rss da popolare
	 */
	private void addRssFeedItem(DettaglioBandoType bando,
			List<SyndEntry> entries) {
		SyndEntry entry = new SyndEntryImpl();
		String title = null;
		if (CostantiBando.TIPOLOGIA_AVVISO.equals(bando.getTipo()))
			title = bando.getTipo()
			+ (bando.getContratto() != null ? " per "
					+ bando.getContratto() : "");
		else {
			title = bando.getTipo()
					+ " di gara per "
					+ bando.getContratto()
					+ (bando.getCig() != null ? " - CIG: " + bando.getCig()
							: "");
		}
		entry.setTitle(title);

		SyndContent description = new SyndContentImpl();
		description.setType("text/html");
		description.setValue("Ente: " + bando.getAmministrazione()
				+ (bando.getTitolo() != null ? " - " + bando.getTitolo() : ""));
		entry.setDescription(description);

		entry.setLink(StringUtils.replace(
				StringUtils.replace(this.patternItemLink, "{0}",
						bando.getCodice()), "{1}", bando.getTipo()));
		entry.setPublishedDate(bando.getPubblicazione());

		List<SyndCategory> categories = new ArrayList<SyndCategory>();
		SyndCategory category = new SyndCategoryImpl();
		category.setName(bando.getTipo());
		categories.add(category);
		category = new SyndCategoryImpl();
		category.setName(bando.getContratto());
		categories.add(category);
		entry.setCategories(categories);

		entries.add(entry);
	}

	/**
	 * Aggiornamento di un feed RSS
	 * 
	 * @param ZipOutputStream 
	 * 		stream di scrittura per il file zip
	 * @param SyndFeed
	 *      dati del feed rss (canali + item)
	 * @param List<String>
	 * 		lista delle stazioni appaltanti già memorizzate com directory all'interno del file zip
	 * 
	 * @return boolean
	 * 		esito dell'operazione di aggiornamento
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws FeedException
	 */
	private boolean updateRssFile(ZipOutputStream zos, SyndFeed feed,
			List<String> zipEntries) throws UnsupportedEncodingException,
			FileNotFoundException, IOException, FeedException {

		boolean esito = writeFiles(feed, null);

		if (esito && zos != null) {
			// scrittura su zip (integrazione con portale presente)
			writeZIP(feed, null, zos, zipEntries);
		}

		return esito;
	}

	/**
	 * Aggiornamento di un feed RSS data una particolare stazione appaltante
	 * 
	 * @param SyndFeed
	 *            dati del feed rss (canali + item)
	 * @param cfStazioneAppaltante
	 *            codice fiscale della stazione appaltante
	 * @param ZipOutputStream
	 *            stream di scrittura per il file zip
	 * @param List
	 *            <String> lista delle stazioni appaltanti già memorizzate com
	 *            directory all'interno del file zip
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws FeedException
	 */
	private boolean updateRssFileSingolaStazioneAppaltante(SyndFeed feed,
			String cfStazioneAppaltante, ZipOutputStream zos,
			List<String> zipEntries) throws UnsupportedEncodingException,
			FileNotFoundException, IOException, FeedException {
		boolean esito = writeFiles(feed, cfStazioneAppaltante);

		if (esito && zos != null) {
			// integrazione con portale
			writeZIP(feed, cfStazioneAppaltante, zos, zipEntries);
		}

		return esito;
	}

	/**
	 * Metodo che permette di aggiungere un feed RSS ad uno zip
	 * 
	 * @param SyndFeed 
	 * 		il feed da scrivere su file
	 * @param String cfStazioneAppaltante 
	 * 		il codice fiscale della stazione appaltante per cui quel feed è stato generato
	 * @param ZipOutputStream
	 * 		stream di scrittura per lo zip
	 * @param List<String>
	 * 		lista delle stazioni appaltanti già memorizzate com directory all'interno del file zip
	 * 
	 * @return boolean esito della scrittura su zip del feed RSS
	 */
	private void writeZIP(SyndFeed feed, String cfStazioneAppaltante, ZipOutputStream zos, List<String> zipEntries) throws IOException, FeedException {
		Writer writer              = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		SyndFeedOutput output      = new SyndFeedOutput();

		writer = new OutputStreamWriter(baos, "UTF-8");

		if(StringUtils.isNotEmpty(StringUtils.stripToNull(cfStazioneAppaltante)) && !zipEntries.contains(cfStazioneAppaltante) ){		
			zipEntries.add(cfStazioneAppaltante);
			zos.putNextEntry(new ZipEntry(cfStazioneAppaltante+"/")); //Aggiungo la barra alla fine per poter distinguere una dir da un file al momento dell'unzip
			zos.closeEntry();
			zos.flush();
		}

		output.output(feed, writer);
		if(StringUtils.isNotEmpty(StringUtils.stripToNull(cfStazioneAppaltante))){
			zos.putNextEntry(new ZipEntry(cfStazioneAppaltante+File.separator+this.rssFilenameBandi));
		}else{
			zos.putNextEntry(new ZipEntry(this.rssFilenameBandi));
		}
		zos.write(baos.toByteArray(), 0 , baos.size());
		writer.close();	
		zos.setMethod(ZipOutputStream.DEFLATED);
		zos.setLevel(Deflater.DEFAULT_COMPRESSION);
		zos.closeEntry();
		zos.flush();
	}

	
	/**
	 * Metodo che permette di scrivere su file system un feed
	 * 
	 * @param SyndFeed 
	 * 		il feed da scrivere su file
	 * @param String cfStazioneAppaltante 
	 * 		il codice fiscale della stazione appaltante per cui quel feed è stato generato
	 * 
	 * @return boolean esito della scrittura su file system del feed RSS
	 */
	private boolean writeFiles(SyndFeed feed, String cfStazioneAppaltante) throws UnsupportedEncodingException, FileNotFoundException, IOException, FeedException {
		boolean esito = true;
		Writer writer = null;
		String path = getBasePath();
		if(StringUtils.isNotEmpty(StringUtils.stripToNull(cfStazioneAppaltante))){
			path += cfStazioneAppaltante;
		}

		boolean createdDir = new File(path).exists();
		if (!createdDir) {
			createdDir = new File(path).mkdirs();
		}

		if (createdDir) {
				writer = new OutputStreamWriter(new FileOutputStream(path
						+ File.separator + this.rssFilenameBandi), "UTF-8");
				SyndFeedOutput output = new SyndFeedOutput();
				output.output(feed, writer);
				writer.close();
		} else {
			logger.error("Impossibile creare il feed rss nel path " + path);
			esito = false;
		}

		return esito;
	}

	protected String getBasePath(){
		if(StringUtils.isEmpty(StringUtils.stripToNull(this.areaShared))){
			return this.context.getRealPath("/rss")+ File.separator;
		}
		return this.areaShared + File.separator;	
	}
}
