package it.accenture.concessionaria;

public class TestVeicolo {

    public static void main(String[] arg) {
    
    GestioneVeicoli gest=new GestioneVeicoli();
    
    Veicolo a=new Auto(123, "Verdi", 2010, 2018, "aa 207 bb ",1500,Stato.DISPONIBILE, "sportiva",5);
	 a.parti(1);
	 a.accelera();
	 gest.inserisciVeicolo(a);
	 
	Veicolo a1=new Auto(100, "Rossi", 2011, 2019, "ab 100 bb ",1400,Stato.VENDUTO, "lusso",15);
	 a1.parti(2);
	 a1.accelera();
	 gest.inserisciVeicolo(a1);
	 
	Veicolo a2=new Auto(101, "Neri", 2011, 2019, "ab 200 zz ",1200,Stato.IN_CONSEGNA, "familiare",5);
	 a2.parti(3);
	 a2.accelera();
	 gest.inserisciVeicolo(a2);
	
	Veicolo c = new Camion(101, "Bova", 2011, 2019, "ab 200 zz ",1200,Stato.IN_CONSEGNA, 4,5);
	 c.parti(4);
	 c.accelera();
	 gest.inserisciVeicolo(c);
	 
	Veicolo m =new Moto(101, "Jobs", 2011, 2019, "ab 200 zz ",1200,Stato.IN_CONSEGNA, 2,5);
	 m.parti(5);
	 m.accelera();
	 gest.inserisciVeicolo(m);
	
	 System.out.println("Lista veicoli ordinati per cilindrata");
	 System.out.println(gest.OrdinaVeicoliCilindrata());
	 System.out.println("/////////////////////////////////////");
	 
	 System.out.println("Lista auto disponibii ordinata per tipo");
	 System.out.println(gest.autoDisponibili());
	 System.out.println("/////////////////////////////////////");
	 
	 System.out.println("Lista veicoli ordinati per targa");
	 System.out.println(gest.VeicoliOrdinatiTarga());
	 System.out.println("/////////////////////////////////////");
	 
	 System.out.println("Veicolo con la targa più grande");
	 System.out.println(gest.veicoloTargaMax());
	 System.out.println("/////////////////////////////////////");
	
	 System.out.println("Veicolo con la cilindrata minima");
	 System.out.println(gest.veicoloCilindrataMin());
	 System.out.println("/////////////////////////////////////");

	 System.out.println("Lista di auto in ordine decrescente di immatricolazione");
	 System.out.println(gest.autoOrdineImmatricolazione());
	 
	 System.out.println("Lista dei veicoli assicurati");
	 System.out.println(gest.veicoliAssicurati(2008));
    }

}
