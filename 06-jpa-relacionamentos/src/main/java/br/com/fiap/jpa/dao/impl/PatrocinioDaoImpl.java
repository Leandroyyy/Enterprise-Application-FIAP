package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.PatrocinioDao;
import br.com.fiap.jpa.entity.Patrocinio;

public class PatrocinioDaoImpl 
			extends GenericDaoImpl<Patrocinio, Integer>
								implements PatrocinioDao {

	public PatrocinioDaoImpl(EntityManager em) {
		super(em);
	}

}
