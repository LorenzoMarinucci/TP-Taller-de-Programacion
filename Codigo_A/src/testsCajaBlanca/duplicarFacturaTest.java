package testsCajaBlanca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Sistema;
import personas.Persona;

public class duplicarFacturaTest {
	
	private Sistema sistema;
	private Persona fisica;
	private Persona juridica;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() {
		EscenarioSistemaConFacturas escenario = new EscenarioSistemaConFacturas();
		sistema = escenario.getSistema();
		fisica = escenario.getPersona();
		juridica = escenario.getJuridica();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown () {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void TestPersonaNula() {
		
	}

}
