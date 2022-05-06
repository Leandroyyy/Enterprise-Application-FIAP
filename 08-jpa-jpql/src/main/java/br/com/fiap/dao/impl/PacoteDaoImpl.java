package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDaoImpl extends GenericDaoImpl<Pacote,Integer> implements PacoteDao{

	public PacoteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Pacote> listar() {
		//Criar a query
		TypedQuery<Pacote> query = em.createQuery("from Pacote", Pacote.class);
		//Executar a query e obter a lista como resposta
		return query.getResultList();
	}

	public List<Pacote> buscarPorQuantidadeDias(Integer inicio, Integer fim) {
		//Criar a query
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.qtdDias between :churros and :pipoca", Pacote.class);
		//Passar os parâmetros para a query
		query.setParameter("churros", inicio);
		query.setParameter("pipoca", fim);
		//Executar a query
		return query.getResultList();
	}

	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		return em.createQuery("from Pacote p where p.transporte = :n ",Pacote.class)
				.setParameter("n", transporte)
				.getResultList();
	}

}
