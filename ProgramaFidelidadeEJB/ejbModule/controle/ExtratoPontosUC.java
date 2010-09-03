package controle;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.Movimentacao;

@WebService
@Stateless
public class ExtratoPontosUC{

	@PersistenceContext
	private EntityManager em;
	@EJB
	ControleCliente controleCliente;
		
	@WebMethod
	public int login(@WebParam(name="cpf") String cpf, @WebParam(name="senha") String senha) throws Exception {
		Query q = em.createNamedQuery("loginCliente");
		q.setParameter(1, cpf);
		q.setParameter(2, senha);
		Cliente cliente = (Cliente) q.getSingleResult();
		if(cliente != null){
			if(controleCliente.getUsuarioLogado(cliente.getCodigo()))
				throw new Exception();
			else
				return cliente.getCodigo();
		}else
			throw new Exception();
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
	public void logout(@WebParam(name="codigoCliente") int codigoCliente) throws Exception {
		if(!controleCliente.removerCliente(codigoCliente))
			throw new Exception();
	}

}
