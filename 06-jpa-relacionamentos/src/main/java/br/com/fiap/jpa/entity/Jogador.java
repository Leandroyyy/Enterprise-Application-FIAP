package br.com.fiap.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_JOGADOR")
@SequenceGenerator(name="jogador", sequenceName = "SQ_TB_JOGADOR", allocationSize = 1)
public class Jogador {

	@Id
	@Column(name="cd_jogador")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogador")
	private Integer codigo;
	
	@Column(name="nm_jogador", nullable = false, length = 80)
	private String nome;
	
	@Column(name="nr_jogador")
	private Integer numero;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_posicao", length = 20)
	private Posicao posicao;
	
	@Column(name="vl_salario", precision = 10, scale = 2)
	private BigDecimal salario;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}
