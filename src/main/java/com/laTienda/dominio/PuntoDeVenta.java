package com.laTienda.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "puntoDeVenta")
public class PuntoDeVenta {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPuntoDeVenta;		
	@Column(name = "Numero", length = 11)
    private int numero;
	
	@OneToMany(mappedBy = "puntoDeVenta", orphanRemoval = true)	
	private List<Sesion> sesiones;	
	
	@OneToMany(mappedBy = "puntoDeVenta", orphanRemoval = true)	
	private List<Venta> ventas;	
	
	@ManyToOne
	@JoinColumn(name = "IdSucursal")
	private Sucursal sucursal;
	
	public int getIdPuntoDeVenta() {
		return idPuntoDeVenta;
	}
	public void setIdPuntoDeVenta(int idPuntoDeVenta) {
		this.idPuntoDeVenta = idPuntoDeVenta;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<Sesion> getSesiones() {
		return sesiones;
	}
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public List<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	
	
	
	
}	
