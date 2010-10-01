/**
 * ProdutosUCServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package remote;

public class ProdutosUCServiceLocator extends org.apache.axis.client.Service implements remote.ProdutosUCService {

    public ProdutosUCServiceLocator() {
    }


    public ProdutosUCServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProdutosUCServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProdutosUCPort
    private java.lang.String ProdutosUCPort_address = "http://localhost:8080/ProdutosUCService/ProdutosUC";

    public java.lang.String getProdutosUCPortAddress() {
        return ProdutosUCPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProdutosUCPortWSDDServiceName = "ProdutosUCPort";

    public java.lang.String getProdutosUCPortWSDDServiceName() {
        return ProdutosUCPortWSDDServiceName;
    }

    public void setProdutosUCPortWSDDServiceName(java.lang.String name) {
        ProdutosUCPortWSDDServiceName = name;
    }

    public remote.ProdutosUC getProdutosUCPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProdutosUCPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProdutosUCPort(endpoint);
    }

    public remote.ProdutosUC getProdutosUCPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            remote.ProdutosUCPortBindingStub _stub = new remote.ProdutosUCPortBindingStub(portAddress, this);
            _stub.setPortName(getProdutosUCPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProdutosUCPortEndpointAddress(java.lang.String address) {
        ProdutosUCPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (remote.ProdutosUC.class.isAssignableFrom(serviceEndpointInterface)) {
                remote.ProdutosUCPortBindingStub _stub = new remote.ProdutosUCPortBindingStub(new java.net.URL(ProdutosUCPort_address), this);
                _stub.setPortName(getProdutosUCPortWSDDServiceName());
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
        if ("ProdutosUCPort".equals(inputPortName)) {
            return getProdutosUCPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://controle/", "ProdutosUCService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://controle/", "ProdutosUCPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProdutosUCPort".equals(portName)) {
            setProdutosUCPortEndpointAddress(address);
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
