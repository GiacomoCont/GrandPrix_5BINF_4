

import java.io.*;

/**
 * La classe Pilota rappresenta un pilota di gara automobilistica.
 * Contiene informazioni personali del pilota come nome, cognome, età,
 * nazionalità, sesso, altezza e peso.
 * Implementa l'interfaccia Serializable per supportare la serializzazione degli
 * oggetti.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 10/02/2024
 */
public class Pilota implements Serializable {

  private String nome; // Nome del pilota
  private String cognome; // Cognome del pilota
  private int eta; // Età del pilota
  private String nazionalita; // Nazionalità del pilota
  private char sesso; // Sesso del pilota ('M' per maschio, 'F' per femmina)
  private float altezza; // Altezza del pilota (in metri)
  private float peso; // Peso del pilota (in chilogrammi)

  /**
   * Costruttore della classe Pilota.
   * 
   * @param nome        il nome del pilota
   * @param cognome     il cognome del pilota
   * @param eta         l'età del pilota
   * @param nazionalita la nazionalità del pilota
   * @param sesso       il sesso del pilota ('M' per maschio, 'F' per femmina)
   * @param altezza     l'altezza del pilota (in metri)
   * @param peso        il peso del pilota (in chilogrammi)
   */
  public Pilota(String nome, String cognome, int eta, String nazionalita, char sesso, float altezza, float peso) {
    this.nome = nome;
    this.cognome = cognome;
    this.eta = eta;
    this.nazionalita = nazionalita;
    this.sesso = sesso;
    this.altezza = altezza;
    this.peso = peso;
  }

  /**
   * Restituisce il nome del pilota.
   * 
   * @return il nome del pilota
   */
  public String getNome() {
    return nome;
  }

  /**
   * Restituisce il cognome del pilota.
   * 
   * @return il cognome del pilota
   */
  public String getCognome() {
    return cognome;
  }
}