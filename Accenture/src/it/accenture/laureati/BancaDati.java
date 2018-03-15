package it.accenture.laureati;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

public class BancaDati {

  private LinkedList<Laureato> laureati;
  private Vector<Relatore> relatori;
  private Vector<CorsoDiLaurea> corsi;
  private LinkedList<Laurea> lauree;

  public BancaDati () {
    laureati = new LinkedList<Laureato>();
    relatori = new Vector<Relatore>();
    corsi = new Vector<CorsoDiLaurea>();
    lauree = new LinkedList<Laurea>();
  }

  // metodi usati per "popolare" gli insiemi
  public void addLaureato(Laureato l) {
    laureati.add(l);
  }

  public void addRelatore(Relatore r) {
    relatori.add(r);
  }

  public void addCorsoDiLaurea(CorsoDiLaurea c) {
    corsi.add(c);
  }

  public void addLaurea(Laurea l) {
    lauree.add(l);
  }

  // seguono i metodi richiesti:

  // primo metodo:
  public int numeroLaureati(int a, String d) {
    // trovo il codice del c.d.l. con denominazione d
    int codiceCdL = -1;
    for (int i=0; i<corsi.size(); i++) {
	  CorsoDiLaurea x = corsi.get(i);
	  if (x.getDenominazione().equals(d)){
	    codiceCdL = x.getCodiceCdL();
	    break;
	  }
	}
    if (codiceCdL == -1) {
	  System.out.println("Errore: corso di laurea inesistente");
	  return -1;
	}
    int numeroLauree = 0;
    ListIterator<Laurea> iter = lauree.listIterator();
    while (iter.hasNext()) {
	  Laurea x = iter.next();
	  int anno = x.getDataSeduta().getYear();
	  int codice = x.getCodiceCdL();
	  if (anno == a && codice == codiceCdL) {
	    numeroLauree++;
	  }
	}
    return numeroLauree;
  }


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

  // metodo aggiunto per semplificare il secondo metodo:
  private String cognome(int codiceRelatore) {
    String c = null;
    for (int i=0; i<relatori.size(); i++) {
	  Relatore r = relatori.get(i);
	  if(r.getCodiceRelatore() == codiceRelatore) {
	    c = r.getCognome();
	    break;
	  }
	}
    return c;
  }


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