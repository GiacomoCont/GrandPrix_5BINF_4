
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * La classe Lettore gestisce l'operazione di lettura di un file.
 * Estende la classe Thread per supportare l'esecuzione concorrente
 * dell'operazione di lettura.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 14/02/2024
 */
public class Lettore extends Thread {
  String nomeFile; // Il nome del file da leggere

  /**
   * Costruttore della classe Lettore.
   * 
   * @param nomeFile il nome del file da leggere
   */
  public Lettore(String nomeFile) {
    this.nomeFile = nomeFile;
  }

  /**
   * Metodo per leggere il contenuto del file e mostrarlo in output.
   * Il metodo legge il file senza tener conto del tipo di file e lo mostra in
   * output.
   */
  public void leggi() {
    int i;
    // Utilizzo del try-with-resources per garantire la chiusura automatica delle
    // risorse
    try (BufferedReader fr = new BufferedReader(new FileReader(nomeFile))) {
      // 1) apro il file
      // 2) leggo carattere per carattere e lo stampo
      while ((i = fr.read()) != -1)
        System.out.print((char) i);

      System.out.print("\n\r");
      // 3) chiudo il file
    } catch (IOException ex) {
      System.err.println("Errore in lettura!");
    }
  }

  /**
   * Metodo per leggere il contenuto del file utilizzando gli stream.
   * 
   * @param nomeFile il nome del file da leggere
   * @return una stringa contenente il contenuto del file letto
   */
  public String Stream(String nomeFile) {
    String userData = "";
    try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
      String line;
      StringBuilder sb = new StringBuilder();
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
      userData = sb.toString();
    } catch (IOException ex) {
      System.err.println("Errore in lettura!");
    }
    return userData;
  }

  /**
   * Metodo che rappresenta il comportamento del thread durante l'esecuzione.
   * Invoca il metodo per leggere il contenuto del file e mostrarlo in output.
   */
  @Override
  public void run() {
    leggi();
  }
}