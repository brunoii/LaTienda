package com.laTienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laTienda.dominio.*;
import com.laTienda.repo.*;

@Controller
@RequestMapping("/producto")
public class ProductoControlador {
	
	@Autowired
	private IProducto repoProducto;
	@Autowired
	private ITalle repoTalle;
	@Autowired
	private IColor repoColor;
	@Autowired
	private IStock repoStock;
	@Autowired
	private IMarca repoMarca;
	@Autowired
	private IRubro repoRubro;
	
	//metodo para crear un nuevo producto
	@RequestMapping("/cargarProducto")
	public String crearProducto(Model model) {
		model.addAttribute("talles", repoTalle.findAll());
		model.addAttribute("marcas", repoMarca.findAll());
		model.addAttribute("rubros", repoRubro.findAll());
		model.addAttribute("colores", repoColor.findAll());
		model.addAttribute("producto", new Producto());
		return "CrearProducto";
	}	
	
	//metodo para agregar un nuevo producto
	@RequestMapping("/agregarProducto")
	public String agregarProducto(@Validated Producto producto, @RequestParam(value = "Cantidad", defaultValue = "1" ) int cantidad) {	
		Stock stock = new Stock(cantidad);	
		repoStock.save(stock);
		producto.setStock(stock);
		producto.calcularIva();
		producto.calcularPrecioFinal();
		repoProducto.save(producto);
		return "Principal";	     	
	}	
	
	//metodo para listar los productos
	@RequestMapping("/listarProductos")
	public String listarProductos(Model model) {		
		model.addAttribute("productos", repoProducto.findAll());
		return "ListarProductos";
	}
}
