package testsCajaBlanca;

import modelo.Sistema;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personas.Persona;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class listarFacturaTest {

    private Sistema sistema;
    private Persona personaConDesc;
    private Persona personaSinDesc;

    @Before
    public void setUp() {
        EscenarioListarFactura escenario = new EscenarioListarFactura();
        sistema = escenario.getSistema();
        personaConDesc = escenario.getPersonaConDesc();
        personaSinDesc = escenario.getPersonaSinDesc();
    }

    @Test
    public void TestSinDescuento(){
        String salida = sistema.listarFactura(personaSinDesc.getNombre());
        Assert.assertTrue(!salida.contains("PRECIO TOTAL SIN DESCUENTO:") && !salida.contains("PRECIO TOTAL CON DESCUENTO:") && salida.contains("PRECIO TOTAL:"));
    }

    @Test
    public void TestConDescuento() {
        String salida = sistema.listarFactura(personaConDesc.getNombre());
        Assert.assertTrue(salida.contains("PRECIO TOTAL SIN DESCUENTO:") && salida.contains("PRECIO TOTAL CON DESCUENTO:") && !salida.contains("PRECIO TOTAL:"));
    }

}
