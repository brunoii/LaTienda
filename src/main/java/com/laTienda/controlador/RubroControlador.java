package com.laTienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laTienda.dominio.*;
import com.laTienda.repo.*;

@Controller
@RequestMapping("/rubro")
public class RubroControlador {	
	
	@Autowired
	private IRubro repoRubro;	
	
	//metodo para crear un nuevo rubro
	@RequestMapping("/cargarRubro")
	public String crearRubro(Model model) {
		model.addAttribute("rubro", new Rubro());
		return "CrearRubro";
	}	
	
	//metodo para agregar un nuevo rubro
	@RequestMapping("/agregarRubro")
	public String agregaRubro(@Validated Rubro rubro) {			
		repoRubro.save(rubro);
		return "Principal";
	     	
	}	
}
