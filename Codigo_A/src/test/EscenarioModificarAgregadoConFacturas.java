package test;

import modelo.Sistema;
import personas.Fisica;
import personas.Persona;
import servicios.DomicilioCasa;

public class EscenarioModificarAgregadoConFacturas {

	Sistema sistema;
	
	public EscenarioModificarAgregadoConFacturas() {
		
		this.sistema = Sistema.getInstancia();
		
		Persona p = new Fisica("Juan Pérez",12123123);
		this.sistema.agregarFacturas( p );
		this.sistema.agregarServicio( "Juan Pérez" , "INTERNET100", 1, 1, 1, new DomicilioCasa("Juan B Justo", 4000));
		
		Persona p2 = new Fisica("Juan Carlos",12122313);
		this.sistema.agregarFacturas( p2 );
		this.sistema.agregarServicio( "Juan Carlos" , "INTERNET500", 0, 0, 0, new DomicilioCasa("Formosa", 4000));
	}
	
	public Sistema getSistema() {
		return Sistema.getInstancia();
	}
}
