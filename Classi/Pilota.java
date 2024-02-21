import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Pilota implements Serializable {

  private String nome;
  private String cognome;
  private int eta;
  private String nazionalita;
  private char sesso;
  private float altezza;
  private float peso;

  public Pilota(String nome, String cognome, int eta, String nazionalita, char sesso, float altezza, float peso) {
    this.nome = nome;
    this.cognome = cognome;
    this.eta = eta;
    this.nazionalita = nazionalita;
    this.sesso = sesso;
    this.altezza = altezza;
    this.peso = peso;
  }
}