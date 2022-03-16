package com.laTienda.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "condicionTributaria")
public class CondicionTributaria {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCondicionTributaria;		
	@Column(name = "Descripcion", length = 50)
    private String descripcion;
	
	@OneToMany(mappedBy = "condicionTributaria", orphanRemoval = true)	
	private List<Cliente> clientes;
	
	public int getIdCondicionTributaria() {
		return idCondicionTributaria;
	}
	public void setIdCondicionTributaria(int idCondicionTributaria) {
		this.idCondicionTributaria = idCondicionTributaria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
