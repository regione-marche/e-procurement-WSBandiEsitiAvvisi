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
package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.ibatis;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.BandiEsitiAvvisiDao;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo.AppaltoAggiudicatoAnticorruzione;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.FileType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Classe di appoggio per l'esecuzione tramite estensione del framework Spring
 * di interazioni con le tabelle per la gestione dei bandi, esiti ed avvisi.
 * 
 * @author Stefano.Sabbadin
 */
public class SqlMapBandiEsitiAvvisiDao extends SqlMapClientDaoSupport implements
		BandiEsitiAvvisiDao {

	@SuppressWarnings("unchecked")
	public List<BandoListaType> getElencoBandi(String tipo, String contratto,
			Date dataPubblicazioneDa, Date dataPubblicazioneA,
			String cig, String codiceStazAppaltante) throws DataAccessException {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("tipo", tipo);
		hash.put("contratto", contratto);
		hash.put("dataPubblicazioneDa", dataPubblicazioneDa);
		hash.put("dataPubblicazioneA", dataPubblicazioneA);
		hash.put("cig", cig);
		hash.put("codiceStazAppaltante", codiceStazAppaltante);
		
		// memorizzo un parametro con la data odierna senza orario
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		hash.put("dataAttuale", new Date(gc.getTimeInMillis()));
		hash.put("dataScadenzaEsito", new Date(gc.getTimeInMillis()));
		return (List<BandoListaType>) this.getSqlMapClientTemplate()
				.queryForList("getElencoBandi", hash);
	}

	@SuppressWarnings("unchecked")
	public List<BandoListaType> getElencoBandiScaduti(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante)
			throws DataAccessException {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("tipo", tipo);
		hash.put("contratto", contratto);
		hash.put("dataPubblicazioneDa", dataPubblicazioneDa);
		hash.put("dataPubblicazioneA", dataPubblicazioneA);
		hash.put("cig", cig);
		hash.put("codiceStazAppaltante", codiceStazAppaltante);

		// memorizzo un parametro con la data odierna senza orario
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		hash.put("dataAttuale", new Date(gc.getTimeInMillis()));
		return (List<BandoListaType>) this.getSqlMapClientTemplate()
				.queryForList("getElencoBandiScaduti", hash);
	}

	@SuppressWarnings("unchecked")
	public List<DettaglioBandoType> getElencoDettagliBandi(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante, 
			Integer deltaGiorniBandi)
			throws DataAccessException {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("tipo", tipo);
		hash.put("contratto", contratto);
		hash.put("dataPubblicazioneDa", dataPubblicazioneDa);
		hash.put("dataPubblicazioneA", dataPubblicazioneA);
		hash.put("cig", cig);
		hash.put("codiceStazAppaltante", codiceStazAppaltante);
		
		// memorizzo un parametro con la data odierna senza orario
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		hash.put("dataAttuale", new Date(gc.getTimeInMillis()));
		if (deltaGiorniBandi != null) {
			GregorianCalendar dataPubblicazioneConDelta = (GregorianCalendar) gc
					.clone();
			dataPubblicazioneConDelta.add(Calendar.DATE, -deltaGiorniBandi);
			hash.put("dataPubblicazioneConDelta", new Date(
					dataPubblicazioneConDelta.getTimeInMillis()));
			GregorianCalendar dataScadenzaEsito = (GregorianCalendar) gc
					.clone();
			dataScadenzaEsito.add(Calendar.DATE, 180 - deltaGiorniBandi);
			hash.put("dataScadenzaEsito",
					new Date(dataScadenzaEsito.getTimeInMillis()));
		} else {
			//dataPubblicazioneConDelta non serve, serve solo dataScadenzaEsito
			hash.put("dataScadenzaEsito", new Date(gc.getTimeInMillis()));
		}
		return (List<DettaglioBandoType>) this.getSqlMapClientTemplate()
				.queryForList("getElencoDettagliBandi", hash);
	}

	@SuppressWarnings("unchecked")
	public List<DettaglioBandoType> getElencoDettagliBandiScaduti(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA,  String cig, String codiceStazAppaltante,
			Integer deltaGiorniBandiScaduti)
			throws DataAccessException {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("tipo", tipo);
		hash.put("contratto", contratto);
		hash.put("dataPubblicazioneDa", dataPubblicazioneDa);
		hash.put("dataPubblicazioneA", dataPubblicazioneA);
		hash.put("cig", cig);
		hash.put("codiceStazAppaltante", codiceStazAppaltante);
		// memorizzo un parametro con la data odierna senza orario
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		Date dataAttuale = new Date(gc.getTimeInMillis());
		hash.put("dataAttuale", dataAttuale);
		if (deltaGiorniBandiScaduti != null) {
			GregorianCalendar dataScadenza = (GregorianCalendar) gc
					.clone();
			dataScadenza.add(Calendar.DATE, -deltaGiorniBandiScaduti);
			hash.put("dataScadenza", new Date(
					dataScadenza.getTimeInMillis()));
		}
		return (List<DettaglioBandoType>) this.getSqlMapClientTemplate()
				.queryForList("getElencoDettagliBandiScaduti", hash);
	}

	@SuppressWarnings("unchecked")
	public List<DettaglioBandoType> getBando(String codice, String tipo)
			throws DataAccessException {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		hash.put("tipo", tipo);
		return (List<DettaglioBandoType>) this.getSqlMapClientTemplate()
				.queryForList("getBando", hash);
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoAllegatoType> getDocumentiBando(String codice,
			String tipo) throws DataAccessException {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("codice", codice);
		hash.put("tipo", tipo);
		return (List<DocumentoAllegatoType>) this.getSqlMapClientTemplate()
				.queryForList("getDocumentiBando", hash);
	}

	public FileType downloadDocumentoBando(String codice, String tipo, int id)
			throws DataAccessException {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("codice", codice);
		hash.put("tipo", tipo);
		hash.put("id", new Integer(id));
		return (FileType) this.getSqlMapClientTemplate().queryForObject(
				"downloadDocumentoBando", hash);
	}

	@SuppressWarnings("unchecked")
	public List<EsitoProspettoBeneficiariType> getProspettoBeneficiari(
			Date dataAffidamentoDa, Date dataAffidamentoA) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("dataAffidamentoDa", dataAffidamentoDa);
		hash.put("dataAffidamentoA", dataAffidamentoA);
		return (List<EsitoProspettoBeneficiariType>) this.getSqlMapClientTemplate()
				.queryForList("getProspettoBeneficiari", hash);
	}

	public Integer getNumeroDocumentiBeneficiario(String codice, String codiceBeneficiario) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		hash.put("codiceBeneficiario", codiceBeneficiario);
		return (Integer) this.getSqlMapClientTemplate().queryForObject(
				"getNumeroDocumentiBeneficiario", hash);
	}

	@SuppressWarnings("unchecked")
	public List<FileType> downloadDocumentiBeneficiario(String codice, String codiceBeneficiario) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		hash.put("codiceBeneficiario", codiceBeneficiario);
		return (List<FileType>) this.getSqlMapClientTemplate().queryForList(
				"downloadDocumentiBeneficiario", hash);
	}

	@SuppressWarnings("unchecked")
	public List<AppaltoAggiudicatoAnticorruzione> getProspettoGareContrattiAnticorruzione(
			int anno, String cig, String proponente, 
			String oggetto, String partecipante, String aggiudicatario) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("anno", anno);
		//WE1158
		if (cig != null && cig.length() > 0) {
			hash.put("cig", "%" + cig.toUpperCase() + "%");
		}
		if (StringUtils.isNotEmpty(proponente))
			hash.put("proponente", "%" + proponente.toUpperCase() + "%");
		if (StringUtils.isNotEmpty(oggetto))
			hash.put("oggetto", "%" + oggetto.toUpperCase() + "%");
		if (StringUtils.isNotEmpty(partecipante))
			hash.put("partecipante", "%" + partecipante.toUpperCase() + "%");
		if (StringUtils.isNotEmpty(aggiudicatario))
			hash.put("aggiudicatario", "%" + aggiudicatario.toUpperCase() + "%");
		return (List<AppaltoAggiudicatoAnticorruzione>) this.getSqlMapClientTemplate()
				.queryForList("getProspettoGareContrattiAnticorruzione", hash);
	}

	@SuppressWarnings("unchecked")
	public List<PartecipanteType> getDitteProspettoGareContrattiAnticorruzione(
			int idLotto, boolean soloAggiudicataria) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("idLotto", idLotto);
		if (soloAggiudicataria) {
			hash.put("aggiudicataria", soloAggiudicataria);
		}
		return (List<PartecipanteType>) this.getSqlMapClientTemplate().queryForList(
				"getDitteProspettoGareContrattiAnticorruzione", hash);
	}

	@SuppressWarnings("unchecked")
	public List<String> getElencoStazioniAppaltanti()
			throws DataAccessException {
		return (List<String>) this.getSqlMapClientTemplate()
				.queryForList("getElencoStazioniAppaltanti");
	}

	@SuppressWarnings("unchecked")
	public List<AdempimentoAnticorruzioneType> getAdempimentoAnticorruzione(Integer anno) {
		
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("anno", anno);
		return (List<AdempimentoAnticorruzioneType>) this.getSqlMapClientTemplate().queryForList("getAdempimentiAnticorruzione",hash);
	}

	@SuppressWarnings("unchecked")
	public List<ProspettoContrattoType> getProspettoContratti(
			String cig,
			String stazioneAppaltante, 
			String oggetto,
			String tipologiaContratto, 
			String partecipante, 
			String aggiudicatario, 
			Date dataPubblicazioneEsitoDa, Date dataPubblicazioneEsitoA) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("cig", StringUtils.isBlank(cig)? null : cig.toUpperCase());
		hash.put("stazioneAppaltante", StringUtils.isBlank(stazioneAppaltante) ? null : stazioneAppaltante);
		hash.put("oggetto", StringUtils.isEmpty(oggetto) ? null : "%"+oggetto.toUpperCase()+"%");
		hash.put("tipoAppalto", StringUtils.isEmpty(tipologiaContratto) ? null : tipologiaContratto);
		hash.put("partecipante", StringUtils.isEmpty(partecipante) ? null : "%" + partecipante.toUpperCase() + "%");
		hash.put("aggiudicatario", StringUtils.isEmpty(aggiudicatario) ? null : "%" + aggiudicatario.toUpperCase() + "%");
		hash.put("dataPubblicazioneEsitoDa", (dataPubblicazioneEsitoDa == null) ? null : dataPubblicazioneEsitoDa);
		hash.put("dataPubblicazioneEsitoA", (dataPubblicazioneEsitoA == null) ? null : dataPubblicazioneEsitoA);
		return (List<ProspettoContrattoType>) this.getSqlMapClientTemplate().queryForList("getProspettoContratto",hash);
	}
	
	public ProspettoContrattoType getInfoContratto(String codice) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		return (ProspettoContrattoType) this.getSqlMapClientTemplate().queryForObject("getInfoContratto",hash);
	}
	
	@SuppressWarnings("unchecked")
	public List<OperatoreInvitatoType> getOperatoriInvitatiContratto(String codice) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice.toUpperCase());
		return (List<OperatoreInvitatoType>) this.getSqlMapClientTemplate().queryForList("getOperatoriInvitatiContratto",hash);
	}

	@SuppressWarnings("unchecked")
	public List<OperatoreType> getComponentiRTI(String ditta) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("ditta", ditta);
		return (List<OperatoreType>) this.getSqlMapClientTemplate().queryForList("getComponentiRTI",hash);
	}
	
	public boolean isSingolaAggiudicataria(String codice) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		return  ((Integer) this.getSqlMapClientTemplate().queryForObject("isSingolaAggiudicataria", hash)).intValue() == 1;
	}

	@SuppressWarnings("unchecked")
	public List<OperatoreInvitatoType> getListaAggiudicatari(String codice) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		return (List<OperatoreInvitatoType>) this.getSqlMapClientTemplate().queryForList("getListaAggiudicatari",hash);
	}

	@SuppressWarnings("unchecked")
	public String getAggiudicataria(String codice) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		return (String) this.getSqlMapClientTemplate().queryForObject("getAggiudicataria",hash);
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsulenteCollaboratoreType> getConsulentiCollaboratori(
			String stazioneAppaltante,
			String soggettoPercettore, 
			Date dataDa, Date dataA,
			String ragioneIncarico, 
			Double compensoPrevistoDa, Double compensoPrevistoA) throws DataAccessException 
	{
		HashMap<String, Object> hash = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(stazioneAppaltante)) {
			hash.put("stazioneAppaltante", stazioneAppaltante);
		}
		if(StringUtils.isNotEmpty(soggettoPercettore)) {
			hash.put("soggettoPercettore", "%" + soggettoPercettore.toUpperCase() + "%");
		}
		hash.put("dataDa", dataDa);		// da data provvedimento
		hash.put("dataA", dataA);		// a data provvedimento
		if(StringUtils.isNotEmpty(ragioneIncarico)) {
			hash.put("ragioneIncarico", "%" + ragioneIncarico.toUpperCase()  + "%");
		}
		hash.put("compensoPrevistoDa", compensoPrevistoDa);
		hash.put("compensoPrevistoA", compensoPrevistoA);
		return (List<ConsulenteCollaboratoreType>) this.getSqlMapClientTemplate()
				.queryForList("getConsulentiCollaboratori", hash);
	}

	@SuppressWarnings("unchecked")
	public Integer getNumeroDocumentiConsulente(String codice, String codiceSoggetto) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("codice", codice);
		hash.put("codiceSoggetto", codiceSoggetto);
		return (Integer) this.getSqlMapClientTemplate().queryForObject(
				"getNumeroDocumentiConsulente", hash);
	}
	
	@SuppressWarnings("unchecked")
	public List<FileType> downloadDocumentiConsulentiCollaboratori(
			String codice, String codiceSoggetto) throws DataAccessException {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("codice", codice);
		hash.put("codiceSoggetto", codiceSoggetto);
		return (List<FileType>) this.getSqlMapClientTemplate().queryForList(
				"downloadDocumentiConsulentiCollaboratori", hash);
	}

}
