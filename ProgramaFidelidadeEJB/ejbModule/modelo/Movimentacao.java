package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="movimentacoes")
public class Movimentacao extends Entidade{

	private static final long serialVersionUID = 1L;
	
	@Column(name="dt_data", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name="loja")
	private Loja loja;
	
	@Column(name="produto")
	private Produto produto;
	
	@Column(name="cliente")
	private Cliente cliente;
	
	@Column(name="nr_pontos", nullable=false)
	private int ponto;
	
	@Column(name="ds_tipo")
	private String tipo;
	
	@Column(name="dt_historico")
	private String historico;
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
}
