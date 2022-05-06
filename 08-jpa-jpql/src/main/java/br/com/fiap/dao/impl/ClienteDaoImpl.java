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
		return em.createQuery("from Cliente c where c.nome like :n",Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.getResultList();
	}

	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf like :n",Cliente.class)
				.setParameter("n", "%" + estado + "%")
				.getResultList();
	}
	
	public List<Cliente> buscarPorDias(Integer reserva){
		return em.createQuery("Select Cliente from Reserva r where r.numeroDias = :n" , Cliente.class)
				.setParameter("n", "%" + reserva + "%")
				.getResultList();
	}
}
