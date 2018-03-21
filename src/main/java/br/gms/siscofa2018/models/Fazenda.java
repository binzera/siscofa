package br.gms.siscofa2018.models;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fazenda database table.
 * 
 */
@Entity
@Table(name="fazenda")
@NamedQuery(name="Fazenda.findAll", query="SELECT f FROM Fazenda f")
public class Fazenda extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int excluido;

	private String nome;

	@Column(name="qtd_alqueires")
	private int qtdAlqueires;

	@Column(name="total_gado_atual")
	private int totalGadoAtual;

	//bi-directional many-to-one association to Despesa
	@OneToMany(mappedBy="fazenda")
	private List<Despesa> despesas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="fazenda")
	private List<Funcionario> funcionarios;

	//bi-directional many-to-one association to Maquina
	@OneToMany(mappedBy="fazenda")
	private List<Maquina> maquinas;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="fazenda")
	private List<MovimentacaoGado> movimentacaoGados;

	public Fazenda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExcluido() {
		return this.excluido;
	}

	public void setExcluido(int excluido) {
		this.excluido = excluido;
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

	public int getTotalGadoAtual() {
		return this.totalGadoAtual;
	}

	public void setTotalGadoAtual(int totalGadoAtual) {
		this.totalGadoAtual = totalGadoAtual;
	}

	public List<Despesa> getDespesas() {
		return this.despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public Despesa addDespesa(Despesa despesa) {
		getDespesas().add(despesa);
		despesa.setFazenda(this);

		return despesa;
	}

	public Despesa removeDespesa(Despesa despesa) {
		getDespesas().remove(despesa);
		despesa.setFazenda(null);

		return despesa;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setFazenda(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setFazenda(null);

		return funcionario;
	}

	public List<Maquina> getMaquinas() {
		return this.maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public Maquina addMaquina(Maquina maquina) {
		getMaquinas().add(maquina);
		maquina.setFazenda(this);

		return maquina;
	}

	public Maquina removeMaquina(Maquina maquina) {
		getMaquinas().remove(maquina);
		maquina.setFazenda(null);

		return maquina;
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