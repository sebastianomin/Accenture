package it.accenture.giochi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Impiccato {

	static String parolaFinale;
	static char[] parolaFinaleChar;
	static char[] parolaHidden;
	static int tentativi;
	static boolean indovinato;
	static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		gioca();
	}

	private static void gioca() {
		parolaFinale = scegliParola();
		parolaFinaleChar = parolaFinale.toCharArray();
		parolaHidden = parolaFinale.replaceAll(".", "*").toCharArray();
		tentativi = 6;
		indovinato = false;
		System.out.println("---L'IMPICCATO---");
		do {
			stampaParola();
			System.out.println("1. Inserisci lettera. Hai ancora " + tentativi + " tentativi. \n2. Dai la soluzione");
			int res = input.nextInt();
			input.nextLine();
			if (res == 1)
				indovinaLettera();
			if (res == 2)
				daiSoluzione();
			checkParola();
		} while (!indovinato && tentativi > 0);
		if (tentativi == 0)
			System.out.println("Hai perso! -_-");
		System.out.println("Rigiocare? y/n");
		char charAt = input.nextLine().toLowerCase().charAt(0);
		if (charAt == 'y') {
			tentativi = 6;
			gioca();
		} else
			System.out.println("E'stato un piacere. Bye");
	}

	private static String scegliParola() {
		String[] parole = { "Giardino", "Casa", "Mobile", "Telefono", "Strada", "Termosifone", "Caricabatteria" };
		Random random = new Random();
		int pos = random.nextInt(parole.length);
		String parola = parole[pos].toLowerCase();
		return parola;
	}

	private static void indovinaLettera() {
		System.out.println("Scrivi la lettera.");
		char charAt = input.nextLine().charAt(0);
		boolean found = false;
		for (int i = 0; i < parolaFinaleChar.length; i++) {
			if (parolaFinaleChar[i] == charAt) {
				parolaHidden[i] = charAt;
				found = true;
			}
		}
		if (!found) {
			tentativi--;
			System.out.println("Lettera non presente!");
		}
	}

	private static void daiSoluzione() {
		System.out.println("Scrivi la risposta.");
		String soluzione = input.nextLine();
		if (parolaFinale.equals(soluzione)) {
			indovinato = true;
			System.out.println("Complimenti! Hai indovinato la parola! -> " + parolaFinale);
		} else {
			System.out.println("Risposta sbagliata.");
			tentativi--;
		}
	}

	private static void checkParola() {
		if (Arrays.equals(parolaHidden, parolaFinaleChar)) {
			System.out.println("Complimenti! Hai indovinato la parola! -> " + parolaFinale);
			indovinato = true;
		}
	}

	private static void stampaParola() {
		System.out.println(parolaHidden);
	}

}

