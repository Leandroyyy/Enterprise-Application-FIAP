package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.VeiculoDao;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class VeiculoDaoImpl implements VeiculoDao {

	private EntityManager em;
	
	public VeiculoDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Veiculo veiculo) {
		em.persist(veiculo);
	}

	public Veiculo procurar(Integer id) throws IdNotFoundException {
		
		Veiculo veiculo = em.find(Veiculo.class, id);
		if(veiculo == null) 
			throw new IdNotFoundException(id);
		return veiculo;
	}

	public void atualizar(Veiculo veiculo) {
		em.merge(veiculo);
	}

	public void apagar(Integer id) throws IdNotFoundException {
		Veiculo veiculo = procurar(id);
		em.remove(veiculo);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			throw new CommitException(); //Criar a exception 
		}
	}

}
