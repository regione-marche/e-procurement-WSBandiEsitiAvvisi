/*
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo.CostantiBando;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulentiCollaboratoriOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiBeneficiarioOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiConsulentiCollaboratoriOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoBandoOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.FileType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoBeneficiariOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattiOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoGareContrattiAnticorruzioneOutType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.VersionOutType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

/**
 * Centralizzazione della logica delle chiamate del web service
 * 
 * @author Stefano.Sabbadin
 */
public class BandiEsitiAvvisiFacade {

	Logger logger = Logger.getLogger(BandiEsitiAvvisiFacade.class);

	private String obbStazioneAppaltante;

	private BandiEsitiAvvisiManager bandiManager;

	/**
	 * Token di autenticazione fissato dall'applicativo se da richiedere ad ogni
	 * chiamata del servizio, null o stringa vuota altrimenti
	 */
	private String authenticationToken;

	/** Template link per l'apertura dell'elenco documenti beneficiario. */
	private String templateLinkBeneficiari;
	
	/** Template link per l'apertura dell'elenco documenti consulente. */
	private String templateLinkConsulenti;

	
	public void setBandiManager(BandiEsitiAvvisiManager bandiManager) {
		this.bandiManager = bandiManager;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = StringUtils.stripToNull(authenticationToken);
	}

	public void setObbStazioneAppaltante(String obbStazioneAppaltante){
		this.obbStazioneAppaltante = StringUtils.stripToNull(obbStazioneAppaltante);
	}

	public void setTemplateLinkBeneficiari(String templateLinkBeneficiari) {
		this.templateLinkBeneficiari = templateLinkBeneficiari;
	}
	
	public void setTemplateLinkConsulenti(String templateLinkConsulenti) {
		this.templateLinkConsulenti = templateLinkConsulenti;
	}

	/**
	 * Ritorna la versione del servizio
	 * 
	 * @return versione del servizio
	 */
	public VersionOutType getVersion() {
		if (logger.isDebugEnabled()) {
			logger.debug("version(): inizio metodo");
		}
		
		VersionOutType risultato = new VersionOutType();
		
		try {
			String[] path = this.getClass().getClassLoader().getResource("").getPath().split("/WEB-INF/classes");
			String appPath = (path != null ? path[0] : "");	
			appPath = appPath.replaceAll("%20", "\\ ");
			
		    BufferedReader br = new BufferedReader(new FileReader(new File(appPath + "/WEB-INF/WSBEA_VER.TXT")));
		    String version = "";
	        String s;
	        while((s = br.readLine()) != null) {
	        	if(s != null) {
	        		version += s + "\n";
	        	}
	        }	
			risultato.setVersion(version);
		} catch (Exception e) {
			logger.error(
					"Errore inaspettato durante l'interazione con la base dati",
					e);
			risultato.setErrore(e.getMessage());
		} 
		
		if (logger.isDebugEnabled())
			logger.debug("version: fine metodo");

		return risultato;
	}
	
