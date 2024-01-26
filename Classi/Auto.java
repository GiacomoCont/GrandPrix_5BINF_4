import java.io.*;
import java.util.*;

public class Auto extends Thread {

	private int velocità;
	private String marca;
	private String modello;
	private String colore;
	private Pilota pilota;

	public Auto(int velocità, String marca, String modello, String colore, Pilota pilota) {
		this.velocità = velocità;
                this.marca = marca;
                this.modello = modello;
                this.colore = colore;
                this.pilota = pilota;
	}

}
