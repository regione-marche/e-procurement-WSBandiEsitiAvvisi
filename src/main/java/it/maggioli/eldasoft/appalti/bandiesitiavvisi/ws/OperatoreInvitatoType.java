/**
 * OperatoreInvitatoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class OperatoreInvitatoType  implements java.io.Serializable {
    private java.lang.String ditta;

    private java.lang.String ragioneSociale;

    private java.lang.String codiceFiscale;

    private java.lang.String partitaIva;

    private java.lang.Boolean rti;

    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType[] componentiRti;

    public OperatoreInvitatoType() {
    }

    public OperatoreInvitatoType(
           java.lang.String ditta,
           java.lang.String ragioneSociale,
           java.lang.String codiceFiscale,
           java.lang.String partitaIva,
           java.lang.Boolean rti,
           it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType[] componentiRti) {
           this.ditta = ditta;
           this.ragioneSociale = ragioneSociale;
           this.codiceFiscale = codiceFiscale;
           this.partitaIva = partitaIva;
           this.rti = rti;
           this.componentiRti = componentiRti;
    }


    /**
     * Gets the ditta value for this OperatoreInvitatoType.
     * 
     * @return ditta
     */
    public java.lang.String getDitta() {
        return ditta;
    }


    /**
     * Sets the ditta value for this OperatoreInvitatoType.
     * 
     * @param ditta
     */
    public void setDitta(java.lang.String ditta) {
        this.ditta = ditta;
    }


    /**
     * Gets the ragioneSociale value for this OperatoreInvitatoType.
     * 
     * @return ragioneSociale
     */
    public java.lang.String getRagioneSociale() {
        return ragioneSociale;
    }


    /**
     * Sets the ragioneSociale value for this OperatoreInvitatoType.
     * 
     * @param ragioneSociale
     */
    public void setRagioneSociale(java.lang.String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }


    /**
     * Gets the codiceFiscale value for this OperatoreInvitatoType.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this OperatoreInvitatoType.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the partitaIva value for this OperatoreInvitatoType.
     * 
     * @return partitaIva
     */
    public java.lang.String getPartitaIva() {
        return partitaIva;
    }


    /**
     * Sets the partitaIva value for this OperatoreInvitatoType.
     * 
     * @param partitaIva
     */
    public void setPartitaIva(java.lang.String partitaIva) {
        this.partitaIva = partitaIva;
    }


    /**
     * Gets the rti value for this OperatoreInvitatoType.
     * 
     * @return rti
     */
    public java.lang.Boolean getRti() {
        return rti;
    }


    /**
     * Sets the rti value for this OperatoreInvitatoType.
     * 
     * @param rti
     */
    public void setRti(java.lang.Boolean rti) {
        this.rti = rti;
    }


    /**
     * Gets the componentiRti value for this OperatoreInvitatoType.
     * 
     * @return componentiRti
     */
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType[] getComponentiRti() {
        return componentiRti;
    }


    /**
     * Sets the componentiRti value for this OperatoreInvitatoType.
     * 
     * @param componentiRti
     */
    public void setComponentiRti(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType[] componentiRti) {
        this.componentiRti = componentiRti;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType getComponentiRti(int i) {
        return this.componentiRti[i];
    }

    public void setComponentiRti(int i, it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.OperatoreType _value) {
        this.componentiRti[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperatoreInvitatoType)) return false;
        OperatoreInvitatoType other = (OperatoreInvitatoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ditta==null && other.getDitta()==null) || 
             (this.ditta!=null &&
              this.ditta.equals(other.getDitta()))) &&
            ((this.ragioneSociale==null && other.getRagioneSociale()==null) || 
             (this.ragioneSociale!=null &&
              this.ragioneSociale.equals(other.getRagioneSociale()))) &&
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.partitaIva==null && other.getPartitaIva()==null) || 
             (this.partitaIva!=null &&
              this.partitaIva.equals(other.getPartitaIva()))) &&
            ((this.rti==null && other.getRti()==null) || 
             (this.rti!=null &&
              this.rti.equals(other.getRti()))) &&
            ((this.componentiRti==null && other.getComponentiRti()==null) || 
             (this.componentiRti!=null &&
              java.util.Arrays.equals(this.componentiRti, other.getComponentiRti())));
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
        if (getDitta() != null) {
            _hashCode += getDitta().hashCode();
        }
        if (getRagioneSociale() != null) {
            _hashCode += getRagioneSociale().hashCode();
        }
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getPartitaIva() != null) {
            _hashCode += getPartitaIva().hashCode();
        }
        if (getRti() != null) {
            _hashCode += getRti().hashCode();
        }
        if (getComponentiRti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComponentiRti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComponentiRti(), i);
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
        new org.apache.axis.description.TypeDesc(OperatoreInvitatoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "OperatoreInvitatoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ditta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ditta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ragioneSociale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ragioneSociale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partitaIva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partitaIva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rti");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentiRti");
        elemField.setXmlName(new javax.xml.namespace.QName("", "componentiRti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "OperatoreType"));
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
