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
package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.BandiEsitiAvvisiDao;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo.AppaltoAggiudicatoAnticorruzione;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.FileType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;


/**
 * Business logic per l'estrazione dei dati sui bandi, esiti ed avvisi.
 * 
 * @author Stefano.Sabbadin
 */
public class BandiEsitiAvvisiManager {

	private BandiEsitiAvvisiDao bandiDao;

	/** Template link per l'apertura dell'elenco documenti beneficiario. */
	private String templateLinkBeneficiari;
	
	/** Template link per l'apertura dell'elenco documenti cosnulente/collaboratore. */
	private String templateLinkConsulenti;

	
	public void setBandiDao(BandiEsitiAvvisiDao bandiDao) {
		this.bandiDao = bandiDao;
	}

	public void setTemplateLinkBeneficiari(String templateLinkBeneficiari) {
		this.templateLinkBeneficiari = templateLinkBeneficiari;
	}

	public void setTemplateLinkConsulenti(String templateLinkConsulenti) {
		this.templateLinkConsulenti = templateLinkConsulenti;
	}
	

	public List<BandoListaType> getElencoBandi(String tipo, String contratto,
			Date dataPubblicazioneDa, Date dataPubblicazioneA, String cig,
			String codiceStazAppaltante) {
		return this.bandiDao.getElencoBandi(tipo, contratto,
				dataPubblicazioneDa, dataPubblicazioneA, cig, codiceStazAppaltante);
	}

	public List<BandoListaType> getElencoBandiScaduti(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante) {
		return this.bandiDao.getElencoBandiScaduti(tipo, contratto,
				dataPubblicazioneDa, dataPubblicazioneA, cig, codiceStazAppaltante);
	}

	public List<DettaglioBandoType> getElencoDettagliBandi(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante,
			Integer deltaGiorniBandi) {
		return this.bandiDao.getElencoDettagliBandi(tipo, contratto,
				dataPubblicazioneDa, dataPubblicazioneA, cig, codiceStazAppaltante,
				deltaGiorniBandi);
	}

	public List<DettaglioBandoType> getElencoDettagliBandiScaduti(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante, 
			Integer deltaGiorniBandiScaduti) {
		return this.bandiDao.getElencoDettagliBandiScaduti(tipo, contratto,
				dataPubblicazioneDa, dataPubblicazioneA, cig, codiceStazAppaltante,
				deltaGiorniBandiScaduti);
	}

	public List<DettaglioBandoType> getBando(String codice, String tipo) {
		return this.bandiDao.getBando(codice, tipo);
	}

	public List<DocumentoAllegatoType> getDocumentiBando(String codice,
			String tipo) {
		return this.bandiDao.getDocumentiBando(codice, tipo);
	}

	public FileType downloadDocumentoBando(String codice, String tipo, int id) {
		return this.bandiDao.downloadDocumentoBando(codice, tipo, id);
	}

	public List<EsitoProspettoBeneficiariType> getProspettoBeneficiari(
			Date dataAffidamentoDa, Date dataAffidamentoA) {
		List<EsitoProspettoBeneficiariType> esiti = this.bandiDao
				.getProspettoBeneficiari(dataAffidamentoDa, dataAffidamentoA);
		for (EsitoProspettoBeneficiariType esito : esiti) {
			if (this.bandiDao.getNumeroDocumentiBeneficiario(esito.getCodice(),
					esito.getCodiceBeneficiario()) > 0) {
				String url = this.templateLinkBeneficiari;
				url = StringUtils.replace(url, "{0}", esito.getCodice());
				url = StringUtils.replace(url, "{1}",
						esito.getCodiceBeneficiario());
				esito.setUrl(url);
			}
		}
		return esiti;
	}

	public List<FileType> downloadDocumentiBeneficiario(String codice, String codiceBeneficiario) {
		return this.bandiDao.downloadDocumentiBeneficiario(codice, codiceBeneficiario);
	}

