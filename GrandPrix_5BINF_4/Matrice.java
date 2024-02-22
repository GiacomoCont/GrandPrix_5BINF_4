

/**
 * La classe Matrice rappresenta una matrice utilizzata per l'algoritmo di
 * cifratura e decifratura di Vigenère.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 14/02/2024
 */
public class Matrice {

  char mv[][]; // La matrice
  String verme; // La chiave per la cifratura

  /**
   * Costruttore della classe Matrice.
   * 
   * @param verme la chiave per la cifratura
   */
  public Matrice(String verme) {
    this.mv = new char[26][26]; // Inizializza la matrice con dimensioni 26x26
    this.verme = verme; // Imposta la chiave per la cifratura
  }

  /**
   * Metodo per impostare un elemento della matrice.
   * 
   * @param r  l'indice di riga dell'elemento
   * @param c  l'indice di colonna dell'elemento
   * @param el il valore da impostare
   */
  public void setElemento(int r, int c, int el) {
    this.mv[r][c] = (char) el;
  }

  /**
   * Metodo per ottenere un elemento della matrice.
   * 
   * @param r l'indice di riga dell'elemento
   * @param c l'indice di colonna dell'elemento
   * @return il valore dell'elemento
   */
  public char getElemento(int r, int c) {
    return mv[r][c];
  }

  /**
   * Metodo per stampare la matrice.
   */
  public void stampa() {
    int r, c;
    for (r = 0; r < 26; r++) {
      for (c = 0; c < 26; c++) {
        System.out.print(this.getElemento(r, c));
      }
      System.out.print("\n");
    }
  }

  /**
   * Metodo per cifrare un testo utilizzando l'algoritmo di Vigenère.
   * 
   * @param fch il testo da cifrare
   * @return il testo cifrato
   */
  public String cifra(String fch) {
    String fcf = "";
    int k = 0;
    for (int j = 0; j < fch.length(); j++) {
      if (k == verme.length()) {
        k = 0;
      }
      int col = (int) fch.charAt(j) - 65;
      int row = (int) verme.charAt(k) - 65;
      if ((int) fch.charAt(j) == 32) {
        fcf = fcf + " ";
      } else {
        fcf = fcf + mv[row][col];
      }
      k++;
    }
    return fcf;
  }

  /**
   * Metodo per decifrare un testo cifrato utilizzando l'algoritmo di Vigenère.
   * 
   * @param fcf il testo cifrato
   * @return il testo decifrato
   */
  public String deCifra(String fcf) {
    String fch = "";
    int k = 0;
    for (int j = 0; j < fcf.length(); j++) {
      if (k == verme.length()) {
        k = 0;
      }
      int row = (int) verme.charAt(k) - 65;
      if ((int) fcf.charAt(j) == 32) {
        fch = fch + " ";
      }
      for (int col = 0; col < 26; col++) {
        if (mv[row][col] == fcf.charAt(j)) {
          char car = (char) (col + 65);
          fch += car;
        }
      }
      k++;
    }
    return fch;
  }
}