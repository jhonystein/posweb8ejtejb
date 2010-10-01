package controle;

import java.rmi.RemoteException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import remote.ExtratoPontosUC;
import remote.ExtratoPontosUCService;
import remote.ExtratoPontosUCServiceLocator;


@SessionScoped
@ManagedBean(name = "loginUC")
public class LoginUC {

	private String login;
	private String senha;
	private Integer idSessao;

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
		} catch (RemoteException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Usuário/Senha inválidos!"));
			return "index";
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Problemas com o acesso ao servidor!"));
			return "index";
		}
		return "lisProdutos";
	}
	
}