	public List<AppaltoAggiudicatoAnticorruzioneType> getProspettoGareContrattiAnticorruzione(
			int anno, String cig, String proponente,
			String oggetto, String partecipante, String aggiudicatario) {
		List<AppaltoAggiudicatoAnticorruzioneType> risultato = new ArrayList<AppaltoAggiudicatoAnticorruzioneType>();
		List<AppaltoAggiudicatoAnticorruzione> lotti = this.bandiDao
				.getProspettoGareContrattiAnticorruzione(anno, cig, proponente,
						oggetto, partecipante, aggiudicatario);
		for (AppaltoAggiudicatoAnticorruzione lotto : lotti) {
			List<PartecipanteType> ditteInvitate = this.bandiDao.getDitteProspettoGareContrattiAnticorruzione(lotto.getIdLotto(), false);
			lotto.setPartecipante(ditteInvitate.toArray(new PartecipanteType[]{}));
			List<PartecipanteType> ditteAggiudicatarie = this.bandiDao.getDitteProspettoGareContrattiAnticorruzione(lotto.getIdLotto(), true);
			lotto.setAggiudicatario(ditteAggiudicatarie.toArray(new PartecipanteType[]{}));
			risultato.add(lotto);
		}
		return risultato;
	}


	// WE746

	public List<String> getElencoStazioniAppaltanti(){
		return this.bandiDao.getElencoStazioniAppaltanti();
	}
	// -WE746

	public List<AdempimentoAnticorruzioneType> getAdempimentiAnticorruzione(Integer anno){	
		return this.bandiDao.getAdempimentoAnticorruzione(anno);
	}

	public List<ProspettoContrattoType> getProspettoContratti(String cig, String strutturaProponente,String oggetto,String tipologiaContratto,String partecipante,String aggiudicatario,Date dataPubblicazioneEsitoDa, Date dataPubblicazioneEsitoA){
		List<ProspettoContrattoType> prospettoContratto = this.bandiDao.getProspettoContratti(cig, strutturaProponente, oggetto, tipologiaContratto, partecipante, aggiudicatario, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA);;

		for(ProspettoContrattoType prospetto : prospettoContratto){
			List<OperatoreInvitatoType> listaAggiudicatari = null;
			String[] aggiudicatari = null;
			if(!this.bandiDao.isSingolaAggiudicataria(prospetto.getCodice())){
				//Prospetto con aggiudicatari multipli
				listaAggiudicatari = this.bandiDao.getListaAggiudicatari(prospetto.getCodice());
				aggiudicatari = new String[listaAggiudicatari.size()];
				int i = 0;
				for(OperatoreInvitatoType aggiudicataria : listaAggiudicatari){
					aggiudicatari[i] = aggiudicataria.getRagioneSociale();
					i++;
				}

			}else{
				//Singola aggiudicataria
				aggiudicatari = new String[1];
				aggiudicatari[0] = (this.bandiDao.getAggiudicataria(prospetto.getCodice()));
			}
			prospetto.setAggiudicatario(aggiudicatari);
		}

		return prospettoContratto;
	}

