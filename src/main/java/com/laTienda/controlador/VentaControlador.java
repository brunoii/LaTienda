package com.laTienda.controlador;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laTienda.dominio.*;
import com.laTienda.repo.*;

@Controller
@RequestMapping("/venta")
public class VentaControlador {	
	Venta venta;	
	
	@Autowired
	private IProducto repoProducto;
	@Autowired
	private IVenta repoVenta;
	@Autowired
	private ICliente repoCliente;
	@Autowired
	private ILineaDeVenta repoLineaDeVenta;
	@Autowired
	private IPuntoDeVenta repoPuntoDeVenta;
	
	
	//metodo para crear una nueva venta
	@RequestMapping("/cargarVenta")
	public String crearVenta(Model model) {
		venta = new Venta();	
		model.addAttribute("productos", repoProducto.findAll());
		model.addAttribute("clientes", repoCliente.findAll());
		model.addAttribute("venta", venta);
		return "CrearVenta";
	}	
	//metodo para agregar producto 
	@RequestMapping("/agregarProducto")
	public String agregarProducto(@RequestParam(value="idProducto") int idProducto,
								  @RequestParam (value= "idVenta") int idVenta,
								  Model model) {		
		venta.setIdVentas(idVenta);		
		for (Producto p : repoProducto.findAll()) {
			if(idProducto == p.getIdProductos()) {				
				LineaDeVenta ldv = venta.agregarProducto(p);
				venta.agregarLineaDeVenta(ldv);
				break;
			}			
		}		
		model.addAttribute("productos", repoProducto.findAll());
		model.addAttribute("clientes", repoCliente.findAll());
		model.addAttribute("venta", venta);
		return "CrearVenta";
	}
	//metodo para quitar producto 
	@RequestMapping("/quitarProducto")
	public String quitarProducto(@RequestParam(value="idLineaDeVenta") int idLineaDeVenta,
			                     @RequestParam (value= "idVenta") int idVenta,
			                     Model model) {		
		for (LineaDeVenta lineaDeVenta : venta.getLineasDeVenta()) {
			if(idLineaDeVenta == lineaDeVenta.getIdLineaDeVenta()) {				
				venta.eliminarProducto(lineaDeVenta);
				break;
			}			
		}		
		model.addAttribute("productos", repoProducto.findAll());
		model.addAttribute("clientes", repoCliente.findAll());
		model.addAttribute("venta", venta);
		return "CrearVenta";
	}
	//metodo para agregar el cliente 
	@RequestMapping("/agregarCliente")
	public String agregarCliente(@RequestParam (value= "idCliente") int idCliente,
			                     Model model) {				
		for (Cliente c : repoCliente.findAll()) {
			if(idCliente == c.getIdCliente()) {				
				venta.setCliente(c);
				break;
			}			
		}		
		model.addAttribute("productos", repoProducto.findAll());
		model.addAttribute("clientes", repoCliente.findAll());
		model.addAttribute("venta", venta);
		return "CrearVenta";
	}
	//metodo para quitar al cliente 
	@RequestMapping("/quitarCliente")
	public String quitarCliente(Model model) {		
				
		venta.setCliente(null);					
					
		model.addAttribute("productos", repoProducto.findAll());
		model.addAttribute("clientes", repoCliente.findAll());
		model.addAttribute("venta", venta);
		return "CrearVenta";
	}
	//metodo para finalizar venta
	@RequestMapping("/finalizarVenta")
	public String finalizarVenta(Model model) {		
		this.datosFinales();
		repoVenta.save(venta);
		for (LineaDeVenta lv : venta.getLineasDeVenta()) {
			lv.setVenta(venta);
			repoLineaDeVenta.save(lv);
		}			
		return "Principal";
	}
	//Cargar todos los datos finales de la venta
	public void datosFinales() {
		PuntoDeVenta pdv = null;
		List<PuntoDeVenta> puntosDeVentas = repoPuntoDeVenta.findAll();
		for (PuntoDeVenta puntoDeVenta : puntosDeVentas) {
			pdv = puntoDeVenta;
		}
		String fecha = String.valueOf(LocalDateTime.now());
		String f = fecha.substring(0,10);
		int numero = repoVenta.findAll().size() + 1;
		venta.setFecha(f);
		venta.setNumeroVenta(numero);
		venta.setTotal(venta.sumaTotal());
		venta.setPuntoDeVenta(pdv);
	}
	
}
