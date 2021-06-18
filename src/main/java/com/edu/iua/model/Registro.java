package com.edu.iua.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="registro")
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Date fechaHora;
	
	@Column(columnDefinition="json")
	private String rawData;
	
	@Column
	private String identificador;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_categoria")
	private Categoria c;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_subcategoria")
	private SubCategoria sc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Categoria getC() {
		return c;
	}

	public void setC(Categoria c) {
		this.c = c;
	}

	public SubCategoria getSc() {
		return sc;
	}

	public void setSc(SubCategoria sc) {
		this.sc = sc;
	}
	
	
}
