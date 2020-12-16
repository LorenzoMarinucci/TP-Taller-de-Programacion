package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interfaces.I_Contratable;

public class EliminarContratacionTest {
	EscenarioEliminarContratacion escenarioNoVacio;

	@Before
	public void setUp() throws Exception {
		escenarioNoVacio = new EscenarioEliminarContratacion();
	}

	@After
	public void tearDown() throws Exception {
		this.escenarioNoVacio.getSistema().setInstancia();
	}
	
	// -------------------------------- CLASES CORRECTAS ---------------------------------

	@Test
	public void testEliminarContratacionConUnaContratacion() { // deberia eliminarse la factura

		this.escenarioNoVacio.getSistema().eliminarContratacion("Juan Pérez", "Juan B Justo 4000");
		
		Assert.assertTrue("Se debería eliminar la factura", !this.escenarioNoVacio.getSistema().getListaFacturas().containsKey("Juan Pérez"));
	}

	@Test
	public void testEliminarContratacionConCuatroContrataciones() { // deberia eliminar la factura
		this.escenarioNoVacio.getSistema().eliminarContratacion("Roberto Almeida", "Formosa 5000");
		
		Iterator<I_Contratable> it = this.escenarioNoVacio.getSistema().getListaFacturas().get("Roberto Almeida").getListaContrataciones().iterator();
		while(it.hasNext()) {
			I_Contratable c = it.next();
			if(c.getDomicilio().getDireccion().equals("Formosa 5000")) {
				Assert.fail("No deberia contener el domicio Formosa 5000");
			}
		}
	}

	// ------------------------------- CLASES INCORRECTAS -------------------------------

	@Test
	public void testEliminarContratacionPersonaVaciaEscenarioNoVacio() {
		this.escenarioNoVacio.getSistema().eliminarContratacion("", "Juan B Justo 4000");
	}

	@Test
	public void testEliminarContratacionDomicilioVacioEscenarioNoVacio() {
		this.escenarioNoVacio.getSistema().eliminarContratacion("Juan Perez", "");
	}

	@Test
	public void testEliminarContratacionPersonaNoExisteEscenarioNoVacio() {
		this.escenarioNoVacio.getSistema().eliminarContratacion("María Suárez", "Salta 1234");
	}

}
