package br.com.fiap.jpa.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CasoTesteDao;
import br.com.fiap.jpa.dao.ItemTesteDao;
import br.com.fiap.jpa.dao.SistemaDao;
import br.com.fiap.jpa.dao.TabUsuarioDao;
import br.com.fiap.jpa.dao.impl.CasoTesteDaoImpl;
import br.com.fiap.jpa.dao.impl.ItemTesteDaoImpl;
import br.com.fiap.jpa.dao.impl.SistemaDaoImpl;
import br.com.fiap.jpa.dao.impl.TabUsuarioDaoImpl;
import br.com.fiap.jpa.entity.CasoTeste;
import br.com.fiap.jpa.entity.ItemTeste;
import br.com.fiap.jpa.entity.Sistema;
import br.com.fiap.jpa.entity.TabUsuario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Resultado {

	public static void main(String[] args)  {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		try {
		TabUsuario usuario = new TabUsuario("Leandro");
		
		Sistema sistema = new Sistema("Evo");
		
		CasoTeste casoTeste = new CasoTeste("dsad","dsaad",sistema);
		
		ItemTeste item1 = new ItemTeste("violao", casoTeste);
		
		TabUsuarioDao usuarioDao = new TabUsuarioDaoImpl(em);
		usuarioDao.cadastrar(usuario);
		usuarioDao.commit();
		SistemaDao sistemaDao = new SistemaDaoImpl(em);
		sistemaDao.cadastrar(sistema);
		sistemaDao.commit();
		CasoTesteDao casoTesteDao = new CasoTesteDaoImpl(em);
		casoTesteDao.cadastrar(casoTeste);
		casoTesteDao.commit();
		ItemTesteDao itemTesteDao = new ItemTesteDaoImpl(em);
		itemTesteDao.cadastrar(item1);
		itemTesteDao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
		}
	}
}
