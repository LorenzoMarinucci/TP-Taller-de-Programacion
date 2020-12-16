package test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mediospagos.PagoCheque;
import mediospagos.PagoEfectivo;
import mediospagos.PagoTarjeta;

public class AbonarTest {
	EscenarioAbonar escenario;
	
	@Before
	public void setUp() throws Exception {
		this.escenario = new EscenarioAbonar();
	}

	@After
	public void tearDown() throws Exception {
		this.escenario.getSistema().setInstancia();
	}

	@Test
	public void testAbonarPersonaFisicaExistenteCheque() {
		this.escenario.getSistema().abonar("Juan Pérez", new PagoCheque());
		Assert.assertTrue("No se abonó correctamente la persona Fisica con Cheque", this.escenario.getSistema().getListaFacturas().get("Juan Pérez").getTotalSinP()*1.1 == this.escenario.getSistema().getListaFacturas().get("Juan Pérez").getTotalConP());
	}
	
	@Test
	public void testAbonarPersonaFisicaExistenteTarjeta() {
		this.escenario.getSistema().abonar("Juan Pérez", new PagoTarjeta());
		Assert.assertTrue("No se abonó correctamente la persona Fisica con Tarjeta", this.escenario.getSistema().getListaFacturas().get("Juan Pérez").getTotalSinP()*1 == this.escenario.getSistema().getListaFacturas().get("Juan Pérez").getTotalConP());
	}
	
	@Test
	public void testAbonarPersonaFisicaExistenteEfectivo() {
		this.escenario.getSistema().abonar("Juan Pérez", new PagoEfectivo());
		Assert.assertTrue("No se abonó correctamente la persona Fisica con Efectivo", this.escenario.getSistema().getListaFacturas().get("Juan Pérez").getTotalSinP()*0.8 == this.escenario.getSistema().getListaFacturas().get("Juan Pérez").getTotalConP());
	}
	
	@Test
	public void testAbonarPersonaJuridicaExistenteCheque() {
		this.escenario.getSistema().abonar("Juan Carlos", new PagoCheque());
		Assert.assertTrue("No se abonó correctamente la persona Juridica con Cheque", this.escenario.getSistema().getListaFacturas().get("Juan Carlos").getTotalSinP()*1.15 == this.escenario.getSistema().getListaFacturas().get("Juan Carlos").getTotalConP());
	}
	
	@Test
	public void testAbonarPersonaJuridicaExistenteTarjeta() {
		this.escenario.getSistema().abonar("Juan Carlos", new PagoTarjeta());
		Assert.assertTrue("No se abonó correctamente la persona Juridica con Tarjeta", this.escenario.getSistema().getListaFacturas().get("Juan Carlos").getTotalSinP()*1.2 == this.escenario.getSistema().getListaFacturas().get("Juan Carlos").getTotalConP());
	}
	
	@Test
	public void testAbonarPersonaJuridicaExistenteEfectivo() {
		this.escenario.getSistema().abonar("Juan Carlos", new PagoEfectivo());
		Assert.assertTrue("No se abonó correctamente la persona Juridica con Efectivo", this.escenario.getSistema().getListaFacturas().get("Juan Carlos").getTotalSinP()*0.9 == this.escenario.getSistema().getListaFacturas().get("Juan Carlos").getTotalConP());
	}
	
	@Test
	public void testAbonarPersonaNoExistente() {
		this.escenario.getSistema().abonar("Matias Rodriguez", new PagoCheque());
	}
}
