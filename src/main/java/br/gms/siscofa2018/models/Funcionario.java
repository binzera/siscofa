package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@Table(name="funcionario")
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	private float salario;

	//bi-directional many-to-one association to Fazenda
	@ManyToOne(fetch=FetchType.LAZY)
	private Fazenda fazenda;

	public Funcionario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return this.salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Fazenda getFazenda() {
		return this.fazenda;
	}

	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

}