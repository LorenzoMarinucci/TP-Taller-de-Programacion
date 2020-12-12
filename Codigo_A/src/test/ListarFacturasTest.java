package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListarFacturasTest {
	EscenarioListarFacturasSinFacturas escenarioVacio;
	EscenarioListarFacturasConFacturas escenarioNoVacio;

	@Before
	public void setUp() throws Exception {
		this.escenarioVacio = new EscenarioListarFacturasSinFacturas();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCadenaVacia() {
		
		String cadena = this.escenarioVacio.getSistema().listarFacturas();
		
		Assert.assertTrue("La cadena debería ser vacia", cadena.equals(""));
		
		
	}
	
	public void testCadenaNoVacia() {
		
		String cadena = this.escenarioNoVacio.getSistema().listarFacturas();
		
		Assert.assertFalse("La cadena no debería ser vacia", cadena.equals(""));
		
		
	}

}
