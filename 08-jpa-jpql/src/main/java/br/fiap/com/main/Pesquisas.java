package br.fiap.com.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDao;
import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.ReservaDao;
import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.CidadeDaoImpl;
import br.com.fiap.dao.impl.ClienteDaoImpl;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.dao.impl.ReservaDaoImpl;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisas {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Criar o PacoteDao
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		TransporteDao transporteDao = new TransporteDaoImpl(em);
		
		List<Transporte> transportes = transporteDao.listar();
		
		Transporte transporte = transportes.get(0);
		
		//Chamar o método de listar
		Double clientes = pacoteDao.precoPorTransporte(transporte);
		
		//Exibir a descrição dos pacotes
	
			System.out.println("soma dos pacotes do transporte "+ transporte.getEmpresa() + " = " + clientes);
		 
		
	}//class
}//main