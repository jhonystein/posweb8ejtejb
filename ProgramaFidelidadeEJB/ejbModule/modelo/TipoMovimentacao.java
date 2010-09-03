package modelo;

public enum TipoMovimentacao {
	
	entrada("Entrada"), saida("Saída");
	
	private String descricao = "";
	
	TipoMovimentacao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}

}
