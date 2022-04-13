package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.entity.Time;

public class TimeDaoImpl 	
				extends GenericDaoImpl<Time, Integer>
										implements TimeDao {

	public TimeDaoImpl(EntityManager em) {
		super(em);
	}

}
