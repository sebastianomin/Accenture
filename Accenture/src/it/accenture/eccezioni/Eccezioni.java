package it.accenture.eccezioni;

public class Eccezioni {
	public static void main(String[] args) {
		String s=null; 
		try { 
		     int l = s.length(); 
		}catch (Exception e){ 
		     System.out.println("Attenzione, stai riferendo una stringa non inizializzata"); 
		}
	}
	
}

