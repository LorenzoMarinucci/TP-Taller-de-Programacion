package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DuplicarFacturaTest {
	
	EscenarioListarFacturasSinFacturas escenarioVacio;
	EscenarioDuplicarFactura escenarioNoVacio;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() throws Exception {
		
		escenarioVacio = new EscenarioListarFacturasSinFacturas();
		escenarioNoVacio = new EscenarioDuplicarFactura();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		this.escenarioNoVacio.getSistema().setInstancia();
		this.escenarioVacio.getSistema().setInstancia();
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	//Assert.assertEquals("Persona ya existente" + System.getProperty("line.separator"), outContent.toString());

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
