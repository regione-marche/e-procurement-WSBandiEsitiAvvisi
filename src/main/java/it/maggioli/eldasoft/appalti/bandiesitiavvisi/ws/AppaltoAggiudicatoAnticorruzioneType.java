/**
 * AppaltoAggiudicatoAnticorruzioneType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class AppaltoAggiudicatoAnticorruzioneType  implements java.io.Serializable {
    private java.lang.String cig;

    private java.lang.String codiceFiscaleProponente;

    private java.lang.String denominazioneProponente;

    private java.lang.String oggetto;

    private java.lang.String sceltaContraente;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] partecipante;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] aggiudicatario;

    private java.lang.Double importoAggiudicazione;

    private java.util.Date dataInizio;

    private java.util.Date dataUltimazione;

    private java.lang.Double importoSommeLiquidate;

    public AppaltoAggiudicatoAnticorruzioneType() {
    }

    public AppaltoAggiudicatoAnticorruzioneType(
           java.lang.String cig,
           java.lang.String codiceFiscaleProponente,
           java.lang.String denominazioneProponente,
           java.lang.String oggetto,
           java.lang.String sceltaContraente,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] partecipante,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] aggiudicatario,
           java.lang.Double importoAggiudicazione,
           java.util.Date dataInizio,
           java.util.Date dataUltimazione,
           java.lang.Double importoSommeLiquidate) {
           this.cig = cig;
           this.codiceFiscaleProponente = codiceFiscaleProponente;
           this.denominazioneProponente = denominazioneProponente;
           this.oggetto = oggetto;
           this.sceltaContraente = sceltaContraente;
           this.partecipante = partecipante;
           this.aggiudicatario = aggiudicatario;
           this.importoAggiudicazione = importoAggiudicazione;
           this.dataInizio = dataInizio;
           this.dataUltimazione = dataUltimazione;
           this.importoSommeLiquidate = importoSommeLiquidate;
    }


    /**
     * Gets the cig value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return cig
     */
    public java.lang.String getCig() {
        return cig;
    }


    /**
     * Sets the cig value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param cig
     */
    public void setCig(java.lang.String cig) {
        this.cig = cig;
    }


    /**
     * Gets the codiceFiscaleProponente value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return codiceFiscaleProponente
     */
    public java.lang.String getCodiceFiscaleProponente() {
        return codiceFiscaleProponente;
    }


    /**
     * Sets the codiceFiscaleProponente value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param codiceFiscaleProponente
     */
    public void setCodiceFiscaleProponente(java.lang.String codiceFiscaleProponente) {
        this.codiceFiscaleProponente = codiceFiscaleProponente;
    }


    /**
     * Gets the denominazioneProponente value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return denominazioneProponente
     */
    public java.lang.String getDenominazioneProponente() {
        return denominazioneProponente;
    }


    /**
     * Sets the denominazioneProponente value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param denominazioneProponente
     */
    public void setDenominazioneProponente(java.lang.String denominazioneProponente) {
        this.denominazioneProponente = denominazioneProponente;
    }


    /**
     * Gets the oggetto value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the sceltaContraente value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return sceltaContraente
     */
    public java.lang.String getSceltaContraente() {
        return sceltaContraente;
    }


    /**
     * Sets the sceltaContraente value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param sceltaContraente
     */
    public void setSceltaContraente(java.lang.String sceltaContraente) {
        this.sceltaContraente = sceltaContraente;
    }


    /**
     * Gets the partecipante value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return partecipante
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] getPartecipante() {
        return partecipante;
    }


    /**
     * Sets the partecipante value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param partecipante
     */
    public void setPartecipante(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] partecipante) {
        this.partecipante = partecipante;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType getPartecipante(int i) {
        return this.partecipante[i];
    }

    public void setPartecipante(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType _value) {
        this.partecipante[i] = _value;
    }


    /**
     * Gets the aggiudicatario value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return aggiudicatario
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] getAggiudicatario() {
        return aggiudicatario;
    }


    /**
     * Sets the aggiudicatario value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param aggiudicatario
     */
    public void setAggiudicatario(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType[] aggiudicatario) {
        this.aggiudicatario = aggiudicatario;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType getAggiudicatario(int i) {
        return this.aggiudicatario[i];
    }

    public void setAggiudicatario(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.PartecipanteType _value) {
        this.aggiudicatario[i] = _value;
    }


    /**
     * Gets the importoAggiudicazione value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return importoAggiudicazione
     */
    public java.lang.Double getImportoAggiudicazione() {
        return importoAggiudicazione;
    }


    /**
     * Sets the importoAggiudicazione value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param importoAggiudicazione
     */
    public void setImportoAggiudicazione(java.lang.Double importoAggiudicazione) {
        this.importoAggiudicazione = importoAggiudicazione;
    }


    /**
     * Gets the dataInizio value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return dataInizio
     */
    public java.util.Date getDataInizio() {
        return dataInizio;
    }


    /**
     * Sets the dataInizio value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param dataInizio
     */
    public void setDataInizio(java.util.Date dataInizio) {
        this.dataInizio = dataInizio;
    }


    /**
     * Gets the dataUltimazione value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return dataUltimazione
     */
    public java.util.Date getDataUltimazione() {
        return dataUltimazione;
    }


    /**
     * Sets the dataUltimazione value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param dataUltimazione
     */
    public void setDataUltimazione(java.util.Date dataUltimazione) {
        this.dataUltimazione = dataUltimazione;
    }


    /**
     * Gets the importoSommeLiquidate value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @return importoSommeLiquidate
     */
    public java.lang.Double getImportoSommeLiquidate() {
        return importoSommeLiquidate;
    }


    /**
     * Sets the importoSommeLiquidate value for this AppaltoAggiudicatoAnticorruzioneType.
     * 
     * @param importoSommeLiquidate
     */
    public void setImportoSommeLiquidate(java.lang.Double importoSommeLiquidate) {
        this.importoSommeLiquidate = importoSommeLiquidate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AppaltoAggiudicatoAnticorruzioneType)) return false;
        AppaltoAggiudicatoAnticorruzioneType other = (AppaltoAggiudicatoAnticorruzioneType) obj;
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
            ((this.codiceFiscaleProponente==null && other.getCodiceFiscaleProponente()==null) || 
             (this.codiceFiscaleProponente!=null &&
              this.codiceFiscaleProponente.equals(other.getCodiceFiscaleProponente()))) &&
            ((this.denominazioneProponente==null && other.getDenominazioneProponente()==null) || 
             (this.denominazioneProponente!=null &&
              this.denominazioneProponente.equals(other.getDenominazioneProponente()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.sceltaContraente==null && other.getSceltaContraente()==null) || 
             (this.sceltaContraente!=null &&
              this.sceltaContraente.equals(other.getSceltaContraente()))) &&
            ((this.partecipante==null && other.getPartecipante()==null) || 
             (this.partecipante!=null &&
              java.util.Arrays.equals(this.partecipante, other.getPartecipante()))) &&
            ((this.aggiudicatario==null && other.getAggiudicatario()==null) || 
             (this.aggiudicatario!=null &&
              java.util.Arrays.equals(this.aggiudicatario, other.getAggiudicatario()))) &&
            ((this.importoAggiudicazione==null && other.getImportoAggiudicazione()==null) || 
             (this.importoAggiudicazione!=null &&
              this.importoAggiudicazione.equals(other.getImportoAggiudicazione()))) &&
            ((this.dataInizio==null && other.getDataInizio()==null) || 
             (this.dataInizio!=null &&
              this.dataInizio.equals(other.getDataInizio()))) &&
            ((this.dataUltimazione==null && other.getDataUltimazione()==null) || 
             (this.dataUltimazione!=null &&
              this.dataUltimazione.equals(other.getDataUltimazione()))) &&
            ((this.importoSommeLiquidate==null && other.getImportoSommeLiquidate()==null) || 
             (this.importoSommeLiquidate!=null &&
              this.importoSommeLiquidate.equals(other.getImportoSommeLiquidate())));
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
        if (getCodiceFiscaleProponente() != null) {
            _hashCode += getCodiceFiscaleProponente().hashCode();
        }
        if (getDenominazioneProponente() != null) {
            _hashCode += getDenominazioneProponente().hashCode();
        }
        if (getOggetto() != null) {
            _hashCode += getOggetto().hashCode();
        }
        if (getSceltaContraente() != null) {
            _hashCode += getSceltaContraente().hashCode();
        }
        if (getPartecipante() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPartecipante());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPartecipante(), i);
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
        if (getDataInizio() != null) {
            _hashCode += getDataInizio().hashCode();
        }
        if (getDataUltimazione() != null) {
            _hashCode += getDataUltimazione().hashCode();
        }
        if (getImportoSommeLiquidate() != null) {
            _hashCode += getImportoSommeLiquidate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AppaltoAggiudicatoAnticorruzioneType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "AppaltoAggiudicatoAnticorruzioneType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscaleProponente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscaleProponente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazioneProponente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazioneProponente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sceltaContraente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sceltaContraente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partecipante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partecipante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "PartecipanteType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggiudicatario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aggiudicatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "PartecipanteType"));
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
