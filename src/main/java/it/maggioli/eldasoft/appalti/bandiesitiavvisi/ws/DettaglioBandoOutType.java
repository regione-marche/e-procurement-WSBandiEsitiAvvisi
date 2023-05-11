/**
 * DettaglioBandoOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class DettaglioBandoOutType  implements java.io.Serializable {
    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType[] bando;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType[] documento;

    private java.lang.String errore;

    public DettaglioBandoOutType() {
    }

    public DettaglioBandoOutType(
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType[] bando,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType[] documento,
           java.lang.String errore) {
           this.bando = bando;
           this.documento = documento;
           this.errore = errore;
    }


    /**
     * Gets the bando value for this DettaglioBandoOutType.
     * 
     * @return bando
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType[] getBando() {
        return bando;
    }


    /**
     * Sets the bando value for this DettaglioBandoOutType.
     * 
     * @param bando
     */
    public void setBando(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType[] bando) {
        this.bando = bando;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType getBando(int i) {
        return this.bando[i];
    }

    public void setBando(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoType _value) {
        this.bando[i] = _value;
    }


    /**
     * Gets the documento value for this DettaglioBandoOutType.
     * 
     * @return documento
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType[] getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this DettaglioBandoOutType.
     * 
     * @param documento
     */
    public void setDocumento(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType[] documento) {
        this.documento = documento;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType getDocumento(int i) {
        return this.documento[i];
    }

    public void setDocumento(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoAllegatoType _value) {
        this.documento[i] = _value;
    }


    /**
     * Gets the errore value for this DettaglioBandoOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this DettaglioBandoOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DettaglioBandoOutType)) return false;
        DettaglioBandoOutType other = (DettaglioBandoOutType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bando==null && other.getBando()==null) || 
             (this.bando!=null &&
              java.util.Arrays.equals(this.bando, other.getBando()))) &&
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              java.util.Arrays.equals(this.documento, other.getDocumento()))) &&
            ((this.errore==null && other.getErrore()==null) || 
             (this.errore!=null &&
              this.errore.equals(other.getErrore())));
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
        if (getBando() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBando());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBando(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocumento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumento(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DettaglioBandoOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DettaglioBandoOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DettaglioBandoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DocumentoAllegatoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errore"));
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
