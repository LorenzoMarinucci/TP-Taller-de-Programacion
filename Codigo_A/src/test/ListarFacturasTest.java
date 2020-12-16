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
		this.escenarioNoVacio = new EscenarioListarFacturasConFacturas();
	}

	@After
	public void tearDown() throws Exception {
		this.escenarioNoVacio.getSistema().setInstancia();
		this.escenarioVacio.getSistema().setInstancia();
	}
	
	//NO ACLARA COMO DEBE SER LA CADENA EN EL JAVADOC, POR LO QUE SOLO PODEMOS TESTEAR POR !=NULL
	
	@Test
	public void testEscenarioSinFacturas() {
		String cadena = this.escenarioVacio.getSistema().listarFacturas();
		Assert.assertTrue("La cadena no debería ser null", cadena != null);
	}
	
	@Test
	public void testEscenarioConFacturas() {
		String cadena = this.escenarioNoVacio.getSistema().listarFacturas();
		Assert.assertTrue("La cadena no debería ser null", cadena != null);
	}
}
