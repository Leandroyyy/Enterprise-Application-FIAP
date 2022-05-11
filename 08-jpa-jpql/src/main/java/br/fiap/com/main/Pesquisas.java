package br.fiap.com.main;

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
		PacoteDao pacotaDao = new PacoteDaoImpl(em);
		
		//Chamar o método de listar
		
		Calendar inicio = new GregorianCalendar(2023 ,Calendar.JANUARY, 23);
		Calendar fim = new GregorianCalendar(2025 ,Calendar.AUGUST, 25);
		List<Pacote> pacotes = pacotaDao.buscarPorDias(inicio, fim);
		
		//Exibir a descrição dos pacotes
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao());
		}
		
	}//class
}//main