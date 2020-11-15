package com.edu.iua.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idCliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8624349707200492059L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	
	@Column(length = 100)
	private String codigoExterno;
	
	@Column(length = 60,nullable = false)
	private String razonSocial;
	
	@Column(length = 100,nullable = false)
	private String contacto;
	
	@OneToMany(targetEntity=Orden.class, mappedBy="cliente", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Orden> ordenList;
	
	@Column(nullable = true)
	private Long numTelefono;
	
	public List<Orden> getOrdenList() {
		return ordenList;
	}

	
	
	
	
	
	public Cliente(Long idCliente, String codigoExterno, String razonSocial, String contacto, Long numTelefono) {
		super();
		this.idCliente = idCliente;
		this.codigoExterno = codigoExterno;
		this.razonSocial = razonSocial;
		this.contacto = contacto;
		this.numTelefono = numTelefono;
	}


	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

	public void setNumTelefono(Long numTelefono) {
		this.numTelefono = numTelefono;
	}


	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}



	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}
	
	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public Long getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(long numTelefono) {
		this.numTelefono = numTelefono;
	}

	public Cliente(Long idCliente, String razonSocial, String contacto, long numTelefono) {
		super();
		this.idCliente = idCliente;
		this.razonSocial = razonSocial;
		this.contacto = contacto;
		this.numTelefono = numTelefono;
	}

	public Cliente() {
		super();
	}






	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", codigoExterno=" + codigoExterno + ", razonSocial=" + razonSocial
				+ ", contacto=" + contacto + ", ordenList=" + ordenList + ", numTelefono=" + numTelefono + "]";
	}
	
	
	
}