package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public abstract class GenericDaoImpl<T,K> implements GenericDao<T, K> {

	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType)getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public List<T> listar(){
		TypedQuery<T> query = 
				em.createQuery("from " + clazz.getName(), clazz);
		return query.getResultList();
	}
	
	public List<T> listar(Integer inicio, Integer fim){
		return em.createQuery("from " + clazz.getName() ,clazz)
				.setFirstResult(inicio)
				.setMaxResults(fim)
				.getResultList();
	}
	
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	public void alterar(T entity) {
		em.merge(entity);
	}

	public void remover(K codigo) throws EntityNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null){
			throw new EntityNotFoundException("Entidade n?o encontrada");
		}
		em.remove(entidade);
	}

	public T pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}
	
	public void salvar() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new CommitException("Erro no commit", e);
		}
	}

}
