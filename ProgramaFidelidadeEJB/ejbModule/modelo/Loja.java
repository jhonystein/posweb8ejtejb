package modelo;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="lojas")
@NamedQuery(name="carregarLoja", query="select l from Loja as l where l.nick = ?1 and l.senha = ?2 ")
@Stateful
public class Loja implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_loja")
	private int codigo;
	
	@Column(name="ds_razaoSocial", nullable=false)
	private String razaoSocial;
	
	@Column(name="ds_nick", unique=true , nullable=false)
	private String nick;
	
	@Column(name="ds_senha", nullable=false)
	private String senha;
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
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
	
}
