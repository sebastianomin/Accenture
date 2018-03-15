package it.accenture.concessionaria;

public abstract class Veicolo implements Comparable<Object>, VeicoloAssicurato{

    private int numMatricola;
    private String proprietario;
    private int annoImmatricolazione;
    private int scadAssicurazione;
    private String targa;
    private int cilindrata;
    private Stato stato;


  

    public Veicolo(int numMatricola, String proprietario, int annoImmatricolazione, int scadAssicurazione, String targa,
			int cilindrata, Stato stato) {
		this.numMatricola = numMatricola;
		this.proprietario = proprietario;
		this.annoImmatricolazione = annoImmatricolazione;
		this.scadAssicurazione = scadAssicurazione;
		this.targa = targa;
		this.cilindrata = cilindrata;
		this.stato = stato;
	}

	
    
    
    public int getNumMatricola() {
		return numMatricola;
	}




	public void setNumMatricola(int numMatricola) {
		this.numMatricola = numMatricola;
	}




	public String getProprietario() {
		return proprietario;
	}




	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}




	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}




	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}




	public int getScadAssicurazione() {
		return scadAssicurazione;
	}




	public void setScadAssicurazione(int scadAssicurazione) {
		this.scadAssicurazione = scadAssicurazione;
	}




	public String getTarga() {
		return targa;
	}




	public void setTarga(String targa) {
		this.targa = targa;
	}




	public int getCilindrata() {
		return cilindrata;
	}




	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}




	public Stato getStato() {
		return stato;
	}


	public void setStato(Stato stato) {
		this.stato = stato;
	}




	public int compareTo(Object o) throws ClassCastException {
        	if(o instanceof Veicolo){
        		Veicolo v=(Veicolo)o;
        return this.targa.compareTo(v.getTarga());
        	}
    	    		
    else throw new ClassCastException("il parametro non è un Veicolo");
    }
         
    public abstract void accelera ();
    
    public abstract void parti(int velocIniz);
    
    public boolean isAssicurato(int annoCorrente) {
		if(getScadAssicurazione()>=annoCorrente)
			return true;
		return false;
	}
    
   
} 
