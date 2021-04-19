package com.alumne.comptecorrent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CompteCorrentTest {

	@Test
	void testDiposita() {
		int resultatActual;
		int resultatEsperat;

		CompteCorrent miCuenta = new CompteCorrent(1000, "miClave");

		resultatActual = miCuenta.diposita(500);

		resultatEsperat = 1500;

		assertEquals(resultatEsperat, resultatActual, "Error en dipositar diners");
	}

	/**
	 * Intentem retirar mes diners dels diners disponbles al saldo i el metode
	 * hauria de retornar -1
	 */
	@Test
	void testRetiraNoSaldo() {
		int saldoInicial = 1000;
		int pasta = 1200;
		int resultatEsperat = -1;
		int resultatActual;

		CompteCorrent miCuenta = new CompteCorrent(saldoInicial, "miClave");

		resultatActual = miCuenta.retira(pasta, "miClave");

		assertEquals(resultatEsperat, resultatActual, "Error. no es detecta el problema del saldo");

	}

	@Test
	void testRetiraContrasenyaMal() {
		int saldoInicial = 1000;
		int pasta = 900;
		int resultatEsperat = -2;
		int resultatActual;
		String contrasenyaEsperada = "miClave";
		String contrasenyaActual = "miClavent";

		CompteCorrent miCuenta = new CompteCorrent(saldoInicial, contrasenyaEsperada);

		resultatActual = miCuenta.retira(pasta, contrasenyaActual);

		assertEquals(resultatActual, resultatEsperat, "Error. Contrasenya incorrecta");

	}

	@Test
	void testRetiraOK() {
		String contrasenya = "miClave";
		int pasta = 900;
		int resultatActual;
		int resultatEsperat;

		CompteCorrent miCuenta = new CompteCorrent(pasta, contrasenya);

		resultatActual = miCuenta.getSaldo(contrasenya);
		resultatEsperat = 900;

		assertEquals(resultatEsperat, resultatActual, "Error");
	}
}
