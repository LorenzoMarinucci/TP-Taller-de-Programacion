package testsCajaBlanca;

import modelo.Sistema;
import personas.Fisica;
import personas.Juridica;
import personas.Persona;

public class EscenarioSistemaConFacturas {

	private Sistema sistema;
	private Persona persona = new Fisica("Matias", 41555555);
	private Persona juridica = new Juridica("Marcos", 13432123);
	
	public EscenarioSistemaConFacturas() {
		
		this.sistema = Sistema.getInstancia();
		
		this.sistema.agregarFacturas(persona);
		this.sistema.agregarFacturas(new Fisica("Pablo", 40777555));
		this.sistema.agregarFacturas(juridica);
		
	}
	
	public Sistema getSistema() {
		return sistema;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public Persona getJuridica() {
		return juridica;
	}
}
