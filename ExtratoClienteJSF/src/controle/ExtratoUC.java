package controle;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import remote.ExtratoPontosUC;
import remote.ExtratoPontosUCService;
import remote.ExtratoPontosUCServiceLocator;
import remote.Movimentacao;


@SessionScoped
@ManagedBean(name = "extratoUC")
public class ExtratoUC {

	private String login;
	private String senha;
	private Integer idSessao;
	private List<Movimentacao> movimentacao;

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logout() {
		try {
			ExtratoPontosUCService service = new ExtratoPontosUCServiceLocator();
			ExtratoPontosUC proxy = service.getExtratoPontosUCPort();
			proxy.logout(idSessao);
			idSessao = null;
		} catch (RemoteException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Sessão inválida!"));
			return "index";
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Problemas com o acesso ao servidor!"));
			return "index";
		}
		return "index";
	}
	
	public String logar(){
		try {
			ExtratoPontosUCService service = new ExtratoPontosUCServiceLocator();
			ExtratoPontosUC proxy = service.getExtratoPontosUCPort();
			idSessao = proxy.login(login, senha);
			updateMovimentacao();
		} catch (RemoteException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Usuário/Senha inválidos!"));
			return "index";
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Problemas com o acesso ao servidor!"));
			return "index";
		}
		return "listProdutos";
	}
	
	public List<Movimentacao> getMovimentacao() {
		updateMovimentacao();
		return movimentacao;
	}
	
	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	private void updateMovimentacao() {
		try {
			ExtratoPontosUCService service = new ExtratoPontosUCServiceLocator();
			ExtratoPontosUC proxy = service.getExtratoPontosUCPort();
			
			Movimentacao[] arrMovimentacao = proxy.extratoPontos(idSessao);
			
			movimentacao = new ArrayList<Movimentacao>();
			if (arrMovimentacao != null) {
				for (Movimentacao movimento : arrMovimentacao) {
					movimentacao.add(movimento);
				}
			}
		} catch (RemoteException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Sessão inválida!"));
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Problemas com o acesso ao servidor!"));
		}
	}
	
}
