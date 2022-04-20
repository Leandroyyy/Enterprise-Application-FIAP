package br.com.fiap.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="TB_PATROCINIO")
@SequenceGenerator(name="pat", sequenceName = "SQ_TB_PATROCINIO", allocationSize = 1)
public class Patrocinio {

	@Id
	@Column(name="cd_patrocinio")
	@GeneratedValue(generator = "pat", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_marca", length = 100, nullable = false)
	private String nomeMarca;
	
	@Column(name="dt_fim_contrato")
	private LocalDate dataFimContrato;
	
	@ManyToMany(mappedBy = "patrocinio")
	private List<Time> times;
	
	public Patrocinio() {}

	public Patrocinio(String nomeMarca, LocalDate dataFimContrato) {
		this.nomeMarca = nomeMarca;
		this.dataFimContrato = dataFimContrato;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public LocalDate getDataFimContrato() {
		return dataFimContrato;
	}

	public void setDataFimContrato(LocalDate dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}
	
}
