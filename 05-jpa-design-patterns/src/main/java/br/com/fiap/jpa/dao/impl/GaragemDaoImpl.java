package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GaragemDao;
import br.com.fiap.jpa.entity.Garagem;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class GaragemDaoImpl	extends GenericDaoImpl<Garagem, Integer> implements GaragemDao{

	public GaragemDaoImpl(EntityManager em) {
		super(em);
	}

}
