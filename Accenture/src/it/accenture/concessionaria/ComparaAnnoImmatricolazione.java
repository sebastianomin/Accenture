package it.accenture.concessionaria;

import java.util.Comparator;

public class ComparaAnnoImmatricolazione implements Comparator {

	public int compare(Object arg0, Object arg1) throws ClassCastException {
		if(arg0 instanceof Auto && arg1 instanceof Auto){
		Auto auto1=(Auto)arg0;
		Auto auto2=(Auto)arg1;
		if(auto1.getAnnoImmatricolazione()>auto2.getAnnoImmatricolazione())
			return -1;
		if(auto1.getAnnoImmatricolazione()==auto2.getAnnoImmatricolazione())
			return 0;
		return 1;
	}
		else throw new ClassCastException("Una dei parametri non è un'auto!");
		}

}
