package modelo;

public class Produto extends Entidade{
	
	private static final long serialVersionUID = 1L;
	private String descricao;
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
