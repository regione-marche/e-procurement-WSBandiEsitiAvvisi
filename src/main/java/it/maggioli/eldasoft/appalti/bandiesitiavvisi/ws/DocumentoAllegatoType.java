/**
 * DocumentoAllegatoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class DocumentoAllegatoType  implements java.io.Serializable {
    /* Descrizione del documento */
    private java.lang.String descrizione;

    /* Nome del file allegato */
    private java.lang.String nomefile;

    /* Id da utilizzare per richiedere
     * 										l'apertura del documento */
    private java.lang.Integer id;

    /* URL del documento in rete */
    private java.lang.String url;

    public DocumentoAllegatoType() {
    }

    public DocumentoAllegatoType(
           java.lang.String descrizione,
           java.lang.String nomefile,
           java.lang.Integer id,
           java.lang.String url) {
           this.descrizione = descrizione;
           this.nomefile = nomefile;
           this.id = id;
           this.url = url;
    }


    /**
     * Gets the descrizione value for this DocumentoAllegatoType.
     * 
     * @return descrizione   * Descrizione del documento
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this DocumentoAllegatoType.
     * 
     * @param descrizione   * Descrizione del documento
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the nomefile value for this DocumentoAllegatoType.
     * 
     * @return nomefile   * Nome del file allegato
     */
    public java.lang.String getNomefile() {
        return nomefile;
    }


    /**
     * Sets the nomefile value for this DocumentoAllegatoType.
     * 
     * @param nomefile   * Nome del file allegato
     */
    public void setNomefile(java.lang.String nomefile) {
        this.nomefile = nomefile;
    }


    /**
     * Gets the id value for this DocumentoAllegatoType.
     * 
     * @return id   * Id da utilizzare per richiedere
     * 										l'apertura del documento
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DocumentoAllegatoType.
     * 
     * @param id   * Id da utilizzare per richiedere
     * 										l'apertura del documento
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the url value for this DocumentoAllegatoType.
     * 
     * @return url   * URL del documento in rete
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this DocumentoAllegatoType.
     * 
     * @param url   * URL del documento in rete
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoAllegatoType)) return false;
        DocumentoAllegatoType other = (DocumentoAllegatoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.nomefile==null && other.getNomefile()==null) || 
             (this.nomefile!=null &&
              this.nomefile.equals(other.getNomefile()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getNomefile() != null) {
            _hashCode += getNomefile().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoAllegatoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DocumentoAllegatoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomefile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomefile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
