

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;

/**
 * La classe ScrittoreAutomobili gestisce l'operazione di scrittura degli
 * oggetti Auto su file.
 * Estende la classe Thread per supportare l'esecuzione concorrente
 * dell'operazione di scrittura.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @since 14/02/2024
 */
public class ScrittoreAutomobili extends Thread {

  String nomeFile; // Il nome del file su cui scrivere gli oggetti Auto

  /**
   * Costruttore della classe ScrittoreAutomobili.
   * 
   * @param nomeFile il nome del file su cui scrivere gli oggetti Auto
   */
  public ScrittoreAutomobili(String nomeFile) {
    this.nomeFile = nomeFile;
  }

  /**
   * Metodo che rappresenta il comportamento del thread durante l'esecuzione.
   * Invoca il metodo per scrivere gli oggetti Auto su file.
   */
  @Override
  public void run() {
    scrivi_automobili();
  }

  /**
   * Metodo statico per scrivere gli oggetti Auto su file.
   * Utilizza l'oggetto ObjectOutputStream per la serializzazione degli oggetti
   * Auto.
   */
  public static void scrivi_automobili() {
    ArrayList<Auto> automobili = Giocatore.getAutomobili();
    // Utilizzo del try-with-resources per garantire la chiusura automatica delle
    // risorse
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("auto&piloti.bin"))) {
      oos.writeObject(automobili);
      System.out.println("Dati delle automobili salvati con successo nel file auto&piloti.bin");
    } catch (IOException e) {
      System.err
          .println("Errore durante la scrittura dei dati delle automobili nel file auto&piloti.bin: " + e.getMessage());
    }
  }

  /**
   * Metodo statico per leggere gli oggetti Auto da file.
   * Utilizza l'oggetto ObjectInputStream per deserializzare gli oggetti Auto.
   */
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