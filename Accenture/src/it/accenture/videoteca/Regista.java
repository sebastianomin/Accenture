package it.accenture.videoteca;

public class Regista extends Persona {

	public Regista(String nome, String cognome) {
		super(nome, cognome);
	}

	@Override
	public String toString() {
		return "Regista: " + getNome() + " " + getCognome();
	}

}
