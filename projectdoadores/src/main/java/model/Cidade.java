package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer ibge;

	@Id
	private Long id;

	private String nome;

	// bi-directional many-to-one association to Estado
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uf")
	private Estado estado;

	@OneToMany(mappedBy = "estado")
	private List<Hemocentro> hemocentros;

	public Cidade() {
	}

	public Integer getIbge() {
		return this.ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Hemocentro> getHemocentros() {
		return hemocentros;
	}

	public void setHemocentros(List<Hemocentro> hemocentros) {
		this.hemocentros = hemocentros;
	}
}