package com.laTienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laTienda.dominio.*;
import com.laTienda.repo.*;

@Controller
@RequestMapping("/marca")
public class MarcaControlador {	
	
	@Autowired
	private IMarca repoMarca;	
	
	//metodo para crear una nueva marca
	@RequestMapping("/cargarMarca")
	public String crearMarca(Model model) {
		model.addAttribute("marca", new Marca());
		return "CrearMarca";
	}	
	
	//metodo para agregar una nueva marca
	@RequestMapping("/agregarMarca")
	public String agregarMarca(@Validated Marca marca) {			
		repoMarca.save(marca);
		return "Principal";
	     	
	}	
}
