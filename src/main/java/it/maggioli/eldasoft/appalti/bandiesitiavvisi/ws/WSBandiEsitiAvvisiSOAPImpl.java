/**
 * WSBandiEsitiAvvisiSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;


import java.rmi.RemoteException;
import java.util.Date;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl.BandiEsitiAvvisiFacade;
import it.maggioli.eldasoft.appalti.bandiesitiavvisi.utils.SpringAppContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WSBandiEsitiAvvisiSOAPImpl implements it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_PortType{
	public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType getElencoBandi(
			java.lang.String token, java.lang.String tipo,
			java.lang.String contratto, java.util.Date pubblicazioneDa,
			java.util.Date pubblicazioneA, java.lang.String cig, java.lang.String codiceStazAppaltante)
			throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getElencoBandi(token, tipo, contratto, pubblicazioneDa,
				pubblicazioneA, cig, codiceStazAppaltante);
	}

	public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType getElencoBandiScaduti(
			java.lang.String token, java.lang.String tipo,
			java.lang.String contratto, java.util.Date pubblicazioneDa,
			java.util.Date pubblicazioneA, java.lang.String cig, java.lang.String codiceStazAppaltante)
			throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getElencoBandiScaduti(token, tipo, contratto, pubblicazioneDa,
				pubblicazioneA, cig, codiceStazAppaltante);
	}

	public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoOutType getDettaglioBando(
			java.lang.String token, java.lang.String codice,
			java.lang.String tipo) throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getDettaglioBando(token, codice, tipo);
	}

	public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoBandoOutType getDocumentoBando(
			java.lang.String token, java.lang.String codice,
			java.lang.String tipo, int id) throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getDocumentoBando(token, codice, tipo, id);
	}

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoBeneficiariOutType getProspettoBeneficiari(java.lang.String token, java.util.Date dataAffidamentoDa, java.util.Date dataAffidamentoA) throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getProspettoBeneficiari(token,
				dataAffidamentoDa, dataAffidamentoA);
    }

	public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiBeneficiarioOutType getDocumentiBeneficiario(
			java.lang.String token, java.lang.String codice, java.lang.String codiceBeneficiario)
			throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getDocumentiBeneficiario(token, codice, codiceBeneficiario);
	}

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoGareContrattiAnticorruzioneOutType getProspettoGareContrattiAnticorruzione(String token, int anno, String cig, String proponente,
			String oggetto, String partecipante, String aggiudicatario) throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getProspettoGareContrattiAnticorruzione(token,
				anno, cig, proponente, oggetto, partecipante, aggiudicatario);
    }
    
	public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneOutType getAdempimentiAnticorruzione(
			java.lang.String token, java.lang.Integer anno) throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getAdempimentiAnticorruzione(token, anno);
	}

	public ProspettoContrattiOutType getProspettoContratti(
			String token,
			String cig, 
			String strutturaProponente, 
			String oggetto, 
			String tipologiaContratto,
			String partecipante, 
			String aggiudicatario,
			Date dataPubblicazioneEsitoDa, Date dataPubblicazioneEsitoA)
			throws RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getProspettoContratti(token, cig, strutturaProponente, oggetto, tipologiaContratto, partecipante, aggiudicatario, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA);
	}

	public DettaglioContrattoOutType getDettaglioContratto(String token,
			String cig) throws RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getDettaglioContratto(token, cig);
	}

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.VersionOutType getVersion() throws java.rmi.RemoteException {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(SpringAppContext.getServletContext());
		BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
				.getBean("bandiEsitiAvvisiFacade");
		return facade.getVersion();
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulentiCollaboratoriOutType getConsulentiCollaboratori(
    		java.lang.String token, java.lang.String stazioneAppaltante, java.lang.String soggettoPercettore, java.util.Date dataDa, java.util.Date dataA, 
    		java.lang.String ragioneIncarico, java.lang.Double compensoPrevistoDa, java.lang.Double compensoPrevistoA) throws java.rmi.RemoteException {
        ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(SpringAppContext.getServletContext());
        BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
			.getBean("bandiEsitiAvvisiFacade");
        return facade.getConsulentiCollaboratori(token, stazioneAppaltante, soggettoPercettore, dataDa, dataA, ragioneIncarico, compensoPrevistoDa, compensoPrevistoA);
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiConsulentiCollaboratoriOutType getDocumentiConsulentiCollaboratori(
    		java.lang.String token, java.lang.String codice, java.lang.String codiceSoggetto) throws java.rmi.RemoteException {
    	ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(SpringAppContext.getServletContext());
	    BandiEsitiAvvisiFacade facade = (BandiEsitiAvvisiFacade) ctx
			.getBean("bandiEsitiAvvisiFacade");
	    return facade.getDocumentiConsulentiCollaboratori(token, codice, codiceSoggetto);
    }

}
