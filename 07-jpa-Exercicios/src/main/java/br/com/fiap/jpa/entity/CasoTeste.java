package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CASO_TESTE")
@SequenceGenerator(name="casoTeste",sequenceName = "SQ_TAB_CASO_TESTE", allocationSize = 1)
public class CasoTeste {

	@Id
	@Column(name = "cd_caso_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "casoTeste")
	private Integer id;
	
	@Column(name="nom_caso_teste")
	private String nome;
	
	@Column(name="des_caso_teste")
	private String descricaoCaso;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_sistema")
	private Sistema sistema;

	public CasoTeste() {
	}

	public CasoTeste(String nome, String descricaoCaso, Sistema sistema) {
		this.nome = nome;
		this.descricaoCaso = descricaoCaso;
		this.sistema = sistema;
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

	public String getDescricaoCaso() {
		return descricaoCaso;
	}

	public void setDescricaoCaso(String descricaoCaso) {
		this.descricaoCaso = descricaoCaso;
	}
	
}
