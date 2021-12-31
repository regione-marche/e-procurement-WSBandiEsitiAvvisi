/**
 * ConsulentiCollaboratoriOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class ConsulentiCollaboratoriOutType  implements java.io.Serializable {
    private java.lang.Integer numConsulentiCollaboratori;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType[] consulentiCollaboratori;

    private java.lang.String errore;

    public ConsulentiCollaboratoriOutType() {
    }

    public ConsulentiCollaboratoriOutType(
           java.lang.Integer numConsulentiCollaboratori,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType[] consulentiCollaboratori,
           java.lang.String errore) {
           this.numConsulentiCollaboratori = numConsulentiCollaboratori;
           this.consulentiCollaboratori = consulentiCollaboratori;
           this.errore = errore;
    }


    /**
     * Gets the numConsulentiCollaboratori value for this ConsulentiCollaboratoriOutType.
     * 
     * @return numConsulentiCollaboratori
     */
    public java.lang.Integer getNumConsulentiCollaboratori() {
        return numConsulentiCollaboratori;
    }


    /**
     * Sets the numConsulentiCollaboratori value for this ConsulentiCollaboratoriOutType.
     * 
     * @param numConsulentiCollaboratori
     */
    public void setNumConsulentiCollaboratori(java.lang.Integer numConsulentiCollaboratori) {
        this.numConsulentiCollaboratori = numConsulentiCollaboratori;
    }


    /**
     * Gets the consulentiCollaboratori value for this ConsulentiCollaboratoriOutType.
     * 
     * @return consulentiCollaboratori
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType[] getConsulentiCollaboratori() {
        return consulentiCollaboratori;
    }


    /**
     * Sets the consulentiCollaboratori value for this ConsulentiCollaboratoriOutType.
     * 
     * @param consulentiCollaboratori
     */
    public void setConsulentiCollaboratori(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType[] consulentiCollaboratori) {
        this.consulentiCollaboratori = consulentiCollaboratori;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType getConsulentiCollaboratori(int i) {
        return this.consulentiCollaboratori[i];
    }

    public void setConsulentiCollaboratori(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulenteCollaboratoreType _value) {
        this.consulentiCollaboratori[i] = _value;
    }


    /**
     * Gets the errore value for this ConsulentiCollaboratoriOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this ConsulentiCollaboratoriOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsulentiCollaboratoriOutType)) return false;
        ConsulentiCollaboratoriOutType other = (ConsulentiCollaboratoriOutType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numConsulentiCollaboratori==null && other.getNumConsulentiCollaboratori()==null) || 
             (this.numConsulentiCollaboratori!=null &&
              this.numConsulentiCollaboratori.equals(other.getNumConsulentiCollaboratori()))) &&
            ((this.consulentiCollaboratori==null && other.getConsulentiCollaboratori()==null) || 
             (this.consulentiCollaboratori!=null &&
              java.util.Arrays.equals(this.consulentiCollaboratori, other.getConsulentiCollaboratori()))) &&
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
        if (getNumConsulentiCollaboratori() != null) {
            _hashCode += getNumConsulentiCollaboratori().hashCode();
        }
        if (getConsulentiCollaboratori() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsulentiCollaboratori());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsulentiCollaboratori(), i);
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
        new org.apache.axis.description.TypeDesc(ConsulentiCollaboratoriOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ConsulentiCollaboratoriOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numConsulentiCollaboratori");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numConsulentiCollaboratori"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consulentiCollaboratori");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consulentiCollaboratori"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ConsulenteCollaboratoreType"));
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
