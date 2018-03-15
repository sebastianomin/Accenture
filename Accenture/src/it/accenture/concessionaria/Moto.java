package it.accenture.concessionaria;

public class Moto extends Veicolo{
	private int numPosti;
    private int incremento;
    private double velocita;
	
	public Moto(int numMatricola, String proprietario, int annoImmatricolazione, int scadAssicurazione, String targa,
			int cilindrata, Stato stato, int numPosti, int incremento) {
		super(numMatricola, proprietario, annoImmatricolazione, scadAssicurazione, targa, cilindrata, stato);
		this.numPosti=numPosti;
		this.incremento=incremento;
		velocita=0;
	}
	
	
	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}


	public int getIncremento() {
		return incremento;
	}


	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}



	public double getVelocita() {
		return velocita;
	}


	public void setVelocita(double velocita) {
		this.velocita = velocita;
	}



	@Override
	public void accelera() {
		velocita=velocita+incremento;
		
	}

	

	@Override
	public void parti(int velocIniz) {
		 velocita=velocIniz ;		
		
	}


	@Override
	public String toString() {
		return "Moto [numPosti=" + numPosti + ", incremento=" + incremento + ", velocita=" + velocita + "]";
	}
	
	

    
    

}
