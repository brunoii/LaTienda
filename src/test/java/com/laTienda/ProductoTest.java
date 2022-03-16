package com.laTienda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.laTienda.dominio.Producto;

@SpringBootTest
class ProductoTest {
	
	@Test
	public void calcularIva() {		
		//Configuracion o datos
		Producto producto = new Producto();
		
		//Ejecucion
		producto.calcularIva();
		
		//Comprobacion
		assertEquals(126, producto.getIva());
		        
	}	

	
	@Test
	public void calcularPrecioFinalProducto() {		
		//Configuracion o datos
		Producto producto = new Producto();
		
		//Ejecucion
		producto.calcularIva();
		producto.calcularPrecioFinal();
		
		//Comprobacion
		assertEquals(726, producto.getPrecioFinal());
		        
	}	
	
}
