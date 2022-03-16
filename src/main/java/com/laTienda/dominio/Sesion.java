package com.laTienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sesiones")
public class Sesion {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSesion;		
	@Column(name = "Fecha", length = 50)
    private String fecha;
	@Column(name = "Hora", length = 50)
	private String hora;
	
	@OneToOne
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "idPuntoDeVenta")
	private PuntoDeVenta puntoDeVenta;	
	
	public int getIdSesion() {
		return idSesion;
	}
	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}
	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	} 
	
	
}
