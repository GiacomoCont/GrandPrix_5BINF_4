import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Giudice {

  public static void main(String[] args) {
    visualizzaInterfaccia();

    Lettore lettore_utenti = new Lettore("user.csv");
    Lettore lettore_auto_piloti = new Lettore("auto&piloti.csv");
    Giocatore giocatore = new Giocatore(" ", " ");

    Scanner sc = new Scanner(System.in);

    int s = -1;
    
    while (s != 0) {
    s = sc.nextInt();
    switch (s) {
      case 1:
        giocatore.accesso();
        visualizzaInterfaccia();
        break;
      case 2:
        giocatore.numAuto();
        visualizzaInterfaccia();
        break;
      case 3:
        giocatore.circuito();
        visualizzaInterfaccia();
        break;
      case 4:
        giocatore.trucca();
        visualizzaInterfaccia();
        break;
      case 5:
        giocatore.iniziaGara();
        break;
      default:
        if(s != 0) {
          System.out.println("Inserisci un valore valido!");
        }
        break;
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
    System.out.println("4) Trucca la tua auto ***************************************************************");
    System.out.println("5) Avvia la gara ********************************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("*************************************************************************************");
    System.out.println("");
  }
}