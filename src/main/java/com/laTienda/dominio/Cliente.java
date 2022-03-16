package com.laTienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;		
	@Column(name = "Cuit", length = 11)
    private long cuit;
	@Column(name = "Nombre", length = 50)
	private String nombre; 
	@Column(name = "Domicilio", length = 50)
	private String domicilio;
	
	@ManyToOne
	@JoinColumn(name = "IdCondicionTributaria")
	private CondicionTributaria condicionTributaria;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public CondicionTributaria getCondicionTributaria() {
		return condicionTributaria;
	}
	public void setCondicionTributaria(CondicionTributaria condicionTributaria) {
		this.condicionTributaria = condicionTributaria;
	}
	
		
	
}
