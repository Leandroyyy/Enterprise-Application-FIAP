package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Reserva;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente,Integer> implements ClienteDao{

	public ClienteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Cliente> buscarPorNome(String nome) {
		return em.createQuery("from Cliente c where lower(c.nome) like lower(:n)",Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.getResultList();
	}

	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf like :n",Cliente.class)
				.setParameter("n", "%" + estado + "%")
				.getResultList();
	}
	
	public Long totalClientesPorEstado(String estado) {
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf like :n",Long.class)
				.setParameter("n", "%" + estado + "%")
				.getSingleResult();
	}
	
	
	public List<Cliente> buscarPorDias(Integer reserva){
		return em.createQuery("select cliente from Reserva r where r.numeroDias = :n" , Cliente.class)
				.setParameter("n", reserva )
				.getResultList();
	}
	
	public List<Cliente> buscar(String nome, String cidade){
		return em.createQuery("from Cliente c where c.nome like :n and c.endereco.cidade.nome like :f", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("f", "%" + cidade + "%")
				.getResultList();
	}
	
	public List<Cliente> buscarPorEstados(List<String> estados){
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in (:n)", Cliente.class)
				.setParameter("n", estados)
				.getResultList();
	}
}
