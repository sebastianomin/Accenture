package it.accenture.concessionaria;



import java.util.Comparator;


public class ComparaTipoAuto implements Comparator<Object>{
	public int compare(Object o1, Object o2) throws ClassCastException {
		if(o1 instanceof Auto && o2 instanceof Auto ){
			Auto a1= (Auto)o1;
			Auto a2=(Auto)o2;
			if(a1.getTipo()=="utilitario" && a1.getTipo()!=a2.getTipo())
				return -1;
			if(a1.getTipo()=="familiare" && a2.getTipo()=="utilitario")
				return 1;
			if(a1.getTipo()=="familiare" && a2.getTipo()=="sportivo")
				return -1;
			if(a1.getTipo()=="familiare" && a2.getTipo()=="familiare")
				return 0;
			if(a1.getTipo()=="sportivo" && a2.getTipo()=="utilitario")
				return 1;
			if(a1.getTipo()=="sportivo" && a2.getTipo()=="sportivo")
				return 0;
		return 1;
		}
		else throw new ClassCastException("Il parametro del metodo compareTo non è un'Auto!");
	}
}
