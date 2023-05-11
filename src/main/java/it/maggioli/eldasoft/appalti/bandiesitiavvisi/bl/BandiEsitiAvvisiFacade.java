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
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Centralizzazione della logica delle chiamate del web service
 * 
 * @author Stefano.Sabbadin
 */
@Component
public class BandiEsitiAvvisiFacade {

	private static final Logger logger = LoggerFactory.getLogger(BandiEsitiAvvisiFacade.class);

	@Autowired
	private BandiEsitiAvvisiManager bandiManager;

	/**
	 * Token di autenticazione fissato dall'applicativo se da richiedere ad ogni
	 * chiamata del servizio, null o stringa vuota altrimenti
	 */
	@Resource
	private String authenticationToken;

	/** Template link per l'apertura dell'elenco documenti beneficiario. */
	@Resource
	private String templateLinkBeneficiari;
	
	/** Template link per l'apertura dell'elenco documenti consulente. */
	@Resource
	private String obbStazioneAppaltante;

	/**
	 * Aggiunto perchè con authenticationToken cercava di farmi il controllo sul token, 
	 * quindi, aggiunto script ovunque per sicurezza
	 */
	@PostConstruct
	private void stripToNull() {
		authenticationToken = StringUtils.stripToNull(authenticationToken);
		templateLinkBeneficiari = StringUtils.stripToNull(templateLinkBeneficiari);
		obbStazioneAppaltante = StringUtils.stripToNull(obbStazioneAppaltante);
	}
	
