package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
@NamedQuery(name="usuarioPorCPF", query="select c from Cliente as c where c.cpf = ?1 ")
public class Cliente extends Entidade{

	private static final long serialVersionUID = 1L;
	
	@Column(name="ds_cliente")
	private String nome;
	
	@Column(name="nr_cpf", unique=true, nullable=false)
	private String cpf;
	
	@Column(name="ds_senha")
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
