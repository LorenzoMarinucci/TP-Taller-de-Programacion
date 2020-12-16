package test;

import modelo.Sistema;

public class EscenarioListarFacturasSinFacturas {

	Sistema sistema;
	
	public EscenarioListarFacturasSinFacturas() {
		this.sistema = Sistema.getInstancia();
	}
	
	public Sistema getSistema() {
		return Sistema.getInstancia();
	}
}
