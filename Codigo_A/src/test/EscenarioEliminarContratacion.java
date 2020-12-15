package test;

import modelo.Sistema;
import personas.Fisica;
import servicios.DomicilioCasa;

//este escenario tiene a "Juan Pérez" con 1 contratacion y a "Roberto Almeida" con 4 contrataciones
//La persona "María Suárez" no existe en el sistema
//para el escenario vacio reciclamos la clase EscenarioListarFacturasSinFacturas
public class EscenarioEliminarContratacion {

	Sistema sistema;

	public EscenarioEliminarContratacion() {

		this.sistema = Sistema.getInstancia();
		this.sistema.agregarFacturas(new Fisica("Juan Pérez", 41555555)); // aca va una persona
		this.sistema.agregarFacturas(new Fisica("Roberto Almeida", 41777555)); // aca va una persona
		// contrataciones
		this.sistema.agregarServicio("Juan Pérez", "INTERNET100", 1, 1, 1, new DomicilioCasa("Juan B Justo", 4000));

		this.sistema.agregarServicio("Roberto Almeida", "INTERNET500", 1, 2, 1, new DomicilioCasa("Formosa", 4000));
		this.sistema.agregarServicio("Roberto Almeida", "INTERNET100", 1, 2, 1, new DomicilioCasa("Mitre", 1000));
		this.sistema.agregarServicio("Roberto Almeida", "INTERNET500", 2, 2, 1, new DomicilioCasa("Formosa", 5000));
		this.sistema.agregarServicio("Roberto Almeida", "INTERNET100", 1, 2, 3, new DomicilioCasa("Alvarado", 2000));
	}

	public Sistema getSistema() {
		return Sistema.getInstancia();
	}

}
