package testsCajaBlanca;

import modelo.Sistema;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personas.Persona;

public class listarFacturasConDescuentoTest {

    private Sistema sistema;

    @Before
    public void setUp() {
        EscenarioListarFacturasConDescuento escenario = new EscenarioListarFacturasConDescuento();
        sistema = escenario.getSistema();
    }

    @Test
    public void TestConDescuento() {
        String salida = sistema.listarFacturas();
        Assert.assertTrue(salida.contains("PRECIO TOTAL SIN DESCUENTO:") && salida.contains("PRECIO TOTAL CON DESCUENTO:") && !salida.contains("PRECIO TOTAL:"));
    }
}
