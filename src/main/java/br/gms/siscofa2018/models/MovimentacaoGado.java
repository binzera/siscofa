package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the movimentacao_gado database table.
 * 
 */
@Entity
@Table(name="movimentacao_gado")
@NamedQuery(name="MovimentacaoGado.findAll", query="SELECT m FROM MovimentacaoGado m")
public class MovimentacaoGado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int excluido;

	private double peso;

	private int quantidade;

	private String sexo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	private double valor;

	//bi-directional many-to-one association to Fazenda
	@ManyToOne(fetch=FetchType.LAZY)
	private Fazenda fazenda;

	//bi-directional many-to-one association to IdadeGado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idade_gado_id")
	private IdadeGado idadeGado;

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

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getExcluido() {
		return this.excluido;
	}

	public void setExcluido(int excluido) {
		this.excluido = excluido;
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

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public IdadeGado getIdadeGado() {
		return this.idadeGado;
	}

	public void setIdadeGado(IdadeGado idadeGado) {
		this.idadeGado = idadeGado;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return this.tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}