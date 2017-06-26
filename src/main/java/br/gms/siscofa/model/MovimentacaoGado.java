package br.gms.siscofa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;




/**
 * The persistent class for the movimentacao_gado database table.
 * 
 */
@Entity
@Table(name="movimentacao_gado")
@NamedQuery(name="MovimentacaoGado.findAll", query="SELECT m FROM MovimentacaoGado m")
public class MovimentacaoGado extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMENTACAO_GADO_ID_GENERATOR", sequenceName="MOVIMENTACAO_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="MOVIMENTACAO_GADO_ID_GENERATOR")
	private Integer id;

	@Column(name="qtd_arrobas")
	private Integer qtdArrobas;

	@Column(name="qtd_gado")
	private Integer qtdGado;

	private char sexo;

	@Column(name="valor_arroba")
	private float valorArroba;

	//bi-directional many-to-one association to LoteGado
	@ManyToOne
	@JoinColumn(name="lote_gado_id")
	private LoteGado loteGado;
	
	//bi-directional many-to-one association to Fazenda
	@ManyToOne
	@JoinColumn(name="fazenda_id")
	private Fazenda fazenda;

	//bi-directional many-to-one association to TipoMovimentacao
	@ManyToOne
	@JoinColumn(name="tipo_movimentacao_id")
	private TipoMovimentacao tipoMovimentacao;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public MovimentacaoGado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdArrobas() {
		return this.qtdArrobas;
	}

	public void setQtdArrobas(Integer qtdArrobas) {
		this.qtdArrobas = qtdArrobas;
	}

	public Integer getQtdGado() {
		return this.qtdGado;
	}

	public void setQtdGado(Integer qtdGado) {
		this.qtdGado = qtdGado;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public float getValorArroba() {
		return this.valorArroba;
	}

	public void setValorArroba(float valorArroba) {
		this.valorArroba = valorArroba;
	}

	public LoteGado getLoteGado() {
		return this.loteGado;
	}

	public void setLoteGado(LoteGado loteGado) {
		this.loteGado = loteGado;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return this.tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the fazenda
	 */
	public Fazenda getFazenda() {
		return fazenda;
	}

	/**
	 * @param fazenda the fazenda to set
	 */
	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

}