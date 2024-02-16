import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Giocatore {

  private String username;
  private String password;
  private static ArrayList<Auto> automobili;
  private static int nAuto = 0;

  public Giocatore(String username, String password) {
    this.username = username;
    this.password = password;
    automobili = new ArrayList<Auto>();
  }

  public void accesso() {
    // creazione matrice per la cifratura
    Matrice m = new Matrice("GRANDPRIXSIMULATORE");
    Vigenere v = new Vigenere(0, 12, 0, 12, m);
    Vigenere v1 = new Vigenere(12, 26, 0, 12, m);
    Vigenere v2 = new Vigenere(0, 12, 12, 26, m);
    Vigenere v3 = new Vigenere(12, 26, 12, 26, m);
    Thread t = new Thread(v);
    Thread t1 = new Thread(v1);
    Thread t2 = new Thread(v2);
    Thread t3 = new Thread(v3);
    t.start();
    t1.start();
    t2.start();
    t3.start();
    try {
      t.join();
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      System.err.println("Errore nel metodo join");
    }
    // richiesta in input dei dati dell'utente
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.println("Inserisci il tuo username (Non inserire numeri o caratteri speciali): ");
      String username = reader.readLine();
      String username_controllo = username.toUpperCase();
      String username_cifrato = m.cifra(username_controllo);
      System.out.println("Inserisci la tua password: ");
      String password = reader.readLine();
      String password_controllo = password.toUpperCase();
      String password_cifrata = m.cifra(password_controllo);
      System.out.println("La tua password sta venendo cifrata...");
      try {
        Thread.sleep(1000);
        System.out.println("Attendi un momento...");
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        System.err.println("Errore nell'attesa della cifratura");
      }
      System.out.println("Password cifrata correttamente!");
      setUsername(username_cifrato);
      setPassword(password_cifrata);
      Scrittore scrittore_utenti = new Scrittore("user.csv", username_cifrato, password_cifrata);
      scrittore_utenti.start();
    } catch (IOException e) {
      System.err.println("Errore nel salvataggio dei dati");
    }
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void numAuto() {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Inserisci il numero di auto: ");
    int numero_auto = Integer.valueOf(sc.nextLine());
    nAuto = numero_auto;

    System.out.println("Adesso creiamo il tuo veicolo!");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.err.println("Errore nell'attesa");
    }

    System.out.println("La velocità dell'auto verrà generata casualmente: ");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.err.println("Errore nell'attesa");
    }

    System.out.println("Inserisci la marca della tua auto: ");
    String marca = sc.nextLine();

    System.out.println("Inserisci il modello della tua auto: ");
    String modello = sc.nextLine();

    System.out.println("Inserisci il colore della tua auto: ");
    String colore = sc.nextLine();

    System.out.println("Inserisci il nome del tuo pilota: ");
    String nomePilota = sc.nextLine();

    System.out.println("Inserisci il cognome del tuo pilota: ");
    String cognomePilota = sc.nextLine();

    System.out.println("Inserisci l'età del tuo pilota: ");
    int etaPilota = Integer.valueOf(sc.nextLine());

    System.out.println("Inserisci la nazionalità del tuo pilota: ");
    String nazionalitaPilota = sc.nextLine();

    System.out.println("Inserisci il sesso del tuo pilota (M/F): ");
    char sessoPilota = sc.nextLine().charAt(0);

    System.out.println("Inserisci l'altezza del tuo pilota (espressa in metri): ");
    float altezzaPilota = Float.valueOf(sc.nextLine());

    System.out.println("Inserisci il peso del tuo pilota (espressa in Kg): ");
    float pesoPilota = Float.valueOf(sc.nextLine());

    Pilota pilota = new Pilota(nomePilota, cognomePilota, etaPilota, nazionalitaPilota, sessoPilota, altezzaPilota, pesoPilota);
    Auto auto = new Auto((int) Math.random() * 1000 + 1, marca, modello, colore, pilota);

    automobili.add(auto);

    System.out.println("Adesso creiamo le altre automobili!");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.err.println("Errore nell'attesa");
    }
    
    for (int i = 1; i < numero_auto; i++) {
      System.out.println("La velocità delle auto verrà generata casualmente: ");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        System.err.println("Errore nell'attesa");
      }

      System.out.println("Inserisci la marca dell'auto " + i + ": ");
      marca = sc.nextLine();

      System.out.println("Inserisci il modello dell'auto " + i + ": ");
      modello = sc.nextLine();

      System.out.println("Inserisci il colore dell'auto " + i + ": ");
      colore = sc.nextLine();

      System.out.println("Inserisci il nome del pilota " + i + ": ");
      nomePilota = sc.nextLine();

      System.out.println("Inserisci il cognome del pilota " + i + ": ");
      cognomePilota = sc.nextLine();

      System.out.println("Inserisci l'età del pilota " + i + ": ");
      etaPilota = Integer.valueOf(sc.nextLine());

      System.out.println("Inserisci la nazionalità del pilota " + i + ": ");
      nazionalitaPilota = sc.nextLine();

      System.out.println("Inserisci il sesso del pilota (M/F) " + i + ": ");
      sessoPilota = sc.nextLine().charAt(0);

      System.out.println("Inserisci l'altezza del pilota (espressa in cm) " + i + ": ");
      altezzaPilota = Float.valueOf(sc.nextLine());

      System.out.println("Inserisci il peso del pilota (espressa in Kg) " + i + ": ");
      pesoPilota = Float.valueOf(sc.nextLine());

      pilota = new Pilota(nomePilota, cognomePilota, etaPilota, nazionalitaPilota, sessoPilota, altezzaPilota, pesoPilota);
      auto = new Auto((int) Math.random() * 1000 + 1, marca, modello, colore, pilota);

      automobili.add(auto);

      ScrittoreAutomobili scrittore = new ScrittoreAutomobili("auto&piloti.csv");
      scrittore.start();
    }
  }

  public void circuito() {
    Scanner sc2 = new Scanner(System.in);
    String nome_circuito = "";
    int lunghezza_circuito = 0;
    int nGiri_circuito = 0;
    int nPitStop_circuito = 0;
    try {
      System.out.println("Inserisci il nome del circuito: ");
      nome_circuito = sc2.nextLine();
      System.out.println("Inserisci la lunghezza del circuito (espressa in Km): ");
      lunghezza_circuito = Integer.valueOf(sc2.nextLine());
      System.out.println("Inserisci il numero di giri necessari al completamento della gara: ");
      nGiri_circuito = Integer.valueOf(sc2.nextLine());
      System.out.println("Inserisci il numero di Pit Stop per ogni auto: ");
      nPitStop_circuito = Integer.valueOf(sc2.nextLine());
    } catch (NullPointerException e) {
      System.err.println("Errore nell'inserimento dei dati");
    }
    Circuito circuito = new Circuito(nome_circuito, lunghezza_circuito, nGiri_circuito, nPitStop_circuito);
  }

  public void trucca() {
    Scanner sc1 = new Scanner(System.in);
    Auto auto = automobili.get(0);
    System.out.println("Inserisci la velocità della tua auto:");
    int velocita = sc1.nextInt();
    System.out.println("Modifiche in corso...");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.err.println("Errore nell'attesa");
    }
    System.out.println("Auto truccata con successo!");
    auto.truccaAuto(velocita);
  }

  public void iniziaGara() {
    for (int i = 0; i < nAuto; i++) {
      automobili.get(i).start();
      try {
      automobili.get(i).join();
    } catch (InterruptedException e) {
        System.err.println("Errore nell'avvio della gara");
    }
  }
  }

  public static ArrayList<Auto> getAutomobili() {
    return automobili;
  }
}