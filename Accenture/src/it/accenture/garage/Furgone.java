package it.accenture.garage;

public class Furgone extends Veicolo{
	private int capacita;

	public int getCapacita() {
		return capacita;
	}

	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}

	@Override
	public String toString() {
		return "Furgone: [" + super.toString() + " capacita=" + capacita + "]";
	}

}
