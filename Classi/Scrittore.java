import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 14/02/2024
 */

public class Scrittore extends Thread {

  String nomeFile;
  String username;
  String password;
  

  public Scrittore(String nomeFile, String username, String password) {
    this.nomeFile = nomeFile;
    this.username = username;
    this.password = password;
  }
  // aggiungere costruttore con 2 parametri testo

  @Override
  public void run() {
    scrivi();
  }

  public void scrivi() {
    //try-with-resources
    try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
      br.write("<" + username + ">");
      br.write("\n\r");
      br.write("<" + password + ">");
      br.write("\n\r");
      br.flush();
    } catch (IOException ex) {
      Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}