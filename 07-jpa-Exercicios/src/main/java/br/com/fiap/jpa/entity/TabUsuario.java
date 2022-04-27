package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario",sequenceName = "SQ_TAB_USUARIO", allocationSize = 1)
public class TabUsuario {
	
	@Id
	@Column(name = "cod_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private Integer id;
	
	@Column(name = "nom_usuario")
	private String nome;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tab_item_teste_usuario", 
		joinColumns = @JoinColumn(name = "cod_usuario"),
		inverseJoinColumns = @JoinColumn(name = "cod_item_teste")
			)
	private List<ItemTeste> itensTeste;
	
	public TabUsuario() {
	}

	public TabUsuario(String nome) {
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
