/*
 * Created on 26/set/11
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo.AppaltoAggiudicatoAnticorruzione;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.*;
import org.springframework.dao.DataAccessException;

import java.util.Date;
import java.util.List;

/**
 * @author Stefano.Sabbadin
 * 
 */
public interface BandiEsitiAvvisiDao {

	/**
	 * Ritorna l'elenco dei bandi, o esiti o avvisi filtrati per contratto e per
	 * data pubblicazione. Se i parametri non sono valorizzati, si estraggono
	 * tutte le occorrenze.
	 * 
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
	 * @throws DataAccessException
	 */
	List<BandoListaType> getElencoBandi(String tipo, String contratto,
			Date dataPubblicazioneDa, Date dataPubblicazioneA, String cig,
			String codiceStazAppaltante) throws DataAccessException;

	/**
	 * Ritorna l'elenco dei bandi o avvisi scaduti e filtrati per contratto e
	 * per data pubblicazione. Se i parametri non sono valorizzati, si
	 * estraggono tutte le occorrenze.
	 * 
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
	 * @param codiceStazAppaltante
	 *            codice fiscale stazione appaltante
	 * @param cig
	 *            codice cig
	 * @return lista di bandi scaduti eventualmente filtrati a seconda dei
	 *         parametri in input specificati
	 * @throws DataAccessException
	 */
	List<BandoListaType> getElencoBandiScaduti(String tipo, String contratto,
			Date dataPubblicazioneDa, Date dataPubblicazioneA, String cig,
			String codiceStazAppaltante) throws DataAccessException;

	/**
	 * Ritorna l'elenco dei bandi, o esiti o avvisi filtrati per contratto e per
	 * data pubblicazione. Se i parametri non sono valorizzati, si estraggono
	 * tutte le occorrenze. Si ritorna direttamente il dettaglio.
	 * 
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
	 * @param deltaGiorniBandi
	 *            numero eventuale di giorni entro cui deve essere pubblicato il
	 *            bando
	 * @return lista di bandi in corso eventualmente filtrati a seconda dei
	 *         parametri in input specificati
	 * @throws DataAccessException
	 */
	List<DettaglioBandoType> getElencoDettagliBandi(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante, Integer deltaGiorniBandi)
			throws DataAccessException;

	/**
	 * Ritorna l'elenco dei bandi o avvisi scaduti e filtrati per contratto e
	 * per data pubblicazione. Se i parametri non sono valorizzati, si
	 * estraggono tutte le occorrenze. Si ritorna direttamente il dettaglio.
	 * 
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
	 * @param deltaGiorniBandiScaduti
	 *            numero eventuale di giorni entro cui deve essere scaduto il
	 *            bando
	 * @return lista di bandi scaduti eventualmente filtrati a seconda dei
	 *         parametri in input specificati
	 * @throws DataAccessException
	 */
	List<DettaglioBandoType> getElencoDettagliBandiScaduti(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante, Integer deltaGiorniBandiScaduti)
			throws DataAccessException;

	/**
	 * Estrae il dettaglio di un bando/avviso/esito nel rispetto del dpcm 26
	 * luglio 2011. Si estrae una lista in modo da permettere, nel caso di view
	 * di partenza orientata alle gare e non ai lotti, di recuperare il record
	 * per la gara (il primo) ed i record per i singoli lotti.
	 * 
	 * @param codice
	 *            identificativo univoco del bando
	 * @param tipo
	 *            tipologia di bando
	 * @return dettaglio rispondente alla tabella A dell'Allegato 2 del dpcm
	 * @throws DataAccessException
	 */
	List<DettaglioBandoType> getBando(String codice, String tipo)
			throws DataAccessException;

	/**
	 * Estrae l'elenco dei documenti collegato al bando/avviso/esito
	 * 
	 * @param codice
	 *            identificativo univoco del bando
	 * @param tipo
	 *            tipologia (Bando, Esito, Avviso)
	 * @return documenti collegati alla tipologia per il bando/lotto
	 * @throws DataAccessException
	 */
	List<DocumentoAllegatoType> getDocumentiBando(String codice, String tipo)
			throws DataAccessException;

	/**
	 * Estrae un documento allegato ad un bando
	 * 
	 * @param codice
	 *            identificativo univoco del bando/esito/avviso
	 * @param tipo
	 *            tipologia (Bando, Esito, Avviso)
	 * @param id
	 *            del documento
	 * @return stream con il documento allegato
	 */
	FileType downloadDocumentoBando(String codice, String tipo, int id)
			throws DataAccessException;

