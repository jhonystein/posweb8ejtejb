package controle;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.Loja;
import modelo.Movimentacao;
import remote.GerenciadorPontosRemote;

@Stateful
public class GerenciadorPontosUC implements GerenciadorPontosRemote{

	@EJB
	private Movimentacao movimentacao;
	@PersistenceContext
	private EntityManager em;
	private Loja loja;
	private Cliente cliente;
	
	@Override
	public boolean existeUsuario(String cpf) {
		Query q = em.createNamedQuery("usuarioPorCPF");
		q.setParameter(1, cpf);
		cliente = (Cliente) q.getSingleResult();
		if(cliente != null)
			return true;
		else
			return false;
	}

	@Override
	public void login(String nick, String senha) {
		Query q = em.createNamedQuery("carregarLoja");
		q.setParameter(1, nick);
		q.setParameter(1, senha);
		loja = (Loja) q.getSingleResult();
		//FALTA ADICIONAR ESTA LOJA A UMA CLASSE SINGLETON 
	}

	@Override
	public void acumular(String cpf, int pontos) {
		movimentacao.setLoja(loja);
		movimentacao.setData(new Date());
		movimentacao.setHistorico("");//acrescentar o texto para historico mais tarde
		movimentacao.setPonto(pontos);
//		movimentacao.setTipo(tipo) falta preencher
		em.persist(movimentacao);
		em.flush();
	}

}
