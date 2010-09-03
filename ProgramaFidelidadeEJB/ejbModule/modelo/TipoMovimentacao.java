package modelo;

public enum TipoMovimentacao {
	
	entrada("Entrada"), saida("Sa�da");
	
	private String descricao = "";
	
	TipoMovimentacao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}

}