	/**
	 * Estrae l'elenco degli esiti per la generazione del prospetto
	 * "sovvenzioni, contributi, sussidi - elenco dei beneficiari" previsto
	 * dall'articolo 18 del Decreto Legislativo 83/2012, filtrando per data
	 * affidamento.
	 * 
	 * @param dataAffidamentoDa
	 *            data affidamento a partire da
	 * @param dataAffidamentoA
	 *            data affidamento fino a
	 * @return elenco degli esiti
	 */
	List<EsitoProspettoBeneficiariType> getProspettoBeneficiari(
			Date dataAffidamentoDa, Date dataAffidamentoA);
	
	/**
	 * Estrae il numero dei documenti per il bando aggiudicato al relativo
	 * beneficiario, come previsto dall'articolo 18 del Decreto Legislativo
	 * 83/2012.
	 * 
	 * @param codice
	 *            dentificativo univoco del bando
	 * @param codiceBeneficiario
	 *            codice univoco della ditta aggiudicatrice/beneficiaria
	 * @return numero di file allegati per il prospetto amministrazione
	 *         trasparente
	 */
	Integer getNumeroDocumentiBeneficiario(String codice,
			String codiceBeneficiario);

	/**
	 * Estrae l'elenco degli esiti per la generazione del prospetto
	 * "gare e contratti - procedure di acquisizione" previsto dall'articolo 1
	 * della legge 190/2012 (Legge anticorruzione), filtrando per data
	 * affidamento.
	 *
	 * @param anno              anno di riferimento
	 * @param cig               eventuale filtro sul cig
	 * @param proponente        eventuale filtro sul codice fiscale o denominazione del
	 *                          proponente
	 * @param oggetto           eventuale filtro sull'oggetto
	 * @param partecipante      eventuale filtro sul codice fiscale o denominazione del
	 *                          partecipante
	 * @param aggiudicatario    eventuale filtro sul codice fiscale o denominazione
	 *                          dell'aggiudicatario
	 * @param indicePrimoRecord
	 * @param maxNumRecord
	 * @return elenco degli appalti aggiudicati che rispettano i filtri in input
	 */
	List<AppaltoAggiudicatoAnticorruzione> getProspettoGareContrattiAnticorruzione(
			int anno, String cig, String proponente,
			String oggetto,
			String partecipante, String aggiudicatario, int indicePrimoRecord, int maxNumRecord);

	int countProspettoGareContrattiAnticorruzione(
			int anno, String cig, String proponente,
			String oggetto,
			String partecipante, String aggiudicatario);

	/**
	 * Estrae l'elenco dei documenti per il bando aggiudicato al relativo
	 * beneficiario, come previsto dall'articolo 18 del Decreto Legislativo
	 * 83/2012.
	 * 
	 * @param codice
	 *            dentificativo univoco del bando
	 * @param codiceBeneficiario
	 *            codice univoco della ditta aggiudicatrice/beneficiaria
	 * @return elenco dei file allegati per il prospetto amministrazione
	 *         trasparente
	 */
	List<FileType> downloadDocumentiBeneficiario(String codice,
			String codiceBeneficiario);

	/**
	 * Estrae l'elenco delle ditte invitate ad una gara o a un lotto o delle
	 * ditte aggiudicatarie per la generazione del prospetto
	 * "gare e contratti - procedure di acquisizione" previsto dall'articolo 1
	 * della legge 190/2012 (Legge anticorruzione).
	 * 
	 * @param idLotto
	 *            id del lotto
	 * @param soloAggiudicataria
	 *            true se si vuole l'aggiudicataria, false se si vogliono le
	 *            invitate
	 * @return elenco delle ditte
	 */
	List<PartecipanteType> getDitteProspettoGareContrattiAnticorruzione(
			int idLotto, boolean soloAggiudicataria);
	
	List<String> getElencoStazioniAppaltanti() throws DataAccessException;
	
	/**
	 * Estrae gli adempimenti per la legge 190 per l'anno selezionato
	 * 
	 * @param anno
	 * 			Anno per cui si desidera estrarre l'adempimento
	 * @return andempimento per l'anno
	 */
	List<AdempimentoAnticorruzioneType> getAdempimentoAnticorruzione(Integer anno);
	
