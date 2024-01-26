import java.io.*;
import java.util.*;

public class Giocatore {

	private String nomeUtente;
	private String password;
	private ArrayList<Auto> nAuto;
	private ArrayList<Circuito> nCircuito;

	public Giocatore(String nomeUtente, String password) {
		this.nomeUtente = nomeUtente;
                this.password = password;
                nAuto = new ArrayList<>();
                nCircuito = new ArrayList<>();
	}

	public Boolean Accesso(String nomeUtente, String password) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void Impostazioni() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void creaFile() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
