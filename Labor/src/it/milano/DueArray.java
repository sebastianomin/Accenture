package it.milano;

public class DueArray {
	public static void main(String[] args) {
		
	
	
	int []a= {1,2,3,4,5};
	int []b= {1,2,6,7,8,9};
	int conta=0;
	
	for (int i = 0; i < a.length; i++) {
		boolean trovato=false;
		for (int j = 0; j < b.length; j++) {
			if(a[i]==b[j]&&!trovato) {
				conta++;
				trovato=true;
			}
			
		}
		
	}
	
	int[]uguali=new int[conta];
	
	for (int i = 0; i < a.length; i++) {
		boolean trovato=false;
		for (int j = 0; j < b.length; j++) {
			if(a[i]==b[j]&&!trovato) {
				uguali[i]=a[i];
				trovato=true;
			}
			
		}
		
	}
	for (int i = 0; i < uguali.length; i++) {
		System.out.println(uguali[i]);
	}
	
	
	}
}
