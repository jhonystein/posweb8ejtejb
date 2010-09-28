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
	private ControleCliente controleCliente;
	@EJB
	private GerenciadorPontosUC gerenciadorPontos;
		
	@WebMethod
	public int login(@WebParam(name="cpf") String cpf, @WebParam(name="senha") String senha) throws Exception {
		Query q = em.createNamedQuery("loginCliente");
		q.setParameter(1, cpf);
		q.setParameter(2, senha);
		Cliente cliente = (Cliente) q.getSingleResult();
		if(cliente != null){
			if(controleCliente.getUsuarioLogado(cliente.getCodigo()))
				throw new Exception("Usuario ja logado");
			else{//adiciona o cliente a lista
				controleCliente.addCliente(cliente.getCodigo());
				return cliente.getCodigo();
			}
		}else
			throw new Exception("Usuario inexistente");
	}

	@WebMethod
	@SuppressWarnings("unchecked")
	public List<Movimentacao> extratoPontos(@WebParam(name="codigoCliente") int codigoCliente) throws Exception {
		if(!controleCliente.getUsuarioLogado(codigoCliente))
			throw new Exception("Usuario nao esta logado");
		Query q = em.createNamedQuery("movimentacaoCliente");
		q.setParameter(1, codigoCliente);
		return q.getResultList();
	}

	@WebMethod
	public void gastarPontos(@WebParam(name="codigoCliente") int codigoCliente, @WebParam(name="codigoProduto") int codigoProduto, @WebParam(name="qtdProduto") int qtdProduto) throws Exception {
		gerenciadorPontos.gastarPontos(codigoCliente, codigoProduto, qtdProduto);
	}

	@WebMethod
	public void logout(@WebParam(name="codigoCliente") int codigoCliente) throws Exception {
		if(!controleCliente.removerCliente(codigoCliente))
			throw new Exception("Usuario nao esta logado");
	}
	
	@Schedule(dayOfMonth="10", hour="11", minute="00", second="00")
	public void descontarPontosMes(){
		Calendar data = Calendar.getInstance();
		data.add(Calendar.MONTH, -2);
		Query q = em.createNamedQuery("clienteUltimaTroca");
		q.setParameter(1, data.getTime());
		
		@SuppressWarnings("unchecked")
		List<Cliente> listaClientes = q.getResultList();
		for(Cliente cliente: listaClientes){
			int totalDescontar = 100;
			if(cliente.getSaldo() < 100)
				totalDescontar = cliente.getSaldo();
			if(totalDescontar > 0){
				cliente.setSaldo(cliente.getSaldo()-totalDescontar);
				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setCliente(cliente);
				movimentacao.setData(new Date());
				movimentacao.setHistorico("Desconto da pontuacao(Mais de 2 meses sem movimentacao)");
				movimentacao.setPonto(totalDescontar);
				movimentacao.setTipo(TipoMovimentacao.SAIDA);				
				em.persist(movimentacao);
				em.flush();
			}
		}
		
	}

}
