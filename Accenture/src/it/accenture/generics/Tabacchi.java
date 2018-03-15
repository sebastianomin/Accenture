package it.accenture.generics;

public class Tabacchi {

	private String tipo;

	private String marca;

	private double prezzo;

	public Tabacchi(String tipo, String marca, double prezzo) {
		this.tipo = tipo;
		this.marca = marca;
		this.prezzo = prezzo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Tabacchi [tipo=" + tipo + ", marca=" + marca + ", prezzo=" + prezzo + "]";
	}

}
