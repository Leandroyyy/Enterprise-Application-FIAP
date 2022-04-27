package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.SistemaDao;
import br.com.fiap.jpa.entity.Sistema;

public class SistemaDaoImpl extends GenericDaoImpl<Sistema, Integer> implements SistemaDao{

	public SistemaDaoImpl(EntityManager em) {
		super(em);
	}

}
