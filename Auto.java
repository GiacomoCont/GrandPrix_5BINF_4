package com.mycompany.grandprix_5binf_4;

import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Auto extends Thread {

	private int velocità;
	private String marca;
	private String modello;
	private String colore;
	private Pilota pilota;
  private boolean safetyCar = false;

	public Auto(int velocità, String marca, String modello, String colore, Pilota pilota) {
		this.velocità = velocità;
    this.marca = marca;
    this.modello = modello;
    this.colore = colore;
    this.pilota = pilota;
	}

  public void setSafetyCar(boolean safetyCar) {
    this.safetyCar = safetyCar;
  }

  public void setVelocità (int velocità) {
    this.velocità = velocità;
  }

  @Override 
  public void run() {
    
  }

}
