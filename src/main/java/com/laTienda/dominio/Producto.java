package com.laTienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@Column(name = "Id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProductos;	
	@Column(name = "Codigo", length = 50)
    private String codigo;
	@Column(name = "Nombre", length = 50)
    private String nombre;
	@Column(name = "Costo", length = 50)
    private double costo;
	@Column(name = "MargenDeGanancia", length = 50)
    private double margenDeGanancia;
	@Column(name = "Iva", length = 50)
	private double iva; 
	@Column(name = "PrecioFinal", length = 50)
	private double precioFinal;	
	
	@ManyToOne
	@JoinColumn(name = "IdColor")
	private Color color;		
	
	@ManyToOne
	@JoinColumn(name = "IdRubro")
	private Rubro rubro;
	
	@ManyToOne
	@JoinColumn(name = "IdTalle")
	private Talle talle;
	
	@ManyToOne
	@JoinColumn(name = "IdMarca")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "IdStock")
	private Stock stock;	
	
	public Producto() {
		
	}	
	public int getIdProductos() {
		return idProductos;
	}
	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	public Talle getTalle() {
		return talle;
	}
	public void setTalle(Talle talle) {
		this.talle = talle;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}	
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getMargenDeGanancia() {
		return margenDeGanancia;
	}
	public void setMargenDeGanancia(double margenDeGanancia) {
		this.margenDeGanancia = margenDeGanancia;
	}	
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public void calcularPrecioFinal() {
		this.precioFinal = iva + costo + costo * margenDeGanancia / 100;
	}
	public void calcularIva() {
		this.iva = (costo + costo * margenDeGanancia / 100) * 21 / 100;
	}
	
}
