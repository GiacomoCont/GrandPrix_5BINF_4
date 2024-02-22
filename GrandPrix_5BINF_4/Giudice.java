

import java.io.*;
import java.util.*;

/**
 * Questa classe rappresenta il giudice del simulatore di gara automobilistica.
 * Gestisce l'interfaccia utente e il flusso del programma.
 * 
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @version 10/02/2024
 */
public class Giudice {

  /**
   * Il metodo principale che avvia il simulatore e gestisce le interazioni con
   * l'utente.
   */
  public static void main(String[] args) {
    visualizzaInterfaccia();

    Giocatore giocatore = new Giocatore(" ", " ");
    boolean inGara = false;

    Scanner sc = new Scanner(System.in);

    int s = -1;
    int currentUserSelection = 0;

    while (s != 0) {
      s = sc.nextInt();
      switch (s) {
        case 1:
          /* opzione per inserire i dati dell'utente intenzionato a giocare per effettuare una registrazione e salvare 
          *  i dati nel file user.csv
          */
          currentUserSelection = 1;
          giocatore.accesso();
          visualizzaInterfaccia();
          break;
        case 2:
          /* opzione per poter inserire i dati della propria automobile e creare le auto avversarie */
          if (currentUserSelection >= 1) {
            currentUserSelection = 2;
            giocatore.numAuto();
          } else {
            System.out.println("Devi selezionare l'opzione 1 prima di procedere.");
          }
          visualizzaInterfaccia();
          break;
        case 3:
          /** 
           * opzione per poter creare il circuito dove si andrà a correre attraverso l'inserimento manuale dei dati 
           * come la lunghezza e il numero di giri
           */
          if (currentUserSelection >= 2) {
            currentUserSelection = 3;
            giocatore.circuito();
          } else {
            System.out.println("Devi selezionare l'opzione 2 prima di procedere.");
          }
          visualizzaInterfaccia();
          break;
        case 4:
          /** 
           * opzione per poter decidere manualmente la velocità della propria auto
           */
          if (currentUserSelection >= 3) {
            currentUserSelection = 4;
            giocatore.trucca();
          } else {
            System.out.println("Devi selezionare l'opzione 2 e 3 prima di procedere.");
          }
          visualizzaInterfaccia();
          break;
        case 5:
          /**
           * opzione per poter iniziare la gara
           */
          if (currentUserSelection >= 3) {
            currentUserSelection = 5;
            inGara = true;
            int giriCompiuti = 0;
            ArrayList<Auto> automobili = Giocatore.getAutomobili();
            for (int i = 0; i < automobili.size(); i++) {
              System.out.println(automobili.get(i));
            }
            giocatore.iniziaGara();
            while (inGara) {
              clearScreen();
              for (int i = 0; i < automobili.size(); i++) {
                System.out.println(automobili.get(i));
              }
              try {
                Thread.sleep(1500);
              } catch (InterruptedException e) {
                System.err.println("Errore nell'avvio della gara");
              }
              for (int c = 0; c < automobili.size(); c++) {
                if (automobili.get(c).getDistanza() >= Circuito.getLunghezza()) {
                  giriCompiuti++;
                  break;
                }
              }
              if (giriCompiuti >= Circuito.getNGiri()) {
                inGara = false;
                break;
              }
            }
            for (int j = 0; j < automobili.size(); j++) {
              automobili.get(j).stopGara();
            }
            mostraClassifica();
          } else {
            System.out.println("Devi selezionare almeno le opzioni 1, 2 e 3 prima di procedere con l'avvio della gara.");
          }
          break;
      }
    }
  }

  /**
   * Metodo per visualizzare l'interfaccia utente e presentare le opzioni
   * disponibili.
   */
  public static void visualizzaInterfaccia() {
    System.out.println("*************************************************************************************");
    System.out.println("************************************| GRAND PRIX |***********************************");
    System.out.println("*************************************************************************************");
    System.out.println("Azioni possibili del simulatore:        |********************************************");
    System.out.println("1) Inserisci l'username e la password   |********************************************");
    System.out.println("2) Scegli il numero di auto e di piloti |********************************************");
    System.out.println("3) Scegli il circuito della gara        |********************************************");
    System.out.println("4) Trucca la tua auto                   |********************************************");
    System.out.println("5) Avvia la gara                        |********************************************");
    System.out.println("*************************************************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("");
    System.out.print("Scelta: ");
  }

  /**
   * Metodo per pulire lo schermo della console.
   */
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Metodo per mostrare la classifica finale della gara e salvarla su file.
   */
  public static void mostraClassifica() {
    salvaClassifica("classifica.txt");

    ArrayList<Auto> automobili = Giocatore.getAutomobili();
    automobili.sort(Comparator.comparing(Auto::getDistanza).reversed());

    System.out.println("\n--- Classifica ---");
    for (int i = 0; i < automobili.size(); i++) {
      System.out.println((i + 1) + ". " + automobili.get(i).getName() + " - " + automobili.get(i).getDistanza());
    }
  }

  /**
     * Metodo per salvare la classifica su file.
     * 
     * @param filename il nome del file in cui salvare la classifica
     */
    public static void salvaClassifica(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            ArrayList<Auto> automobili = Giocatore.getAutomobili();
            automobili.sort(Comparator.comparing(Auto::getDistanza).reversed());

            writer.println("--- Classifica ---");
            for (int i = 0; i < automobili.size(); i++) {
                writer.println((i + 1) + ". " + automobili.get(i).getName() + " - " + automobili.get(i).getDistanza());
            }
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio della classifica: " + e.getMessage());
        }
    }
}