	public DettaglioContrattoType getDettaglioContratto(String codice){

		DettaglioContrattoType dettaglio = null;
		if(!StringUtils.isBlank(codice)){
			ProspettoContrattoType contratto = this.bandiDao.getInfoContratto(codice);
			if(contratto != null){
				dettaglio = new DettaglioContrattoType();
				dettaglio.setCig(contratto.getCig());
				dettaglio.setStrutturaProponenteCF(contratto.getStrutturaProponenteCF());
				dettaglio.setStrutturaProponenteDenominazione(contratto.getStrutturaProponenteDenominazione());
				dettaglio.setOggetto(contratto.getOggetto());
				dettaglio.setSceltaContraente(contratto.getSceltaContraente());
				dettaglio.setImportoAggiudicazione(contratto.getImportoAggiudicazione());
				dettaglio.setImportoContratto(contratto.getImportoContratto());
				dettaglio.setDataInizio(contratto.getDataInizio());
				dettaglio.setDataUltimazione(contratto.getDataUltimazione());
				dettaglio.setImportoSommeLiquidate(contratto.getImportoSommeLiquidate());
				dettaglio.setCodice(contratto.getCodice());

				// si completano gli operatori invitati con le eventuali partecipanti in caso di RTI
				List<OperatoreInvitatoType> operatoriInvitati = this.bandiDao.getOperatoriInvitatiContratto(dettaglio.getCodice());
				for(OperatoreInvitatoType operatoreInvitato : operatoriInvitati){
					if(operatoreInvitato.getRti()){
						List<OperatoreType> componentiRTIList  = this.bandiDao.getComponentiRTI(operatoreInvitato.getDitta());
						OperatoreType[] componentiRti = new OperatoreType[componentiRTIList.size()];
						int i = 0;
						for(OperatoreType componente : componentiRTIList){
							componentiRti[i] = componente;
							i++;
						}
						operatoreInvitato.setComponentiRti(componentiRti);
					}
				}
				dettaglio.setElencoOperatoriInvitati(operatoriInvitati.toArray(new OperatoreInvitatoType[] {}));
				
				// si valorizzano gli aggiudicatari
				boolean isSingolaAggiudicataria = this.bandiDao.isSingolaAggiudicataria(dettaglio.getCodice());
				if (isSingolaAggiudicataria) {
					String singolaAggiudicataria = this.bandiDao.getAggiudicataria(dettaglio.getCodice());
					// nel caso di singola aggiudicataria, si cerca di reperire tra le imprese invitate quella che corrisponde all'aggiudicataria
					if (singolaAggiudicataria != null) {
						OperatoreInvitatoType[] aggiudicatario = new OperatoreInvitatoType[1];
						for(OperatoreInvitatoType operatoreInvitato : operatoriInvitati){
							if(operatoreInvitato.getRagioneSociale().equalsIgnoreCase(singolaAggiudicataria)){
								aggiudicatario[0] = operatoreInvitato;
							}
						}
						if (aggiudicatario[0] == null) {
							// nel caso in cui non venga reperito, allora siamo nel caso in cui si aggiudica la gara una RTI non invitata, ma formatasi in fase di offerta, per cui non si trova corrispondenza tra gli operatori invitati. In tal caso si costruisce l'informazione
							aggiudicatario[0] = new OperatoreInvitatoType();
							aggiudicatario[0].setRagioneSociale(singolaAggiudicataria);
						}
						dettaglio.setAggiudicatario(aggiudicatario);
					}
				} else {
					// nel caso di piu' aggiudicatarie, si estrae mediante interrogazione ad apposita view
					List<OperatoreInvitatoType> listaAggiudicatari = this.bandiDao.getListaAggiudicatari(dettaglio.getCodice());
					OperatoreInvitatoType[] aggiudicatari = new OperatoreInvitatoType[listaAggiudicatari.size()];
					int i = 0;
					for(OperatoreInvitatoType aggiudicataria : listaAggiudicatari){
						// come per le imprese invitate si costruisce l'eventuale elenco delle partecipanti al raggruppamento
						if(aggiudicataria.getRti()){
							List<OperatoreType> componentiRTIList  = this.bandiDao.getComponentiRTI(aggiudicataria.getDitta());
							OperatoreType[] componentiRti = new OperatoreType[componentiRTIList.size()];
							int j = 0;
							for(OperatoreType componente : componentiRTIList){
								componentiRti[j] = componente;
								j++;
							}
							aggiudicataria.setComponentiRti(componentiRti);
						}
						aggiudicatari[i] = aggiudicataria;
						i++;
					}
					dettaglio.setAggiudicatario(aggiudicatari);
				}
			}
		}
		return dettaglio;
	}
	
	public List<ConsulenteCollaboratoreType> getConsulentiCollaboratori(
			String stazioneAppaltante,
			String soggettoPercettore, 
			Date dataDa, 
			Date dataA, 
			String ragioneIncarico, 
			Double compensoPrevistoDa, 
			Double compensoPrevistoA) 
	{
		List<ConsulenteCollaboratoreType> consulenti = this.bandiDao.getConsulentiCollaboratori(
				stazioneAppaltante,
				soggettoPercettore, 
				dataDa, dataA, 
				ragioneIncarico, 
				compensoPrevistoDa, compensoPrevistoA);	
		for (ConsulenteCollaboratoreType consulente : consulenti) {
			if (this.bandiDao.getNumeroDocumentiConsulente(consulente.getCodice(), consulente.getCodiceSoggetto()) > 0) {
				String url = this.templateLinkConsulenti;
				url = StringUtils.replace(url, "{0}", consulente.getCodice());
				url = StringUtils.replace(url, "{1}", consulente.getCodiceSoggetto());
				consulente.setUrl(url);
			}
		}		
		return consulenti;
	}
	
	public List<FileType> downloadDocumentiConsulentiCollaboratori(String codice, String codiceSoggetto) {
		return this.bandiDao.downloadDocumentiConsulentiCollaboratori(codice, codiceSoggetto);
	}

}
