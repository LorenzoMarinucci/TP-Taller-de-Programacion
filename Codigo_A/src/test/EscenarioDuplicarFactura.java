package test;

import modelo.Sistema;
import personas.Fisica;
import personas.Juridica;
import servicios.DomicilioCasa;

public class EscenarioDuplicarFactura {

Sistema sistema;
	
		public EscenarioDuplicarFactura() {
		
		this.sistema = Sistema.getInstancia();
		this.sistema.agregarFacturas( new Fisica("Juan Pérez", 41555555) ); //aca va una persona
		this.sistema.agregarFacturas( new Juridica("Ezequiel Dominguez", 41777555) ); //aca va una persona
		
		//contrataciones
		this.sistema.agregarServicio( "Juan Pérez" , "INTERNET100", 1, 1, 1, new DomicilioCasa("Juan B Justo", 4000));
		
		this.sistema.agregarServicio( "Ezequiel Dominguez" , "INTERNET500", 1, 2, 1, new DomicilioCasa("Formosa", 4000));
		
	}
		
		
	public Sistema getSistema() {
		return Sistema.getInstancia();
	}
	
	
	
	
}
