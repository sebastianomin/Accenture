package it.accenture.thread;

	public class EsempioThread extends Thread {
		  public void run() {
		    int n;
		    for(n=0;n<6;n++) {
		      System.out.println("L'indice n è uguale a : " + n);
		    }
		  }
	
}
