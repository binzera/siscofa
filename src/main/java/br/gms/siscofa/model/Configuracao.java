package br.gms.siscofa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the configuracao database table.
 * 
 */
@Entity
@NamedQuery(name="Configuracao.findAll", query="SELECT c FROM Configuracao c")
public class Configuracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONFIGURACAO_ID_GENERATOR", sequenceName="HIBERNATE_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CONFIGURACAO_ID_GENERATOR")
	private Integer id;

	@Column(name="dt_ultima_sincronizacao")
	private Timestamp dtUltimaSincronizacao;

	@Column(name="id_app")
	private Integer idApp;

	private Integer usuario;

	public Configuracao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDtUltimaSincronizacao() {
		return this.dtUltimaSincronizacao;
	}

	public void setDtUltimaSincronizacao(Timestamp dtUltimaSincronizacao) {
		this.dtUltimaSincronizacao = dtUltimaSincronizacao;
	}

	public Integer getIdApp() {
		return this.idApp;
	}

	public void setIdApp(Integer idApp) {
		this.idApp = idApp;
	}

	public Integer getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

}