package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.dao.impl.TimeDaoImpl;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploBusca {

	public static void main(String[] args) {
		//Criar a fabrica e entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Criar o TimeDao
		TimeDao timeDao = new TimeDaoImpl(em);
		
		try {
			//Pesquisar o time pelo codigo
			Time time = timeDao.procurar(1);
			
			//Exibir o nome do time
			System.out.println(time.getNome());

			//Exibir o nome do técnico
			System.out.println(time.getTecnico().getNome());
			
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
}//class