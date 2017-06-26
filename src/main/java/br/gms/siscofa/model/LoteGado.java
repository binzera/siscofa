package br.gms.siscofa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;



/**
 * The persistent class for the lote_gado database table.
 * 
 */
@Entity
@Table(name="lote_gado")
@NamedQuery(name="LoteGado.findAll", query="SELECT l FROM LoteGado l")
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
public class LoteGado extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOTE_GADO_ID_GENERATOR", sequenceName="LOTE_GADO_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="LOTE_GADO_ID_GENERATOR")
	private Integer id;

	@Column(name="qtd_arrobas")
	private Integer qtdArrobas;

	@Column(name="qtd_gado")
	private Integer qtdGado;

	private char sexo;

	@Column(name="valor_arroba")
	private float valorArroba;

	//bi-directional many-to-one association to Fazenda
	@ManyToOne
	private Fazenda fazenda;

	//bi-directional many-to-one association to Idade
	@ManyToOne
	private Idade idade;

	//bi-directional many-to-one association to RacaGado
	@ManyToOne
	@JoinColumn(name="raca_gado_id")
	private RacaGado racaGado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="loteGado", fetch=FetchType.LAZY)
	private List<MovimentacaoGado> movimentacaoGados;

	public LoteGado() {
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

	public Fazenda getFazenda() {
		return this.fazenda;
	}

	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

	public Idade getIdade() {
		return this.idade;
	}

	public void setIdade(Idade idade) {
		this.idade = idade;
	}

	public RacaGado getRacaGado() {
		return this.racaGado;
	}

	public void setRacaGado(RacaGado racaGado) {
		this.racaGado = racaGado;
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
		movimentacaoGado.setLoteGado(this);

		return movimentacaoGado;
	}

	public MovimentacaoGado removeMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().remove(movimentacaoGado);
		movimentacaoGado.setLoteGado(null);

		return movimentacaoGado;
	}

}