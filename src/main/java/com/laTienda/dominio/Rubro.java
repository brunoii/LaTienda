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
@Table(name = "rubros")
public class Rubro 	{
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRubro;	
	@Column(name = "Nombre", length = 50)
	private String nombre;
	
	@OneToMany(mappedBy = "rubro", orphanRemoval = true)	
	private List<Producto> productos;
	
	public int getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(int idRubro) {
		this.idRubro = idRubro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	} 
	
	
}
