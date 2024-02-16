import java.io.*;
import java.util.*;

/**
 *
 * @author Giacomo Contini, Francesco Borzuola, Franco Miscia, Matteo Gropasi
 * @ 10/02/2024
 */

public class Circuito {

  private String nome;
	private static int lunghezza;
	private static int nGiri;
	private int nPitStop;

	public Circuito(String nome, int lunghezza, int nGiri, int nPitStop) {
    this.nome = nome;
		this.lunghezza = lunghezza;
    this.nGiri = nGiri;
    this.nPitStop = nPitStop;
  }

  public static int getLunghezza() {
    return lunghezza;
  }

  public static int getNGiri() {
    return nGiri;
  }

  public int getNPitStop() {
    return nPitStop;
  }
}