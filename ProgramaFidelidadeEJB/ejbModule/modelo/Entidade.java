package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Entidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int codigo;
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}

}
