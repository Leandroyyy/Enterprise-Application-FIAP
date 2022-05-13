package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public interface ClienteDao extends GenericDao<Cliente,Integer>{

	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorDias(Integer reserva);
	
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	Long totalClientesPorEstado(String estado);
}
