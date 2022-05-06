package br.fiap.com.main;

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
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		//Chamar o método de listar
		//List<Pacote> pacotes = pacoteDao.listar();
		
		List<Cliente> clientes = clienteDao.buscarPorDias(10);
		
		//Exibir a descrição dos pacotes
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
		}
		
		
		
	}//class
}//main