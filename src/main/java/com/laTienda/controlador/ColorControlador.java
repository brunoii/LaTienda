package com.laTienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laTienda.dominio.*;
import com.laTienda.repo.*;

@Controller
@RequestMapping("/color")
public class ColorControlador {
	
	@Autowired
	private IColor repoColor;
	
	//metodo para crear un nuevo color
	@RequestMapping("/cargarColor")
	public String crearColor(Model model) {
		model.addAttribute("color", new Color());
		return "CrearColor";
	}	
	
	//metodo para agregar un nuevo color
	@RequestMapping("/agregarColor")
	public String agregarColor(@Validated Color color) {			
		repoColor.save(color);
		return "Principal";
	     	
	}	
}
