package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="TB_GARAGEM")
@SequenceGenerator(name="garagem", sequenceName = "SQ_TB_GARAGEM", allocationSize=1)
public class Garagem {
	
	@Id
	@Column(name="cd_garagem")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garagem")
	private Integer id;
	
	@Column(name="nm_garagem", nullable=false)
	private String nome;
		
	
	public Garagem() {
		super();
	}

	public Garagem(String nome) {
		super();
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
