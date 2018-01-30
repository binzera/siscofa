package br.gms.siscofa.model.simplificado;
// Generated 29/06/2017 17:32:00 by Hibernate Tools 4.3.4.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fazenda generated by hbm2java
 */
@Entity
@Table(name = "fazenda", catalog = "siscofa")
public class Fazenda implements java.io.Serializable {

	private Integer id;
	private Usuario usuario;
	private Date created;
	private Date updated;
	private String nome;
	private Integer qtdAlqueires;

	public Fazenda() {
	}

	public Fazenda(Date created, Date updated) {
		this.created = created;
		this.updated = updated;
	}

	public Fazenda(Usuario usuario, Date created, Date updated, String nome, Integer qtdAlqueires) {
		this.usuario = usuario;
		this.created = created;
		this.updated = updated;
		this.nome = nome;
		this.qtdAlqueires = qtdAlqueires;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false, length = 19)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "qtd_alqueires")
	public Integer getQtdAlqueires() {
		return this.qtdAlqueires;
	}

	public void setQtdAlqueires(Integer qtdAlqueires) {
		this.qtdAlqueires = qtdAlqueires;
	}

}
