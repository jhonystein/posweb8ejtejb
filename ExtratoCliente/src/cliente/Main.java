package cliente;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import controle.Produto;
import controle.ProdutosUC;
import controle.ProdutosUCService;
import controle.ProdutosUCServiceLocator;

public class Main {

	public static void main(String[] args) {
		try {
	        ProdutosUCService service = new ProdutosUCServiceLocator();
	        ProdutosUC proxy;
			proxy = service.getProdutosUCPort();
	        Produto[] produtos;
			produtos = proxy.listar();
	
	        for (Produto prod : produtos) {
	            System.out.println("Produto: " + prod.getCodigo() + " " + prod.getDescricao() + " " + prod.getPontos());
	        }
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
