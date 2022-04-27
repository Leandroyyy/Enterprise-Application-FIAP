package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CasoTesteDao;
import br.com.fiap.jpa.entity.CasoTeste;

public class CasoTesteDaoImpl extends GenericDaoImpl<CasoTeste, Integer> implements CasoTesteDao{

	public CasoTesteDaoImpl(EntityManager em) {
		super(em);
	}

}
