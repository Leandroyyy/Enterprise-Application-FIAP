package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDao extends GenericDao<Pacote,Integer>{

	List<Pacote> listar();
	
	//Pesquisar pacotes por quantidade de dias entre dois valores
	List<Pacote> buscarPorQuantidadeDias(Integer inicio, Integer fim);
	
	List<Pacote> buscarPorTransporte(Transporte transporte);
}