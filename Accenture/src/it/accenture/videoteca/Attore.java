package it.accenture.videoteca;

public class Attore extends Persona {

	public Attore(String nome, String cognome) {
		super(nome, cognome);
	}

	@Override
	public String toString() {
		return getNome() + " " + getCognome();
	}

}
