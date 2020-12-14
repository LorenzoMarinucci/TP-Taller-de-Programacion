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
import servicios.Domicilio;
import servicios.DomicilioCasa;

public class agregarServicioTest {

	private Sistema sistema;
	private String persona;
	private Domicilio domicilio = new DomicilioCasa("Paso", 2303);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() {
		EscenarioSistemaConFacturas escenario = new EscenarioSistemaConFacturas();
		sistema = escenario.getSistema();
		persona = escenario.getPersona().getNombre();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown () {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void testAgregarServicio(){
		sistema.agregarServicio(persona, "INTERNET100", 4, 2, 10, domicilio);
		Assert.assertEquals("", outContent.toString());
	}
	
	@Test
	public void testServicioInvalido() {
		sistema.agregarServicio(persona, "", 4, 2, 10, domicilio);
		Assert.assertEquals("No se ingreso un servicio de internet" + System.getProperty("line.separator"), outContent.toString());
	}
	
	@Test
	public void testDomicilioInvalido() {
		sistema.agregarServicio(persona, "INTERNET100", 4, 2, 10, null);
		Assert.assertEquals("No se ingreso un domicilio" + System.getProperty("line.separator"), outContent.toString());
	}
	
	@Test
	public void testInternetInvalido() {
		sistema.agregarServicio(persona, "INTERNET1000", 4, 2, 10, domicilio);
		Assert.assertEquals("El servicio de internet ingresado no existe" + System.getProperty("line.separator"), outContent.toString());
	}
	
}
