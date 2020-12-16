package testsCajaBlanca;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({listarFacturaTest.class, listarFacturasVacioTest.class, listarFacturasConDescuentoTest.class,
        listarFacturasSinDescuentoTest.class, getInstanciaTest.class, eliminarContratacionConDatosTest.class,
        eliminarContratacionVacioTest.class, duplicarFacturaEscenarioConDatosTest.class, agregarServicioTest.class, agregarFacturasVacioTest.class,
        agregarFacturasConDatosTest.class, duplicarFacturaEscenarioVacio.class})
public class TestSuite {
}
