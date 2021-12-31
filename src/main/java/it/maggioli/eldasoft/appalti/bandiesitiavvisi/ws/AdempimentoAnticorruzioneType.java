/**
 * AdempimentoAnticorruzioneType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class AdempimentoAnticorruzioneType  implements java.io.Serializable {
    private java.lang.String codice;

    private java.lang.String stazioneAppaltante;

    private java.lang.String codiceFiscaleSA;

    private int annoRiferimento;

    private java.lang.String url;

    private int pubblicato;

    private java.util.Date dataPubblicazione;

    private java.util.Date dataAggiornamento;

    private java.util.Date dataApprovazione;

    public AdempimentoAnticorruzioneType() {
    }

    public AdempimentoAnticorruzioneType(
           java.lang.String codice,
           java.lang.String stazioneAppaltante,
           java.lang.String codiceFiscaleSA,
           int annoRiferimento,
           java.lang.String url,
           int pubblicato,
           java.util.Date dataPubblicazione,
           java.util.Date dataAggiornamento,
           java.util.Date dataApprovazione) {
           this.codice = codice;
           this.stazioneAppaltante = stazioneAppaltante;
           this.codiceFiscaleSA = codiceFiscaleSA;
           this.annoRiferimento = annoRiferimento;
           this.url = url;
           this.pubblicato = pubblicato;
           this.dataPubblicazione = dataPubblicazione;
           this.dataAggiornamento = dataAggiornamento;
           this.dataApprovazione = dataApprovazione;
    }


    /**
     * Gets the codice value for this AdempimentoAnticorruzioneType.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this AdempimentoAnticorruzioneType.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }


    /**
     * Gets the stazioneAppaltante value for this AdempimentoAnticorruzioneType.
     * 
     * @return stazioneAppaltante
     */
    public java.lang.String getStazioneAppaltante() {
        return stazioneAppaltante;
    }


    /**
     * Sets the stazioneAppaltante value for this AdempimentoAnticorruzioneType.
     * 
     * @param stazioneAppaltante
     */
    public void setStazioneAppaltante(java.lang.String stazioneAppaltante) {
        this.stazioneAppaltante = stazioneAppaltante;
    }


    /**
     * Gets the codiceFiscaleSA value for this AdempimentoAnticorruzioneType.
     * 
     * @return codiceFiscaleSA
     */
    public java.lang.String getCodiceFiscaleSA() {
        return codiceFiscaleSA;
    }


    /**
     * Sets the codiceFiscaleSA value for this AdempimentoAnticorruzioneType.
     * 
     * @param codiceFiscaleSA
     */
    public void setCodiceFiscaleSA(java.lang.String codiceFiscaleSA) {
        this.codiceFiscaleSA = codiceFiscaleSA;
    }


    /**
     * Gets the annoRiferimento value for this AdempimentoAnticorruzioneType.
     * 
     * @return annoRiferimento
     */
    public int getAnnoRiferimento() {
        return annoRiferimento;
    }


    /**
     * Sets the annoRiferimento value for this AdempimentoAnticorruzioneType.
     * 
     * @param annoRiferimento
     */
    public void setAnnoRiferimento(int annoRiferimento) {
        this.annoRiferimento = annoRiferimento;
    }


    /**
     * Gets the url value for this AdempimentoAnticorruzioneType.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this AdempimentoAnticorruzioneType.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the pubblicato value for this AdempimentoAnticorruzioneType.
     * 
     * @return pubblicato
     */
    public int getPubblicato() {
        return pubblicato;
    }


    /**
     * Sets the pubblicato value for this AdempimentoAnticorruzioneType.
     * 
     * @param pubblicato
     */
    public void setPubblicato(int pubblicato) {
        this.pubblicato = pubblicato;
    }


    /**
     * Gets the dataPubblicazione value for this AdempimentoAnticorruzioneType.
     * 
     * @return dataPubblicazione
     */
    public java.util.Date getDataPubblicazione() {
        return dataPubblicazione;
    }


    /**
     * Sets the dataPubblicazione value for this AdempimentoAnticorruzioneType.
     * 
     * @param dataPubblicazione
     */
    public void setDataPubblicazione(java.util.Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }


    /**
     * Gets the dataAggiornamento value for this AdempimentoAnticorruzioneType.
     * 
     * @return dataAggiornamento
     */
    public java.util.Date getDataAggiornamento() {
        return dataAggiornamento;
    }


    /**
     * Sets the dataAggiornamento value for this AdempimentoAnticorruzioneType.
     * 
     * @param dataAggiornamento
     */
    public void setDataAggiornamento(java.util.Date dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }


    /**
     * Gets the dataApprovazione value for this AdempimentoAnticorruzioneType.
     * 
     * @return dataApprovazione
     */
    public java.util.Date getDataApprovazione() {
        return dataApprovazione;
    }


    /**
     * Sets the dataApprovazione value for this AdempimentoAnticorruzioneType.
     * 
     * @param dataApprovazione
     */
    public void setDataApprovazione(java.util.Date dataApprovazione) {
        this.dataApprovazione = dataApprovazione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdempimentoAnticorruzioneType)) return false;
        AdempimentoAnticorruzioneType other = (AdempimentoAnticorruzioneType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice()))) &&
            ((this.stazioneAppaltante==null && other.getStazioneAppaltante()==null) || 
             (this.stazioneAppaltante!=null &&
              this.stazioneAppaltante.equals(other.getStazioneAppaltante()))) &&
            ((this.codiceFiscaleSA==null && other.getCodiceFiscaleSA()==null) || 
             (this.codiceFiscaleSA!=null &&
              this.codiceFiscaleSA.equals(other.getCodiceFiscaleSA()))) &&
            this.annoRiferimento == other.getAnnoRiferimento() &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            this.pubblicato == other.getPubblicato() &&
            ((this.dataPubblicazione==null && other.getDataPubblicazione()==null) || 
             (this.dataPubblicazione!=null &&
              this.dataPubblicazione.equals(other.getDataPubblicazione()))) &&
            ((this.dataAggiornamento==null && other.getDataAggiornamento()==null) || 
             (this.dataAggiornamento!=null &&
              this.dataAggiornamento.equals(other.getDataAggiornamento()))) &&
            ((this.dataApprovazione==null && other.getDataApprovazione()==null) || 
             (this.dataApprovazione!=null &&
              this.dataApprovazione.equals(other.getDataApprovazione())));
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
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        if (getStazioneAppaltante() != null) {
            _hashCode += getStazioneAppaltante().hashCode();
        }
        if (getCodiceFiscaleSA() != null) {
            _hashCode += getCodiceFiscaleSA().hashCode();
        }
        _hashCode += getAnnoRiferimento();
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        _hashCode += getPubblicato();
        if (getDataPubblicazione() != null) {
            _hashCode += getDataPubblicazione().hashCode();
        }
        if (getDataAggiornamento() != null) {
            _hashCode += getDataAggiornamento().hashCode();
        }
        if (getDataApprovazione() != null) {
            _hashCode += getDataApprovazione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdempimentoAnticorruzioneType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "AdempimentoAnticorruzioneType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stazioneAppaltante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stazioneAppaltante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscaleSA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscaleSA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annoRiferimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "annoRiferimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubblicato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pubblicato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataPubblicazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataPubblicazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAggiornamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataAggiornamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataApprovazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataApprovazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
