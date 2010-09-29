package controle;

import java.util.Date;
import java.util.List;

import javax.ejb.Lock;
import javax.ejb.LockType;
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

	private Movimentacao movimentacao;
	private Loja loja;
	
	@PersistenceContext
	private EntityManager em;
	
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
	public void login(String nick, String senha) throws Exception {
		Query q = em.createNamedQuery("carregarLoja");
		q.setParameter(1, nick);
		q.setParameter(2, senha);
		List<Loja> lstLojas = q.getResultList();
		if(lstLojas.size() > 0)
			loja = (Loja) lstLojas.get(0); 
		if(loja == null)
			throw new Exception("Loja inválido!");
	}

	@Override
	@Lock(LockType.WRITE)
	public void acumular(String cpf, int pontos) {
		
		Query q = em.createNamedQuery("clientePorCPF");
		q.setParameter(1, cpf);
		Cliente cliente = (Cliente) q.getSingleResult();
		cliente.setSaldo(cliente.getSaldo()+pontos);
		movimentacao = new Movimentacao();
		movimentacao.setCliente(cliente);
		movimentacao.setLoja(loja);
		movimentacao.setData(new Date());
		movimentacao.setHistorico("Compra de produto(s)");
		movimentacao.setPonto(pontos);
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		em.merge(movimentacao);
		em.flush();
		
	}

}
