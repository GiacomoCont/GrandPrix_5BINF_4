package com.mycompany.grandprix_5binf_4;

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
 // @sourceLevel: 1.7

public class ScrittoreAutomobili extends Thread {
  String nomeFile;
  String marca;
  String modello;
  String colore;
  String velocita;
  String nome_pilota;
  String cognome_pilota;
  String eta_pilota;
  String sesso_pilota;
  String nazionalita_pilota;
  String altezza_pilota;
  String peso_pilota;
  
  
  public ScrittoreAutomobili(String nomeFile, String marca, String modello, String colore, String velocita, String nome_pilota, String cognome_pilota, String eta_pilota, String sesso_pilota, String nazionalita_pilota, String altezza_pilota, String peso_pilota) {
    this.marca = marca;
    this.modello = modello;
    this.colore = colore;
    this.velocita = velocita;
    this.nome_pilota = nome_pilota;
    this.cognome_pilota = cognome_pilota;
    this.eta_pilota = eta_pilota;
    this.sesso_pilota = sesso_pilota;
    this.nazionalita_pilota = nazionalita_pilota;
    this.altezza_pilota = altezza_pilota;
    this.peso_pilota = peso_pilota;
  }
  
  @Override
  public void run() {
    scrivi_automobili();
  }
  
  public void scrivi_automobili() {
    //try-with-resources
    try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
      br.write("<" + marca + ">");
      br.write("\n\r");
      br.write("<" + modello + ">");
      br.write("\n\r");
      br.write("<" + colore + ">");
      br.write("\n\r");
      br.write("<" + velocita + ">");
      br.write("\n\r");
      br.write("<" + nome_pilota + ">");
      br.write("\n\r");
      br.write("<" + cognome_pilota + ">");
      br.write("\n\r");
      br.write("<" + eta_pilota + ">");
      br.write("\n\r");
      br.write("<" + sesso_pilota + ">");
      br.write("\n\r");
      br.write("<" + nazionalita_pilota + ">");
      br.write("\n\r");
      br.write("<" + altezza_pilota + ">");
      br.write("\n\r");
      br.write("<" + peso_pilota + ">");
      br.write("\n\r");
      br.flush();
    } catch (IOException ex) {
      Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}