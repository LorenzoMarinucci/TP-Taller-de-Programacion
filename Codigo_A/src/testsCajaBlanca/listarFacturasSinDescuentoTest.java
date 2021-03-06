package testsCajaBlanca;

import modelo.Sistema;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personas.Persona;

public class listarFacturasSinDescuentoTest {

    private Sistema sistema;

    @Before
    public void setUp() {
        EscenarioListarFacturasSinDescuento escenario = new EscenarioListarFacturasSinDescuento();
        sistema = escenario.getSistema();
    }

    @Test
    public void TestSinDescuento() {
        String salida = sistema.listarFacturas();
        Assert.assertTrue(!salida.contains("PRECIO TOTAL SIN DESCUENTO:") && !salida.contains("PRECIO TOTAL CON DESCUENTO:") && salida.contains("PRECIO TOTAL:"));
    }

}
