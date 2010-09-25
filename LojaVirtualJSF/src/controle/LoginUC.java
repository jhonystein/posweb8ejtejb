package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import remote.GerenciadorPontosRemote;

@SessionScoped
@ManagedBean(name="LoginUC")
public class LoginUC {
	
	private String nick;
	private String senha;
	
	public LoginUC() {}


	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logar() throws NamingException {
		
		Context ctx = new InitialContext();
        GerenciadorPontosRemote gerenciador = (GerenciadorPontosRemote) ctx.lookup("java:global/TrabalhoFinal/ProgramaFidelidadeEJB/GerenciadorPontosUC");
        gerenciador.login(nick, senha);
        
		return "formAdicionarPontos";
	}

}
