/**
 * BandoListaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class BandoListaType  implements java.io.Serializable {
    private java.lang.String codice;

    private java.lang.String tipo;

    private java.lang.String contratto;

    private java.util.Date pubblicazione;

    private java.util.Date scadenzaBando;

    private java.util.Date scadenzaPubblEsito;

    private java.util.Date scadenzaAvviso;

    private java.lang.String titolo;

    private java.lang.String cig;

    private java.lang.String codiceStazAppaltante;

    private java.lang.String stazioneAppaltante;

    public BandoListaType() {
    }

    public BandoListaType(
           java.lang.String codice,
           java.lang.String tipo,
           java.lang.String contratto,
           java.util.Date pubblicazione,
           java.util.Date scadenzaBando,
           java.util.Date scadenzaPubblEsito,
           java.util.Date scadenzaAvviso,
           java.lang.String titolo,
           java.lang.String cig,
           java.lang.String codiceStazAppaltante,
           java.lang.String stazioneAppaltante) {
           this.codice = codice;
           this.tipo = tipo;
           this.contratto = contratto;
           this.pubblicazione = pubblicazione;
           this.scadenzaBando = scadenzaBando;
           this.scadenzaPubblEsito = scadenzaPubblEsito;
           this.scadenzaAvviso = scadenzaAvviso;
           this.titolo = titolo;
           this.cig = cig;
           this.codiceStazAppaltante = codiceStazAppaltante;
           this.stazioneAppaltante = stazioneAppaltante;
    }


    /**
     * Gets the codice value for this BandoListaType.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this BandoListaType.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }


    /**
     * Gets the tipo value for this BandoListaType.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this BandoListaType.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the contratto value for this BandoListaType.
     * 
     * @return contratto
     */
    public java.lang.String getContratto() {
        return contratto;
    }


    /**
     * Sets the contratto value for this BandoListaType.
     * 
     * @param contratto
     */
    public void setContratto(java.lang.String contratto) {
        this.contratto = contratto;
    }


    /**
     * Gets the pubblicazione value for this BandoListaType.
     * 
     * @return pubblicazione
     */
    public java.util.Date getPubblicazione() {
        return pubblicazione;
    }


    /**
     * Sets the pubblicazione value for this BandoListaType.
     * 
     * @param pubblicazione
     */
    public void setPubblicazione(java.util.Date pubblicazione) {
        this.pubblicazione = pubblicazione;
    }


    /**
     * Gets the scadenzaBando value for this BandoListaType.
     * 
     * @return scadenzaBando
     */
    public java.util.Date getScadenzaBando() {
        return scadenzaBando;
    }


    /**
     * Sets the scadenzaBando value for this BandoListaType.
     * 
     * @param scadenzaBando
     */
    public void setScadenzaBando(java.util.Date scadenzaBando) {
        this.scadenzaBando = scadenzaBando;
    }


    /**
     * Gets the scadenzaPubblEsito value for this BandoListaType.
     * 
     * @return scadenzaPubblEsito
     */
    public java.util.Date getScadenzaPubblEsito() {
        return scadenzaPubblEsito;
    }


    /**
     * Sets the scadenzaPubblEsito value for this BandoListaType.
     * 
     * @param scadenzaPubblEsito
     */
    public void setScadenzaPubblEsito(java.util.Date scadenzaPubblEsito) {
        this.scadenzaPubblEsito = scadenzaPubblEsito;
    }


    /**
     * Gets the scadenzaAvviso value for this BandoListaType.
     * 
     * @return scadenzaAvviso
     */
    public java.util.Date getScadenzaAvviso() {
        return scadenzaAvviso;
    }


    /**
     * Sets the scadenzaAvviso value for this BandoListaType.
     * 
     * @param scadenzaAvviso
     */
    public void setScadenzaAvviso(java.util.Date scadenzaAvviso) {
        this.scadenzaAvviso = scadenzaAvviso;
    }


    /**
     * Gets the titolo value for this BandoListaType.
     * 
     * @return titolo
     */
    public java.lang.String getTitolo() {
        return titolo;
    }


    /**
     * Sets the titolo value for this BandoListaType.
     * 
     * @param titolo
     */
    public void setTitolo(java.lang.String titolo) {
        this.titolo = titolo;
    }


    /**
     * Gets the cig value for this BandoListaType.
     * 
     * @return cig
     */
    public java.lang.String getCig() {
        return cig;
    }


    /**
     * Sets the cig value for this BandoListaType.
     * 
     * @param cig
     */
    public void setCig(java.lang.String cig) {
        this.cig = cig;
    }


    /**
     * Gets the codiceStazAppaltante value for this BandoListaType.
     * 
     * @return codiceStazAppaltante
     */
    public java.lang.String getCodiceStazAppaltante() {
        return codiceStazAppaltante;
    }


    /**
     * Sets the codiceStazAppaltante value for this BandoListaType.
     * 
     * @param codiceStazAppaltante
     */
    public void setCodiceStazAppaltante(java.lang.String codiceStazAppaltante) {
        this.codiceStazAppaltante = codiceStazAppaltante;
    }


    /**
     * Gets the stazioneAppaltante value for this BandoListaType.
     * 
     * @return stazioneAppaltante
     */
    public java.lang.String getStazioneAppaltante() {
        return stazioneAppaltante;
    }


    /**
     * Sets the stazioneAppaltante value for this BandoListaType.
     * 
     * @param stazioneAppaltante
     */
    public void setStazioneAppaltante(java.lang.String stazioneAppaltante) {
        this.stazioneAppaltante = stazioneAppaltante;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BandoListaType)) return false;
        BandoListaType other = (BandoListaType) obj;
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
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.contratto==null && other.getContratto()==null) || 
             (this.contratto!=null &&
              this.contratto.equals(other.getContratto()))) &&
            ((this.pubblicazione==null && other.getPubblicazione()==null) || 
             (this.pubblicazione!=null &&
              this.pubblicazione.equals(other.getPubblicazione()))) &&
            ((this.scadenzaBando==null && other.getScadenzaBando()==null) || 
             (this.scadenzaBando!=null &&
              this.scadenzaBando.equals(other.getScadenzaBando()))) &&
            ((this.scadenzaPubblEsito==null && other.getScadenzaPubblEsito()==null) || 
             (this.scadenzaPubblEsito!=null &&
              this.scadenzaPubblEsito.equals(other.getScadenzaPubblEsito()))) &&
            ((this.scadenzaAvviso==null && other.getScadenzaAvviso()==null) || 
             (this.scadenzaAvviso!=null &&
              this.scadenzaAvviso.equals(other.getScadenzaAvviso()))) &&
            ((this.titolo==null && other.getTitolo()==null) || 
             (this.titolo!=null &&
              this.titolo.equals(other.getTitolo()))) &&
            ((this.cig==null && other.getCig()==null) || 
             (this.cig!=null &&
              this.cig.equals(other.getCig()))) &&
            ((this.codiceStazAppaltante==null && other.getCodiceStazAppaltante()==null) || 
             (this.codiceStazAppaltante!=null &&
              this.codiceStazAppaltante.equals(other.getCodiceStazAppaltante()))) &&
            ((this.stazioneAppaltante==null && other.getStazioneAppaltante()==null) || 
             (this.stazioneAppaltante!=null &&
              this.stazioneAppaltante.equals(other.getStazioneAppaltante())));
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
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getContratto() != null) {
            _hashCode += getContratto().hashCode();
        }
        if (getPubblicazione() != null) {
            _hashCode += getPubblicazione().hashCode();
        }
        if (getScadenzaBando() != null) {
            _hashCode += getScadenzaBando().hashCode();
        }
        if (getScadenzaPubblEsito() != null) {
            _hashCode += getScadenzaPubblEsito().hashCode();
        }
        if (getScadenzaAvviso() != null) {
            _hashCode += getScadenzaAvviso().hashCode();
        }
        if (getTitolo() != null) {
            _hashCode += getTitolo().hashCode();
        }
        if (getCig() != null) {
            _hashCode += getCig().hashCode();
        }
        if (getCodiceStazAppaltante() != null) {
            _hashCode += getCodiceStazAppaltante().hashCode();
        }
        if (getStazioneAppaltante() != null) {
            _hashCode += getStazioneAppaltante().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BandoListaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "BandoListaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contratto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contratto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubblicazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pubblicazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scadenzaBando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scadenzaBando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scadenzaPubblEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scadenzaPubblEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scadenzaAvviso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scadenzaAvviso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titolo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "titolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceStazAppaltante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceStazAppaltante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stazioneAppaltante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stazioneAppaltante"));
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
