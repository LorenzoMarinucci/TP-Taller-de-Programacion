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

	@Before
	public void setUp() {
		EscenarioSistemaVacio escenario = new EscenarioSistemaVacio();
		sistema = escenario.getSistema();
	}
	
	@Test
	public void testAgregarPersona(){
		Persona persona = new Fisica("Juancito", 41777555);
		sistema.agregarFacturas(persona);
		Assert.assertTrue(sistema.getListaFacturas().containsKey(persona.getNombre()));
	}
	
}
 