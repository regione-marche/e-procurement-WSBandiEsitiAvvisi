/**
 * DettaglioContrattoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class DettaglioContrattoType  implements java.io.Serializable {
    private java.lang.String cig;

    private java.lang.String strutturaProponenteCF;

    private java.lang.String strutturaProponenteDenominazione;

    private java.lang.String oggetto;

    private java.lang.String sceltaContraente;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] elencoOperatoriInvitati;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] aggiudicatario;

    private java.lang.Double importoAggiudicazione;

    private java.lang.Double importoContratto;

    private java.util.Date dataInizio;

    private java.util.Date dataUltimazione;

    private java.lang.Double importoSommeLiquidate;

    private java.lang.String codice;

    public DettaglioContrattoType() {
    }

    public DettaglioContrattoType(
           java.lang.String cig,
           java.lang.String strutturaProponenteCF,
           java.lang.String strutturaProponenteDenominazione,
           java.lang.String oggetto,
           java.lang.String sceltaContraente,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] elencoOperatoriInvitati,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] aggiudicatario,
           java.lang.Double importoAggiudicazione,
           java.lang.Double importoContratto,
           java.util.Date dataInizio,
           java.util.Date dataUltimazione,
           java.lang.Double importoSommeLiquidate,
           java.lang.String codice) {
           this.cig = cig;
           this.strutturaProponenteCF = strutturaProponenteCF;
           this.strutturaProponenteDenominazione = strutturaProponenteDenominazione;
           this.oggetto = oggetto;
           this.sceltaContraente = sceltaContraente;
           this.elencoOperatoriInvitati = elencoOperatoriInvitati;
           this.aggiudicatario = aggiudicatario;
           this.importoAggiudicazione = importoAggiudicazione;
           this.importoContratto = importoContratto;
           this.dataInizio = dataInizio;
           this.dataUltimazione = dataUltimazione;
           this.importoSommeLiquidate = importoSommeLiquidate;
           this.codice = codice;
    }


    /**
     * Gets the cig value for this DettaglioContrattoType.
     * 
     * @return cig
     */
    public java.lang.String getCig() {
        return cig;
    }


    /**
     * Sets the cig value for this DettaglioContrattoType.
     * 
     * @param cig
     */
    public void setCig(java.lang.String cig) {
        this.cig = cig;
    }


    /**
     * Gets the strutturaProponenteCF value for this DettaglioContrattoType.
     * 
     * @return strutturaProponenteCF
     */
    public java.lang.String getStrutturaProponenteCF() {
        return strutturaProponenteCF;
    }


    /**
     * Sets the strutturaProponenteCF value for this DettaglioContrattoType.
     * 
     * @param strutturaProponenteCF
     */
    public void setStrutturaProponenteCF(java.lang.String strutturaProponenteCF) {
        this.strutturaProponenteCF = strutturaProponenteCF;
    }


    /**
     * Gets the strutturaProponenteDenominazione value for this DettaglioContrattoType.
     * 
     * @return strutturaProponenteDenominazione
     */
    public java.lang.String getStrutturaProponenteDenominazione() {
        return strutturaProponenteDenominazione;
    }


    /**
     * Sets the strutturaProponenteDenominazione value for this DettaglioContrattoType.
     * 
     * @param strutturaProponenteDenominazione
     */
    public void setStrutturaProponenteDenominazione(java.lang.String strutturaProponenteDenominazione) {
        this.strutturaProponenteDenominazione = strutturaProponenteDenominazione;
    }


    /**
     * Gets the oggetto value for this DettaglioContrattoType.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this DettaglioContrattoType.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the sceltaContraente value for this DettaglioContrattoType.
     * 
     * @return sceltaContraente
     */
    public java.lang.String getSceltaContraente() {
        return sceltaContraente;
    }


    /**
     * Sets the sceltaContraente value for this DettaglioContrattoType.
     * 
     * @param sceltaContraente
     */
    public void setSceltaContraente(java.lang.String sceltaContraente) {
        this.sceltaContraente = sceltaContraente;
    }


    /**
     * Gets the elencoOperatoriInvitati value for this DettaglioContrattoType.
     * 
     * @return elencoOperatoriInvitati
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] getElencoOperatoriInvitati() {
        return elencoOperatoriInvitati;
    }


    /**
     * Sets the elencoOperatoriInvitati value for this DettaglioContrattoType.
     * 
     * @param elencoOperatoriInvitati
     */
    public void setElencoOperatoriInvitati(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] elencoOperatoriInvitati) {
        this.elencoOperatoriInvitati = elencoOperatoriInvitati;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType getElencoOperatoriInvitati(int i) {
        return this.elencoOperatoriInvitati[i];
    }

    public void setElencoOperatoriInvitati(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType _value) {
        this.elencoOperatoriInvitati[i] = _value;
    }


    /**
     * Gets the aggiudicatario value for this DettaglioContrattoType.
     * 
     * @return aggiudicatario
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] getAggiudicatario() {
        return aggiudicatario;
    }


    /**
     * Sets the aggiudicatario value for this DettaglioContrattoType.
     * 
     * @param aggiudicatario
     */
    public void setAggiudicatario(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType[] aggiudicatario) {
        this.aggiudicatario = aggiudicatario;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType getAggiudicatario(int i) {
        return this.aggiudicatario[i];
    }

    public void setAggiudicatario(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreInvitatoType _value) {
        this.aggiudicatario[i] = _value;
    }


    /**
     * Gets the importoAggiudicazione value for this DettaglioContrattoType.
     * 
     * @return importoAggiudicazione
     */
    public java.lang.Double getImportoAggiudicazione() {
        return importoAggiudicazione;
    }


    /**
     * Sets the importoAggiudicazione value for this DettaglioContrattoType.
     * 
     * @param importoAggiudicazione
     */
    public void setImportoAggiudicazione(java.lang.Double importoAggiudicazione) {
        this.importoAggiudicazione = importoAggiudicazione;
    }


    /**
     * Gets the importoContratto value for this DettaglioContrattoType.
     * 
     * @return importoContratto
     */
    public java.lang.Double getImportoContratto() {
        return importoContratto;
    }


    /**
     * Sets the importoContratto value for this DettaglioContrattoType.
     * 
     * @param importoContratto
     */
    public void setImportoContratto(java.lang.Double importoContratto) {
        this.importoContratto = importoContratto;
    }


    /**
     * Gets the dataInizio value for this DettaglioContrattoType.
     * 
     * @return dataInizio
     */
    public java.util.Date getDataInizio() {
        return dataInizio;
    }


    /**
     * Sets the dataInizio value for this DettaglioContrattoType.
     * 
     * @param dataInizio
     */
    public void setDataInizio(java.util.Date dataInizio) {
        this.dataInizio = dataInizio;
    }


    /**
     * Gets the dataUltimazione value for this DettaglioContrattoType.
     * 
     * @return dataUltimazione
     */
    public java.util.Date getDataUltimazione() {
        return dataUltimazione;
    }


    /**
     * Sets the dataUltimazione value for this DettaglioContrattoType.
     * 
     * @param dataUltimazione
     */
    public void setDataUltimazione(java.util.Date dataUltimazione) {
        this.dataUltimazione = dataUltimazione;
    }


    /**
     * Gets the importoSommeLiquidate value for this DettaglioContrattoType.
     * 
     * @return importoSommeLiquidate
     */
    public java.lang.Double getImportoSommeLiquidate() {
        return importoSommeLiquidate;
    }


    /**
     * Sets the importoSommeLiquidate value for this DettaglioContrattoType.
     * 
     * @param importoSommeLiquidate
     */
    public void setImportoSommeLiquidate(java.lang.Double importoSommeLiquidate) {
        this.importoSommeLiquidate = importoSommeLiquidate;
    }


    /**
     * Gets the codice value for this DettaglioContrattoType.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this DettaglioContrattoType.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DettaglioContrattoType)) return false;
        DettaglioContrattoType other = (DettaglioContrattoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cig==null && other.getCig()==null) || 
             (this.cig!=null &&
              this.cig.equals(other.getCig()))) &&
            ((this.strutturaProponenteCF==null && other.getStrutturaProponenteCF()==null) || 
             (this.strutturaProponenteCF!=null &&
              this.strutturaProponenteCF.equals(other.getStrutturaProponenteCF()))) &&
            ((this.strutturaProponenteDenominazione==null && other.getStrutturaProponenteDenominazione()==null) || 
             (this.strutturaProponenteDenominazione!=null &&
              this.strutturaProponenteDenominazione.equals(other.getStrutturaProponenteDenominazione()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.sceltaContraente==null && other.getSceltaContraente()==null) || 
             (this.sceltaContraente!=null &&
              this.sceltaContraente.equals(other.getSceltaContraente()))) &&
            ((this.elencoOperatoriInvitati==null && other.getElencoOperatoriInvitati()==null) || 
             (this.elencoOperatoriInvitati!=null &&
              java.util.Arrays.equals(this.elencoOperatoriInvitati, other.getElencoOperatoriInvitati()))) &&
            ((this.aggiudicatario==null && other.getAggiudicatario()==null) || 
             (this.aggiudicatario!=null &&
              java.util.Arrays.equals(this.aggiudicatario, other.getAggiudicatario()))) &&
            ((this.importoAggiudicazione==null && other.getImportoAggiudicazione()==null) || 
             (this.importoAggiudicazione!=null &&
              this.importoAggiudicazione.equals(other.getImportoAggiudicazione()))) &&
            ((this.importoContratto==null && other.getImportoContratto()==null) || 
             (this.importoContratto!=null &&
              this.importoContratto.equals(other.getImportoContratto()))) &&
            ((this.dataInizio==null && other.getDataInizio()==null) || 
             (this.dataInizio!=null &&
              this.dataInizio.equals(other.getDataInizio()))) &&
            ((this.dataUltimazione==null && other.getDataUltimazione()==null) || 
             (this.dataUltimazione!=null &&
              this.dataUltimazione.equals(other.getDataUltimazione()))) &&
            ((this.importoSommeLiquidate==null && other.getImportoSommeLiquidate()==null) || 
             (this.importoSommeLiquidate!=null &&
              this.importoSommeLiquidate.equals(other.getImportoSommeLiquidate()))) &&
            ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCig() != null) {
            _hashCode += getCig().hashCode();
        }
        if (getStrutturaProponenteCF() != null) {
            _hashCode += getStrutturaProponenteCF().hashCode();
        }
        if (getStrutturaProponenteDenominazione() != null) {
            _hashCode += getStrutturaProponenteDenominazione().hashCode();
        }
        if (getOggetto() != null) {
            _hashCode += getOggetto().hashCode();
        }
        if (getSceltaContraente() != null) {
            _hashCode += getSceltaContraente().hashCode();
        }
        if (getElencoOperatoriInvitati() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getElencoOperatoriInvitati());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getElencoOperatoriInvitati(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAggiudicatario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAggiudicatario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAggiudicatario(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getImportoAggiudicazione() != null) {
            _hashCode += getImportoAggiudicazione().hashCode();
        }
        if (getImportoContratto() != null) {
            _hashCode += getImportoContratto().hashCode();
        }
        if (getDataInizio() != null) {
            _hashCode += getDataInizio().hashCode();
        }
        if (getDataUltimazione() != null) {
            _hashCode += getDataUltimazione().hashCode();
        }
        if (getImportoSommeLiquidate() != null) {
            _hashCode += getImportoSommeLiquidate().hashCode();
        }
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DettaglioContrattoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DettaglioContrattoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strutturaProponenteCF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "strutturaProponenteCF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strutturaProponenteDenominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "strutturaProponenteDenominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sceltaContraente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sceltaContraente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elencoOperatoriInvitati");
        elemField.setXmlName(new javax.xml.namespace.QName("", "elencoOperatoriInvitati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "OperatoreInvitatoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggiudicatario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aggiudicatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "OperatoreInvitatoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoAggiudicazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importoAggiudicazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoContratto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importoContratto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInizio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataInizio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataUltimazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoSommeLiquidate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importoSommeLiquidate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
