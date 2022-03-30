package br.com.fiap.jpa.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	public static void main(String[] args) {
		//Obter uma fabrica de entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Cadastrar a garagem.. veiculo e etc.
		
		fabrica.close();
	}
	
}
