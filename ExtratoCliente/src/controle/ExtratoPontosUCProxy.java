package controle;

public class ExtratoPontosUCProxy implements controle.ExtratoPontosUC {
  private String _endpoint = null;
  private controle.ExtratoPontosUC extratoPontosUC = null;
  
  public ExtratoPontosUCProxy() {
    _initExtratoPontosUCProxy();
  }
  
  public ExtratoPontosUCProxy(String endpoint) {
    _endpoint = endpoint;
    _initExtratoPontosUCProxy();
  }
  
  private void _initExtratoPontosUCProxy() {
    try {
      extratoPontosUC = (new controle.ExtratoPontosUCServiceLocator()).getExtratoPontosUCPort();
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
  
  public controle.ExtratoPontosUC getExtratoPontosUC() {
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    return extratoPontosUC;
  }
  
  public int login(java.lang.String cpf, java.lang.String senha) throws java.rmi.RemoteException, controle.Exception{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    return extratoPontosUC.login(cpf, senha);
  }
  
  public void logout(int codigoCliente) throws java.rmi.RemoteException, controle.Exception{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    extratoPontosUC.logout(codigoCliente);
  }
  
  public controle.Movimentacao[] extratoPontos(int codigoCliente) throws java.rmi.RemoteException, controle.Exception{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    return extratoPontosUC.extratoPontos(codigoCliente);
  }
  
  public void gastarPontos(int codigoCliente, int codigoProduto) throws java.rmi.RemoteException{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    extratoPontosUC.gastarPontos(codigoCliente, codigoProduto);
  }
  
  public void descontarPontosMes() throws java.rmi.RemoteException{
    if (extratoPontosUC == null)
      _initExtratoPontosUCProxy();
    extratoPontosUC.descontarPontosMes();
  }
  
  
}