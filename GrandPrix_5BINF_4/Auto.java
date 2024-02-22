

import java.io.*;
import java.util.*;

/**
 * La classe Auto rappresenta un'auto da corsa.
 * Estende la classe Thread e implementa l'interfaccia Serializable per
 * supportare la gestione dei thread e la serializzazione degli oggetti.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 10/02/2024
 */
public class Auto extends Thread implements Serializable {

  private int velocita; // Velocità dell'auto
  private String marca; // Marca dell'auto
  private String modello; // Modello dell'auto
  private String colore; // Colore dell'auto
  private Pilota pilota; // Pilota dell'auto
  private boolean safetyCar = false; // Indica se l'auto è una safety car
  private boolean inGara = false; // Indica se l'auto è in gara
  private int distanza = 0; // Distanza percorsa dall'auto

  /**
   * Costruttore della classe Auto.
   * 
   * @param velocita la velocità iniziale dell'auto
   * @param marca    la marca dell'auto
   * @param modello  il modello dell'auto
   * @param colore   il colore dell'auto
   * @param pilota   il pilota che guida l'auto
   */
  public Auto(int velocita, String marca, String modello, String colore, Pilota pilota) {
    super(marca + " " + modello + " " + pilota.getNome() + " " + pilota.getCognome());
    this.velocita = velocita;
    this.marca = marca;
    this.modello = modello;
    this.colore = colore;
    this.pilota = pilota;
  }

  /**
   * Imposta lo stato di safety car dell'auto.
   * 
   * @param safetyCar true se l'auto è una safety car, false altrimenti
   */
  public void setSafetyCar(boolean safetyCar) {
    this.safetyCar = safetyCar;
  }

  /**
   * Restituisce la distanza percorsa dall'auto.
   * 
   * @return la distanza percorsa dall'auto
   */
  public int getDistanza() {
    return distanza;
  }

  /**
   * Metodo per modificare la velocità dell'auto.
   * 
   * @param velocita la nuova velocità dell'auto
   */
  public void truccaAuto(int velocita) {
    this.velocita = velocita;
    while (velocita >= Circuito.getLunghezza() / 2) {
      System.out.println(
          "La velocità dell'auto è troppo alta, inserire un valore più piccolo (non maggiore della metà della lunghezza del circuito)");
      velocita = new Scanner(System.in).nextInt();
      this.velocita = velocita;
    }
  }

  /**
   * Metodo che rappresenta il comportamento del thread auto durante la gara.
   */
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
      if (distanza >= Circuito.getLunghezza()) {
        distanza = 0;
      }
      pitStop();
    }
  }

  /**
   * Metodo per terminare la gara dell'auto.
   */
  public void stopGara() {
    inGara = false;
  }

  /**
   * Metodo per visualizzare l'auto come stringa, con la sua posizione rispetto al
   * circuito.
   * 
   * @return la rappresentazione dell'auto come stringa
   */
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

  /**
   * Metodo che simula un pit stop durante la gara.
   */
  public void pitStop() {
    Random r1 = new Random();
    for (int i = 0; i < Circuito.getNPitStop(); i++) {
      float nextPitStop = r1.nextFloat();
      if (nextPitStop <= 0.1) {
        try {
          Thread.sleep(1500);
        } catch (InterruptedException e) {
          System.err.println("Errore nel Pit Stop");
        }
      }
    }
  }
}