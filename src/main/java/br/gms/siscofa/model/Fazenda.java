package br.gms.siscofa.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fazenda database table.
 * 
 */
@Entity
@NamedQuery(name="Fazenda.findAll", query="SELECT f FROM Fazenda f")
public class Fazenda extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	@Column(name="qtd_alqueires")
	private int qtdAlqueires;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private Usuario usuario;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="fazenda")
	@JsonManagedReference
	private List<MovimentacaoGado> movimentacaoGados;

	public Fazenda() {
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

	public int getQtdAlqueires() {
		return this.qtdAlqueires;
	}

	public void setQtdAlqueires(int qtdAlqueires) {
		this.qtdAlqueires = qtdAlqueires;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<MovimentacaoGado> getMovimentacaoGados() {
		return this.movimentacaoGados;
	}

	public void setMovimentacaoGados(List<MovimentacaoGado> movimentacaoGados) {
		this.movimentacaoGados = movimentacaoGados;
	}

	public MovimentacaoGado addMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().add(movimentacaoGado);
		movimentacaoGado.setFazenda(this);

		return movimentacaoGado;
	}

	public MovimentacaoGado removeMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().remove(movimentacaoGado);
		movimentacaoGado.setFazenda(null);

		return movimentacaoGado;
	}

}