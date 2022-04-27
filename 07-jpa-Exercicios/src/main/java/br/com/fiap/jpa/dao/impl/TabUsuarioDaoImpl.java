package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.TabUsuarioDao;
import br.com.fiap.jpa.entity.TabUsuario;

public class TabUsuarioDaoImpl extends GenericDaoImpl<TabUsuario, Integer> implements TabUsuarioDao{

	public TabUsuarioDaoImpl(EntityManager em) {
		super(em);
	}

}

