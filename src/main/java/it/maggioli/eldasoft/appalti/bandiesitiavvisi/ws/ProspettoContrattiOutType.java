/**
 * ProspettoContrattiOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class ProspettoContrattiOutType  implements java.io.Serializable {
    private java.lang.String errore;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType[] contratto;

    public ProspettoContrattiOutType() {
    }

    public ProspettoContrattiOutType(
           java.lang.String errore,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType[] contratto) {
           this.errore = errore;
           this.contratto = contratto;
    }


    /**
     * Gets the errore value for this ProspettoContrattiOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this ProspettoContrattiOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }


    /**
     * Gets the contratto value for this ProspettoContrattiOutType.
     * 
     * @return contratto
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType[] getContratto() {
        return contratto;
    }


    /**
     * Sets the contratto value for this ProspettoContrattiOutType.
     * 
     * @param contratto
     */
    public void setContratto(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType[] contratto) {
        this.contratto = contratto;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType getContratto(int i) {
        return this.contratto[i];
    }

    public void setContratto(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattoType _value) {
        this.contratto[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProspettoContrattiOutType)) return false;
        ProspettoContrattiOutType other = (ProspettoContrattiOutType) obj;
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
            ((this.contratto==null && other.getContratto()==null) || 
             (this.contratto!=null &&
              java.util.Arrays.equals(this.contratto, other.getContratto())));
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
        if (getContratto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContratto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContratto(), i);
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
        new org.apache.axis.description.TypeDesc(ProspettoContrattiOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ProspettoContrattiOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contratto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contratto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ProspettoContrattoType"));
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
