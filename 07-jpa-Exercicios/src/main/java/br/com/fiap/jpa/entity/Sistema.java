package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema",sequenceName = "SQ_TAB_ITEM_TESTE", allocationSize = 1)
public class Sistema {

	@Id
	@Column(name = "cod_sistema")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemTeste")
	private Integer id;

	@Column(name = "nom_sistema")
	private String nome;

	public Sistema() {
	}

	public Sistema(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
