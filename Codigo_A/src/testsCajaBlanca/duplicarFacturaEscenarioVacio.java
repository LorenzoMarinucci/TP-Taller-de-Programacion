package testsCajaBlanca;

import modelo.Sistema;
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;

public class duplicarFacturaEscenarioVacio {

    Sistema sistema;

    public void setUp() {
        EscenarioSistemaVacio escenario = new EscenarioSistemaVacio();
        sistema = escenario.getSistema();
    }

    @Test
    public void TestClonarPersonaNull() {
        try {
            sistema.duplicarFactura(null);
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void TestClonarPersonaNoExistente() {
        try {
            sistema.duplicarFactura("Pedro");
        }
        catch (Exception e) {
            Assert.fail();
        }
    }
}
