package it.accenture.laureati;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

public class ProvaBancaDati {

  public static void main (String args[]) {

    BancaDatiPersonale b = new BancaDatiPersonale();

    CorsoDiLaurea c1 = new CorsoDiLaurea(100, "Ingegneria Gestionale", false);
    CorsoDiLaurea c2 = new CorsoDiLaurea(250, "Ingegneria Gestionale", true);
    CorsoDiLaurea c3 = new CorsoDiLaurea(120, "Ingegneria Informatica", false);
    CorsoDiLaurea c4 = new CorsoDiLaurea(230, "Ingegneria Informatica", true);

    Relatore r1 = new Relatore(10, "Mario", "Rossi", "Ingegneria");
    Relatore r2 = new Relatore(11, "Giuseppe", "Verdi", "Ingegneria");
    Relatore r3 = new Relatore(12, "Ugo", "Bianchi", null);

    Laureato l1 = new Laureato("XYZ001", "Maria", "Neri", 1985,3,5);
    Laureato l2 = new Laureato("PQR999", "Giulio", "Cesare",1977,4,12);

    Laurea laurea1 = new Laurea("XYZ001", 100, 110, false, 2002,15,12, "La programmazione orientata agli oggetti");
    laurea1.getCodiciRelatori().add(10);
    laurea1.getCodiciRelatori().add(11);
    laurea1.getCodiciRelatori().add(12);
   

    Laurea laurea2 = new Laurea("XYZ001", 100, 110, true, 2005,11,9, "Architetture orientate ai servizi");
    laurea2.getCodiciRelatori().add(11);

    Laurea laurea3 = new Laurea("PQR999", 100, 105, false, 2002,15,5, "Sistemi Peer-to-Peer");
    laurea3.getCodiciRelatori().add(12);

    // aggiungere altri dati per esercizio...

  b.getLaureati().add(l1);
   b.getLaureati().add(l2);
   
   
  b.getCorsi().add(c1);
  b.getCorsi().add(c2);
  b.getCorsi().add(c3);
  b.getCorsi().add(c4);
  
  b.getRelatori().add(r1);
  b.getRelatori().add(r2);
  b.getRelatori().add(r3);

    b.getLauree().add(laurea1);
    b.getLauree().add(laurea2);
    b.getLauree().add(laurea3);
    

    int numeroLauree = b.numeroLaureati(2003, "Ingegneria Gestionale");

    System.out.println("Numero lauree = "+numeroLauree);
    
    ArrayList <String> listaTesi=b.tesiRelatori("Rossi");
    for (String string : listaTesi) {
    	System.out.println(string);
		
	}

    // provare gli altri metodi...

  }

}