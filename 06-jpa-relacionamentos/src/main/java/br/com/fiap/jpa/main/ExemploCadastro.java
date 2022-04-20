package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TecnicoDao;
import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.dao.impl.TecnicoDaoImpl;
import br.com.fiap.jpa.dao.impl.TimeDaoImpl;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Patrocinio;
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
			
			//Cadastrar o time com o técnico
			Time time = new Time(tecnico, "Noroeste", "Alfredo de castilho");
			TimeDao timeDao = new TimeDaoImpl(em);
			
			//Adicionar dois jogadores no time
			Jogador ronaldo = new Jogador("Ronaldo", 9, Posicao.ATACANTE, new BigDecimal("1000"));
			Jogador marta = new Jogador("Marta", 10, Posicao.MEIA, new BigDecimal("1000"));
			
			time.addJogador(marta);
			time.addJogador(ronaldo);
			
			//Cadastrar dois patrocinios no time
			Patrocinio growth = new Patrocinio("Growth Suplementos", LocalDate.now());
			Patrocinio integralMedica = new Patrocinio("Integral Medica", LocalDate.now());
			
			List<Patrocinio> patrocinios = new ArrayList<Patrocinio>();			
			time.setPatrocinio(patrocinios);
			
			System.out.println(time.getPatrocinio());
			
			//Cadastra o time, tecnico e jogadores em cascata
			timeDao.cadastrar(time);
			timeDao.commit();
			
		}catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	}//main
}//class