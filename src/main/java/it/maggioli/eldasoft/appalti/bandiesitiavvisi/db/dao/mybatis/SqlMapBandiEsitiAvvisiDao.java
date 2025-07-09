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
package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.mybatis;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.dao.BandiEsitiAvvisiDao;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.mapper.BandiEsitiAvvisiMapper;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo.AppaltoAggiudicatoAnticorruzione;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Classe di appoggio per l'esecuzione tramite estensione del framework Spring
 * di interazioni con le tabelle per la gestione dei bandi, esiti ed avvisi.
 * 
 * @author Stefano.Sabbadin
 */
@Component
public class SqlMapBandiEsitiAvvisiDao implements BandiEsitiAvvisiDao {
	
	@Autowired
	private BandiEsitiAvvisiMapper bandiMapper;

	public List<BandoListaType> getElencoBandi(String tipo, String contratto,
			Date dataPubblicazioneDa, Date dataPubblicazioneA,
			String cig, String codiceStazAppaltante) throws DataAccessException {
		// memorizzo un parametro con la data odierna senza orario
		Date dataAttuale = getDateWithoutTime();
		Date scadenzaEsito = dataAttuale;
		
		return bandiMapper.getElencoBandi(
				dataAttuale
				, null
				, scadenzaEsito
				, tipo
				, contratto
				, dataPubblicazioneDa
				, dataPubblicazioneA
				, codiceStazAppaltante
				, cig);
	}
	
	public List<BandoListaType> getElencoBandiScaduti(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante) throws DataAccessException {
		// memorizzo un parametro con la data odierna senza orario
		Date currentTime = getDateWithoutTime();
		return bandiMapper.getElencoBandiScaduti(
				  currentTime
				, null
				, tipo
				, contratto
				, dataPubblicazioneDa
				, dataPubblicazioneA
				, codiceStazAppaltante
				, cig
				);
	}
	
	public List<DettaglioBandoType> getElencoDettagliBandi(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA, String cig, String codiceStazAppaltante, 
			Integer deltaGiorniBandi) throws DataAccessException {
		Date dataScadenzaEsito = null;
		Date dataAttuale = null;
		Date dataPubblicazioneConDelta = null;
		
		// memorizzo un parametro con la data odierna senza orario
		GregorianCalendar gc = getCalendarWithoutTime();
		dataAttuale = new Date(gc.getTimeInMillis());
		if (deltaGiorniBandi != null) {
			dataPubblicazioneConDelta = addDayToCalendarAndGetDate((GregorianCalendar) gc.clone(), -deltaGiorniBandi);
			dataScadenzaEsito = addDayToCalendarAndGetDate((GregorianCalendar) gc.clone(), 180 - deltaGiorniBandi);
		} else {
			//dataPubblicazioneConDelta non serve, serve solo dataScadenzaEsito
			dataScadenzaEsito = new Date(gc.getTimeInMillis());
		}
		return bandiMapper.getElencoDettagliBandi(
				  dataAttuale
				, null
				, tipo
				, contratto
				, dataPubblicazioneDa
				, dataPubblicazioneA
				, dataPubblicazioneConDelta
				, codiceStazAppaltante
				, dataScadenzaEsito
				, cig);
	}
	
	public List<DettaglioBandoType> getElencoDettagliBandiScaduti(String tipo,
			String contratto, Date dataPubblicazioneDa,
			Date dataPubblicazioneA,  String cig, String codiceStazAppaltante,
			Integer deltaGiorniBandiScaduti) throws DataAccessException {
		Date dataScadenza = null;
		// memorizzo un parametro con la data odierna senza orario
		GregorianCalendar gc = getCalendarWithoutTime();
		Date dataAttuale = new Date(gc.getTimeInMillis());
		if (deltaGiorniBandiScaduti != null)
			dataScadenza = addDayToCalendarAndGetDate((GregorianCalendar) gc.clone(), -deltaGiorniBandiScaduti);
		
		return bandiMapper.getElencoDettagliBandiScaduti(
				  dataAttuale
				, dataScadenza
				, tipo
				, contratto
				, dataPubblicazioneDa
				, dataPubblicazioneA
				, codiceStazAppaltante
				, cig);
	}
	
