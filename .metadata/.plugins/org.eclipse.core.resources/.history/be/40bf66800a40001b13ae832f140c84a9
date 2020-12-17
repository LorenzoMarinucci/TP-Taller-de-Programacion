package testsCajaBlanca;

import interfaces.I_Contratable;
import modelo.Sistema;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personas.Fisica;
import personas.Persona;
import servicios.Factura;

import java.util.Iterator;

public class eliminarContratacionConDatosTest {

    private Sistema sistema;
    private Persona persona1,persona2;

    @Before
    public void setUp() {
        EscenarioSistemaConContrataciones escenario = new EscenarioSistemaConContrataciones();
        sistema = escenario.getSistema();
        persona1 = escenario.getPersona1();
        persona2 = escenario.getPersona2();
    }

    @Test
    public void testEliminarContratacionPersonaNoExistente(){
        Persona persona = new Fisica("Juancito", 41777555);
        sistema.eliminarContratacion(persona.getNombre(),"Juan B Justo 1256");
    }

    @Test
    public void testEliminaContratacion(){
        sistema.eliminarContratacion(persona2.getNombre(),"Laprida 3187");
        Iterator<I_Contratable> it = sistema.getListaFacturas().get(persona2.getNombre()).getListaContrataciones().iterator();
        while(it.hasNext()) {
            I_Contratable c = it.next();
            if(c.getDomicilio().getDireccion().equals("Laprida 3187")) {
                Assert.fail("No deberia contener el domicio Laprida 3187");
            }
        }
    }

    @Test
    public void testEliminaContratacionYFactura(){
        sistema.eliminarContratacion(persona2.getNombre(),"Laprida 3187");
        Iterator<I_Contratable> it = sistema.getListaFacturas().get(persona2.getNombre()).getListaContrataciones().iterator();
        while(it.hasNext()) {
            I_Contratable c = it.next();
            if(c.getDomicilio().getDireccion().equals("Laprida 3187")) {
                Assert.fail("No deberia contener el domicio Laprida 3187");
            }
        }
    }

}