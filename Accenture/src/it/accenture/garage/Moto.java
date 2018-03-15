package it.accenture.garage;

public class Moto extends Veicolo{
	private int tempi;

	public int getTempi() {
		return tempi;
	}

	public void setTempi(int tempi) {
		this.tempi = tempi;
	}

	@Override
	public String toString() {
		return "Moto: [" + super.toString() + " tempi=" + tempi + "]";
	}
}
