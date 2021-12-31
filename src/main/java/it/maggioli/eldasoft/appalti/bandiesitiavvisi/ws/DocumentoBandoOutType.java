/**
 * DocumentoBandoOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class DocumentoBandoOutType  implements java.io.Serializable {
    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.FileType file;

    private java.lang.String errore;

    public DocumentoBandoOutType() {
    }

    public DocumentoBandoOutType(
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.FileType file,
           java.lang.String errore) {
           this.file = file;
           this.errore = errore;
    }


    /**
     * Gets the file value for this DocumentoBandoOutType.
     * 
     * @return file
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.FileType getFile() {
        return file;
    }


    /**
     * Sets the file value for this DocumentoBandoOutType.
     * 
     * @param file
     */
    public void setFile(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.FileType file) {
        this.file = file;
    }


    /**
     * Gets the errore value for this DocumentoBandoOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this DocumentoBandoOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoBandoOutType)) return false;
        DocumentoBandoOutType other = (DocumentoBandoOutType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.file==null && other.getFile()==null) || 
             (this.file!=null &&
              this.file.equals(other.getFile()))) &&
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
        if (getFile() != null) {
            _hashCode += getFile().hashCode();
        }
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoBandoOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DocumentoBandoOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("file");
        elemField.setXmlName(new javax.xml.namespace.QName("", "file"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "FileType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
