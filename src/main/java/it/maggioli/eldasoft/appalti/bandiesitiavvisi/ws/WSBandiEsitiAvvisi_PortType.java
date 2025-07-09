/**
 * WSBandiEsitiAvvisi_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public interface WSBandiEsitiAvvisi_PortType extends java.rmi.Remote {
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType getElencoBandi(java.lang.String token, java.lang.String tipo, java.lang.String contratto, java.util.Date pubblicazioneDa, java.util.Date pubblicazioneA, java.lang.String cig, java.lang.String codiceStazAppaltante) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType getElencoBandiScaduti(java.lang.String token, java.lang.String tipo, java.lang.String contratto, java.util.Date pubblicazioneDa, java.util.Date pubblicazioneA, java.lang.String cig, java.lang.String codiceStazAppaltante) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoOutType getDettaglioBando(java.lang.String token, java.lang.String codice, java.lang.String tipo) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoBandoOutType getDocumentoBando(java.lang.String token, java.lang.String codice, java.lang.String tipo, int id) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoBeneficiariOutType getProspettoBeneficiari(java.lang.String token, java.util.Date dataAffidamentoDa, java.util.Date dataAffidamentoA) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiBeneficiarioOutType getDocumentiBeneficiario(java.lang.String token, java.lang.String codice, java.lang.String codiceBeneficiario) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoGareContrattiAnticorruzioneOutType getProspettoGareContrattiAnticorruzione(java.lang.String token, int anno, java.lang.String cig, java.lang.String proponente, java.lang.String oggetto, java.lang.String partecipante, java.lang.String aggiudicatario, int indicePrimoRecord, int maxNumRecord) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneOutType getAdempimentiAnticorruzione(java.lang.String token, java.lang.Integer anno) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattiOutType getProspettoContratti(java.lang.String token, java.lang.String cig, java.lang.String strutturaProponente, java.lang.String oggetto, java.lang.String tipoAppalto, java.lang.String partecipante, java.lang.String aggiudicatario, java.util.Date dataPubblicazioneEsitoDa, java.util.Date dataPubblicazioneEsitoA) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoOutType getDettaglioContratto(java.lang.String token, java.lang.String codice) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.VersionOutType getVersion() throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulentiCollaboratoriOutType getConsulentiCollaboratori(java.lang.String token, java.lang.String stazioneAppaltante, java.lang.String soggettoPercettore, java.util.Date dataDa, java.util.Date dataA, java.lang.String ragioneIncarico, java.lang.Double compensoPrevistoDa, java.lang.Double compensoPrevistoA) throws java.rmi.RemoteException;
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiConsulentiCollaboratoriOutType getDocumentiConsulentiCollaboratori(java.lang.String token, java.lang.String codice, java.lang.String codiceSoggetto) throws java.rmi.RemoteException;
}
