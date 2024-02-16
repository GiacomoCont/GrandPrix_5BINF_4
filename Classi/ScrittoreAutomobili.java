import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 14/02/2024
 */

public class ScrittoreAutomobili extends Thread {
  
  String nomeFile;
  
  public ScrittoreAutomobili(String nomeFile) {
    this.nomeFile = nomeFile;
  }
  
  @Override
  public void run() {
    scrivi_automobili();
  }
  
  public void scrivi_automobili() {
    //try-with-resources
    ArrayList<Auto> automobili = Giocatore.getAutomobili();
    try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
      br.write("<" + automobili.get(0) + ">");
      br.write("\n\r");
      br.flush();
    } catch (IOException ex) {
      Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}