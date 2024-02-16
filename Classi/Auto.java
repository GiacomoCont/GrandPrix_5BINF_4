import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Auto extends Thread {

	private int velocita;
	private String marca;
	private String modello;
	private String colore;
	private Pilota pilota;
  private boolean safetyCar = false;
  private boolean inGara = false;

	public Auto(int velocita, String marca, String modello, String colore, Pilota pilota) {
		this.velocita = velocita;
    this.marca = marca;
    this.modello = modello;
    this.colore = colore;
    this.pilota = pilota;
	}

  public void setSafetyCar(boolean safetyCar) {
    this.safetyCar = safetyCar;
  }

  public void truccaAuto (int velocita) {
    this.velocita = velocita;
  }

  @Override 
  public void run() {
    Random r = new Random();
    inGara = true;
    int distanza = 0;
    int giriCompiuti = 0;
    int lunghezza = Circuito.getLunghezza() * 1000;

    while (inGara) {
      this.toString();
      distanza = (int) r.nextFloat() * velocita;
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
        e.printStacktrace();
      }
      if(distanza >= Circuito.getLunghezza()) {
        giriCompiuti++;
        if(giriCompiuti >= Circuito.getNGiri()) {
          inGara = false;
        }
      }
      clearScreen();
    }
  }

  public void stopGara() {
    inGara = false;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(getName()).append(" |");

    for (int i = 0; i < distanza - 1; i++) {
      sb.append(" ");
    }
    sb.append("o");
    for (int i = 0; i < lunghezza - distanza-1; i++) {
      sb.append(" ");
    }
    if(distanza < lunghezza) {
      sb.append("|");
    }

    return sb.toString();
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}