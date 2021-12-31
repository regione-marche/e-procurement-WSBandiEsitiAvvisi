/**
 * ProspettoGareContrattiAnticorruzioneOutType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class ProspettoGareContrattiAnticorruzioneOutType  implements java.io.Serializable {
    private java.lang.Integer numAppaltiAggiudicati;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType[] appalto;

    private java.lang.String errore;

    public ProspettoGareContrattiAnticorruzioneOutType() {
    }

    public ProspettoGareContrattiAnticorruzioneOutType(
           java.lang.Integer numAppaltiAggiudicati,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType[] appalto,
           java.lang.String errore) {
           this.numAppaltiAggiudicati = numAppaltiAggiudicati;
           this.appalto = appalto;
           this.errore = errore;
    }


    /**
     * Gets the numAppaltiAggiudicati value for this ProspettoGareContrattiAnticorruzioneOutType.
     * 
     * @return numAppaltiAggiudicati
     */
    public java.lang.Integer getNumAppaltiAggiudicati() {
        return numAppaltiAggiudicati;
    }


    /**
     * Sets the numAppaltiAggiudicati value for this ProspettoGareContrattiAnticorruzioneOutType.
     * 
     * @param numAppaltiAggiudicati
     */
    public void setNumAppaltiAggiudicati(java.lang.Integer numAppaltiAggiudicati) {
        this.numAppaltiAggiudicati = numAppaltiAggiudicati;
    }


    /**
     * Gets the appalto value for this ProspettoGareContrattiAnticorruzioneOutType.
     * 
     * @return appalto
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType[] getAppalto() {
        return appalto;
    }


    /**
     * Sets the appalto value for this ProspettoGareContrattiAnticorruzioneOutType.
     * 
     * @param appalto
     */
    public void setAppalto(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType[] appalto) {
        this.appalto = appalto;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType getAppalto(int i) {
        return this.appalto[i];
    }

    public void setAppalto(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AppaltoAggiudicatoAnticorruzioneType _value) {
        this.appalto[i] = _value;
    }


    /**
     * Gets the errore value for this ProspettoGareContrattiAnticorruzioneOutType.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this ProspettoGareContrattiAnticorruzioneOutType.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProspettoGareContrattiAnticorruzioneOutType)) return false;
        ProspettoGareContrattiAnticorruzioneOutType other = (ProspettoGareContrattiAnticorruzioneOutType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numAppaltiAggiudicati==null && other.getNumAppaltiAggiudicati()==null) || 
             (this.numAppaltiAggiudicati!=null &&
              this.numAppaltiAggiudicati.equals(other.getNumAppaltiAggiudicati()))) &&
            ((this.appalto==null && other.getAppalto()==null) || 
             (this.appalto!=null &&
              java.util.Arrays.equals(this.appalto, other.getAppalto()))) &&
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
        if (getNumAppaltiAggiudicati() != null) {
            _hashCode += getNumAppaltiAggiudicati().hashCode();
        }
        if (getAppalto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAppalto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAppalto(), i);
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
        new org.apache.axis.description.TypeDesc(ProspettoGareContrattiAnticorruzioneOutType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ProspettoGareContrattiAnticorruzioneOutType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numAppaltiAggiudicati");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numAppaltiAggiudicati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appalto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appalto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "AppaltoAggiudicatoAnticorruzioneType"));
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
