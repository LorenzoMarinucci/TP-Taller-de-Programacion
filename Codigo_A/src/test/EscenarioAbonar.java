package test;

import modelo.Sistema;
import personas.Fisica;
import personas.Juridica;
import servicios.DomicilioCasa;

public class EscenarioAbonar {
	Sistema sistema;

	public EscenarioAbonar() {

		this.sistema = Sistema.getInstancia();
		this.sistema.agregarFacturas(new Fisica("Juan Pérez", 41555555)); // aca va una persona
		this.sistema.agregarFacturas(new Juridica("Juan Carlos", 41555555)); // aca va una persona

		// contrataciones
		this.sistema.agregarServicio("Juan Pérez", "INTERNET100", 1, 1, 1, new DomicilioCasa("Juan B Justo", 4000));
		this.sistema.agregarServicio("Juan Carlos", "INTERNET100", 1, 1, 1, new DomicilioCasa("Alvarado", 2000));
	}

	public Sistema getSistema() {
		return Sistema.getInstancia();
	}
}
