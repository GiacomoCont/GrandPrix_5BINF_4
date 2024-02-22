

import java.io.*;
import java.util.*;

/**
 * La classe Circuito rappresenta un circuito della nostra gara.
 * Contiene informazioni sul nome del circuito, la sua lunghezza, il numero di
 * giri e il numero di pit stop.
 * Le informazioni sulla lunghezza, il numero di giri e il numero di pit stop
 * sono statiche e condivise da tutte le istanze della classe, in quanto noi ci aspettiamo di creare una sola istanza 
 * di Circuito per gara.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 10/02/2024
 */
public class Circuito {

  private String nome; // Nome del circuito
  private static int lunghezza; // Lunghezza del circuito
  private static int nGiri; // Numero di giri del circuito
  private static int nPitStop; // Numero di pit stop consentiti nel circuito

  /**
   * Costruttore della classe Circuito.
   * 
   * @param nome      il nome del circuito
   * @param lunghezza la lunghezza del circuito
   * @param nGiri     il numero di giri del circuito
   * @param nPitStop  il numero di pit stop consentiti nel circuito
   */
  public Circuito(String nome, int lunghezza, int nGiri, int nPitStop) {
    this.nome = nome;
    this.lunghezza = lunghezza;
    this.nGiri = nGiri;
    this.nPitStop = nPitStop;
  }

  /**
   * Restituisce la lunghezza del circuito.
   * 
   * @return la lunghezza del circuito
   */
  public static int getLunghezza() {
    return lunghezza;
  }

  /**
   * Restituisce il numero di giri del circuito.
   * 
   * @return il numero di giri del circuito
   */
  public static int getNGiri() {
    return nGiri;
  }

  /**
   * Restituisce il numero di pit stop consentiti nel circuito.
   * 
   * @return il numero di pit stop consentiti nel circuito
   */
  public static int getNPitStop() {
    return nPitStop;
  }
}