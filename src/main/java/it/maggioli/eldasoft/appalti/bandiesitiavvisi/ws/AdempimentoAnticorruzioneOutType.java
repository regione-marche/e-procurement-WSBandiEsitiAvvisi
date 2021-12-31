/**
 * AdempimentoAnticorruzioneOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class AdempimentoAnticorruzioneOutType  implements java.io.Serializable {
    private java.lang.String errore;

    private java.lang.Integer numAdempimenti;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType[] adempimento;

    public AdempimentoAnticorruzioneOutType() {
    }

    public AdempimentoAnticorruzioneOutType(
           java.lang.String errore,
           java.lang.Integer numAdempimenti,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType[] adempimento) {
           this.errore = errore;
           this.numAdempimenti = numAdempimenti;
           this.adempimento = adempimento;
    }


    /**
     * Gets the errore value for this AdempimentoAnticorruzioneOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this AdempimentoAnticorruzioneOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }


    /**
     * Gets the numAdempimenti value for this AdempimentoAnticorruzioneOutType.
     * 
     * @return numAdempimenti
     */
    public java.lang.Integer getNumAdempimenti() {
        return numAdempimenti;
    }


    /**
     * Sets the numAdempimenti value for this AdempimentoAnticorruzioneOutType.
     * 
     * @param numAdempimenti
     */
    public void setNumAdempimenti(java.lang.Integer numAdempimenti) {
        this.numAdempimenti = numAdempimenti;
    }


    /**
     * Gets the adempimento value for this AdempimentoAnticorruzioneOutType.
     * 
     * @return adempimento
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType[] getAdempimento() {
        return adempimento;
    }


    /**
     * Sets the adempimento value for this AdempimentoAnticorruzioneOutType.
     * 
     * @param adempimento
     */
    public void setAdempimento(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType[] adempimento) {
        this.adempimento = adempimento;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType getAdempimento(int i) {
        return this.adempimento[i];
    }

    public void setAdempimento(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType _value) {
        this.adempimento[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdempimentoAnticorruzioneOutType)) return false;
        AdempimentoAnticorruzioneOutType other = (AdempimentoAnticorruzioneOutType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errore==null && other.getErrore()==null) || 
             (this.errore!=null &&
              this.errore.equals(other.getErrore()))) &&
            ((this.numAdempimenti==null && other.getNumAdempimenti()==null) || 
             (this.numAdempimenti!=null &&
              this.numAdempimenti.equals(other.getNumAdempimenti()))) &&
            ((this.adempimento==null && other.getAdempimento()==null) || 
             (this.adempimento!=null &&
              java.util.Arrays.equals(this.adempimento, other.getAdempimento())));
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
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        if (getNumAdempimenti() != null) {
            _hashCode += getNumAdempimenti().hashCode();
        }
        if (getAdempimento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdempimento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdempimento(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdempimentoAnticorruzioneOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "AdempimentoAnticorruzioneOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numAdempimenti");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numAdempimenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adempimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adempimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "AdempimentoAnticorruzioneType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
