package com.laTienda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrincipalControlador {
	
	@RequestMapping
	public String principal(Model model) {
		return "Principal";
	}
}
