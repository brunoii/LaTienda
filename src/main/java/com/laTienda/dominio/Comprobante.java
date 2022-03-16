package com.laTienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comprobantes")
public class Comprobante {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComprobante;		
	@Column(name = "Numero", length = 50)
    private long numero;
	
	@OneToOne
	private Venta venta;
	
	@OneToOne
	private TipoDeFactura tipoDeFactura;
	
	public int getIdComprobante() {
		return idComprobante;
	}
	public void setIdComprobante(int idComprobante) {
		this.idComprobante = idComprobante;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public TipoDeFactura getTipoDeFactura() {
		return tipoDeFactura;
	}
	public void setTipoDeFactura(TipoDeFactura tipoDeFactura) {
		this.tipoDeFactura = tipoDeFactura;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
