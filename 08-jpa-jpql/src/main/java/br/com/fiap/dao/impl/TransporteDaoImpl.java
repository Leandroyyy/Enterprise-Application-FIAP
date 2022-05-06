package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TransporteDao;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class TransporteDaoImpl extends GenericDaoImpl<Transporte,Integer> implements TransporteDao{

	public TransporteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
