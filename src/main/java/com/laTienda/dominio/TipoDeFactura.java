package com.laTienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoFacturas")
public class TipoDeFactura {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTipoFactura;	
	@Column(name = "Tipo", length = 50)
    private String tipo;
	@Column(name = "Descripcion", length = 50)
	private String descripcion;
	
	
	public int getIdTipoFactura() {
		return idTipoFactura;
	}
	public void setIdTipoFactura(int idTipoFactura) {
		this.idTipoFactura = idTipoFactura;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
	
	
	
}