	/**
	 * Estrae i prospetti per il riepilogo dei contratti per amministrazione trasparente
	 * 
	 * @param cig
	 * 			eventuale filtro sul cig
	 * @param stazioneAppaltante
	 * 			eventuale filtro sulla stazione appaltante
	 * @param oggetto
	 * 			eventuale filtro sull'oggetto
	 * @param tipologiaContratto
	 * 			eventuale filtro sul tipo di contratto
	 * @param dataPubblicazioneEsitoDa
	 * 			eventuale filtro sulla data di pubblicazione dell'esito 
	 * @param dataPubblicazioneEsitoA
	 * 			eventuale filtro sulla data di pubblicazione dell'esito
	 * @return elenco dei prospetti 
	 */
	List<ProspettoContrattoType> getProspettoContratti(String cig, String stazioneAppaltante, String oggetto, String tipologiaContratto, String partecipante, String aggiudicatario, Date dataPubblicazioneEsitoDa, Date dataPubblicazioneEsitoA);
	
	/**
	 * Estrae le infromazioni relative a un contratto partendo dal codice della gara
	 * 
	 * @param codice
	 * 			codice della gara
	 * @return prospetto del contratto
	 */
	ProspettoContrattoType getInfoContratto(String codice);
	
	/**
	 * Estrare l'elenco degli operatori che sono stati invitati a partecipare a una gara
	 * 
	 * @param codice 
	 * 			codice della gara
	 * @return elenco degli operatori invitati a partecipare alla gara
	 */
	List<OperatoreInvitatoType> getOperatoriInvitatiContratto(String codice);

	/**
	 * Estrae l'elenco degli operatori raggruppati all'interno di una RTI, quando la RTI � stata invitata a partecipare a una gara
	 * 
	 * @param codiceRTI
	 * 			codice del ragruppamento temporaneo di cui si desidera conoscere la composizione
	 * @return elenco degli operatori appartenenti alla RTI
	 */
	List<OperatoreType> getComponentiRTI(String codiceRTI);
	
	/**
	 * Estrae l'informazione relativamente alla presenza di aggiudicatari singoli/multipli 
	 * 
	 * @param codice
	 * 			codice della gara
	 * @return true se la gara ha un singolo aggiudicatario, false altrimenti
	 */
	boolean isSingolaAggiudicataria(String codice);

	/**
	 * Estrae l'elenco degli aggiudicatari in caso di aggiudicatari multipli 
	 * 
	 * @param codice
	 * 			codice della gara
	 * @return elenco degli aggiudicatari
	 */
	List<OperatoreInvitatoType> getListaAggiudicatari(String codice);

	/**
	 * Estrae l'elenco degli aggiudicatari in caso di aggiudicatari multipli 
	 * 
	 * @param codice
	 * 			codice della gara
	 * @return unica aggiudicataria
	 */
	String getAggiudicataria(String codice);
	
	/**
	 * Ritorna l'elenco dei consulenti e collaboratori. 
	 * Se i parametri non sono valorizzati, si estraggono tutte le occorrenze.
	 * 
	 * @param ...
	 *            
	 * @return lista dei consulenti e collaboratori eventualmente filtrati a seconda dei
	 *         parametri in input specificati
	 * @throws DataAccessException
	 */
	List<ConsulenteCollaboratoreType> getConsulentiCollaboratori(
			String stazioneAppaltante,
			String soggettoPercettore, 
			Date dataDa, Date dataA, 
			String ragioneIncarico, 
			Double compensoPrevistoDa, Double compensoPrevistoA) throws DataAccessException;

	/**
	 * Estrae il numero dei documenti per il bando aggiudicato al relativo
	 * consulente/collaboratore, come previsto dal Decreto Legislativo 33/2013 art.15, cc. 1,2.
	 * 
	 * @param codice
	 *            dentificativo univoco del bando
	 * @param codiceSoggetto
	 *            codice univoco della ditta consulente/collaboratore
	 * @return numero di file allegati 
	 */
	Integer getNumeroDocumentiConsulente(String codice, String codiceSoggetto);

	/**
	 * Esegue il download dei dolcumenti relativi ad un consulente/collaboratore. 
	 * 
	 * @param ...
	 *            
	 * @return elenco dei documenti relativi ad un consulente/collaboratore
	 * @throws DataAccessException
	 */
	public List<FileType> downloadDocumentiConsulentiCollaboratori(
			String codice, String codiceSoggetto) throws DataAccessException;

}
