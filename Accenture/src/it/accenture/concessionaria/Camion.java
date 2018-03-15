package it.accenture.concessionaria;

public class Camion extends Veicolo {
	
	private int numAssi;
    private int incremento;
    private double velocita;
	
	public Camion(int numMatricola, String proprietario, int annoImmatricolazione, int scadAssicurazione, String targa,
			int cilindrata, Stato stato, int numAssi, int incremento) {
		super(numMatricola, proprietario, annoImmatricolazione, scadAssicurazione, targa, cilindrata, stato);
		this.numAssi=numAssi;
		this.incremento=incremento;
		velocita=0;
	}
	
	
	public int getNumAssi() {
		return numAssi;
	}

    public void setNumAssi(int numAssi) {
		this.numAssi = numAssi;
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
 		velocita=velocita+incremento/4;
 		
 	}

 	

 	@Override
 	public void parti(int velocIniz) {
 		 velocita=velocIniz ;		
 		
 	}


	@Override
	public String toString() {
		return "Camion [numAssi=" + numAssi + ", incremento=" + incremento + ", velocita=" + velocita + "]";
	}
	
	

}
