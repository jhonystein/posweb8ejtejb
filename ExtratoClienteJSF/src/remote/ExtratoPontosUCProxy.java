package remote;

public class ExtratoPontosUCProxy implements remote.ExtratoPontosUC {
  private String _endpoint = null;
  private remote.ExtratoPontosUC extratoPontosUC = null;
  
  public ExtratoPontosUCProxy() {
    _initExtratoPontosUCProxy();
  }
  
  public ExtratoPontosUCProxy(String endpoint) {
    _endpoint = endpoint;
    _initExtratoPontosUCProxy();
  }
  
  private void _initExtratoPontosUCProxy() {
    try {
      extratoPontosUC = (new remote.ExtratoPontosUCServiceLocator()).getExtratoPontosUCPort();
      if (extratoPontosUC != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)extratoPontosUC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)extratoPontosUC)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (extratoPontosUC != null)
      ((javax.xml.rpc.Stub)extratoPontosUC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public remote.ExtratoPontosUC getExtratoPontosUC() {
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    return extratoPontosUC;
  }
  
  public int login(java.lang.String cpf, java.lang.String senha) throws java.rmi.RemoteException, remote.Exception{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    return extratoPontosUC.login(cpf, senha);
  }
  
  public void logout(int codigoCliente) throws java.rmi.RemoteException, remote.Exception{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    extratoPontosUC.logout(codigoCliente);
  }
  
  public remote.Movimentacao[] extratoPontos(int codigoCliente) throws java.rmi.RemoteException, remote.Exception{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    return extratoPontosUC.extratoPontos(codigoCliente);
  }
  
  public void gastarPontos(int codigoCliente, int codigoProduto, int qtdProduto) throws java.rmi.RemoteException, remote.Exception{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    extratoPontosUC.gastarPontos(codigoCliente, codigoProduto, qtdProduto);
  }
  
  public void descontarPontosMes() throws java.rmi.RemoteException{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    extratoPontosUC.descontarPontosMes();
  }
  
  
}