/**
 * WSBandiEsitiAvvisi_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws;

public class WSBandiEsitiAvvisi_ServiceLocator extends org.apache.axis.client.Service implements it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_Service {

    public WSBandiEsitiAvvisi_ServiceLocator() {
    }


    public WSBandiEsitiAvvisi_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSBandiEsitiAvvisi_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSBandiEsitiAvvisiSOAP
    private java.lang.String WSBandiEsitiAvvisiSOAP_address = "http://localhost:8080/AliceWSBandiEsitiAvvisi/services/WSBandiEsitiAvvisiSOAP";

    public java.lang.String getWSBandiEsitiAvvisiSOAPAddress() {
        return WSBandiEsitiAvvisiSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSBandiEsitiAvvisiSOAPWSDDServiceName = "WSBandiEsitiAvvisiSOAP";

    public java.lang.String getWSBandiEsitiAvvisiSOAPWSDDServiceName() {
        return WSBandiEsitiAvvisiSOAPWSDDServiceName;
    }

    public void setWSBandiEsitiAvvisiSOAPWSDDServiceName(java.lang.String name) {
        WSBandiEsitiAvvisiSOAPWSDDServiceName = name;
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_PortType getWSBandiEsitiAvvisiSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSBandiEsitiAvvisiSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSBandiEsitiAvvisiSOAP(endpoint);
    }

    public it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_PortType getWSBandiEsitiAvvisiSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisiSOAPStub _stub = new it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisiSOAPStub(portAddress, this);
            _stub.setPortName(getWSBandiEsitiAvvisiSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSBandiEsitiAvvisiSOAPEndpointAddress(java.lang.String address) {
        WSBandiEsitiAvvisiSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisi_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisiSOAPStub _stub = new it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.WSBandiEsitiAvvisiSOAPStub(new java.net.URL(WSBandiEsitiAvvisiSOAP_address), this);
                _stub.setPortName(getWSBandiEsitiAvvisiSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSBandiEsitiAvvisiSOAP".equals(inputPortName)) {
            return getWSBandiEsitiAvvisiSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "WSBandiEsitiAvvisi");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.eldasoft.it/appalti/WSBandiEsitiAvvisi/", "WSBandiEsitiAvvisiSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSBandiEsitiAvvisiSOAP".equals(portName)) {
            setWSBandiEsitiAvvisiSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
