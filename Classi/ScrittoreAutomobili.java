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
  
  public static void scrivi_automobili() {
    ArrayList<Auto> automobili = Giocatore.getAutomobili();
    //try-with-resources
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("auto&piloti.bin"))) {
        oos.writeObject(automobili);
        System.out.println("Dati delle automobili salvati con successo nel file auto&piloti.bin");
    } catch (IOException e) {
        System.err.println("Errore durante la scrittura dei dati delle automobili nel file auto&piloti.bin: " + e.getMessage());
    }
  }

  public static void leggiAutomobili() {
    String filePath = "auto&piloti.bin";
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
      ArrayList<Auto> automobili = (ArrayList<Auto>) ois.readObject();
      for (Auto auto : automobili) {
        System.out.println(auto);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Errore durante la lettura dei dati delle automobili da file: " + e.getMessage());
    }
  }
}