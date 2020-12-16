package testsCajaBlanca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Sistema;

public class getInstanciaTest {
	
	
	@Test
	public void instanciaNoCreada() {
		Sistema sistema = Sistema.getInstancia();
		// si la creó exitosamente, no falla y el test pasa
	}
	
	@Test
	public void instanciaCreada() {
		Sistema.getInstancia().setInstancia();
		Sistema primeraInstancia = Sistema.getInstancia();
		Sistema segundaInstancia = Sistema.getInstancia();
		Assert.assertSame(primeraInstancia, segundaInstancia);
	}

}
