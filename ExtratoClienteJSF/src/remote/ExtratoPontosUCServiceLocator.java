/**
 * ExtratoPontosUCServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package remote;

public class ExtratoPontosUCServiceLocator extends org.apache.axis.client.Service implements remote.ExtratoPontosUCService {

    public ExtratoPontosUCServiceLocator() {
    }


    public ExtratoPontosUCServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ExtratoPontosUCServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ExtratoPontosUCPort
    private java.lang.String ExtratoPontosUCPort_address = "http://localhost:8080/ExtratoPontosUCService/ExtratoPontosUC";

    public java.lang.String getExtratoPontosUCPortAddress() {
        return ExtratoPontosUCPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ExtratoPontosUCPortWSDDServiceName = "ExtratoPontosUCPort";

    public java.lang.String getExtratoPontosUCPortWSDDServiceName() {
        return ExtratoPontosUCPortWSDDServiceName;
    }

    public void setExtratoPontosUCPortWSDDServiceName(java.lang.String name) {
        ExtratoPontosUCPortWSDDServiceName = name;
    }

    public remote.ExtratoPontosUC getExtratoPontosUCPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ExtratoPontosUCPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getExtratoPontosUCPort(endpoint);
    }

    public remote.ExtratoPontosUC getExtratoPontosUCPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            remote.ExtratoPontosUCPortBindingStub _stub = new remote.ExtratoPontosUCPortBindingStub(portAddress, this);
            _stub.setPortName(getExtratoPontosUCPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setExtratoPontosUCPortEndpointAddress(java.lang.String address) {
        ExtratoPontosUCPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (remote.ExtratoPontosUC.class.isAssignableFrom(serviceEndpointInterface)) {
                remote.ExtratoPontosUCPortBindingStub _stub = new remote.ExtratoPontosUCPortBindingStub(new java.net.URL(ExtratoPontosUCPort_address), this);
                _stub.setPortName(getExtratoPontosUCPortWSDDServiceName());
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
        if ("ExtratoPontosUCPort".equals(inputPortName)) {
            return getExtratoPontosUCPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://controle/", "ExtratoPontosUCService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://controle/", "ExtratoPontosUCPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ExtratoPontosUCPort".equals(portName)) {
            setExtratoPontosUCPortEndpointAddress(address);
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
