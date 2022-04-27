package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ItemTesteDao;
import br.com.fiap.jpa.entity.ItemTeste;

public class ItemTesteDaoImpl extends GenericDaoImpl<ItemTeste, Integer> implements ItemTesteDao{

	public ItemTesteDaoImpl(EntityManager em) {
		super(em);
	}

}
