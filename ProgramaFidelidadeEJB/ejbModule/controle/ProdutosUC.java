package controle;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Produto;

@WebService
@Stateless
public class ProdutosUC{

	@PersistenceContext
	private EntityManager em;

	@WebMethod
	public List<Produto> listar() {
		return em.createQuery("select p from Produto p ").getResultList();
	}

}
