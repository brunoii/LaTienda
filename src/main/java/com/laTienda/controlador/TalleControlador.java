package com.laTienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laTienda.dominio.*;
import com.laTienda.repo.*;

@Controller
@RequestMapping("/talle")
public class TalleControlador {
	
	@Autowired
	private ITalle repoTalle;	
	
	//metodo para crear un nuevo talle
	@RequestMapping("/cargarTalle")
	public String crearTalle(Model model) {
		model.addAttribute("talle", new Talle());
		return "CrearTalle";
	}	
	
	//metodo para agregar una nueva marca
	@RequestMapping("/agregarTalle")
	public String agregarTalle(@Validated Talle talle) {			
		repoTalle.save(talle);
		return "Principal";
	     	
	}	
}
