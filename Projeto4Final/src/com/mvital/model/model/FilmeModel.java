package com.mvital.model.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "filme")
public class FilmeModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "filmeID")
	Integer codigo;

	@ManyToOne
	@JoinColumn(name = "GeneroID", referencedColumnName = "GeneroID")
	GeneroModel id;

	@Column(name = "DataLancamento", length = 50, nullable = true)
	Date dataLancamento;

	@Column(name = "Diretor", length = 55, nullable = false)
	String diretor;

	@Column(name = "AtoresID", length = 255, nullable = false)
	String atores;


//	@ManyToOne(mappedBy="filmeModel")
//	private List<GeneroModel> generoModel;
//	
//	@XmlTransient
//	public List<GeneroModel> getGeneros() {
//		return generoModel;
//	}
//	

	public FilmeModel() {

	}

	public FilmeModel(Integer codigo, String nome, String email, String fone) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public GeneroModel getId() {
		return id;
	}

	public void setId(GeneroModel id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmeModel other = (FilmeModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
