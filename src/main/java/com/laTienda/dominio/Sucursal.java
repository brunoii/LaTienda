package com.laTienda.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSucursal;		
	@Column(name = "Nombre", length = 50)
	private String nombre; 
	@Column(name = "Telefono", length = 50)
	private long telefono; 
	@Column(name = "Domicilio", length = 50)
	private String domicilio;
	
	@OneToMany(mappedBy = "sucursal", orphanRemoval = true)	
	private List<PuntoDeVenta> puntosDeVentas;	
	
	@OneToOne
	private Stock stock;
	
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public List<PuntoDeVenta> getPuntosDeVentas() {
		return puntosDeVentas;
	}
	public void setPuntosDeVentas(List<PuntoDeVenta> puntosDeVentas) {
		this.puntosDeVentas = puntosDeVentas;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
}
