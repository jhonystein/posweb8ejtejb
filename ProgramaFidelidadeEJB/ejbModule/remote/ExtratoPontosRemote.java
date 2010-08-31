package remote;

import java.util.List;

import javax.ejb.Remote;

import modelo.Movimentacao;

@Remote
public interface ExtratoPontosRemote {

	int login(String cpf, String senha);
	List<Movimentacao> extratoPontos(int codigoCliente);
	void gastarPontos(int codigoCliente, int codigoProduto);
	void logout(int codigoCliente);
	
}
