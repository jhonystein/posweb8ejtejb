package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto extends Entidade{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="ds_produto")
	private String descricao;
	
	@Column(name="nr_pontos")
	private int pontos;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
