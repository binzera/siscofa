package br.gms.siscofa2018.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Configuracao database table.
 * 
 */
@Entity
@NamedQuery(name="Configuracao.findAll", query="SELECT c FROM Configuracao c")
public class Configuracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_ultima_sincronizacao")
	private Date dtUltimaSincronizacao;

	@Column(name="id_app")
	private int idApp;

	private int usuario;

	public Configuracao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDtUltimaSincronizacao() {
		return this.dtUltimaSincronizacao;
	}

	public void setDtUltimaSincronizacao(Date dtUltimaSincronizacao) {
		this.dtUltimaSincronizacao = dtUltimaSincronizacao;
	}

	public int getIdApp() {
		return this.idApp;
	}

	public void setIdApp(int idApp) {
		this.idApp = idApp;
	}

	public int getUsuario() {
		return this.usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

}