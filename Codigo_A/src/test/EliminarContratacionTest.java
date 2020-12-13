package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EliminarContratacionTest {
	
	EscenarioListarFacturasSinFacturas escenarioVacio;
	EscenarioEliminarContratacion escenarioNoVacio;

	@Before
	public void setUp() throws Exception {
		
		escenarioVacio = new EscenarioListarFacturasSinFacturas();
		escenarioNoVacio = new EscenarioEliminarContratacion();
	}

	@After
	public void tearDown() throws Exception {
	}

	//-------------------------------- 	CLASES CORRECTAS ---------------------------------

	@Test
	public void testEliminarContratacionConUnaContratacion() { //deberia eliminarse la factura
		
		this.escenarioNoVacio.getSistema().eliminarContratacion("Juan Pérez", "Juan B Justo 4000");
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Juan Pérez");
		
		Assert.assertTrue("La cadena debería ser vacia", cadena.equals(""));
		
	}
	
	@Test
	public void testEliminarContratacionConCuatroContrataciones() { //no deberia eliminarse la factura, solo eliminar 1 contratacion y dejar 3
		
		this.escenarioNoVacio.getSistema().eliminarContratacion("Roberto Almeida", "Formosa 5000");
		String cadena = this.escenarioNoVacio.getSistema().listarFactura("Roberto Almeida");
		
		Assert.assertTrue("La cadena debería no tener el domicilio Formosa 5000, debio ser eliminado", cadena.contains("Formosa 5000") );
		
	}
	
	
	//------------------------------- 	CLASES INCORRECTAS -------------------------------
	
	//los metodos estan en el orden de la bateria de pruebas (de arriba hacia abajo)
	//primero los 3 casos con el escenario vacio y luego los 3 casos de escenario no vacio
	
	
	@Test
	public void testEliminarContratacionPersonaVaciaEscenarioVacio() {
		
		this.escenarioVacio.getSistema().eliminarContratacion("", "Juan B Justo 4000");
		//como debería evaluarse?
		
	}
	
	@Test
	public void testEliminarContratacionDomicilioVacioEscenarioVacio() {
		
		this.escenarioVacio.getSistema().eliminarContratacion("Juan Pérez", "");
		//como debería evaluarse?
		
	}
	
	@Test
	public void testEliminarContratacionPersonaNoExisteEscenarioVacio() {
		
		this.escenarioVacio.getSistema().eliminarContratacion("María Suárez", "Salta 1234");
		//como debería evaluarse?
		
	}
	
	@Test
	public void testEliminarContratacionPersonaVaciaEscenarioNoVacio() {
		
		this.escenarioNoVacio.getSistema().eliminarContratacion("", "Juan B Justo 4000");
		//como debería evaluarse?
		
	}
	
	@Test
	public void testEliminarContratacionDomicilioVacioEscenarioNoVacio() {
		
		this.escenarioNoVacio.getSistema().eliminarContratacion("Juan Pérez", "");
		//como debería evaluarse?
		
	}
	
	@Test
	public void testEliminarContratacionPersonaNoExisteEscenarioNoVacio() {
		
		this.escenarioNoVacio.getSistema().eliminarContratacion("María Suárez", "Salta 1234");
		//como debería evaluarse?
		
	}
	
	
	
	
	
	
	
	
	

}
