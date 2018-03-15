package it.accenture.concessionaria;


import java.util.Comparator;

 public class ComparaCilindrata implements Comparator{
	
	public int compare(Object o1, Object o2) throws ClassCastException{
		if(o1 instanceof Veicolo && o2 instanceof Veicolo){
    	Veicolo v1 = (Veicolo)o1;
    	Veicolo v2 = (Veicolo)o2;
    	if(v1.getCilindrata()>v2.getCilindrata())
			return 1;
		if(v1.getCilindrata()<v2.getCilindrata())
			return -1;
		return 0;
		}
		else throw new ClassCastException("Uno dei parametri non è un'auto!");
     }
    	
    }
