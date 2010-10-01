package remote;

public class ProdutosUCProxy implements remote.ProdutosUC {
  private String _endpoint = null;
  private remote.ProdutosUC produtosUC = null;
  
  public ProdutosUCProxy() {
    _initProdutosUCProxy();
  }
  
  public ProdutosUCProxy(String endpoint) {
    _endpoint = endpoint;
    _initProdutosUCProxy();
  }
  
  private void _initProdutosUCProxy() {
    try {
      produtosUC = (new remote.ProdutosUCServiceLocator()).getProdutosUCPort();
      if (produtosUC != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)produtosUC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)produtosUC)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (produtosUC != null)
      ((javax.xml.rpc.Stub)produtosUC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public remote.ProdutosUC getProdutosUC() {
    if (produtosUC == null)
      _initProdutosUCProxy();
    return produtosUC;
  }
  
  public remote.Produto[] listar() throws java.rmi.RemoteException{
    if (produtosUC == null)
      _initProdutosUCProxy();
    return produtosUC.listar();
  }
  
  
}