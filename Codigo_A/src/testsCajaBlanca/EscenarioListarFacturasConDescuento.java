package testsCajaBlanca;

import mediospagos.PagoCheque;
import mediospagos.PagoEfectivo;
import modelo.Sistema;
import personas.Fisica;
import personas.Persona;
import servicios.Domicilio;
import servicios.DomicilioCasa;

public class EscenarioListarFacturasConDescuento {

    private Sistema sistema;
    private Persona personaConDesc = new Fisica("Matias", 41555555);

    public EscenarioListarFacturasConDescuento() {

        Sistema.getInstancia().setInstancia();
        this.sistema = Sistema.getInstancia();
        this.sistema.agregarFacturas(personaConDesc);

        Domicilio domicilioCD = new DomicilioCasa("Juan B Justo", 2320);

        sistema.agregarServicio(personaConDesc.getNombre(), "INTERNET100", 2, 2, 2, domicilioCD);

        sistema.abonar(personaConDesc.getNombre(), new PagoEfectivo());
    }

    public Sistema getSistema() {
        return sistema;
    }

}
