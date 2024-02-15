package com.mycompany.grandprix_5binf_4;

import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Giudice {

  public static void main(String[] args) {
    visualizzaInterfaccia();

    // Lettore lettore_utenti = new Lettore("user.csv");
    // Lettore lettore_auto_piloti = new Lettore("auto&piloti.csv");

    Scanner sc = new Scanner(System.in);

    int s = -1;
    
    while (s != 0) {
    s = sc.nextInt();
    switch (s) {
      case 1 -> accesso();
      case 2 -> numAuto();
      case 3 -> circuito();
    }
  }
}
    
  public static void visualizzaInterfaccia() {
    //visualizzazione dell'interfaccia utente e presentazione delle opzioni a disposizione
    System.out.println("*************************************************************************************");
    System.out.println("************************************GRAND PRIX***************************************");
    System.out.println("*************************************************************************************");
    System.out.println("Azioni possibili del simulatore: ****************************************************");
    System.out.println("1) Inserisci l'username e la password ***********************************************");
    System.out.println("2) Scegli il numero di auto e di piloti *********************************************");
    System.out.println("3) Scegli il circuito della gara ****************************************************");
    System.out.println("4) Imposta la lunghezza del circuito ************************************************");
    System.out.println("5) Imposta il numero di giri necessari al completamento della gara ******************");
    System.out.println("6) Imposta il numero di Pit Stop ****************************************************");
    System.out.println("7) Modifica lo stato di una macchina ************************************************");
    System.out.println("8) Entrata della Safety Car *********************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("");
  }

  public static void accesso() {
    //creazione matrice per la cifratura
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
    //richiesta in input dei dati dell'utente
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.println("Inserisci il tuo username: ");
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
      // A cosa serve salvare username e password in un file se poi alla prossima
      // partita il file viene sovrascritto?
      Scrittore scrittore_utenti = new Scrittore("user.csv", username_cifrato, password_cifrata);
      scrittore_utenti.start();
    } catch (IOException e) {
      System.err.println("Errore nel salvataggio dei dati");
    }
  }

  public static void numAuto() {
    Scanner sc1 = new Scanner(System.in);
    try {
      System.out.println("Inserisci il numero di auto: ");
      int numero_auto = sc1.nextInt();

      String[][] automobili = new String[numero_auto][11];

      System.out.println("Adesso creiamo il tuo veicolo!");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        System.err.println("Errore nell'attesa");
      }
      String automobile = "";
      System.out.println("Inserisci la marca dell'auto");
      automobile = sc1.nextLine();
      automobili[0][0] = automobile;
      System.out.println("Inserisci il modello dell'auto");
      automobile = sc1.nextLine();
      automobili[0][1] = automobile;
      System.out.println("Inserisci il colore dell'auto");
      automobile = sc1.nextLine();
      automobili[0][2] = automobile;
      System.out.println("La velocità della tua auto verrà generata randomicamente");
      automobili[0][3] = Integer.toString((int) (Math.random() * 1000 + 1));
      try {
        Thread.sleep(3000);
        System.out.println("Se vuoi modificare la velocità potrai truccarla durante la gara");
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        System.err.println("Errore nell'attesa!");
      }
      System.out.println("Inserisci il nome del pilota");
      automobile = sc1.nextLine();
      automobili[0][4] = automobile;
      System.out.println("Inserisci il cognome del pilota");
      automobile = sc1.nextLine();
      automobili[0][5] = automobile;
      System.out.println("Inserisci l'età del pilota");
      automobile = sc1.nextLine();
      automobili[0][6] = automobile;
      System.out.println("Inserisci il sesso del pilota");
      automobile = sc1.nextLine();
      automobili[0][7] = automobile;
      System.out.println("Inserisci la nazionalità del pilota");
      automobile = sc1.nextLine();
      automobili[0][8] = automobile;
      System.out.println("Inserisci l'altezza del pilota");
      automobile = sc1.nextLine();
      automobili[0][9] = automobile;
      System.out.println("Inserisci il peso del pilota");
      automobile = sc1.nextLine();
      automobili[0][10] = automobile;

      System.out.println("Adesso scegliamo le altre automobili!");

      for (int i = 1; i < numero_auto; i++) {
        System.out.println("Inserisci la marca dell'auto: ");
        automobile = sc1.nextLine();
        automobili[i][0] = automobile;
        System.out.println("Inserisci il modello dell'auto: ");
        automobile = sc1.nextLine();
        automobili[i][1] = automobile;
        System.out.println("Inserisci il colore dell'auto: ");
        automobile = sc1.nextLine();
        automobili[i][2] = automobile;
        System.out.println("La velocità dell'auto verrà generata randomicamente");
        automobili[i][3] = Integer.toString((int) (Math.random() * 1000 + 1));
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          System.err.println("Errore nell'attesa");
        }
        System.out.println("Inserisci il nome pilota: ");
        automobile = sc1.nextLine();
        automobili[i][4] = automobile;
        System.out.println("Inserisci il cognome del pilota: ");
        automobile = sc1.nextLine();
        automobili[i][5] = automobile;
        System.out.println("Inserisci l'età del pilota");
        automobile = sc1.nextLine();
        automobili[i][6] = automobile;
        System.out.println("Inserisci il sesso del pilota");
        automobile = sc1.nextLine();
        automobili[i][7] = automobile;
        System.out.println("Inserisci la nazionalità del pilota");
        automobile = sc1.nextLine();
        automobili[i][8] = automobile;
        System.out.println("Inserisci l'altezza del pilota");
        automobile = sc1.nextLine();
        automobili[i][9] = automobile;
        System.out.println("Inserisci il peso del pilota");
        automobile = sc1.nextLine();
        automobili[i][10] = automobile;
      }

      ScrittoreAutomobili scrittore_auto_piloti = new ScrittoreAutomobili(null, null, null, null, null, null, null, null, null, null, null, null);

      for (int i = 0; i < numero_auto; i++) {
        scrittore_auto_piloti = new ScrittoreAutomobili("auto&piloti.csv", automobili[i][0], automobili[i][1], automobili[i][2], automobili[i][3], automobili[i][4], automobili[i][5], automobili[i][6], automobili[i][7], automobili[i][8], automobili[i][9], automobili[i][10]);
      }
      scrittore_auto_piloti.start();
    } catch (NullPointerException e) {
      System.err.println("Errore nell'inserimento dei dati");
    }
  }

      public static void circuito() {

      }
}