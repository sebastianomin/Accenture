package it.accenture.gestionedate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente {
    private String nome;
    private String cognome;
    private Date data;
	
    
    public Cliente(String nome, String cognome, int anno, int mese, int giorno) {
		this.nome = nome;
		this.cognome = cognome;
		
		GregorianCalendar g=new GregorianCalendar(anno,mese-1,giorno);
		
		data=g.getTime();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", data=" + data + "]";
	}
    
    
    
    
    
    
    
    
    
}
