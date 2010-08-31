package modelo;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQuery(name="usuarioExiste", query="select count(c) from Cliente as c where c.cpf = ?1 ")
public class Cliente extends Entidade{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
