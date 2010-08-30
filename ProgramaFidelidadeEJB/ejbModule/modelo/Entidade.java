package modelo;

import java.io.Serializable;

public class Entidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}

}
