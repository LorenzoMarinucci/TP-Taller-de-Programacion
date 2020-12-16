package testsCajaBlanca;

import mediospagos.PagoCheque;
import mediospagos.PagoEfectivo;
import modelo.Sistema;
import personas.Juridica;
import personas.Persona;
import servicios.Domicilio;
import servicios.DomicilioCasa;

public class EscenarioListarFacturasSinDescuento {

    private Sistema sistema;
    private Persona personaSinDesc = new Juridica("Marcos", 13432123);

    public EscenarioListarFacturasSinDescuento() {

        Sistema.getInstancia().setInstancia();
        this.sistema = Sistema.getInstancia();
        this.sistema.agregarFacturas(personaSinDesc);

        Domicilio domicilioSD = new DomicilioCasa("Guemes", 1212);

        sistema.agregarServicio(personaSinDesc.getNombre(), "INTERNET100", 2, 2, 2, domicilioSD);

        sistema.abonar(personaSinDesc.getNombre(), new PagoCheque());
    }

    public Sistema getSistema() {
        return sistema;
    }

}
