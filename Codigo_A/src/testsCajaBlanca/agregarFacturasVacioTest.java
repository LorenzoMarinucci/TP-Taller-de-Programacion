package testsCajaBlanca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Sistema;
import personas.Fisica;
import personas.Persona;

public class agregarFacturasVacioTest {
	
	Sistema sistema;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() {
		EscenarioSistemaVacio escenario = new EscenarioSistemaVacio();
		sistema = escenario.getSistema();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown () {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void testAgregarPersona(){
		Persona persona = new Fisica("Juancito", 41777555);
		sistema.agregarFacturas(persona);
		Assert.assertEquals("", outContent.toString());
	}
	
}
 