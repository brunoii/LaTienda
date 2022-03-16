package com.laTienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laTienda.dominio.Cliente;
import com.laTienda.repo.ICliente;
import com.laTienda.repo.ICondicionTributaria;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {
	
	@Autowired
	private ICliente repoCliente;
	@Autowired
	private ICondicionTributaria repoCondicionTributaria;
	
	//metodo para crear un nuevo cliente
	@RequestMapping("/crearCliente")
	public String crearCliente(Model model) {
		model.addAttribute("condicionTributaria", repoCondicionTributaria.findAll());
		model.addAttribute("cliente", new Cliente());
		return "CrearCliente";
	}	
	
	//metodo para agregar un nuevo cliente
	@RequestMapping("/agregarCliente")
	public String agregarCliente(@Validated Cliente cliente) {	
		repoCliente.save(cliente);
		return "Principal";	    
	}
	
	//metodo para listar los clientes
	@RequestMapping("/listarClientes")
	public String listarClientes(Model model) {		
		model.addAttribute("clientes", repoCliente.findAll());
		return "ListarClientes";
	}
}
