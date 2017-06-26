package br.gms.siscofa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the tipo_movimentacao database table.
 * 
 */
@Entity
@Table(name="tipo_movimentacao")
@NamedQuery(name="TipoMovimentacao.findAll", query="SELECT t FROM TipoMovimentacao t")
public class TipoMovimentacao extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_MOVIMENTACAO_ID_GENERATOR", sequenceName="TIPO_MOVIMENTACAO_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TIPO_MOVIMENTACAO_ID_GENERATOR")
	private Integer id;

	private String descricao;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="tipoMovimentacao")
	private List<MovimentacaoGado> movimentacaoGados;

	public TipoMovimentacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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