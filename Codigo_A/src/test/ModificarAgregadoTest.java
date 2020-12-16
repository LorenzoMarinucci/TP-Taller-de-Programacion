package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModificarAgregadoTest {

	EscenarioModificarAgregadoConFacturas escenarioNoVacio;
	
	@Before
	public void setUp() throws Exception {
		this.escenarioNoVacio = new EscenarioModificarAgregadoConFacturas();
	}

	@After
	public void tearDown() throws Exception {
		this.escenarioNoVacio.getSistema().setInstancia();
	}

	@Test
	public void testCambiarInternet100() {
		
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Carlos", "Formosa 4000", "CAMBIAR", "INTERNET100");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Carlos");
		Assert.assertTrue("No se modifico a internet100", !cadena.contains("500"));
		Assert.assertTrue("No se modifico a internet100", cadena.contains("100"));
	}
	
	@Test
	public void testCambiarInternet500() {
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Pérez", "Juan B Justo 4000", "CAMBIAR", "INTERNET500");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Pérez");
		Assert.assertTrue("No se modifico a internet500", cadena.contains("500"));
		Assert.assertTrue("No se modifico a internet500", !cadena.contains("100"));
	}
	
	@Test
	public void testAgregarCelular() {
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Carlos", "Formosa 4000", "AGREGAR", "CELULAR");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Carlos");
		Assert.assertTrue("No se agrego el celular", cadena.contains("CELULAR"));
	}
	
	@Test
	public void testAgregarTelefonoFijo() {
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Carlos", "Formosa 4000", "AGREGAR", "TELEFONO FIJO");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Carlos");
		Assert.assertTrue("No se agrego el telefono fijo", cadena.contains("TELEFONO"));
	}
	
	@Test
	public void testAgregarTVCable() {
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Carlos", "Formosa 4000", "AGREGAR", "TVCABLE");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Carlos");
		Assert.assertTrue("No se agrego tv-cable", cadena.contains("TV"));
	}
	
	@Test
	public void testQuitarCelular() {
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Pérez", "Juan B Justo 4000", "QUITAR", "CELULAR");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Pérez");
		Assert.assertTrue("No se quito el celular", !cadena.contains("CELULAR"));
	}
	
	@Test
	public void testQuitarTelefonoFijo() {
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Pérez", "Juan B Justo 4000", "QUITAR", "TELEFONO FIJO");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Pérez");
		Assert.assertTrue("No se quito el celular", !cadena.contains("TELEFONO"));
	}
	
	@Test
	public void testQuitarTVCable() {
		this.escenarioNoVacio.getSistema().modificarAgregado("Juan Pérez", "Juan B Justo 4000", "QUITAR", "TVCABLE");
		
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Pérez");
		Assert.assertTrue("No se quito el celular", !cadena.contains("TVCABLE"));
	}
	

}
