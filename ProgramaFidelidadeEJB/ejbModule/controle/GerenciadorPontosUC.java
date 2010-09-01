package controle;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import modelo.Movimentacao;
import remote.GerenciadorPontosRemote;

@Stateless
public class GerenciadorPontosUC implements GerenciadorPontosRemote{

	@EJB
	private Movimentacao movimentacao;
	
	@Override
	public boolean existeUsuario(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void login(String nick, String senha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acumular(String cpf, int pontos) {
		
	}

}
