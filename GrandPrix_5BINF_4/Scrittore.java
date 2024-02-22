

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe Scrittore gestisce l'operazione di scrittura di username e password
 * su file.
 * Estende la classe Thread per supportare l'esecuzione concorrente
 * dell'operazione di scrittura.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 14/02/2024
 */
public class Scrittore extends Thread {

  String nomeFile; // Il nome del file su cui scrivere username e password
  String username; // Lo username da scrivere
  String password; // La password da scrivere

  /**
   * Costruttore della classe Scrittore.
   * 
   * @param nomeFile il nome del file su cui scrivere username e password
   * @param username lo username da scrivere
   * @param password la password da scrivere
   */
  public Scrittore(String nomeFile, String username, String password) {
    this.nomeFile = nomeFile;
    this.username = username;
    this.password = password;
  }

  /**
   * Metodo che rappresenta il comportamento del thread durante l'esecuzione.
   * Invoca il metodo scrivi() per scrivere username e password su file.
   */
  @Override
  public void run() {
    scrivi();
  }

  /**
   * Metodo per scrivere username e password su file.
   * Utilizza un oggetto BufferedWriter per scrivere i dati su file.
   */
  public void scrivi() {
    // Utilizzo del try-with-resources per garantire la chiusura automatica delle
    // risorse
    try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
      br.write("<" + username + ">"); // Scrive lo username
      br.write("\n\r");
      br.write("<" + password + ">"); // Scrive la password
      br.write("\n\r");
      br.flush();
    } catch (IOException ex) {
      Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}