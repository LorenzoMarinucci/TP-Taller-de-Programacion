package testsCajaBlanca;

import modelo.Sistema;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class listarFacturasVacioTest {

    Sistema sistema;

    @Before
    public void setUp() {
        EscenarioSistemaVacio escenario = new EscenarioSistemaVacio();
        sistema = escenario.getSistema();
    }

    @Test
    public void testListarFacturasVacio(){
        Assert.assertTrue("FACTURAS:\n".equals(sistema.listarFacturas()));
    }

}
