package it.accenture.gestionedate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class CalendarioTest {
	public static void main(String[] args) {
		
		Cliente c=new Cliente("seb", "rossi", 2000, 12, 1);
		
		Date d=c.getData();
		
	GregorianCalendar ca=new GregorianCalendar();
	//gli passo la data d che ho creato prima per inserirla dentro al calendario
	ca.setTime(d);
	//tiro fuori il mese dal calendario
    int mese=ca.get(Calendar.MONTH);
    
    
    
    
	
		System.out.println(c.toString());
		
		GregorianCalendar cal=new GregorianCalendar();
		int meseAttuale=cal.get(Calendar.MONTH);
		System.out.println("Siamo nel mese di "+meseAttuale);
		
	}

}
