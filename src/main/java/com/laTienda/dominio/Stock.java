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
@Table(name = "stock")
public class Stock {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idStock;		
	@Column(name = "Cantidad", length = 50)
    private long cantidad;
	
	@OneToMany(mappedBy = "stock", orphanRemoval = true)	
	private List<Producto> productos;
	
	public Stock() {
		
	}
	public Stock(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
