package it.accenture.matematica;
//La ricorsione è una tecnica di programmazione 
//per eseguire operazioni che direttamente o 
//indirettamente richiamano se stessi
/*Nella ricorsione viene invocato un metodo mentre questo è in esecuzione. 
Il metodo che ne faccia uso si chiama metodo ricorsivo.
Quando un metodo ricorsivo invoca se stesso, la macchina virtuale Java esegue 
le stesse azioni che vengono eseguite quando viene invocato un metodo qualsiasi:

  sospende l’esecuzione del metodo invocante
  esegue il metodo invocato fino alla sua terminazione
  riprende l’esecuzione del metodo invocante dal punto in cui era stata sospeso.

*/

public class Ricorsione {
public static void main(String[] args) {
		
		int risultatoFinale=fattoriale(9);
		System.out.println(risultatoFinale);
		
	}
	static int fattoriale(int x) {
		int risultato = 0;
		if (x == 0) { // caso base
		risultato = 1;
		} else { // caso ricorsivo
		risultato = x * fattoriale(x-1);
		}
		return risultato;
		}

}
