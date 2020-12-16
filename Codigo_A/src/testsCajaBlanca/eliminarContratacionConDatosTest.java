package testsCajaBlanca;

import interfaces.I_Contratable;
import modelo.Sistema;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personas.Fisica;
import personas.Persona;
import servicios.Factura;

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
        Factura factura = sistema.getListaFacturas().get(persona2.getNombre());
        int contrataciones = factura.getListaContrataciones().size();
        int p = factura.buscaContratacion("Matheu 5487");
        I_Contratable contratacion = factura.getListaContrataciones().get(p);
        sistema.eliminarContratacion(persona2.getNombre(),"Matheu 5487");
        Assert.assertEquals(contrataciones-1,factura.getListaContrataciones().size());
        Assert.assertTrue(!factura.getListaContrataciones().contains(contratacion));
    }

    @Test
    public void testEliminaContratacionYFactura(){
        Factura factura = sistema.getListaFacturas().get(persona1.getNombre());
        sistema.eliminarContratacion(persona1.getNombre(),"Juan B Justo 4586");
        Assert.assertEquals(0,factura.getListaContrataciones().size());
        Assert.assertTrue(!sistema.getListaFacturas().containsKey(persona1.getNombre()));
    }

}