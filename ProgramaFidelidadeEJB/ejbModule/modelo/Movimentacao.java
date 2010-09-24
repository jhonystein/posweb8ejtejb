package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Stateful;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="movimentacoes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name="movimentacaoCliente", query="select m from Movimentacao as m where m.cliente.codigo = ?1 ")
//@NamedQuery(name="clientePorCPF", query="select c from Cliente as c where c.cpf = ?1 ")
@Stateful
public class Movimentacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movimentacao")
	private int codigo;
	
	@Column(name="dt_data", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_loja")	
	private Loja loja;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_produto")
	private Produto produto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_cliente")
	private Cliente cliente;
	
	@Column(name="nr_pontos", nullable=false)
	private int ponto;
	
	@Column(name="ds_tipo")
	@Enumerated
	private TipoMovimentacao tipo;
	
	@Column(name="ds_historico")
	private String historico;
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
		
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getPonto() {
		return ponto;
	}
	public void setPonto(int ponto) {
		this.ponto = ponto;
	}
	public TipoMovimentacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
}
