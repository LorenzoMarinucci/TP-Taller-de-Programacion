package testsCajaBlanca;

import mediospagos.PagoCheque;
import mediospagos.PagoEfectivo;
import modelo.Sistema;
import personas.Fisica;
import personas.Juridica;
import personas.Persona;
import servicios.Domicilio;
import servicios.DomicilioCasa;

public class EscenarioListarFactura {

    private Sistema sistema;
    private Persona personaConDesc = new Fisica("Matias", 41555555);
    private Persona personaSinDesc = new Juridica("Marcos", 13432123);

    public EscenarioListarFactura() {

        this.sistema = Sistema.getInstancia();
        this.sistema.agregarFacturas(personaConDesc);
        this.sistema.agregarFacturas(personaSinDesc);

        Domicilio domicilioCD = new DomicilioCasa("Juan B Justo", 2320);
        Domicilio domicilioSD = new DomicilioCasa("Guemes", 1212);

        sistema.agregarServicio(personaConDesc.getNombre(), "INTERNET100", 2, 2, 2, domicilioCD);
        sistema.agregarServicio(personaConDesc.getNombre(), "INTERNET100", 2, 2, 2, domicilioSD);

        sistema.abonar(personaConDesc.getNombre(), new PagoEfectivo());
        sistema.abonar(personaSinDesc.getNombre(), new PagoCheque());
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Persona getPersonaConDesc() {
        return personaConDesc;
    }

    public Persona getPersonaSinDesc() {
        return personaSinDesc;
    }

}
