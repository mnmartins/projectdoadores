package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Integer ibge;

	private String nome;

	private Integer pais;

	private String uf;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades;
	
	@OneToMany(mappedBy="cidade")
	private List<Hemocentro> hemocentros;

	public Estado() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIbge() {
		return this.ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPais() {
		return this.pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public void setHemocentros(List<Hemocentro> hemocentros) {
		this.hemocentros = hemocentros;
	}
	public List<Hemocentro> getHemocentros() {
		return hemocentros;
	}
	
	public Cidade addCidade(Cidade cidade) {
		getCidades().add(cidade);
		cidade.setEstado(this);

		return cidade;
	}

	public Cidade removeCidade(Cidade cidade) {
		getCidades().remove(cidade);
		cidade.setEstado(null);

		return cidade;
	}

}