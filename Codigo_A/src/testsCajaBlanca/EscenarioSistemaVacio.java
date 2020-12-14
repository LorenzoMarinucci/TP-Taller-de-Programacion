package testsCajaBlanca;

import modelo.Sistema;

public class EscenarioSistemaVacio {

	private Sistema sistema;

	public EscenarioSistemaVacio() {

		this.sistema = Sistema.getInstancia();
	}

	public Sistema getSistema() {
		return sistema;
	}

}
