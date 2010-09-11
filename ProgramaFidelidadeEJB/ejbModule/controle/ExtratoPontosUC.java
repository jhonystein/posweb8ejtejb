package controle;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;

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
				throw new Exception();//usuario ja logado
			else{//adiciona o cliente a lista
				controleCliente.addCliente(cliente.getCodigo());
				return cliente.getCodigo();
			}
		}else
			throw new Exception();//usuario inexistente
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
			throw new Exception();//usuario nao esta logado
	}
	
	@Schedule(dayOfMonth="10", hour="11")
	public void descontarPontosMes(){
		Calendar data = Calendar.getInstance();
		data.add(Calendar.MONTH, -2);
		Query q = em.createNamedQuery("clienteUltimaTroca");
		q.setParameter(1, data.getTime());
		
		List<Object[]> listaObjetos = q.getResultList();
		for(Object[] o: listaObjetos){
			int saldoPonto = (Integer)o[1];
			int totalDescontar = 100;
			if(saldoPonto < 100)
				totalDescontar = saldoPonto;
			if(totalDescontar > 0){
				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setCliente((Cliente)o[0]);
				movimentacao.setData(new Date());
				movimentacao.setHistorico("");//acrescentar o texto para historico mais tarde
				movimentacao.setPonto(totalDescontar);
				movimentacao.setTipo(TipoMovimentacao.SAIDA);
				em.persist(movimentacao);
				em.flush();
			}
		}
		
	}

}
