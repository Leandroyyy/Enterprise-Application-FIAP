package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GaragemDao;
import br.com.fiap.jpa.dao.impl.GaragemDaoImpl;
import br.com.fiap.jpa.entity.Garagem;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	public static Integer id = 11;
	
	public static void main(String[] args) {
		//Obter uma fabrica de entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Obter o entity manager
		EntityManager entity = fabrica.createEntityManager();
		
		//Criar a GaragemDao
		GaragemDao garagemBanco = new GaragemDaoImpl(entity);
		
		//Instanciar a garagem
		Garagem garagem = new Garagem("to tenadodasd");

		//Cadastrar a garagem.. veiculo e etc.
		garagemBanco.cadastrar(garagem);
		
		try {
			//Pesquisar a Garagem
			Garagem buscar = garagemBanco.procurar(id);
			System.out.println(buscar.getNome());
		}catch(IdNotFoundException e) {
			System.out.println();
		}
	
		//Atualizar a garagem
		garagem.setNome("novo nome");
		garagemBanco.atualizar(garagem);
		
		
		try {
			//Remover a Garagem
			garagemBanco.apagar(id); 
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Commit
			garagemBanco.commit();
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
	
		fabrica.close();
	}
	
}