package br.gms.siscofa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The persistent class for the movimentacao_gado database table.
 * 
 */
@Entity
@Table(name="movimentacao_gado")
@NamedQuery(name="MovimentacaoGado.findAll", query="SELECT m FROM MovimentacaoGado m")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class MovimentacaoGado extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//@Temporal(TemporalType.DATE)
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "dd/MM/yyyy"
	)
	private Date data;

	private int idade;

	private double peso;

	private int quantidade;

	private Character sexo;

	private double valor;

	//bi-directional many-to-one association to Fazenda
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private Fazenda fazenda;

	//bi-directional many-to-one association to TipoMovimentacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_movimentacao_id")
	private TipoMovimentacao tipoMovimentacao;

	public MovimentacaoGado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Character getSexo() {
		return this.sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
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

	public TipoMovimentacao getTipoMovimentacao() {
		return this.tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}