package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_movimentacao database table.
 * 
 */
@Entity
@Table(name="tipo_movimentacao")
@NamedQuery(name="TipoMovimentacao.findAll", query="SELECT t FROM TipoMovimentacao t")
public class TipoMovimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="tipoMovimentacao")
	private List<MovimentacaoGado> movimentacaoGados;

	public TipoMovimentacao() {
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

	public List<MovimentacaoGado> getMovimentacaoGados() {
		return this.movimentacaoGados;
	}

	public void setMovimentacaoGados(List<MovimentacaoGado> movimentacaoGados) {
		this.movimentacaoGados = movimentacaoGados;
	}

	public MovimentacaoGado addMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().add(movimentacaoGado);
		movimentacaoGado.setTipoMovimentacao(this);

		return movimentacaoGado;
	}

	public MovimentacaoGado removeMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().remove(movimentacaoGado);
		movimentacaoGado.setTipoMovimentacao(null);

		return movimentacaoGado;
	}

}