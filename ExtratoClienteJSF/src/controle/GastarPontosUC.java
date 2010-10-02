package controle;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import remote.Produto;
import remote.ProdutosUC;
import remote.ProdutosUCService;
import remote.ProdutosUCServiceLocator;

@SessionScoped
@ManagedBean(name = "gastarPontosUC")
public class GastarPontosUC {
	
	private List<Produto> produtos;
    private UIData selec;

	public GastarPontosUC() {
		try {
			ProdutosUCService service = new ProdutosUCServiceLocator();
			ProdutosUC proxy = service.getProdutosUCPort();
			
			Produto[] arrProduto = proxy.listar();
			
			produtos = new ArrayList<Produto>(arrProduto.length);
			for (Produto produto : arrProduto) {
				produtos.add(produto);
			}
		} catch (RemoteException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Sessão inválida!"));
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Problemas com o acesso ao servidor!"));
		}
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

    public UIData getSelec() {
        return selec;
    }

    public void setSelec(UIData selec) {
        this.selec = selec;
    }

}
