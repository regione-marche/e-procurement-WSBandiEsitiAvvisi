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
 * Produce il feed rss dei bandi, esiti ed avvisi in corso.
 * 
 * @author Stefano.Sabbadin
 */
@Component(value = "RssFeedBandi")
public class RssFeedBandi extends AbstractRssFeedBandi {

	@Resource
	private String deltaGiorniBandi;
	@Resource
	private String rssFilenameBandi;


	@PostConstruct
	private void init() {
		setChannelTitle("Bandi di gara");
		setChannelDescription("Elenco dei bandi, avvisi e esiti di gara non scaduti");
		setRssFilenameBandi(rssFilenameBandi);
	}
	
	/**
	 * @param deltaGiorniBandi the deltaGiorniBandi to set
	 */
	public void setDeltaGiorniBandi(String deltaGiorniBandi) {
		this.deltaGiorniBandi = deltaGiorniBandi;
	}


	@Override
	public List<DettaglioBandoType> getElencoBandi(String codiceFiscaleAmministrazione) {
		Integer delta = null;
		try {
			if (StringUtils.isNotEmpty(deltaGiorniBandi))
				delta = Integer.parseInt(deltaGiorniBandi);
		} catch (NumberFormatException e) {
		}
		return bandiManager.getElencoDettagliBandi(null, null, null, null, null, codiceFiscaleAmministrazione, delta);
	}
	
}
