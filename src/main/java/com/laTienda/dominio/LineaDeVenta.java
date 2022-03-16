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
@Table(name = "lineaDeVenta")
public class LineaDeVenta {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLineaDeVenta;			
	@Column(name = "Cantidad", length = 50)
	private long cantidad;
	
	@ManyToOne
	@JoinColumn(name = "IdVenta")
	private Venta venta;	
	
	@OneToOne
	private Producto producto;
	
	public LineaDeVenta() {
		
	}
	public LineaDeVenta(long cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}
	public int getIdLineaDeVenta() {
		return idLineaDeVenta;
	}
	public void setIdLineaDeVenta(int idLineaDeVenta) {
		this.idLineaDeVenta = idLineaDeVenta;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	} 
	
	
}
