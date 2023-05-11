/**
 * ProspettoBeneficiariOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class ProspettoBeneficiariOutType  implements java.io.Serializable {
    private java.lang.Integer numEsiti;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType[] esito;

    private java.lang.String errore;

    public ProspettoBeneficiariOutType() {
    }

    public ProspettoBeneficiariOutType(
           java.lang.Integer numEsiti,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType[] esito,
           java.lang.String errore) {
           this.numEsiti = numEsiti;
           this.esito = esito;
           this.errore = errore;
    }


    /**
     * Gets the numEsiti value for this ProspettoBeneficiariOutType.
     * 
     * @return numEsiti
     */
    public java.lang.Integer getNumEsiti() {
        return numEsiti;
    }


    /**
     * Sets the numEsiti value for this ProspettoBeneficiariOutType.
     * 
     * @param numEsiti
     */
    public void setNumEsiti(java.lang.Integer numEsiti) {
        this.numEsiti = numEsiti;
    }


    /**
     * Gets the esito value for this ProspettoBeneficiariOutType.
     * 
     * @return esito
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType[] getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this ProspettoBeneficiariOutType.
     * 
     * @param esito
     */
    public void setEsito(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType[] esito) {
        this.esito = esito;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType getEsito(int i) {
        return this.esito[i];
    }

    public void setEsito(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.EsitoProspettoBeneficiariType _value) {
        this.esito[i] = _value;
    }


    /**
     * Gets the errore value for this ProspettoBeneficiariOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this ProspettoBeneficiariOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProspettoBeneficiariOutType)) return false;
        ProspettoBeneficiariOutType other = (ProspettoBeneficiariOutType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numEsiti==null && other.getNumEsiti()==null) || 
             (this.numEsiti!=null &&
              this.numEsiti.equals(other.getNumEsiti()))) &&
            ((this.esito==null && other.getEsito()==null) || 
             (this.esito!=null &&
              java.util.Arrays.equals(this.esito, other.getEsito()))) &&
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
        if (getNumEsiti() != null) {
            _hashCode += getNumEsiti().hashCode();
        }
        if (getEsito() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEsito());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEsito(), i);
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
        new org.apache.axis.description.TypeDesc(ProspettoBeneficiariOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ProspettoBeneficiariOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numEsiti");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numEsiti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "esito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "EsitoProspettoBeneficiariType"));
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
