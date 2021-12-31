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

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType;

import java.util.List;


/**
 * Produce il feed rss dei bandi, esiti ed avvisi in corso.
 * 
 * @author Stefano.Sabbadin
 */
public class RssFeedBandi extends AbstractRssFeedBandi {

	private Integer deltaGiorniBandi;

	
	/**
	 * @param deltaGiorniBandi the deltaGiorniBandi to set
	 */
	public void setDeltaGiorniBandi(Integer deltaGiorniBandi) {
		this.deltaGiorniBandi = deltaGiorniBandi;
	}


	@Override
	public List<DettaglioBandoType> getElencoBandi(String codiceFiscaleAmministrazione) {
		return this.getBandiManager().getElencoDettagliBandi(null, null, null, null, null, codiceFiscaleAmministrazione, deltaGiorniBandi);
	}
}
