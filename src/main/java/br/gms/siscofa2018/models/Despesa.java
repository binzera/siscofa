package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the despesa database table.
 * 
 */
@Entity
@Table(name="despesa")
@NamedQuery(name="Despesa.findAll", query="SELECT d FROM Despesa d")
public class Despesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private int excluido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	private double valor;

	//bi-directional many-to-one association to Fazenda
	@ManyToOne(fetch=FetchType.LAZY)
	private Fazenda fazenda;

	//bi-directional many-to-one association to TipoDespesa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_despesa_id")
	private TipoDespesa tipoDespesa;

	public Despesa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getExcluido() {
		return this.excluido;
	}

	public void setExcluido(int excluido) {
		this.excluido = excluido;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
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

	public TipoDespesa getTipoDespesa() {
		return this.tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

}