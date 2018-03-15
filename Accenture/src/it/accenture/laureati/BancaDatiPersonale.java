	package it.accenture.laureati;

	import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
	import java.util.ListIterator;
	import java.util.Vector;

	public class BancaDatiPersonale {

	  private ArrayList<Laureato> laureati;
	  private ArrayList<Relatore> relatori;
	  private ArrayList<CorsoDiLaurea> corsi;
	  private ArrayList<Laurea> lauree;

	  public BancaDatiPersonale () {
	    laureati = new ArrayList<Laureato>();
	    relatori = new ArrayList<Relatore>();
	    corsi = new ArrayList<CorsoDiLaurea>();
	    lauree = new ArrayList<Laurea>();
	  }
	  

	

	  // seguono i metodi richiesti:
	  
	  public ArrayList<Laureato> getLaureati() {
		return laureati;
	}




	public void setLaureati(ArrayList<Laureato> laureati) {
		this.laureati = laureati;
	}




	public ArrayList<Relatore> getRelatori() {
		return relatori;
	}




	public void setRelatori(ArrayList<Relatore> relatori) {
		this.relatori = relatori;
	}




	public ArrayList<CorsoDiLaurea> getCorsi() {
		return corsi;
	}




	public void setCorsi(ArrayList<CorsoDiLaurea> corsi) {
		this.corsi = corsi;
	}




	public ArrayList<Laurea> getLauree() {
		return lauree;
	}




	public void setLauree(ArrayList<Laurea> lauree) {
		this.lauree = lauree;
	}




	/*Restituisce il numero totale di lauree conseguite nell’anno a per il corso di laurea con
denominazione d.
	   * primo metodo
	   */
	  public int numeroLaureati(int a, String d) {

	    // trovo il codice del c.d.l. con denominazione d
		  int codiceCdl=-1;
		  int numeroLauree = 0;
	    for (CorsoDiLaurea corsoDiLaurea : corsi) {
		  if (corsoDiLaurea.getDenominazione().equals(d)){
		    codiceCdl = corsoDiLaurea.getCodiceCdL();
		    for (Laurea  l : lauree) {
		    	GregorianCalendar ca=new GregorianCalendar();
				  ca.setTime(l.getDataSeduta());
				  int anno = ca.get(Calendar.YEAR);
				  System.out.println(anno);
				  int codice = l.getCodiceCdL();
				  if (anno == a && codice == codiceCdl) {
				    numeroLauree++;
				  }
		    	
		  }
		}
	    
	    
	    
	   // ListIterator<Laurea> iter = lauree.listIterator();
	  //  while (iter.hasNext()) {
		 // Laurea x = iter.next();
		  
		}
	    return numeroLauree;
	  }
	  /*Restituisce i titoli di tutte le tesi di laurea 
	   * che hanno un relatore con cognome c. Se esistono più relatori con cognome c, il metodo dovrà restituire 
	   * i titoli delle tesi di tutti questi relatori.
	   * secondo metodo:
	   */
 
	  // secondo metodo:
	  public ArrayList<String> tesiRelatori(String c) {
	    ArrayList<String> titoli = new ArrayList<String>();
	    int codiceRelatore=0;
	    for(Relatore r:relatori) {
	    	if(r.getCognome().equals(c)) {
	    		codiceRelatore=r.getCodiceRelatore();
	    		
	          for(Laurea l:lauree) {
	          ArrayList<Integer> codiciRelatori = l.getCodiciRelatori();
	      // cerco c tra i relatori della tesi di laurea x
		    for (Integer integer : codiciRelatori) {
		           if (codiceRelatore==integer) {
			       titoli.add(l.getTitoloTesi());
			}}}  
		  }
		}
		return titoli;
	  }
	  /*Restituisce la lista di tutti i relatori che prestano servizio 
	   * presso la facoltà f e che sono stati correlatori di almeno 
	   * un “relatore esterno”. Due relatori sono detti “correlatori” 
	   * se sono stati relatori di una stessa tesi di laurea.
	   */



	  // terzo metodo:
	  public LinkedList<Relatore> correlatoriEsterni(String f) {
	    LinkedList<Relatore> risultato = new LinkedList<Relatore>();
	    for (int i=0; i<relatori.size(); i++) {
		  Relatore x = relatori.get(i);
		  int codiceX = x.getCodiceRelatore();
		  // trovo i correlatori di x
		  if (x.getFacolta().equals(f)) {
	        ListIterator<Laurea> it = lauree.listIterator();
	        while (it.hasNext()) {
	          Laurea l = it.next();
		    // per ogni tesi di laurea
		    ArrayList<Integer> codiciRelatori =
		                                     l.getCodiciRelatori();
	          boolean correlatore = false;
		    //se tra i relatori figura x, verifico se figura anche un relatore esterno
	          if (codiciRelatori.contains(codiceX)) {
			    ListIterator<Integer> itCodici =
			                         codiciRelatori.listIterator();
			    while (itCodici.hasNext()) {
	              int cod = itCodici.next();
	              if (relatoreEsterno(cod)) {
			        correlatore = true;
				    break;
				  }
			    }
			  }
	          if (correlatore) {
			    risultato.add(x);
			  }
		    }
	      }
		}
		return risultato;
	  }

	  // metodo aggiuntivo usato dal terzo metodo:
	  private boolean relatoreEsterno(int cod) {
	    for (int i=0; i<relatori.size(); i++) {
		  Relatore x = relatori.get(i);
		  if (x.getCodiceRelatore() == cod && x.getFacolta() == null) {
		    return true;
		  }
		}
	    return false;
	  }
     /*Restituisce la lista di tutti i laureati che hanno conseguito
      *  una laurea primo livello con una certa denominazione ed una 
      *  di secondo livello con una denominazione diversa (per esempio,
      *   laurea di primo livello in “Ingegneria Gestionale” e 
      *   laurea di secondo livello in “Ingegneria Informatica”).
      * 
      */

	  // quarto metodo:
	  public LinkedList<Laureato> studentiImprevedibili() {
	    LinkedList<Laureato> risultato =
	                               new LinkedList<Laureato>();
	    ListIterator<Laureato> itLaureati =
	                               laureati.listIterator();
	    while (itLaureati.hasNext()) {
	      Laureato laureato = itLaureati.next();
	      String codiceLaureato = laureato.getCodiceFiscale();
	      // assumo che uno abbia al conseguito al pi� una
	      // laurea di primo livello ed una laurea di secondo livello
	      String denominazione1 = null;
	      String denominazione2 = null;
	      ListIterator<Laurea> itLauree = lauree.listIterator();
	      // cerco le lauree conseguite dallo studente con 
		// codice fiscale codiceLaureato
		while (itLauree.hasNext()) {
	        Laurea laurea = itLauree.next();
	        // se trovo una laurea conseguita da codiceLaureato,
		  // verifico se questa sia di primo o di secondo livello
		  if (laurea.getCodiceFiscale().equals(codiceLaureato)) {
		      int codiceCdL = laurea.getCodiceCdL();
		      // devo risalire al corso di laurea per verificare
		      // se si tratti di un corso di laurea specialistico
			for (int i=0; i<corsi.size(); i++) {
	            CorsoDiLaurea corso = corsi.get(i);
	            if (corso.getCodiceCdL() == codiceCdL) {
	              if (corso.getSpecialistica() == true) {
	                denominazione2 = corso.getDenominazione();
	              }
	              else {
				    denominazione1 = corso.getDenominazione();
				  }
			    }
	          }
		    }
		  }
		  if (denominazione2 != null &&
		      denominazione1 != denominazione2) {
		    risultato.add(laureato);
		  }
		}
	    return risultato;
	  }
   /*Restituisce la denominazione del corso di laurea i cui laureati,
    *  nell’anno a, hanno conseguito in media il voto di laurea più
    *   alto. Ai fini del calcolo della media si consideri il 
    *   voto “110 e lode” uguale a 113. 
    * 
    */

	  // quinto metodo:
	  public String corsoMiglioreAnno(int a) {
	    String denominazioneMigliore = null;
	    double mediaMigliore = 0;
	    for (int i=0; i<corsi.size(); i++) {
		  CorsoDiLaurea corso = corsi.get(i);
		  int codiceCorso = corso.getCodiceCdL();
	      // numero di lauree relative al corso di laurea "codiceCorso"
	      int numeroLauree = 0;
		double sommaVoti = 0;
	      ListIterator<Laurea> itLauree = lauree.listIterator();
	      while (itLauree.hasNext()) {
		    Laurea laurea = itLauree.next();
		    if (laurea.getCodiceCdL() == codiceCorso &&
		        laurea.getDataSeduta().getYear() == a) {
	          	numeroLauree++;
	          	int votoLaurea = laurea.getVoto();
	          	if (laurea.getLode()) {
				    votoLaurea += 3;
			}
		      sommaVoti += votoLaurea;
		    }
		}
		double mediaCdL = sommaVoti/numeroLauree;
		if (mediaCdL > mediaMigliore) {
		    mediaMigliore = mediaCdL;
		    denominazioneMigliore = corso.getDenominazione();
		}
	    }
	    return denominazioneMigliore;
	  }
	}

