package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_despesa database table.
 * 
 */
@Entity
@Table(name="tipo_despesa")
@NamedQuery(name="TipoDespesa.findAll", query="SELECT t FROM TipoDespesa t")
public class TipoDespesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Despesa
	@OneToMany(mappedBy="tipoDespesa")
	private List<Despesa> despesas;

	public TipoDespesa() {
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

	public List<Despesa> getDespesas() {
		return this.despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public Despesa addDespesa(Despesa despesa) {
		getDespesas().add(despesa);
		despesa.setTipoDespesa(this);

		return despesa;
	}

	public Despesa removeDespesa(Despesa despesa) {
		getDespesas().remove(despesa);
		despesa.setTipoDespesa(null);

		return despesa;
	}

}