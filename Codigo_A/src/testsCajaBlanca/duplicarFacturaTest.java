package testsCajaBlanca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
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
	public void TestClonarFisica() {
		sistema.duplicarFactura(fisica.getNombre());
		String salida = outContent.toString();
		Assert.assertTrue(salida.contains("FACTURA DUPLICADA:") && !salida.contains("Error al clonar, la persona es juridica"));
	}

	@Test
	public void TestClonarJuridica() {
		sistema.duplicarFactura(juridica.getNombre());
		Assert.assertEquals("Error al clonar, la persona es juridica" + System.getProperty("line.separator"), outContent.toString());
	}

}
