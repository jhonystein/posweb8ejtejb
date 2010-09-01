package util;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class JPAUtil {
	
	@PersistenceContext
	private EntityManager em;
	
	public void incluir(Object obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public void excluir(Object obj) {
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}
	
	public void alterar(Object obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public <T> T ler(Class<T> clazz, Object codigo) {
		Object obj = em.find(clazz, codigo);
		return (T)obj;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> listarTodos(Class<T> clazz) {
		Query q = em.createQuery("from " + clazz.getName());
		List<T> l = q.getResultList();
		
		return l;
	}
	
	@SuppressWarnings("rawtypes")
	public List listarNamedQuery(String namedQuery) {
		Query q = em.createNamedQuery(namedQuery);
		List l = q.getResultList();
		
		return l;
	}
		
}
