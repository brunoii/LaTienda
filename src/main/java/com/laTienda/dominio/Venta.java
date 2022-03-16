package com.laTienda.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVentas;		
	@Column(name = "Numero", length = 11)
    private long numeroVenta;
	@Column(name = "Fecha", length = 50)
	private String fecha; 
	@Column(name = "Total", length = 50)
	private double total;	
	
	@OneToOne
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "IdPuntoDeVenta")
	private PuntoDeVenta puntoDeVenta;		
		
	@OneToMany(mappedBy = "venta", orphanRemoval = true)	
	private List<LineaDeVenta> lineasDeVenta;
	
	public int getIdVentas() {
		return idVentas;
	}
	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}
	public long getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(long numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}	
	public List<LineaDeVenta> getLineasDeVenta() {
		return lineasDeVenta;
	}
	public void setLineasDeVenta(List<LineaDeVenta> lineasDeVenta) {
		this.lineasDeVenta = lineasDeVenta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}
	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	}	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}		
	public void agregarLineaDeVenta(LineaDeVenta lineaDeVenta) {
		if(lineasDeVenta == null) {
			lineasDeVenta = new ArrayList<>();
			this.lineasDeVenta.add(lineaDeVenta);			
		}else {
			this.lineasDeVenta.add(lineaDeVenta);
		}			
	}		
	public LineaDeVenta agregarProducto(Producto p) {
		LineaDeVenta lineaDeVenta = new LineaDeVenta(1,p);		
		return lineaDeVenta;		
	}
	
	public double sumaTotal() {
		double suma = 0;
		if (!lineasDeVenta.isEmpty()) {
			for (LineaDeVenta lineaDeVenta : lineasDeVenta) {
				suma = suma + lineaDeVenta.getProducto().getPrecioFinal();
			}
		}		
		return suma;
	}
	public void eliminarProducto(LineaDeVenta lineaDeVenta) {		
		for (LineaDeVenta ldv : lineasDeVenta) {
			if(ldv.getIdLineaDeVenta() == lineaDeVenta.getIdLineaDeVenta()) {
				this.lineasDeVenta.remove(lineaDeVenta);
				break;
			}
		}			
	}
}
