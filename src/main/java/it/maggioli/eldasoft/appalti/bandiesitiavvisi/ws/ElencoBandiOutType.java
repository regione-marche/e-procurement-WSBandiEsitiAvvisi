/**
 * ElencoBandiOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class ElencoBandiOutType  implements java.io.Serializable {
    private java.lang.Integer numBandi;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType[] bando;

    private java.lang.String errore;

    public ElencoBandiOutType() {
    }

    public ElencoBandiOutType(
           java.lang.Integer numBandi,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType[] bando,
           java.lang.String errore) {
           this.numBandi = numBandi;
           this.bando = bando;
           this.errore = errore;
    }


    /**
     * Gets the numBandi value for this ElencoBandiOutType.
     * 
     * @return numBandi
     */
    public java.lang.Integer getNumBandi() {
        return numBandi;
    }


    /**
     * Sets the numBandi value for this ElencoBandiOutType.
     * 
     * @param numBandi
     */
    public void setNumBandi(java.lang.Integer numBandi) {
        this.numBandi = numBandi;
    }


    /**
     * Gets the bando value for this ElencoBandiOutType.
     * 
     * @return bando
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType[] getBando() {
        return bando;
    }


    /**
     * Sets the bando value for this ElencoBandiOutType.
     * 
     * @param bando
     */
    public void setBando(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType[] bando) {
        this.bando = bando;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType getBando(int i) {
        return this.bando[i];
    }

    public void setBando(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.BandoListaType _value) {
        this.bando[i] = _value;
    }


    /**
     * Gets the errore value for this ElencoBandiOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this ElencoBandiOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ElencoBandiOutType)) return false;
        ElencoBandiOutType other = (ElencoBandiOutType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numBandi==null && other.getNumBandi()==null) || 
             (this.numBandi!=null &&
              this.numBandi.equals(other.getNumBandi()))) &&
            ((this.bando==null && other.getBando()==null) || 
             (this.bando!=null &&
              java.util.Arrays.equals(this.bando, other.getBando()))) &&
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
        if (getNumBandi() != null) {
            _hashCode += getNumBandi().hashCode();
        }
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
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ElencoBandiOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ElencoBandiOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numBandi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numBandi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "BandoListaType"));
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
