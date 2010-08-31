package controle;

import java.util.List;

import modelo.Movimentacao;
import remote.ExtratoPontosRemote;

public class ExtratoPontosUC implements ExtratoPontosRemote{

	@Override
	public int login(String cpf, String senha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Movimentacao> extratoPontos(int codigoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gastarPontos(int codigoCliente, int codigoProduto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(int codigoCliente) {
		// TODO Auto-generated method stub
		
	}

}
