package controle;

import java.util.ArrayList;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class ControleCliente{
	
	private ArrayList<Integer> clientesLogados = new ArrayList<Integer>();
	
	@Lock(LockType.READ)
	public boolean getUsuarioLogado(int codigoCliente) {
		for(Integer codigo: clientesLogados)
			if(codigo == codigoCliente)
				return true;
		return false;
	}
	
	@Lock(LockType.WRITE)
	public void addCliente(int codigo) {
		clientesLogados.add(codigo);
	}

	@Lock(LockType.WRITE)
	public boolean removerCliente(int codigoCliente) {
		for(Integer codigo: clientesLogados)
			if(codigo == codigoCliente){
				clientesLogados.remove(codigo);
				return true;
			}
		return false;
	}

}
