package br.gms.siscofa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the idade database table.
 * 
 */
@Entity
@NamedQuery(name="Idade.findAll", query="SELECT i FROM Idade i")
public class Idade extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IDADE_ID_GENERATOR", sequenceName="IDADE_SEQUENCE", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IDADE_ID_GENERATOR")
	private Integer id;

	private String descricao;

	//bi-directional many-to-one association to LoteGado
	@JsonIgnore
	@OneToMany(mappedBy="idade", fetch=FetchType.LAZY)
	private List<LoteGado> loteGados;

	public Idade() {
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

	public List<LoteGado> getLoteGados() {
		return this.loteGados;
	}

	public void setLoteGados(List<LoteGado> loteGados) {
		this.loteGados = loteGados;
	}

	public LoteGado addLoteGado(LoteGado loteGado) {
		getLoteGados().add(loteGado);
		loteGado.setIdade(this);

		return loteGado;
	}

	public LoteGado removeLoteGado(LoteGado loteGado) {
		getLoteGados().remove(loteGado);
		loteGado.setIdade(null);

		return loteGado;
	}

}