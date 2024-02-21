import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Auto extends Thread implements Serializable {

  private int velocita;
  private String marca;
  private String modello;
  private String colore;
  private Pilota pilota;
  private boolean safetyCar = false;
  private boolean inGara = false;
  private int distanza = 0;

  public Auto(int velocita, String marca, String modello, String colore, Pilota pilota) {
    super(marca + " " + modello);
    this.velocita = velocita;
    this.marca = marca;
    this.modello = modello;
    this.colore = colore;
    this.pilota = pilota;
  }

  public void setSafetyCar(boolean safetyCar) {
    this.safetyCar = safetyCar;
  }

  public int getDistanza() {
    return distanza;
  }

  public void truccaAuto(int velocita) {
    this.velocita = velocita;
    while (velocita >= Circuito.getLunghezza() / 2) {
      System.out.println(
          "La velocità dell'auto è troppo alta, inserire un valore più piccolo (non maggiore della metà della lunghezza del circuito)");
      velocita = new Scanner(System.in).nextInt();
      this.velocita = velocita;
    }
  }

  @Override
  public void run() {
    Random r = new Random();
    inGara = true;
    distanza = 0;

    while (inGara) {
      distanza += r.nextInt(1, 2) * velocita;
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
        System.err.println("Errore nell'attesa");
      }
      if(distanza >= Circuito.getLunghezza()) {
        distanza = 0; 
      }
    }
  }

  public void stopGara() {
    inGara = false;
  }

  @Override
  public String toString() {
    int lunghezza = Circuito.getLunghezza();
    StringBuilder sb = new StringBuilder();

    sb.append(getName()).append(" |");

    for (int i = 0; i < distanza - 1; i++) {
      sb.append(" ");
    }
    sb.append("o");
    for (int i = 0; i < lunghezza - distanza - 1; i++) {
      sb.append(" ");
    }
    if (distanza < lunghezza) {
      sb.append("|");
    }

    return sb.toString();
  }
}