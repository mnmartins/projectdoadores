package model2;
// Generated 07/06/2020 20:37:23 by Hibernate Tools 5.4.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado implements java.io.Serializable {

	private long id;
	private String nome;
	private String uf;
	private Integer ibge;
	private Integer pais;
	private Set hemocentros = new HashSet(0);
	private Set cidades = new HashSet(0);
	private Set cidades_1 = new HashSet(0);

	public Estado() {
	}

	public Estado(long id) {
		this.id = id;
	}

	public Estado(long id, String nome, String uf, Integer ibge, Integer pais, Set hemocentros, Set cidades, Set cidades_1) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.ibge = ibge;
		this.pais = pais;
		this.hemocentros = hemocentros;
		this.cidades = cidades;
		this.cidades_1 = cidades_1;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getIbge() {
		return this.ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public Integer getPais() {
		return this.pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public Set getHemocentros() {
		return this.hemocentros;
	}

	public void setHemocentros(Set hemocentros) {
		this.hemocentros = hemocentros;
	}

	public Set getCidades() {
		return this.cidades;
	}

	public void setCidades(Set cidades) {
		this.cidades = cidades;
	}

	public Set getCidades_1() {
		return this.cidades_1;
	}

	public void setCidades_1(Set cidades_1) {
		this.cidades_1 = cidades_1;
	}

}
