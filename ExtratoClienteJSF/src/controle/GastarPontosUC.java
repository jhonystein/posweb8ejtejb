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

import remote.ExtratoPontosUC;
import remote.ExtratoPontosUCService;
import remote.ExtratoPontosUCServiceLocator;
import remote.Produto;
import remote.ProdutosUC;
import remote.ProdutosUCService;
import remote.ProdutosUCServiceLocator;

@SessionScoped
@ManagedBean(name = "gastarPontosUC")
public class GastarPontosUC {
	
	private List<Produto> produtos;
    private UIData selec;
    private Produto produtoSelecionado;
    private Integer qtdade;
	private Integer idSessao;
    
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

    public String selecione(){
        produtoSelecionado = (Produto)selec.getRowData();
        return "formGastarPontos";
    }

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setQtdade(Integer qtdade) {
		this.qtdade = qtdade;
	}

	public Integer getQtdade() {
		return qtdade;
	}

	public String gastarPontos() {
		try {
			ExtratoPontosUCService service = new ExtratoPontosUCServiceLocator();
			ExtratoPontosUC proxy = service.getExtratoPontosUCPort();
			ExtratoUC extrato = (ExtratoUC)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("extratoUC");
			proxy.gastarPontos(extrato.getIdSessao(), produtoSelecionado.getCodigo(), qtdade);
		} catch (RemoteException e) {
			FacesContext.getCurrentInstance().addMessage("produto",
					new FacesMessage("Não foi possível gastar os pontos " + e.getMessage()));
			return "formGastarPontos";
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Problemas com o acesso ao servidor!"));
			return "index";
		}
		return "listProdutos";
	}

	public void setIdSessao(Integer idSessao) {
		this.idSessao = idSessao;
	}

	public Integer getIdSessao() {
		return idSessao;
	}
	
}
