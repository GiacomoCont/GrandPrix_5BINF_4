package com.mycompany.grandprix_5binf_4;

import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Giocatore {

	private String nomeUtente;
	private String password;
	private ArrayList<Auto> nAuto;
	private ArrayList<Circuito> nCircuito;

	public Giocatore (String nomeUtente, String password) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.nAuto = new ArrayList<Auto>();
		this.nCircuito = new ArrayList<Circuito>();
	}

	public void Impostazioni() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void creaFile() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
