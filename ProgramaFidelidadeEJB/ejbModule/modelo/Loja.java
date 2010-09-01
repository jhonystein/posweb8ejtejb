package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lojas")
public class Loja extends Entidade{

	private static final long serialVersionUID = 1L;
	
	@Column(name="ds_razaoSocial", nullable=false)
	private String razaoSocial;
	
	@Column(name="ds_login", unique=true , nullable=false)
	private String login;
	
	@Column(name="ds_senha", nullable=false)
	private String senha;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
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
	
}
