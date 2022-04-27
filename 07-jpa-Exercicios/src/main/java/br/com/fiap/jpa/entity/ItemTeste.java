package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ITEM_TESTE")
@SequenceGenerator(name="itemTeste",sequenceName = "SQ_TAB_ITEM_TESTE", allocationSize = 1)
public class ItemTeste {
	
	@Id
	@Column(name = "cod_item_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemTeste")
	private Integer id;
	
	@Column(name="des_item_teste")
	private String descricaoItem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_caso_teste")
	private CasoTeste casoTeste;

	@ManyToMany(mappedBy="itensTeste")
	private List<TabUsuario> usuarios;

	public ItemTeste(String descricaoItem, CasoTeste casoTeste) {
		this.descricaoItem = descricaoItem;
		this.casoTeste = casoTeste;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}
	
}
