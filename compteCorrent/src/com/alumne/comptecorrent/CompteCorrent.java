package com.alumne.comptecorrent;

public class CompteCorrent {

	private int saldo;
	private String contrasenya;

	// Constructor
	public CompteCorrent(int saldoInicial, String cs) {
		this.saldo = saldoInicial;
		this.contrasenya = cs;
	}

	// Rebem els diners
	public int diposita(int pasta) {
		saldo += pasta;
		return saldo;
	}

	// Si la contrasenya és correcta i tenim prou diners, els restem del saldo i
	// retornem el valor de la pasta que hem retirat.
	// Si no tenim prou saldo, retornem un -1.
	// Si la contrasenya no és correcte, retornem un -2.
	public int retira(int pasta, String cs) {
		if (saldo < pasta) {
			return -1;
		}

		if (cs != contrasenya) {
			return -2;
		}

		saldo = saldo - pasta;

		return saldo;
	}

	// Retornem el saldo
	public int getSaldo(String cs) {

		if (this.contrasenya == cs) {
			return this.saldo;
		} else {
			return -2;
		}
	}

	// Modifiquem la contrasenya, retornem 0 si va bé i -2 si l’antiga és incorrecta
	public int setContrasenya(String antiga, String nova) {

		if (antiga == this.contrasenya) {
			this.contrasenya = nova;
			return 0;
		} else {
			return -2;
		}
	}
}
