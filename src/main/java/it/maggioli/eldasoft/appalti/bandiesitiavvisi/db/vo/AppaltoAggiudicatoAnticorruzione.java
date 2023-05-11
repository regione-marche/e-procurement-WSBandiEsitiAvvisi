/*
 * Created on 11/set/13
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */
package it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo;

import it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType;

/**
 * Wrapper che estende AppaltoAggiudicatoAnticorruzioneType aggiungendo
 * l'idlotto per le operazioni interne di recupero dati.
 * 
 * @author Stefano.Sabbadin
 */
public class AppaltoAggiudicatoAnticorruzione extends
		AppaltoAggiudicatoAnticorruzioneType {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -8150000150947211043L;

	private int idLotto;

	/**
	 * @return the idLotto
	 */
	public int getIdLotto() {
		return idLotto;
	}

	/**
	 * @param idLotto
	 *            the idLotto to set
	 */
	public void setIdLotto(int idLotto) {
		this.idLotto = idLotto;
	}

}
