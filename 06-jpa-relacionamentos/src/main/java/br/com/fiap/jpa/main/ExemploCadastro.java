package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TecnicoDao;
import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.dao.impl.TecnicoDaoImpl;
import br.com.fiap.jpa.dao.impl.TimeDaoImpl;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Posicao;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploCadastro {

	public static void main(String[] args) {
		//Cadastrar o técnico depois o time
		//Obter a factory e o entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		try {
			//Criar o objeto tecnico sem o código e time
			Tecnico tecnico = new Tecnico("Rogério", LocalDate.of(1980, 1, 15), 4);
			 
			//Criar o TecnicoDao
			TecnicoDao tecnicoDao = new TecnicoDaoImpl(em);
			 
			//Cadastrar.. 
			//tecnicoDao.cadastrar(tecnico);
			//tecnicoDao.commit();
			
			//Cadastrar o time com o técemco
			Time time = new Time(tecnico, "Noroeste", "Alfredo de castilho");
			TimeDao timeDao = new TimeDaoImpl(em);
			
			//Adicionar dois jogadores no time
			Jogador leandro = new Jogador("leandro", 1, Posicao.GOLEIRO, new BigDecimal(2000));
			Jogador lucas = new Jogador("lucas", 2, Posicao.ATACANTE, new BigDecimal(3000));
			
			time.addJogador(leandro);
			time.addJogador(lucas);
			
			timeDao.cadastrar(time);
			timeDao.commit();
			
		}catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	}//main
}//class