	/**
	 * Ritorna l'elenco dei bandi, o esiti o avvisi filtrati per contratto. Se i
	 * parametri non sono valorizzati, si estraggono tutte le occorrenze In caso
	 * di parametri non valorizzati correttamente, ritorna un errore.
	 * 
	 * @param token
	 *            token eventuale di autenticazione
	 * @param tipo
	 *            tipologia di elenco da estrarre. I valori ammessi sono:
	 *            <ul>
	 *            <li>Bando</li>
	 *            <li>Esito</li>
	 *            <li>Avviso</li>
	 *            </ul>
	 * @param contratto
	 *            tipologia di contratto da estrarre. I valori ammessi sono:
	 *            <ul>
	 *            <li>Lavori</li>
	 *            <li>Forniture</li>
	 *            <li>Servizi</li>
	 *            </ul>
	 * @param dataPubblicazioneDa
	 *            data pubblicazione a partire da
	 * @param dataPubblicazioneA
	 *            data pubblicazione fino a
	 * @param cig
	 *            codice cig
	 * @param codiceStazAppaltante
	 *            codice fiscale stazione appaltante
	 * @return lista di bandi in corso eventualmente filtrati a seconda dei
	 *         parametri in input specificati
	 */
	public ElencoBandiOutType getElencoBandi(String token, String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante) {

		if (logger.isDebugEnabled()) {
			logger.debug("elencoBandi(" + token + "," + tipo + "," + contratto
					+ "," + dataPubblicazioneDa + "," + dataPubblicazioneA
					+ "," + cig + "," + codiceStazAppaltante
					+ "): inizio metodo");
		}

		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);
		tipo = StringUtils.stripToNull(tipo);
		contratto = StringUtils.stripToNull(contratto);
		codiceStazAppaltante = StringUtils.stripToNull(codiceStazAppaltante);
		cig = StringUtils.stripToNull(cig);


		ElencoBandiOutType risultato = new ElencoBandiOutType();

		// si effettua un controllo preventivo dei parametri generando un errore
		// in caso di codifica non prevista

		boolean continua = true;

		if (continua && (this.authenticationToken != null
				&& !this.authenticationToken.equals(token))) {
			risultato.setErrore("Parametro token non impostato o non valido");
			continua = false;
		}

		if (continua && (!CostantiBando.TIPOLOGIA_BANDO.equals(tipo)
				&& !CostantiBando.TIPOLOGIA_ESITO.equals(tipo)
				&& !CostantiBando.TIPOLOGIA_AVVISO.equals(tipo))){
			risultato.setErrore("Parametro tipo non impostato o non valido");
			continua = false;
		}

		if (continua && (contratto != null
				&& !CostantiBando.CONTRATTO_LAVORI.equals(contratto)
				&& !CostantiBando.CONTRATTO_FORNITURE.equals(contratto)
				&& !CostantiBando.CONTRATTO_SERVIZI.equals(contratto))){
			risultato.setErrore("Parametro contratto non valido");
			continua = false;
		}

		//controlli su obbligatorietà stazione appaltante
		if(continua){
			if(StringUtils.isEmpty(this.obbStazioneAppaltante)){
				risultato.setErrore("Parametro obbligatorieta' stazione appaltante non configurato");
				continua = false;
			}

			if(continua && ("1".equals(this.obbStazioneAppaltante) && StringUtils.isEmpty(codiceStazAppaltante))){
				risultato.setErrore("Parametro codice fiscale della stazione appaltante non impostato");
				continua = false;
			}
		}

