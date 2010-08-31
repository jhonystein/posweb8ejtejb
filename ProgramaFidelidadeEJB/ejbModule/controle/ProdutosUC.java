package controle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Produto;

import remote.ProdutosRemote;

@Stateless
public class ProdutosUC implements ProdutosRemote {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() {
		return em.createQuery("from " + Produto.class.getName()).getResultList();
	}

}
