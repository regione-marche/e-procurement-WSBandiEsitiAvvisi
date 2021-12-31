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
 * Produce il feed rss dei bandi e avvisi scaduti.
 * 
 * @author Stefano.Sabbadin
 */
public class RssFeedBandiScaduti extends AbstractRssFeedBandi {

	private Integer deltaGiorniBandiScaduti;
	
	/**
	 * @param deltaGiorniBandiScaduti the deltaGiorniBandiScaduti to set
	 */
	public void setDeltaGiorniBandiScaduti(Integer deltaGiorniBandiScaduti) {
		this.deltaGiorniBandiScaduti = deltaGiorniBandiScaduti;
	}

	@Override
	public List<DettaglioBandoType> getElencoBandi(String codiceFiscaleAmministrazione) {
		return this.getBandiManager().getElencoDettagliBandiScaduti(null, null, null, null, null, codiceFiscaleAmministrazione, deltaGiorniBandiScaduti);
	}

}
