package br.gms.siscofa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the raca_gado database table.
 * 
 */
@Entity
@Table(name="raca_gado")
@NamedQuery(name="RacaGado.findAll", query="SELECT r FROM RacaGado r")
public class RacaGado extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RACA_GADO_ID_GENERATOR", sequenceName="RACA_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="RACA_GADO_ID_GENERATOR")
	private Integer id;
	
	@Column(nullable=false, unique=true)
	private String nome;

	//bi-directional many-to-one association to LoteGado
	@JsonIgnore
	@OneToMany(mappedBy="racaGado")
	private List<LoteGado> loteGados;

	public RacaGado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LoteGado> getLoteGados() {
		return this.loteGados;
	}

	public void setLoteGados(List<LoteGado> loteGados) {
		this.loteGados = loteGados;
	}

	public LoteGado addLoteGado(LoteGado loteGado) {
		getLoteGados().add(loteGado);
		loteGado.setRacaGado(this);

		return loteGado;
	}

	public LoteGado removeLoteGado(LoteGado loteGado) {
		getLoteGados().remove(loteGado);
		loteGado.setRacaGado(null);

		return loteGado;
	}

}