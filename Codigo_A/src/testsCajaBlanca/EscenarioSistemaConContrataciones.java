package testsCajaBlanca;

import modelo.Sistema;
import personas.Fisica;
import personas.Juridica;
import personas.Persona;
import servicios.DomicilioCasa;
import servicios.DomicilioDepto;

public class EscenarioSistemaConContrataciones {

    private Sistema sistema;
    private Persona persona1 = new Fisica("Matias", 41555555);
    private Persona persona2 = new Juridica("Marcos", 13432123);

    public EscenarioSistemaConContrataciones() {

        Sistema.getInstancia().setInstancia();
        this.sistema = Sistema.getInstancia();

        this.sistema.agregarFacturas(persona1);
        this.sistema.agregarFacturas(new Fisica("Pablo", 40777555));
        this.sistema.agregarFacturas(persona2);

        this.sistema.agregarServicio("Matias","INTERNET100",2,1,2,new DomicilioCasa("Juan B Justo",4586));
        this.sistema.agregarServicio("Marcos","INTERNET100",1,1,2,new DomicilioCasa("Laprida",3187));
        this.sistema.agregarServicio("Marcos","INTERNET500",1,1,2,new DomicilioCasa("Matheu",5487));

    }

    public Sistema getSistema() {
        return sistema;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public Persona getPersona2() {
        return persona2;
    }
}