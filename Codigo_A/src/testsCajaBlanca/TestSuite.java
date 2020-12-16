package testsCajaBlanca;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({listarFacturaTest.class, listarFacturasVacioTest.class, listarFacturasConDescuentoTest.class,
        listarFacturasSinDescuentoTest.class, getInstanciaTest.class, eliminarContratacionConDatosTest.class,
        eliminarContratacionVacioTest.class, duplicarFacturaTest.class, agregarServicioTest.class, agregarFacturasVacioTest.class,
        agregarFacturasConDatosTest.class})
public class TestSuite {
}
