package it.accenture.esempithread;

	/*
	 * Creo un Thread estendendo la classe Thread e ridefinendo il metodo run
	 * Per ogni Thread si ridefinisce il metodo run in cui c'è il codice che dovrà eseguire.
	 * Ad ogni modo bisogna richiamare il metodo start affinchè un Thread inizi la sua esecuzione
	 */
	public class Processo1 extends Thread {

  public static void main(String[] args) {
	    Processo1 p=new Processo1();
	    p.start();
	
}
		/*
		 * Ogni Thread deve definire obbligatoriamente il metodo seguente perché
		 * le operazioni che dovrà eseguire sono definite qui
		 */
		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				System.out.println ("Processo1 lanciato " + i + " volte.");
				try {
					/*
					 * Il metodo sleep() della classe Thread accetta un long rappresentante il
					 * tempo in millisecondi; tale metodo mette in attesa il Thread per il tempo settato
					 * per poi ripartire
					 */
					sleep(50);
				} catch (InterruptedException ex) {
					// Il metodo printStackTrace() stampa l'eccezione
					ex.printStackTrace();
				}
			}
		}
	}

