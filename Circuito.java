package com.mycompany.grandprix_5binf_4;

import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Circuito {

	private double lunghezza;
	private int nGiri;
	private int nPitStop;

	public Circuito(double lunghezza, int nGiri, int nPitStop) {
		this.lunghezza = lunghezza;
    this.nGiri = nGiri;
    this.nPitStop = nPitStop;
	}

	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public void setNGiri(int nGiri) {
		this.nGiri = nGiri;
	}

	public void setNPitStop(int nPitStop) {
		this.nPitStop = nPitStop;
	}

}
