package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public interface VeiculoDao {

	void cadastrar(Veiculo veiculo);
	
	Veiculo procurar(Integer id) throws IdNotFoundException;
	
	void atualizar(Veiculo veiculo);
	
	void apagar(Integer id) throws IdNotFoundException;
	
	void commit() throws CommitException;
	
}