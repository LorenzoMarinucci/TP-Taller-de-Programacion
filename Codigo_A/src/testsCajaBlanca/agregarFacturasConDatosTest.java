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

public class agregarFacturasConDatosTest {

	private Sistema sistema;
	private Persona persona;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() {
		EscenarioSistemaConFacturas escenario = new EscenarioSistemaConFacturas();
		sistema = escenario.getSistema();
		persona = escenario.getPersona();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown () {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void testAgregarNuevaPersona(){
		Persona nuevaPersona = new Fisica("Juancito", 41777555);
		sistema.agregarFacturas(nuevaPersona);
		Assert.assertEquals("", outContent.toString());
	}
	
	@Test
	public void testAgregarPersonaRepetida() {
		sistema.agregarFacturas(persona);
		Assert.assertEquals("Persona ya existente" + System.getProperty("line.separator"), outContent.toString());
	}
	
}
