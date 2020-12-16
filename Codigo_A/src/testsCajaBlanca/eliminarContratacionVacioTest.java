package testsCajaBlanca;

import modelo.Sistema;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personas.Fisica;
import personas.Persona;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class eliminarContratacionVacioTest {

    Sistema sistema;

    @Before
    public void setUp() {
        EscenarioSistemaVacio escenario = new EscenarioSistemaVacio();
        sistema = escenario.getSistema();
    }

    @Test
    public void testEliminarContratacion() {
        Persona persona = new Fisica("Juancito", 41777555);
        sistema.eliminarContratacion(persona.getNombre(), "Juan B Justo 1256");
    }
}