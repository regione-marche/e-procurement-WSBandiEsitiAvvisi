/**
 * WSBandiEsitiAvvisiSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class WSBandiEsitiAvvisiSOAPSkeleton implements it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_PortType, org.apache.axis.wsdl.Skeleton {
    private it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contratto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pubblicazioneDa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pubblicazioneA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cig"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codiceStazAppaltante"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getElencoBandi", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ElencoBandiOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetElencoBandi"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetElencoBandi");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getElencoBandi") == null) {
            _myOperations.put("getElencoBandi", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getElencoBandi")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contratto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pubblicazioneDa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pubblicazioneA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cig"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codiceStazAppaltante"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getElencoBandiScaduti", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ElencoBandiOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetElencoBandiScaduti"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetElencoBandiScaduti");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getElencoBandiScaduti") == null) {
            _myOperations.put("getElencoBandiScaduti", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getElencoBandiScaduti")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codice"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDettaglioBando", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DettaglioBandoOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetDettaglioBando"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetDettaglioBando");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDettaglioBando") == null) {
            _myOperations.put("getDettaglioBando", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDettaglioBando")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codice"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDocumentoBando", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DocumentoBandoOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetDocumentoBando"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetDocumentoBando");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDocumentoBando") == null) {
            _myOperations.put("getDocumentoBando", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDocumentoBando")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dataAffidamentoDa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dataAffidamentoA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getProspettoBeneficiari", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ProspettoBeneficiariOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetProspettoBeneficiari"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetProspettoBeneficiari");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProspettoBeneficiari") == null) {
            _myOperations.put("getProspettoBeneficiari", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProspettoBeneficiari")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codice"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codiceBeneficiario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDocumentiBeneficiario", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DocumentiBeneficiarioOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetDocumentiBeneficiario"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetDocumentiBeneficiario");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDocumentiBeneficiario") == null) {
            _myOperations.put("getDocumentiBeneficiario", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDocumentiBeneficiario")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "anno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cig"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "proponente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "oggetto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "partecipante"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aggiudicatario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "indicePrimoRecord"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxNumRecord"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getProspettoGareContrattiAnticorruzione", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ProspettoGareContrattiAnticorruzioneOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetProspettoGareContrattiAnticorruzione"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetProspettoGareContrattiAnticorruzione");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProspettoGareContrattiAnticorruzione") == null) {
            _myOperations.put("getProspettoGareContrattiAnticorruzione", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProspettoGareContrattiAnticorruzione")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "anno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAdempimentiAnticorruzione", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "AdempimentoAnticorruzioneOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetAdempimentiAnticorruzione"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetAdempimentiAnticorruzione");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAdempimentiAnticorruzione") == null) {
            _myOperations.put("getAdempimentiAnticorruzione", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAdempimentiAnticorruzione")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cig"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strutturaProponente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "oggetto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipoAppalto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "partecipante"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aggiudicatario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dataPubblicazioneEsitoDa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dataPubblicazioneEsitoA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getProspettoContratti", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ProspettoContrattiOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetProspettoContratti"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetProspettoContratti");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProspettoContratti") == null) {
            _myOperations.put("getProspettoContratti", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProspettoContratti")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codice"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDettaglioContratto", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DettaglioContrattoOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetDettaglioContratto"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetDettaglioContratto");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDettaglioContratto") == null) {
            _myOperations.put("getDettaglioContratto", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDettaglioContratto")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getVersion", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "VersionOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetVersion"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetVersion");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getVersion") == null) {
            _myOperations.put("getVersion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getVersion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stazioneAppaltante"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "soggettoPercettore"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dataDa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dataA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ragioneIncarico"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "compensoPrevistoDa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), java.lang.Double.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "compensoPrevistoA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), java.lang.Double.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getConsulentiCollaboratori", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "ConsulentiCollaboratoriOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetConsulentiCollaboratori"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetConsulentiCollaboratori");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getConsulentiCollaboratori") == null) {
            _myOperations.put("getConsulentiCollaboratori", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getConsulentiCollaboratori")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codice"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codiceSoggetto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDocumentiConsulentiCollaboratori", _params, new javax.xml.namespace.QName("", "risultato"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "DocumentiConsulentiCollaboratoriOutType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "GetDocumentiConsulentiCollaboratori"));
        _oper.setSoapAction("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/GetDocumentiConsulentiCollaboratori");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDocumentiConsulentiCollaboratori") == null) {
            _myOperations.put("getDocumentiConsulentiCollaboratori", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDocumentiConsulentiCollaboratori")).add(_oper);
    }

    public WSBandiEsitiAvvisiSOAPSkeleton() {
        this.impl = new it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisiSOAPImpl();
    }

    public WSBandiEsitiAvvisiSOAPSkeleton(it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_PortType impl) {
        this.impl = impl;
    }
    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType getElencoBandi(java.lang.String token, java.lang.String tipo, java.lang.String contratto, java.util.Date pubblicazioneDa, java.util.Date pubblicazioneA, java.lang.String cig, java.lang.String codiceStazAppaltante) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType ret = impl.getElencoBandi(token, tipo, contratto, pubblicazioneDa, pubblicazioneA, cig, codiceStazAppaltante);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType getElencoBandiScaduti(java.lang.String token, java.lang.String tipo, java.lang.String contratto, java.util.Date pubblicazioneDa, java.util.Date pubblicazioneA, java.lang.String cig, java.lang.String codiceStazAppaltante) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ElencoBandiOutType ret = impl.getElencoBandiScaduti(token, tipo, contratto, pubblicazioneDa, pubblicazioneA, cig, codiceStazAppaltante);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoOutType getDettaglioBando(java.lang.String token, java.lang.String codice, java.lang.String tipo) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioBandoOutType ret = impl.getDettaglioBando(token, codice, tipo);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoBandoOutType getDocumentoBando(java.lang.String token, java.lang.String codice, java.lang.String tipo, int id) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentoBandoOutType ret = impl.getDocumentoBando(token, codice, tipo, id);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoBeneficiariOutType getProspettoBeneficiari(java.lang.String token, java.util.Date dataAffidamentoDa, java.util.Date dataAffidamentoA) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoBeneficiariOutType ret = impl.getProspettoBeneficiari(token, dataAffidamentoDa, dataAffidamentoA);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiBeneficiarioOutType getDocumentiBeneficiario(java.lang.String token, java.lang.String codice, java.lang.String codiceBeneficiario) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiBeneficiarioOutType ret = impl.getDocumentiBeneficiario(token, codice, codiceBeneficiario);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoGareContrattiAnticorruzioneOutType getProspettoGareContrattiAnticorruzione(java.lang.String token, int anno, java.lang.String cig, java.lang.String proponente, java.lang.String oggetto, java.lang.String partecipante, java.lang.String aggiudicatario, int indicePrimoRecord, int maxNumRecord) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoGareContrattiAnticorruzioneOutType ret = impl.getProspettoGareContrattiAnticorruzione(token, anno, cig, proponente, oggetto, partecipante, aggiudicatario, indicePrimoRecord, maxNumRecord);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneOutType getAdempimentiAnticorruzione(java.lang.String token, java.lang.Integer anno) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneOutType ret = impl.getAdempimentiAnticorruzione(token, anno);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattiOutType getProspettoContratti(java.lang.String token, java.lang.String cig, java.lang.String strutturaProponente, java.lang.String oggetto, java.lang.String tipoAppalto, java.lang.String partecipante, java.lang.String aggiudicatario, java.util.Date dataPubblicazioneEsitoDa, java.util.Date dataPubblicazioneEsitoA) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ProspettoContrattiOutType ret = impl.getProspettoContratti(token, cig, strutturaProponente, oggetto, tipoAppalto, partecipante, aggiudicatario, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoOutType getDettaglioContratto(java.lang.String token, java.lang.String codice) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DettaglioContrattoOutType ret = impl.getDettaglioContratto(token, codice);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.VersionOutType getVersion() throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.VersionOutType ret = impl.getVersion();
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulentiCollaboratoriOutType getConsulentiCollaboratori(java.lang.String token, java.lang.String stazioneAppaltante, java.lang.String soggettoPercettore, java.util.Date dataDa, java.util.Date dataA, java.lang.String ragioneIncarico, java.lang.Double compensoPrevistoDa, java.lang.Double compensoPrevistoA) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.ConsulentiCollaboratoriOutType ret = impl.getConsulentiCollaboratori(token, stazioneAppaltante, soggettoPercettore, dataDa, dataA, ragioneIncarico, compensoPrevistoDa, compensoPrevistoA);
        return ret;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiConsulentiCollaboratoriOutType getDocumentiConsulentiCollaboratori(java.lang.String token, java.lang.String codice, java.lang.String codiceSoggetto) throws java.rmi.RemoteException
    {
        it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.DocumentiConsulentiCollaboratoriOutType ret = impl.getDocumentiConsulentiCollaboratori(token, codice, codiceSoggetto);
        return ret;
    }

}
