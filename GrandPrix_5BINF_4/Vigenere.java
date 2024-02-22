

import java.io.*;
import java.util.*;

/**
 * La classe Vigenere implementa l'interfaccia Runnable e rappresenta un task
 * per popolare una matrice secondo l'algoritmo di Vigenère.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 14/02/2024
 */
public class Vigenere implements Runnable {

  private int ir; // Indice di partenza delle righe da popolare
  private int fr; // Indice di fine delle righe da popolare
  private int ic; // Indice di partenza delle colonne da popolare
  private int fc; // Indice di fine delle colonne da popolare
  private Matrice matrix; // Matrice da popolare

  /**
   * Costruttore della classe Vigenere.
   * 
   * @param ir     indice di partenza delle righe da popolare
   * @param fr     indice di fine delle righe da popolare
   * @param ic     indice di partenza delle colonne da popolare
   * @param fc     indice di fine delle colonne da popolare
   * @param matrix la matrice da popolare
   */
  public Vigenere(int ir, int fr, int ic, int fc, Matrice matrix) {
    this.ir = ir;
    this.fr = fr;
    this.ic = ic;
    this.fc = fc;
    this.matrix = matrix;
  }

  /**
   * Metodo che rappresenta il comportamento del thread durante l'esecuzione.
   * Invoca il metodo popola() per popolare la matrice secondo l'algoritmo di
   * Vigenère.
   */
  @Override
  public void run() {
    popola();
  }

  /**
   * Metodo privato per popolare la matrice secondo l'algoritmo di Vigenère.
   * Itera attraverso le righe e le colonne specificate e calcola il valore da
   * inserire nella matrice.
   * Il valore è ottenuto sommando gli indici di riga e colonna e aggiungendo 65.
   * Se il valore supera 90, viene sottratto 26.
   */
  private void popola() {
    int c, r, car;
    for (r = ir; r < fr; r++) {
      for (c = ic; c < fc; c++) {
        car = r + c + 65;
        if (car > 90) {
          car = car - 26;
        }
        this.matrix.setElemento(r, c, car);
      }
    }
  }
}