	public List<DettaglioBandoType> getBando(String codice, String tipo) throws DataAccessException {
		return bandiMapper.getBando(codice, tipo);
	}
	
	public List<DocumentoAllegatoType> getDocumentiBando(String codice,
			String tipo) throws DataAccessException {
		return bandiMapper.getDocumentiBando(codice, tipo);
	}
	
	public FileType downloadDocumentoBando(String codice, String tipo, int id) throws DataAccessException {
		//hash.put("id", new Integer(id));
		return bandiMapper.downloadDocumentoBando(codice, tipo, id);
	}
	
	public List<EsitoProspettoBeneficiariType> getProspettoBeneficiari(
			Date dataAffidamentoDa, Date dataAffidamentoA) {
		return bandiMapper.getProspettoBeneficiari(dataAffidamentoDa, dataAffidamentoA);
	}
	
	public Integer getNumeroDocumentiBeneficiario(String codice, String codiceBeneficiario) {
		return bandiMapper.getNumeroDocumentiBeneficiario(codice, codiceBeneficiario);
	}
	
	public List<FileType> downloadDocumentiBeneficiario(String codice, String codiceBeneficiario) {
		return bandiMapper.downloadDocumentiBeneficiario(codice, codiceBeneficiario);
	}
	
	public List<AppaltoAggiudicatoAnticorruzione> getProspettoGareContrattiAnticorruzione(
			int anno, String cig, String proponente,
			String oggetto, String partecipante, String aggiudicatario, int indicePrimoRecord, int maxNumRecord) {
		//WE1158
		if (StringUtils.isNotEmpty(cig))
			cig = "%" + cig.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(proponente))
			proponente = "%" + proponente.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(oggetto))
			oggetto = "%" + oggetto.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(partecipante))
			partecipante = "%" + partecipante.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(aggiudicatario))
			aggiudicatario = "%" + aggiudicatario.toUpperCase() + "%";
		
		return bandiMapper.getProspettoGareContrattiAnticorruzione(
				  anno
				, cig
				, proponente
				, oggetto
				, partecipante
				, aggiudicatario
				, getBounds((long) indicePrimoRecord, (long) maxNumRecord)
		);
	}

	public int countProspettoGareContrattiAnticorruzione(
			int anno, String cig, String proponente,
			String oggetto,
			String partecipante, String aggiudicatario
	) {
		if (StringUtils.isNotEmpty(cig))
			cig = "%" + cig.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(proponente))
			proponente = "%" + proponente.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(oggetto))
			oggetto = "%" + oggetto.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(partecipante))
			partecipante = "%" + partecipante.toUpperCase() + "%";
		if (StringUtils.isNotEmpty(aggiudicatario))
			aggiudicatario = "%" + aggiudicatario.toUpperCase() + "%";

		return bandiMapper.countProspettoGareContrattiAnticorruzione(anno, cig, proponente, oggetto, partecipante, aggiudicatario);
	}
	
	public List<PartecipanteType> getDitteProspettoGareContrattiAnticorruzione(
			int idLotto, boolean soloAggiudicataria) {
		String aggiudicatariaString = soloAggiudicataria ? Boolean.toString(soloAggiudicataria) : null;
		return bandiMapper.getDitteProspettoGareContrattiAnticorruzione(idLotto, aggiudicatariaString);
	}
	
	public List<String> getElencoStazioniAppaltanti() throws DataAccessException {
		return bandiMapper.getElencoStazioniAppaltanti();
	}
	
	public List<AdempimentoAnticorruzioneType> getAdempimentoAnticorruzione(Integer anno) {
		return bandiMapper.getAdempimentiAnticorruzione(anno);
	}
	
	public List<ProspettoContrattoType> getProspettoContratti(
			String cig,
			String stazioneAppaltante, 
			String oggetto,
			String tipologiaContratto, 
			String partecipante, 
			String aggiudicatario, 
			Date dataPubblicazioneEsitoDa, Date dataPubblicazioneEsitoA) {
		cig = StringUtils.isEmpty(cig) ? null : "%" + cig.toUpperCase() + "%";
		stazioneAppaltante = StringUtils.isEmpty(stazioneAppaltante) ? null : stazioneAppaltante;
		oggetto = StringUtils.isEmpty(oggetto) ? null : "%" + oggetto.toUpperCase() + "%";
//		tipologiaContratto = StringUtils.isEmpty(tipologiaContratto) ? null : tipologiaContratto;	//Campo commentato sull'xml
		partecipante = StringUtils.isEmpty(partecipante) ? null : "%" + partecipante.toUpperCase() + "%";
		aggiudicatario = StringUtils.isEmpty(aggiudicatario) ? null : "%" + aggiudicatario.toUpperCase() + "%";
		
		return bandiMapper.getProspettoContratto(
				  cig
				, stazioneAppaltante
				, oggetto
				, partecipante
				, aggiudicatario
				, dataPubblicazioneEsitoDa
				, dataPubblicazioneEsitoA);
	}
	
	public ProspettoContrattoType getInfoContratto(String codice) {
		return bandiMapper.getInfoContratto(codice);
	}
	
	public List<OperatoreInvitatoType> getOperatoriInvitatiContratto(String codice) {
		return bandiMapper.getOperatoriInvitatiContratto(codice);
	}
	
	public List<OperatoreType> getComponentiRTI(String ditta) {
		return bandiMapper.getComponentiRTI(ditta);
	}
	
	public boolean isSingolaAggiudicataria(String codice) {
		return bandiMapper.isSingolaAggiudicataria(codice) == 1;
	}
	
	public List<OperatoreInvitatoType> getListaAggiudicatari(String codice) {
		return bandiMapper.getListaAggiudicatari(codice);
	}
	
	public String getAggiudicataria(String codice) {
		return bandiMapper.getAggiudicataria(codice);
	}
	
	public List<ConsulenteCollaboratoreType> getConsulentiCollaboratori(
			String stazioneAppaltante,
			String soggettoPercettore, 
			Date dataDa, Date dataA,
			String ragioneIncarico, 
			Double compensoPrevistoDa, Double compensoPrevistoA) throws DataAccessException {
		if(StringUtils.isEmpty(stazioneAppaltante))
			stazioneAppaltante = null;
		if(StringUtils.isNotEmpty(soggettoPercettore))
			soggettoPercettore = "%" + soggettoPercettore.toUpperCase() + "%";
		if(StringUtils.isNotEmpty(ragioneIncarico))
			ragioneIncarico = "%" + ragioneIncarico.toUpperCase()  + "%";
		return bandiMapper.getConsulentiCollaboratori(
				  stazioneAppaltante
				, soggettoPercettore
				, dataDa
				, dataA
				, ragioneIncarico
				, compensoPrevistoDa
				, compensoPrevistoA);
	}
	
	public Integer getNumeroDocumentiConsulente(String codice, String codiceSoggetto) {
		return bandiMapper.getNumeroDocumentiConsulente(codice, codiceSoggetto);
	}
	
	public List<FileType> downloadDocumentiConsulentiCollaboratori(
			String codice, String codiceSoggetto) throws DataAccessException {
		return bandiMapper.downloadDocumentiConsulentiCollaboratori(codice, codiceSoggetto);
	}
	
	private GregorianCalendar getCalendarWithoutTime() {
		GregorianCalendar calendar = new GregorianCalendar();
		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar;
	}
	
	private Date getDateWithoutTime() {
		return new Date(getCalendarWithoutTime().getTimeInMillis());
	}

	private Date addDayToCalendarAndGetDate(GregorianCalendar calendar, int days) {
		calendar.add(Calendar.DATE, days);
		return new Date(calendar.getTimeInMillis());
	}

	public RowBounds getBounds(Long indicePrimoRecord, Long maxNumRecord) {
		return new RowBounds(
				indicePrimoRecord == null ? 0 : indicePrimoRecord.intValue()
				, maxNumRecord == null || maxNumRecord == 0L ? Integer.MAX_VALUE : maxNumRecord.intValue()
		);
	}
	
}
