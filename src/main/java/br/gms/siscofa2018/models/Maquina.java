package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the maquina database table.
 * 
 */
@Entity
@Table(name="maquina")
@NamedQuery(name="Maquina.findAll", query="SELECT m FROM Maquina m")
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	private double valor;

	//bi-directional many-to-one association to Fazenda
	@ManyToOne(fetch=FetchType.LAZY)
	private Fazenda fazenda;

	public Maquina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Fazenda getFazenda() {
		return this.fazenda;
	}

	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

}