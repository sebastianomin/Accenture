package it.milano;

public class concatena {
	public static void main(String[] args) {
		char[]c= {'1','a','2','b','3','4'};
		String conc="";
		
		for (int i = 0; i < c.length; i++) {
			switch (c[i]){
			case '0':conc+=c[i];break;
			case '1':conc+=c[i];break;
			case '2':conc+=c[i];break;
			case '3':conc+=c[i];break;
			case '4':conc+=c[i];break;
			case '5':conc+=c[i];break;
			case '6':conc+=c[i];break;
			case '7':conc+=c[i];break;
			case '8':conc+=c[i];break;
			case '9':conc+=c[i];break;
			}
			
		}
		System.out.println(conc);
		
	}

}