	/**
	 * Ritorna la versione del servizio
	 * 
	 * @return versione del servizio
	 */
	public VersionOutType getVersion() {
		logger.debug("version(): inizio metodo");

		VersionOutType risultato = new VersionOutType();
		
		try {
			String[] path = this.getClass().getClassLoader().getResource("").getPath().split("/WEB-INF/classes");
			String appPath = (path != null ? path[0] : "");	
			appPath = appPath.replaceAll("%20", "\\ ");
			
		    try (BufferedReader br = new BufferedReader(new FileReader(appPath + "/WEB-INF/WSBEA_VER.TXT"))) {
			    String version = "";
		        String s = null;
		        while((s = br.readLine()) != null)
	        		version += s + "\n";
		        
				risultato.setVersion(version);
		    }
		} catch (Exception e) {
			logger.error(
					"Errore inaspettato durante l'interazione con la base dati",
					e);
			risultato.setErrore(e.getMessage());
		} 
		
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

		logger.debug("elencoBandi({},{},{},{},{},{},{}): inizio metodo"
				, token, tipo, contratto, dataPubblicazioneDa, dataPubblicazioneA, cig, codiceStazAppaltante);

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
				logger.info("Lista bandi richiesta per la stazione appaltante {}", codiceStazAppaltante);
			// se i parametri sono corretti, si procede con l'inoltro della
			// chiamata
			try {
				List<BandoListaType> elencoBandi = this.bandiManager
						.getElencoBandi(tipo, contratto, dataPubblicazioneDa,
								dataPubblicazioneA, cig, codiceStazAppaltante);
				risultato.setBando(elencoBandi.toArray(new BandoListaType[0]));
				risultato.setNumBandi(elencoBandi.size());
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("getElencoBandi({})"
						, tipo
						, contratto
						, dataPubblicazioneDa
						, dataPubblicazioneA
						, cig
						, codiceStazAppaltante);
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

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
		logger.debug("elencoBandiScaduti({},{},{},{},{},{},{}): inizio metodo"
				, token, tipo, contratto, dataPubblicazioneDa, dataPubblicazioneA
				, cig, codiceStazAppaltante);

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
				logger.info("Lista bandi scaduti richiesta per la stazione appaltante {}", codiceStazAppaltante);

			// se i parametri sono corretti, si procede con l'inoltro della
			// chiamata
			try {
				List<BandoListaType> elencoBandi = this.bandiManager
						.getElencoBandiScaduti(tipo, contratto,
								dataPubblicazioneDa, dataPubblicazioneA, cig,
								codiceStazAppaltante);
				risultato
				.setBando(elencoBandi.toArray(new BandoListaType[0]));
				risultato.setNumBandi(elencoBandi.size());
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("getDocumentiBando({})"
						, tipo
						, contratto
						, dataPubblicazioneDa
						, dataPubblicazioneA
						, cig
						, codiceStazAppaltante);

						logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

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
		logger.debug("dettaglioBando({}, {}): inizio metodo", codice, tipo);

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
				risultato.setBando(bando.toArray(new DettaglioBandoType[0]));
				List<DocumentoAllegatoType> doc = this.bandiManager
						.getDocumentiBando(codice, tipo);
				risultato.setDocumento(doc
						.toArray(new DocumentoAllegatoType[0]));
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("getDocumentiBando({})"
						, codice
						, tipo);
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

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
		logger.debug("documentoBando({}, {}, {}, {}): inizio metodo", token, codice, tipo, id);

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
				logWithUndefinedNumberOfParameters("downloadDocumentoBando({})"
						, codice
						, tipo
						, id);
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

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
		logger.debug("prospettoBeneficiari({}, {}, {}): inizio metodo", token, dataAffidamentoDa, dataAffidamentoA);

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
				if (this.authenticationToken != null && logger.isInfoEnabled())
					logger.info("Lista esiti richiesta per il prospetto beneficiari secondo l'art. 18 DLgs 83/2012: da data= {} a data={}"
							, dataAffidamentoDa, dataAffidamentoA);
				// se i parametri sono corretti, si procede con l'inoltro della
				// chiamata
				try {
					List<EsitoProspettoBeneficiariType> elencoEsiti = this.bandiManager
							.getProspettoBeneficiari(dataAffidamentoDa,
									dataAffidamentoA);
					risultato.setEsito(elencoEsiti
							.toArray(new EsitoProspettoBeneficiariType[0]));
					risultato.setNumEsiti(elencoEsiti.size());
					if (this.authenticationToken != null
							&& logger.isInfoEnabled())
						logger.info("Prospetto beneficiari: estratti {} record", risultato.getNumEsiti());
				} catch (DataAccessException e) {
					logWithUndefinedNumberOfParameters("downloadDocumentiBeneficiario({})"
							, dataAffidamentoDa
							, dataAffidamentoA);
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
		logger.debug("documentiBeneficiario({}, {}, {}): inizio metodo", token, codice, codiceBeneficiario);

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
					logger.info("Lista documenti allegati per il prospetto beneficiari secondo l'art. 18 DLgs 83/2012: codice={}"
							, codice);
				}
				// se i parametri sono corretti, si procede con l'inoltro della
				// chiamata
				try {
					List<FileType> elencoFile = this.bandiManager
							.downloadDocumentiBeneficiario(codice,
									codiceBeneficiario);
					risultato.setDocumento(elencoFile
							.toArray(new FileType[0]));
					if (this.authenticationToken != null
							&& logger.isInfoEnabled()) {
						logger.info("Documenti beneficiario: estratti {} record", elencoFile.size());
					}
				} catch (DataAccessException e) {
					logWithUndefinedNumberOfParameters("downloadDocumentiBeneficiario({})"
							, codice
							, codiceBeneficiario);
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
		logger.debug("prospettoGareContrattiAnticorruzione({}, {}, {}, {}, {}, {}, {}): inizio metodo"
				,token, anno, cig, proponente, oggetto, partecipante, aggiudicatario);

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
			if (this.authenticationToken != null && logger.isInfoEnabled()) 
				logger.info("Lista esiti richiesta per il prospetto gare contratti secondo l'art. 1 Legge 190/2012: "
						+ "anno={}, cig={}, oggetto={}, partecipante={}, aggiudicatario={}"
						, anno, cig, proponente, oggetto, partecipante);
			
			// se i parametri sono corretti, si procede con l'inoltro della
			// chiamata
			try {
				List<AppaltoAggiudicatoAnticorruzioneType> elencoAppalti = this.bandiManager
						.getProspettoGareContrattiAnticorruzione(anno, cig, proponente,
								oggetto, partecipante, aggiudicatario);
				risultato
				.setAppalto(elencoAppalti
						.toArray(new AppaltoAggiudicatoAnticorruzioneType[0]));
				risultato.setNumAppaltiAggiudicati(elencoAppalti.size());
				if (this.authenticationToken != null
						&& logger.isInfoEnabled())
					logger.info("Prospetto gare e contratti: estratti {} record", risultato.getNumAppaltiAggiudicati());
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("getProspettoContratti({})"
						, anno
						, cig
						, proponente
						, oggetto
						, partecipante
						, aggiudicatario);
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		logger.debug("prospettoGareContrattiAnticorruzione: fine metodo");

		return risultato;
	}

	public AdempimentoAnticorruzioneOutType getAdempimentiAnticorruzione(String token, Integer anno){
		
		logger.debug("adempimentiAnticorruzione({}, {}): inizio metodo", token, anno);

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
			if (this.authenticationToken != null && logger.isInfoEnabled())
				logger.info("Lista adempimenti secondo l'art. 1 Legge 190/2012: anno={}", anno);
			List<AdempimentoAnticorruzioneType> adempimenti = this.bandiManager.getAdempimentiAnticorruzione(anno);
			risultato.setAdempimento(adempimenti.toArray(new AdempimentoAnticorruzioneType[0]));
			risultato.setNumAdempimenti(adempimenti.size());
		}
		
		logger.debug("adempimentiAnticorruzione: fine metodo");
		
		return risultato;
	}

	public ProspettoContrattiOutType getProspettoContratti(String token, String cig, String stazioneAppaltante, String oggetto, String tipologiaContratto, String partecipante, String aggiudicatario, Date dataPubblicazioneEsitoDa, Date dataPubblicazioneEsitoA){
		
		logger.debug("prospettoContratti({}, {}, {}, {}, {}, {}, {}, {}, {}): inizio metodo"
				, token, cig, stazioneAppaltante, oggetto, tipologiaContratto, partecipante, aggiudicatario
				, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA);
		
		ProspettoContrattiOutType risultato = new ProspettoContrattiOutType();

		token = StringUtils.stripToNull(token);

		if (this.authenticationToken != null
				&& !this.authenticationToken.equals(token)) {
			risultato
			.setErrore("Parametro token non impostato o non valido");
		} else {
			if (this.authenticationToken != null && logger.isInfoEnabled())
				logger.info("Lista contratti: cig={}, stazioneAppaltante={}, oggetto={}, tipologiaContratto={}, "
						+ "partecipante={}, aggiudicatario={}, dataPubblicazioneEsitoDa={}, dataPubblicazioneEsitoA={}"
						, cig, stazioneAppaltante, oggetto, tipologiaContratto, partecipante, aggiudicatario, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA);

			try{
				List<ProspettoContrattoType> contratti = this.bandiManager.getProspettoContratti(cig, stazioneAppaltante, oggetto, tipologiaContratto, partecipante, aggiudicatario, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA);
				risultato.setContratto(contratti.toArray(new ProspettoContrattoType[0]));
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("getProspettoContratti({})"
						, cig
						, stazioneAppaltante
						, oggetto
						, tipologiaContratto
						, partecipante
						, aggiudicatario
						, dataPubblicazioneEsitoDa
						, dataPubblicazioneEsitoA);
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
		
		logger.debug("dettaglioContratto({}, {}): inizio metodo", token, codice);
		
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
			if (this.authenticationToken != null && logger.isInfoEnabled())
				logger.info("Lista contratti: codice={}", codice);

			try{
				DettaglioContrattoType dettaglioContratto = this.bandiManager.getDettaglioContratto(codice);
				risultato.setDettaglioContratto(dettaglioContratto);
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("getDettaglioContratto({})", codice);
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			} catch (RuntimeException e) {
				logWithUndefinedNumberOfParameters("getDettaglioContratto({})", codice);
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
		logger.debug("getConsulentiCollaboratori({}, {}, {}, {}, {}, {}, {}, {}): inizio metodo"
				, token, stazioneAppaltante, soggettoPercettore, dataDa, dataA, ragioneIncarico, compensoPrevistoDa, compensoPrevistoA);
		
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
					risultato.setConsulentiCollaboratori(elenco.toArray(new ConsulenteCollaboratoreType[0]));
				} else {
					risultato.setConsulentiCollaboratori(new ConsulenteCollaboratoreType[0]);
				}
				risultato.setNumConsulentiCollaboratori(elenco.size());
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("getConsulentiCollaboratori({})",
						  stazioneAppaltante
						, soggettoPercettore
						, dataDa
						, dataA
						, ragioneIncarico
						, compensoPrevistoDa
						, compensoPrevistoA);

				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		logger.debug("getConsulentiCollaboratori: fine metodo");

		return risultato;
	}
	
	public DocumentiConsulentiCollaboratoriOutType getDocumentiConsulentiCollaboratori(String token, String codice, String codiceSoggetto) {
		logger.debug("documentiConsulentiCollaboratori({}, {}, {}): inizio metodo"
				, token, codice, codiceSoggetto);

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
				risultato.setDocumento(elencoFile.toArray(new FileType[0]));
				if (this.authenticationToken != null && logger.isInfoEnabled())
					logger.info("Documenti consulenti collaboratori: estratti {} record", elencoFile.size());
			} catch (DataAccessException e) {
				logWithUndefinedNumberOfParameters("downloadDocumentiConsulentiCollaboratori", codice, codiceSoggetto);
				logger.error(
						"Errore inaspettato durante l'interazione con la base dati",
						e);
				risultato.setErrore(e.getMessage());
			}
		}

		logger.debug("documentiConsulentiCollaboratori: fine metodo");

		return risultato;
	}

	/**
	 *
	 * @param message Ex: elencoBandi({}): inizio metodo
	 * @param params parametri da visualizzare
	 * chiamata: logWithUndefinedNumberOfParameters("elencoBandi({})", 1, "ciao");
	 * Output: elencoBandi(1, ciao)
	 */
	private void logWithUndefinedNumberOfParameters(String message, Object ... params) {
		String paramsToPrint = null;
		if (params != null && params.length > 0)
			paramsToPrint = Arrays.stream(params).map(param -> param == null ? "null" : param.toString()).collect(Collectors.joining(", "));
		logger.error(message, paramsToPrint);
	}

}
