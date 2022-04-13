package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Tecnico;
import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.TecnicoDao;

public class TecnicoDaoImpl 
					extends GenericDaoImpl<Tecnico, Integer>	
									implements TecnicoDao {

	public TecnicoDaoImpl(EntityManager em) {
		super(em);
	}

}
