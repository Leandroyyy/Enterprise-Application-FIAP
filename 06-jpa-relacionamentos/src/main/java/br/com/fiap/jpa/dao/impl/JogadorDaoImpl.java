package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.JogadorDao;
import br.com.fiap.jpa.entity.Jogador;

public class JogadorDaoImpl 
			extends GenericDaoImpl<Jogador, Integer> 
											implements JogadorDao {

	public JogadorDaoImpl(EntityManager em) {
		super(em);
	}

}