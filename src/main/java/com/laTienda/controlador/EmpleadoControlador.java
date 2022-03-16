package com.laTienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laTienda.dominio.Empleado;
import com.laTienda.repo.IEmpleado;

@Controller
@RequestMapping("/empleado")
public class EmpleadoControlador {
	
	
	@Autowired
	private IEmpleado repoEmpleado;
	
	//metodo para crear un nuevo empleado
	@RequestMapping("/crearEmpleado")
	public String crearEmpleado(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "CrearEmpleado";
	}	
	
	//metodo para agregar un nuevo empleado
	@RequestMapping("/agregarEmpleado")
	public String agregarEmpleado(@Validated Empleado empleado) {	
		repoEmpleado.save(empleado);
		return "Principal";	    
	}
	
	//metodo para listar los empleados
	@RequestMapping("/listarEmpleados")
	public String listarEmpleados(Model model) {		
		model.addAttribute("empleados", repoEmpleado.findAll());
		return "ListarEmpleados";
	}
}
