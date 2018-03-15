package it.accenture.concessionaria;

public class Auto extends Veicolo {
	private String tipo;
    private int incremento;
    private int velocita;
    
    

	public Auto(int numMatricola, String proprietario, int annoImmatricolazione, int scadAssicurazione, String targa,
			int cilindrata, Stato stato, String tipo, int incremento) {
		super(numMatricola, proprietario,  annoImmatricolazione, scadAssicurazione,  targa, cilindrata, stato);
		this.tipo = tipo;
		this.incremento = incremento;
		this.velocita = 0;
	}
	
	

	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public int getIncremento() {
		return incremento;
	}



	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}



	public int getVelocita() {
		return velocita;
	}



	public void setVelocita(int velocita) {
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
		return "Auto [tipo=" + tipo + ", incremento=" + incremento + ", velocita=" + velocita + "]";
	}
	
	
	
    
    
	
    
    
    
}
