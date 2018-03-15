package it.accenture.garage;

public class Veicolo 
implements Comparable<Object> 
{
	private String marca;

	private int anno;

	private int cilindrata;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "marca=" + marca + ", anno=" + anno + ", cilindrata=" + cilindrata;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Veicolo) {
			Veicolo a = (Veicolo) o;
			if (this.anno == a.getAnno())
				return 0;
			if (this.anno > a.getAnno())
				return 1;
			return -1;
		}

		 else throw new ClassCastException("Il parametro del metodo compareTo non è un Veicolo!");
	}
}