		if(continua) {
			if (this.authenticationToken != null && logger.isInfoEnabled())
				logger.info("Lista bandi richiesta per la stazione appaltante "
						+ codiceStazAppaltante);
			// se i parametri sono corretti, si procede con l'inoltro della
			// chiamata
			try {
				List<BandoListaType> elencoBandi = this.bandiManager
						.getElencoBandi(tipo, contratto, dataPubblicazioneDa,
								dataPubblicazioneA, cig, codiceStazAppaltante);
				risultato
				.setBando(elencoBandi.toArray(new BandoListaType[] {}));
				risultato.setNumBandi(new Integer(elencoBandi.size()));
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("elencoBandi: fine metodo");

		return risultato;
	}

	/**
	 * Ritorna l'elenco dei bandi o avvisi scaduti filtrati per contratto. Se i
	 * parametri non sono valorizzati, si estraggono tutte le occorrenze In caso
	 * di parametri non valorizzati correttamente, ritorna un errore.
	 * 
	 * @param token
	 *            token eventuale di autenticazione
	 * @param tipo
	 *            tipologia di elenco da estrarre. I valori ammessi sono:
	 *            <ul>
	 *            <li>Bando</li>
	 *            <li>Avviso</li>
	 *            </ul>
	 * @param contratto
	 *            tipologia di contratto da estrarre. I valori ammessi sono:
	 *            <ul>
	 *            <li>Lavori</li>
	 *            <li>Forniture</li>
	 *            <li>Servizi</li>
	 *            </ul>
	 * @param dataPubblicazioneDa
	 *            data pubblicazione a partire da
	 * @param dataPubblicazioneA
	 *            data pubblicazione fino a
	 * @param cig
	 *            codice cig
	 * @param codiceStazAppaltante
	 *            codice fiscale stazione appaltante
	 * @return lista di bandi scaduti eventualmente filtrati a seconda dei
	 *         parametri in input specificati
	 */
	public ElencoBandiOutType getElencoBandiScaduti(String token, String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante) {
		if (logger.isDebugEnabled()) {
			logger.debug("elencoBandiScaduti(" + token + "," + tipo + ","
					+ contratto + "," + dataPubblicazioneDa + ","
					+ dataPubblicazioneA + "," + cig + ","
					+ codiceStazAppaltante + "): inizio metodo");
		}

		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);
		tipo = StringUtils.stripToNull(tipo);
		contratto = StringUtils.stripToNull(contratto);
		codiceStazAppaltante = StringUtils.stripToNull(codiceStazAppaltante);
		cig = StringUtils.stripToNull(cig);

		ElencoBandiOutType risultato = new ElencoBandiOutType();

		// si effettua un controllo preventivo dei parametri generando un errore
		// in caso di codifica non prevista
		boolean continua = true;

		if (continua && (this.authenticationToken != null
				&& !this.authenticationToken.equals(token))) {
			risultato.setErrore("Parametro token non impostato o non valido");
			continua = false;
		}

		if (continua && (!CostantiBando.TIPOLOGIA_BANDO.equals(tipo)
				&& !CostantiBando.TIPOLOGIA_ESITO.equals(tipo)
				&& !CostantiBando.TIPOLOGIA_AVVISO.equals(tipo))){
			risultato.setErrore("Parametro tipo non impostato o non valido");
			continua = false;
		}

		if (continua && (contratto != null
				&& !CostantiBando.CONTRATTO_LAVORI.equals(contratto)
				&& !CostantiBando.CONTRATTO_FORNITURE.equals(contratto)
				&& !CostantiBando.CONTRATTO_SERVIZI.equals(contratto))){
			risultato.setErrore("Parametro contratto non valido");
			continua = false;
		}

		//controlli su obbligatorietà stazione appaltante
		if(continua){
			if(StringUtils.isEmpty(this.obbStazioneAppaltante)){
				risultato.setErrore("Parametro obbligatorieta' stazione appaltante non configurato");
				continua = false;
			}

			if(continua && ("1".equals(this.obbStazioneAppaltante) && StringUtils.isEmpty(codiceStazAppaltante))){
				risultato.setErrore("Parametro codice fiscale della stazione appaltante non impostato");
				continua = false;
			}
		}
		//controlli su obbligatorietà stazione appaltante
		if(continua){
			if(StringUtils.isEmpty(this.obbStazioneAppaltante)){
				risultato.setErrore("Parametro obbligatorieta' stazione appaltante non configurato");
				continua = false;
			}

			if(continua && ("1".equals(this.obbStazioneAppaltante) && StringUtils.isEmpty(codiceStazAppaltante))){
				risultato.setErrore("Parametro codice fiscale della stazione appaltante non impostato");
				continua = false;
			}
		}

		if(continua) {
			if (this.authenticationToken != null && logger.isInfoEnabled())
				logger.info("Lista bandi scaduti richiesta per la stazione appaltante "
						+ codiceStazAppaltante);

			// se i parametri sono corretti, si procede con l'inoltro della
			// chiamata
			try {
				List<BandoListaType> elencoBandi = this.bandiManager
						.getElencoBandiScaduti(tipo, contratto,
								dataPubblicazioneDa, dataPubblicazioneA, cig,
								codiceStazAppaltante);
				risultato
				.setBando(elencoBandi.toArray(new BandoListaType[] {}));
				risultato.setNumBandi(new Integer(elencoBandi.size()));
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("elencoBandiScaduti: fine metodo");

		return risultato;
	}

	/**
	 * Estrae il dettaglio di un bando e l'elenco dei riferimenti ai documenti
	 * allegati
	 * 
	 * @param token
	 *            token eventuale di autenticazione
	 * @param codice
	 *            identificativo univoco del bando
	 * @param tipo
	 *            tipologia del bando
	 * @return dettaglio bando nel rispetto del d.p.c.m. 26 aprile 2011
	 */
	public DettaglioBandoOutType getDettaglioBando(String token, String codice,
			String tipo) {
		if (logger.isDebugEnabled())
			logger.debug("dettaglioBando(" + codice + ", " + tipo
					+ "): inizio metodo");

		DettaglioBandoOutType risultato = new DettaglioBandoOutType();

		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);
		tipo = StringUtils.stripToNull(tipo);

		if (this.authenticationToken != null
				&& !this.authenticationToken.equals(token)) {
			risultato.setErrore("Parametro token non impostato o non valido");
		} else if (codice == null) {
			risultato.setErrore("Parametro codice non impostato");
		} else if (!CostantiBando.TIPOLOGIA_BANDO.equals(tipo)
				&& !CostantiBando.TIPOLOGIA_ESITO.equals(tipo)
				&& !CostantiBando.TIPOLOGIA_AVVISO.equals(tipo)) {
			risultato.setErrore("Parametro tipo non impostato o non valido");
		} else {
			try {
				List<DettaglioBandoType> bando = this.bandiManager.getBando(
						codice, tipo);
				risultato.setBando(bando.toArray(new DettaglioBandoType[] {}));
				List<DocumentoAllegatoType> doc = this.bandiManager
						.getDocumentiBando(codice, tipo);
				risultato.setDocumento(doc
						.toArray(new DocumentoAllegatoType[] {}));
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("dettaglioBando: fine metodo");

		return risultato;
	}

	/**
	 * Estrae un documento allegato ad un bando
	 * 
	 * @param token
	 *            token eventuale di autenticazione
	 * @param codice
	 *            identificativo univoco del bando/esito/avviso
	 * @param tipo
	 *            tipologia di bando
	 * @param id
	 *            del documento
	 * @return stream con il documento allegato
	 */
	public DocumentoBandoOutType getDocumentoBando(String token, String codice,
			String tipo, int id) {
		if (logger.isDebugEnabled())
			logger.debug("documentoBando(" + codice + ", " + tipo + "," + id
					+ "): inizio metodo");

		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);
		codice = StringUtils.stripToNull(codice);
		tipo = StringUtils.stripToNull(tipo);

		DocumentoBandoOutType risultato = new DocumentoBandoOutType();

		if (this.authenticationToken != null
				&& !this.authenticationToken.equals(token)) {
			risultato.setErrore("Parametro token non impostato o non valido");
		} else if (codice == null) {
			risultato.setErrore("Parametro codice non impostato");
		} else if (!CostantiBando.TIPOLOGIA_BANDO.equals(tipo)
				&& !CostantiBando.TIPOLOGIA_AVVISO.equals(tipo)) {
			risultato.setErrore("Parametro tipo non impostato o non valido");
		} else {
			try {
				FileType file = this.bandiManager.downloadDocumentoBando(
						codice, tipo, id);
				risultato.setFile(file);
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("documentoBando: fine metodo");

		return risultato;
	}

	/**
	 * Ritorna l'elenco degli esiti filtrati per data affidamento. Se i
	 * parametri non sono valorizzati, si estraggono tutte le occorrenze. In
	 * caso di parametri non valorizzati correttamente, ritorna un errore.
	 * 
	 * @param token
	 *            token eventuale di autenticazione
	 * @param dataAffidamentoDa
	 *            data affidamento a partire da
	 * @param dataAffidamentoA
	 *            data affidamento fino a
	 * @return lista di esiti eventualmente filtrati a seconda dei parametri in
	 *         input specificati
	 */
	public ProspettoBeneficiariOutType getProspettoBeneficiari(String token,
			Date dataAffidamentoDa, Date dataAffidamentoA) {
		if (logger.isDebugEnabled())
			logger.debug("prospettoBeneficiari(" + token + ","
					+ dataAffidamentoDa + "," + dataAffidamentoA
					+ "): inizio metodo");

		ProspettoBeneficiariOutType risultato = new ProspettoBeneficiariOutType();

		if (StringUtils.isBlank(this.templateLinkBeneficiari)) {
			risultato.setErrore("Operazione non supportata");
			logger.error("Operazione prospettoBeneficiari non supportata, richiesta rifiutata");
		} else {

			// conversione a null di eventuali parametri vuoti
			token = StringUtils.stripToNull(token);

			// si effettua un controllo preventivo dei parametri generando un
			// errore
			// in caso di codifica non prevista
			if (this.authenticationToken != null
					&& !this.authenticationToken.equals(token)) {
				risultato
				.setErrore("Parametro token non impostato o non valido");
			} else {
				if (this.authenticationToken != null && logger.isInfoEnabled()) {
					logger.info("Lista esiti richiesta per il prospetto beneficiari secondo l'art. 18 DLgs 83/2012: da data="
							+ dataAffidamentoDa + " a data=" + dataAffidamentoA);
				}
				// se i parametri sono corretti, si procede con l'inoltro della
				// chiamata
				try {
					List<EsitoProspettoBeneficiariType> elencoEsiti = this.bandiManager
							.getProspettoBeneficiari(dataAffidamentoDa,
									dataAffidamentoA);
					risultato.setEsito(elencoEsiti
							.toArray(new EsitoProspettoBeneficiariType[] {}));
					risultato.setNumEsiti(new Integer(elencoEsiti.size()));
					if (this.authenticationToken != null
							&& logger.isInfoEnabled()) {
						logger.info("Prospetto beneficiari: estratti "
								+ risultato.getNumEsiti() + " record");
					}
				} catch (DataAccessException e) {
					logger.error(
							"Errore inaspettato durante l'interazione con la base dati",
							e);
					risultato.setErrore(e.getMessage());
				}
			}
		}

		logger.debug("prospettoBeneficiari: fine metodo");

		return risultato;
	}

	/**
	 * Ritorna l'elenco dei file allegati per la trasparenza.
	 * 
	 * @param token
	 *            token eventuale di autenticazione
	 * @param codice
	 *            identificativo univoco del bando
	 * @param codiceBeneficiario
	 *            codice univoco della ditta aggiudicatrice/beneficiaria
	 * @return elenco dei file associati al bando con relativo beneficiario
	 */
	public DocumentiBeneficiarioOutType getDocumentiBeneficiario(String token,
			String codice, String codiceBeneficiario) {
		if (logger.isDebugEnabled())
			logger.debug("documentiBeneficiario(" + token + "," + codice + ","
					+ codiceBeneficiario + "): inizio metodo");

		DocumentiBeneficiarioOutType risultato = new DocumentiBeneficiarioOutType();

		if (StringUtils.isBlank(this.templateLinkBeneficiari)) {
			risultato.setErrore("Operazione non supportata");
			logger.error("Operazione documentiBeneficiario non supportata, richiesta rifiutata");
		} else {

			// conversione a null di eventuali parametri vuoti
			token = StringUtils.stripToNull(token);

			// si effettua un controllo preventivo dei parametri generando un
			// errore in caso di codifica non prevista
			if (this.authenticationToken != null
					&& !this.authenticationToken.equals(token)) {
				risultato
				.setErrore("Parametro token non impostato o non valido");
			} else {
				if (this.authenticationToken != null && logger.isInfoEnabled()) {
					logger.info("Lista documenti allegati per il prospetto beneficiari secondo l'art. 18 DLgs 83/2012: codice="
							+ codice);
				}
				// se i parametri sono corretti, si procede con l'inoltro della
				// chiamata
				try {
					List<FileType> elencoFile = this.bandiManager
							.downloadDocumentiBeneficiario(codice,
									codiceBeneficiario);
					risultato.setDocumento(elencoFile
							.toArray(new FileType[] {}));
					if (this.authenticationToken != null
							&& logger.isInfoEnabled()) {
						logger.info("Documenti beneficiario: estratti "
								+ elencoFile.size() + " record");
					}
				} catch (DataAccessException e) {
					logger.error(
							"Errore inaspettato durante l'interazione con la base dati",
							e);
					risultato.setErrore(e.getMessage());
				}
			}
		}

		logger.debug("documentiBeneficiario: fine metodo");

		return risultato;
	}

	public ProspettoGareContrattiAnticorruzioneOutType getProspettoGareContrattiAnticorruzione(
			String token, int anno, String cig, String proponente,
			String oggetto, 
			String partecipante, String aggiudicatario) {
		if (logger.isDebugEnabled())
			logger.debug("prospettoGareContrattiAnticorruzione(" + token + ","
					+ anno + "," + cig + "," + proponente + "," + oggetto
					+ "," + partecipante + "," + aggiudicatario + "): inizio metodo");

		ProspettoGareContrattiAnticorruzioneOutType risultato = new ProspettoGareContrattiAnticorruzioneOutType();

		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);

		// si effettua un controllo preventivo dei parametri generando un
		// errore in caso di codifica non prevista
		if (this.authenticationToken != null
				&& !this.authenticationToken.equals(token)) {
			risultato
			.setErrore("Parametro token non impostato o non valido");
		} else {
			if (this.authenticationToken != null && logger.isInfoEnabled()) {
				logger.info("Lista esiti richiesta per il prospetto gare contratti secondo l'art. 1 Legge 190/2012: anno="
						+ anno
						+ ", cig="
						+ cig
						+ ", proponente="
						+ proponente
						+ ", oggetto="
						+ oggetto
						+ ", partecipante="
						+ partecipante
						+ ", aggiudicatario=" + aggiudicatario);
			}
			// se i parametri sono corretti, si procede con l'inoltro della
			// chiamata
			try {
				List<AppaltoAggiudicatoAnticorruzioneType> elencoAppalti = this.bandiManager
						.getProspettoGareContrattiAnticorruzione(anno, cig, proponente,
								oggetto, partecipante, aggiudicatario);
				risultato
				.setAppalto(elencoAppalti
						.toArray(new AppaltoAggiudicatoAnticorruzioneType[] {}));
				risultato.setNumAppaltiAggiudicati(new Integer(elencoAppalti.size()));
				if (this.authenticationToken != null
						&& logger.isInfoEnabled()) {
					logger.info("Prospetto gare e contratti: estratti "
							+ risultato.getNumAppaltiAggiudicati() + " record");
				}
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		logger.debug("prospettoGareContrattiAnticorruzione: fine metodo");

		return risultato;
	}

	public AdempimentoAnticorruzioneOutType getAdempimentiAnticorruzione(String token,Integer anno){
		
		if (logger.isDebugEnabled())
			logger.debug("adempimentiAnticorruzione(" + token + ","
					+ anno + "): inizio metodo");

		AdempimentoAnticorruzioneOutType risultato = new AdempimentoAnticorruzioneOutType(); 
		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);

		// si effettua un controllo preventivo dei parametri generando un
		// errore in caso di codifica non prevista
		if (this.authenticationToken != null
				&& !this.authenticationToken.equals(token)) {
			risultato
			.setErrore("Parametro token non impostato o non valido");
		} else {
			if (this.authenticationToken != null && logger.isInfoEnabled()) {
				logger.info("Lista adempimenti secondo l'art. 1 Legge 190/2012: anno="+ anno);
			}
			List<AdempimentoAnticorruzioneType> adempimenti = this.bandiManager.getAdempimentiAnticorruzione(anno);
			risultato.setAdempimento(adempimenti.toArray(new AdempimentoAnticorruzioneType[] {}));
			risultato.setNumAdempimenti(new Integer(adempimenti.size()));	
		}
		
		logger.debug("adempimentiAnticorruzione: fine metodo");
		
		return risultato;
	}

	public ProspettoContrattiOutType getProspettoContratti(String token, String cig, String stazioneAppaltante, String oggetto, String tipologiaContratto, String partecipante, String aggiudicatario, Date dataPubblicazioneEsitoDa, Date dataPubblicazioneEsitoA){
		
		if (logger.isDebugEnabled()) {
			logger.debug("prospettoContratti(" + token + "," + cig + ","
					+ stazioneAppaltante + "," + oggetto + ","
					+ tipologiaContratto + "," + partecipante + ","
					+ aggiudicatario + "," + dataPubblicazioneEsitoDa + ","
					+ dataPubblicazioneEsitoA + "): inizio metodo");
		}
		
		
		ProspettoContrattiOutType risultato = new ProspettoContrattiOutType();

		token = StringUtils.stripToNull(token);

		if (this.authenticationToken != null
				&& !this.authenticationToken.equals(token)) {
			risultato
			.setErrore("Parametro token non impostato o non valido");
		} else {
			if (this.authenticationToken != null && logger.isInfoEnabled()) {
				logger.info("Lista contratti: cig="
						+ cig
						+ ", stazioneAppaltante="
						+ stazioneAppaltante
						+ ", oggetto="
						+ oggetto
						+ ", tipologiaContratto="
						+ tipologiaContratto
						+ ", partecipante=" 
						+ partecipante 
						+ ", aggiudicatario="
						+ aggiudicatario
						+ ", dataPubblicazioneEsitoDa=" + dataPubblicazioneEsitoDa
						+ ", dataPubblicazioneEsitoA=" + dataPubblicazioneEsitoA);
			}

			try{
				List<ProspettoContrattoType> contratti = this.bandiManager.getProspettoContratti(cig, stazioneAppaltante, oggetto, tipologiaContratto, partecipante, aggiudicatario, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA);
				risultato.setContratto(contratti.toArray(new ProspettoContrattoType[] {}));
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}
		
		logger.debug("prospettoContratti: fine metodo");
		return risultato;
	}

	public DettaglioContrattoOutType getDettaglioContratto(String token, String codice){
		
		if (logger.isDebugEnabled())
			logger.debug("dettaglioContratto(" + token + ","
					+ codice + "): inizio metodo");
		
		DettaglioContrattoOutType risultato = new DettaglioContrattoOutType();

		token = StringUtils.stripToNull(token);

		if (this.authenticationToken != null
				&& !this.authenticationToken.equals(token)) {
			risultato
			.setErrore("Parametro token non impostato o non valido");
		} else if(StringUtils.isEmpty(codice)){
			risultato.setErrore("Parametro codice non valorizzato");
			logger.error("Parametro codice non valorizzato");
		} else {
			if (this.authenticationToken != null && logger.isInfoEnabled()) {
				logger.info("Lista contratti: codice=" + codice);
			}

			try{
				DettaglioContrattoType dettaglioContratto = this.bandiManager.getDettaglioContratto(codice);
				risultato.setDettaglioContratto(dettaglioContratto);
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			} 
			catch (RuntimeException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}
		
		logger.debug("prospettoContratto: fine metodo");
		
		return risultato;
	}
	
	public ConsulentiCollaboratoriOutType getConsulentiCollaboratori(
			String token,
			String stazioneAppaltante,
			String soggettoPercettore, 
			Date dataDa, 
			Date dataA, 
			String ragioneIncarico, 
			Double compensoPrevistoDa, 
			Double compensoPrevistoA) 
	{	
		if (logger.isDebugEnabled())
			logger.debug("getConsulentiCollaboratori(" + token + ","
					+ stazioneAppaltante + ","
					+ soggettoPercettore + ","
					+ dataDa + "," + dataA + ","
					+ ragioneIncarico + ","
					+ compensoPrevistoDa + "," + compensoPrevistoA + "): inizio metodo");
		
		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);
		soggettoPercettore = StringUtils.stripToNull(soggettoPercettore);
		ragioneIncarico = StringUtils.stripToNull(ragioneIncarico);

		ConsulentiCollaboratoriOutType risultato = new ConsulentiCollaboratoriOutType();

		// si effettua un controllo preventivo dei parametri generando un errore
		// in caso di codifica non prevista
		boolean continua = true;

		if (continua && (this.authenticationToken != null && !this.authenticationToken.equals(token))) {
			risultato.setErrore("Parametro token non impostato o non valido");
			continua = false;
		}

		if(continua) {
			if (this.authenticationToken != null && logger.isInfoEnabled())
				logger.info("Lista consulenti e collaboratori richiesta");
			
			// se i parametri sono corretti, si procede con l'inoltro della chiamata
			try {
				List<ConsulenteCollaboratoreType> elenco = this.bandiManager.getConsulentiCollaboratori(
						stazioneAppaltante,
						soggettoPercettore, 
						dataDa, 
						dataA, 
						ragioneIncarico, 
						compensoPrevistoDa, 
						compensoPrevistoA);
								
				if(elenco != null) {
					risultato.setConsulentiCollaboratori(elenco.toArray(new ConsulenteCollaboratoreType[] {}));
				} else {
					risultato.setConsulentiCollaboratori(new ConsulenteCollaboratoreType[] {});
				}
				risultato.setNumConsulentiCollaboratori(new Integer(elenco.size()));
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("getConsulentiCollaboratori: fine metodo");

		return risultato;
	}
	
	public DocumentiConsulentiCollaboratoriOutType getDocumentiConsulentiCollaboratori(String token, String codice, String codiceSoggetto) {
		if (logger.isDebugEnabled())
			logger.debug("documentiConsulentiCollaboratori(" + 
					token + "," + codice + "," + codiceSoggetto + "): inizio metodo");

		// conversione a null di eventuali parametri vuoti
		token = StringUtils.stripToNull(token);
		codice = StringUtils.stripToNull(codice);
		codiceSoggetto = StringUtils.stripToNull(codiceSoggetto);

		DocumentiConsulentiCollaboratoriOutType risultato = new DocumentiConsulentiCollaboratoriOutType();

		if (this.authenticationToken != null && !this.authenticationToken.equals(token)) {
			risultato.setErrore("Parametro token non impostato o non valido");
		} else if (StringUtils.isEmpty(codice)) {
			risultato.setErrore("Parametro codice non impostato");
		} else if (StringUtils.isEmpty(codiceSoggetto)) {
			risultato.setErrore("Parametro codiceSoggetto non impostato o non valido");
		} else {
			try {
				List<FileType> elencoFile = this.bandiManager.downloadDocumentiConsulentiCollaboratori(codice, codiceSoggetto);
				risultato.setDocumento(elencoFile.toArray(new FileType[] {}));
				if (this.authenticationToken != null && logger.isInfoEnabled()) {
					logger.info("Documenti consulenti collaboratori: estratti " + elencoFile.size() + " record");
				}
			} catch (DataAccessException e) {
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("documentiConsulentiCollaboratori: fine metodo");

		return risultato;
	}

}
