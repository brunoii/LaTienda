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
@Table(name = "talles")
public class Talle {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTalle;		
	@Column(name = "Descripcion", length = 50)
    private String descripcion;
	
	@OneToMany(mappedBy = "talle", orphanRemoval = true)	
	private List<Producto> productos;
	
	public int getIdTalle() {
		return idTalle;
	}
	public void setIdTalle(int idTalle) {
		this.idTalle = idTalle;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
