package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.mapper;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo.AppaltoAggiudicatoAnticorruzione;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * Interfaccia che rappresenta in java il BandiEsitiAvvisiMapper.xml, facendo l'autowired
 * è possibile effettuare le SELECT/INSERT/UPDATE... delle query nell'xml
 *  
 * @author cmantini
 *
 */
@Mapper
public interface BandiEsitiAvvisiMapper {

	public List<FileType> downloadDocumentiConsulentiCollaboratori(
			  @Param("codice") String codice
			, @Param("codiceSoggetto") String codiceSoggetto);
	
	public int getNumeroDocumentiConsulente(
			  @Param("codice") String codice
			, @Param("codiceSoggetto") String codiceSoggetto);

	public List<ConsulenteCollaboratoreType> getConsulentiCollaboratori(
			  @Param("stazioneAppaltante") String stazioneAppaltante
			, @Param("soggettoPercettore") String soggettoPercettore
			, @Param("dataDa") Date dataDa
			, @Param("dataA") Date dataA
			, @Param("ragioneIncarico") String ragioneincarico
			, @Param("compensoPrevistoDa") Double compensoPrevistoDa
			, @Param("compensoPrevistoA") Double compensoPrevistoA);

	public String getAggiudicataria(
			  @Param("codice") String codice);

	public List<OperatoreInvitatoType> getListaAggiudicatari(
			  @Param("codice") String codice);
	
	public int isSingolaAggiudicataria(
			  @Param("codice") String codice);
	
	public List<OperatoreType> getComponentiRTI(
			  @Param("ditta") String ditta);

	public List<OperatoreInvitatoType> getOperatoriInvitatiContratto(
			  @Param("codice") String codice);
	
	public ProspettoContrattoType getInfoContratto(
			  @Param("codice") String codice);

	public List<ProspettoContrattoType> getProspettoContratto(
			  @Param("cig") String cig
			, @Param("stazioneAppaltante") String stazioneAppaltante
			, @Param("oggetto") String oggetto
			, @Param("partecipante") String partecipante
			, @Param("aggiudicatario") String aggiudicatario
			, @Param("dataPubblicazioneEsitoDa") Date dataPubblicazioneEsitoDa
			, @Param("dataPubblicazioneEsitoA") Date dataPubblicazioneEsitoA);
	
	public List<AdempimentoAnticorruzioneType> getAdempimentiAnticorruzione(
			  @Param("anno") Integer anno);

	public List<PartecipanteType> getDitteProspettoGareContrattiAnticorruzione(
			  @Param("idLotto") Integer idLotto
			, @Param("aggiudicataria") String aggiudicataria);
	
	public List<AppaltoAggiudicatoAnticorruzione> getProspettoGareContrattiAnticorruzione(
			  @Param("anno") Integer anno
			, @Param("cig") String cig
			, @Param("proponente") String proponente
			, @Param("oggetto") String oggetto
			, @Param("partecipante") String partecipante
			, @Param("aggiudicatario") String aggiudicatario
		    , RowBounds bounds
	);

	public List<FileType> downloadDocumentiBeneficiario(
			  @Param("codice") String codice
			, @Param("codiceBeneficiario") String codiceBeneficiario);

	public int getNumeroDocumentiBeneficiario(
			  @Param("codice") String codice
			, @Param("codiceBeneficiario") String codiceBeneficiario);
	
	public List<EsitoProspettoBeneficiariType> getProspettoBeneficiari(
			  @Param("dataAffidamentoDa") Date dataAffidamentoDa
			, @Param("dataAffidamentoA") Date dataAffidamentoA);
	
	public FileType downloadDocumentoBando(
			  @Param("codice") String codice
			, @Param("tipo") String tipo
			, @Param("id") Integer id);
	
	public List<DocumentoAllegatoType> getDocumentiBando(
			  @Param("codice") String codice
			, @Param("tipo") String tipo);

	public List<DettaglioBandoType> getBando(
			  @Param("codice") String codice
			, @Param("tipo") String tipo);

	public List<DettaglioBandoType> getElencoDettagliBandiScaduti(
			  @Param("dataAttuale") Date dataAttuale
			, @Param("dataScadenza") Date dataScadenza
			, @Param("tipo") String tipo
			, @Param("contratto") String contratto
			, @Param("dataPubblicazioneDa") Date dataPubblicazioneDa
			, @Param("dataPubblicazioneA") Date dataPubblicazioneA
			, @Param("codiceStazAppaltante") String codiceStazAppaltante
			, @Param("cig") String cig);

	public List<DettaglioBandoType> getElencoDettagliBandi(
			  @Param("dataAttuale") Date dataAttuale
			, @Param("dataScadenza") Date dataScadenza
			, @Param("tipo") String tipo
			, @Param("contratto") String contratto
			, @Param("dataPubblicazioneDa") Date dataPubblicazioneDa
			, @Param("dataPubblicazioneA") Date dataPubblicazioneA
			, @Param("dataPubblicazioneConDelta") Date dataPubblicazioneConDelta
			, @Param("codiceStazAppaltante") String codiceStazAppaltante
			, @Param("dataScadenzaEsito") Date dataScadenzaEsito
			, @Param("cig") String cig);
	
	public List<String> getElencoStazioniAppaltanti();
	
	public List<BandoListaType> getElencoBandiScaduti(
			  @Param("dataAttuale") Date dataAttuale
			, @Param("dataScadenza") Date dataScadenza
			, @Param("tipo") String tipo
			, @Param("contratto") String contratto
			, @Param("dataPubblicazioneDa") Date dataPubblicazioneDa
			, @Param("dataPubblicazioneA") Date dataPubblicazioneA
			, @Param("codiceStazAppaltante") String codiceStazAppaltante
			, @Param("cig") String cig);
	
	public List<BandoListaType> getElencoBandi(
			  @Param("dataAttuale") Date dataAttuale
			, @Param("dataPubblicazioneConDelta") Date dataPubblicazioneConDelta
			, @Param("dataScadenzaEsito") Date dataScadenzaEsito
			, @Param("tipo") String tipo
			, @Param("contratto") String contratto
			, @Param("dataPubblicazioneDa") Date dataPubblicazioneDa
			, @Param("dataPubblicazioneA") Date dataPubblicazioneA
			, @Param("codiceStazAppaltante") String codiceStazAppaltante
			, @Param("cig") String cig);

	int countProspettoGareContrattiAnticorruzione(
			@Param("anno") Integer anno
			, @Param("cig") String cig
			, @Param("proponente") String proponente
			, @Param("oggetto") String oggetto
			, @Param("partecipante") String partecipante
			, @Param("aggiudicatario") String aggiudicatario
	);
}
