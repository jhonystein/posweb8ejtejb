package controle;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Cliente;
import modelo.Loja;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;
import remote.GerenciadorPontosRemote;

@Stateful
public class GerenciadorPontosUC implements GerenciadorPontosRemote{

	@EJB
	private Movimentacao movimentacao;
	
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private Loja loja;
	
	@Override
	public boolean existeUsuario(String cpf) {
		Query q = em.createNamedQuery("clientePorCPF");
		q.setParameter(1, cpf);
		
		if (q.getResultList().isEmpty())
			return false;
		else
			return true;
	}

	@Override
	public void login(String nick, String senha) {
		Query q = em.createNamedQuery("carregarLoja");
		q.setParameter(1, nick);
		q.setParameter(2, senha);
		loja = (Loja) q.getSingleResult(); 
	}

	@Override
	public void acumular(String cpf, int pontos) {
		
		Query q = em.createNamedQuery("clientePorCPF");
		q.setParameter(1, cpf);
		Cliente cliente = (Cliente) q.getSingleResult();
		movimentacao.setCliente(cliente);
		movimentacao.setLoja(loja);
		movimentacao.setData(new Date());
		movimentacao.setHistorico("");//acrescentar o texto para historico mais tarde
		movimentacao.setPonto(pontos);
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		em.persist(movimentacao);
		em.flush();
		
	}

}
