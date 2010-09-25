package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clientes")
@NamedQueries({
@NamedQuery(name="clientePorCPF", query="select c from Cliente as c where c.cpf = ?1 "),
@NamedQuery(name="loginCliente", query="select c from Cliente as c where c.cpf = ?1 and c.senha = ?2 "),
@NamedQuery(name="clienteUltimaTroca", query="select c from Cliente c where c.ultimaSaida <= ?1")
})
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int codigo;
	
	@Column(name="ds_cliente")
	private String nome;
	
	@Column(name="nr_cpf", unique=true, nullable=false)
	private String cpf;
	
	@Column(name="ds_senha")
	private String senha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_ultimasaida")
	private Date ultimaSaida;
	
	@Column(name="vl_saldo")
	private int saldo;
	
	public Date getUltimaSaida() {
		return ultimaSaida;
	}
	public void setUltimaSaida(Date ultimaSaida) {
		this.ultimaSaida = ultimaSaida;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
		
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
