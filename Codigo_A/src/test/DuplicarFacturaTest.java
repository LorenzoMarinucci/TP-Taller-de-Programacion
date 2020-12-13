package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DuplicarFacturaTest {
	
	EscenarioListarFacturasSinFacturas escenarioVacio;
	EscenarioDuplicarFactura escenarioNoVacio;

	@Before
	public void setUp() throws Exception {
		
		escenarioVacio = new EscenarioListarFacturasSinFacturas();
		escenarioNoVacio = new EscenarioDuplicarFactura();
	}

	@After
	public void tearDown() throws Exception {
	}

	//Observaciones: el metodo deberia obligarnos a poner un try-catch y no lo hace
	
	// ----------------------------------- CLASES CORRECTAS -----------------------------------
	
	@Test
	public void testPersonaFisica() {
		
		this.escenarioNoVacio.getSistema().duplicarFactura("Juan Pérez");
		//duplica la factura y la "muestra" segun la precondicion, como lo comprobamos? es metodo void
		//lo unico que hace el metodo en definitiva es un system.out ...
		
	}
	
	@Test
	public void testPersonaJuridica() {
		
		this.escenarioNoVacio.getSistema().duplicarFactura("Ezequiel Dominguez");
		//segun el comentario del metodo duplicarFactura, deberia lanzarse una CloneNotSupportedException
		//pero en el javadoc no habla sobre lanzar nada, la excepcion se lanza pero se Catchea de forma interna, no la "lanza" hacia afuera del método..
		//simplemente si no se puede clonar muestra un mensaje de la imposibilidad de duplicar la factura
		
	}
	
	// ----------------------------------- CLASES INCORRECTAS ---------------------------------
	
	@Test
	public void testPersonaNull() {
		
		this.escenarioNoVacio.getSistema().duplicarFactura(null);
		//lo mismo que antes, es un system.out
		
	}
	
	@Test
	public void testPersonaInexistente() {
		
		this.escenarioNoVacio.getSistema().duplicarFactura("Matias Dominguez");
		//lo mismo que antes, es un system.out
		
	}
	
	
	
	
	
	
	
	
	

}
