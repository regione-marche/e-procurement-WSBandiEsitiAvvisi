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
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Produce il feed rss dei bandi e avvisi scaduti.
 * 
 * @author Stefano.Sabbadin
 */
@Component(value = "RssFeedBandiScaduti")
public class RssFeedBandiScaduti extends AbstractRssFeedBandi {

	@Resource
	private String deltaGiorniBandiScaduti;
	@Resource
	private String rssFilenameBandiScaduti;

	@PostConstruct
	private void init() {
		setChannelDescription("Elenco dei bandi e avvisi di gara scaduti");
		setChannelTitle("Bandi di gara scaduti");
		setRssFilenameBandi(rssFilenameBandiScaduti);
	}
	
	/**
	 * @param deltaGiorniBandiScaduti the deltaGiorniBandiScaduti to set
	 */
	public void setDeltaGiorniBandiScaduti(String deltaGiorniBandiScaduti) {
		this.deltaGiorniBandiScaduti = deltaGiorniBandiScaduti;
	}

	@Override
	public List<DettaglioBandoType> getElencoBandi(String codiceFiscaleAmministrazione) {
		Integer delta = null;
		try {
			if (StringUtils.isNotEmpty(deltaGiorniBandiScaduti))
				delta = Integer.parseInt(deltaGiorniBandiScaduti);
		} catch (NumberFormatException e) {
		}
		return bandiManager.getElencoDettagliBandiScaduti(null, null, null, null, null, codiceFiscaleAmministrazione, delta);
	}
	
}
