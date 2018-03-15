package it.accenture.thread.runnable;

public class ImplementazioneThread {
	  
	  public static void main(String[] args) {
	  
	    //istanzio l'oggetto della classe che estende
	    //l'interfaccia Runnable
	    EsempioThread r = new EsempioThread();
	  
	    //Creo il Thread passando al costruttore della classe
	    //Thread del Java l'oggetto della classe
	    //che implementa l'interfaccia Runnable
	  
	    Thread nuovoThread = new Thread(r);
	    nuovoThread.start();
	  }
	}