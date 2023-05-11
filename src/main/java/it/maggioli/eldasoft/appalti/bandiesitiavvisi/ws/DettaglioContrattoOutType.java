/**
 * DettaglioContrattoOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class DettaglioContrattoOutType  implements java.io.Serializable {
    private java.lang.String errore;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoType dettaglioContratto;

    public DettaglioContrattoOutType() {
    }

    public DettaglioContrattoOutType(
           java.lang.String errore,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoType dettaglioContratto) {
           this.errore = errore;
           this.dettaglioContratto = dettaglioContratto;
    }


    /**
     * Gets the errore value for this DettaglioContrattoOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this DettaglioContrattoOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }


    /**
     * Gets the dettaglioContratto value for this DettaglioContrattoOutType.
     * 
     * @return dettaglioContratto
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoType getDettaglioContratto() {
        return dettaglioContratto;
    }


    /**
     * Sets the dettaglioContratto value for this DettaglioContrattoOutType.
     * 
     * @param dettaglioContratto
     */
    public void setDettaglioContratto(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoType dettaglioContratto) {
        this.dettaglioContratto = dettaglioContratto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DettaglioContrattoOutType)) return false;
        DettaglioContrattoOutType other = (DettaglioContrattoOutType) obj;
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
            ((this.dettaglioContratto==null && other.getDettaglioContratto()==null) || 
             (this.dettaglioContratto!=null &&
              this.dettaglioContratto.equals(other.getDettaglioContratto())));
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
        if (getDettaglioContratto() != null) {
            _hashCode += getDettaglioContratto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DettaglioContrattoOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DettaglioContrattoOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dettaglioContratto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dettaglioContratto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DettaglioContrattoType"));
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
