package controle;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.Movimentacao;

@WebService
public class ExtratoPontosUC{

	@WebMethod
	public int login(@WebParam(name="cpf") String cpf, @WebParam(name="senha") String senha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@WebMethod
	public List<Movimentacao> extratoPontos(@WebParam(name="codigoCliente") int codigoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@WebMethod
	public void gastarPontos(@WebParam(name="codigoCliente") int codigoCliente, @WebParam(name="codigoProduto") int codigoProduto) {
		// TODO Auto-generated method stub
		
	}

	@WebMethod
	public void logout(@WebParam(name="codigoCliente") int codigoCliente) {
		// TODO Auto-generated method stub
		
	}

}
