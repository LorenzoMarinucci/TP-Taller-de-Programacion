package test;

import modelo.Sistema;
import personas.Fisica;
import personas.Persona;

public class EscenarioListarFacturasConFacturas {

	Sistema sistema;
	
	public EscenarioListarFacturasConFacturas() {
		
		this.sistema = Sistema.getInstancia();
		this.sistema.agregarFacturas( new Fisica("Matias", 41555555) ); //aca va una persona
		this.sistema.agregarFacturas( new Fisica("Juancito", 41777555) ); //aca va una persona
		
	}
	
	public Sistema getSistema() {
		return Sistema.getInstancia();
	}
}