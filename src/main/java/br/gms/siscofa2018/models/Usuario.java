package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario extends AbstractTimestampEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String email;

	private String nome;

	private String senha;

	private String usuario;

	//bi-directional many-to-one association to Fazenda
	@OneToMany(mappedBy="usuario")
	private List<Fazenda> fazendas;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Fazenda> getFazendas() {
		return this.fazendas;
	}

	public void setFazendas(List<Fazenda> fazendas) {
		this.fazendas = fazendas;
	}

	public Fazenda addFazenda(Fazenda fazenda) {
		getFazendas().add(fazenda);
		fazenda.setUsuario(this);

		return fazenda;
	}

	public Fazenda removeFazenda(Fazenda fazenda) {
		getFazendas().remove(fazenda);
		fazenda.setUsuario(null);

		return fazenda;
	}

}