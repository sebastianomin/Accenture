package it.accenture.garage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Garage {
	private final static int POSTI = 15;

	private static Scanner input;

	private static List<Veicolo> garage;

	public static void main(String[] args) {

		int scelta = 0;

		input = new Scanner(System.in);

		garage = new ArrayList<>(POSTI);

		System.out.println("****BENVENUTO IN GARAGE MANAGER!****");
		System.out.println("Cosa vuoi fare?");

		do {
			try {
				System.out.println("------------------");
				System.out.println("1 - Inserisci auto");
				System.out.println("2 - Inserisci furgone");
				System.out.println("3 - Inserisci moto");
				System.out.println("4 - Libera posto");
				System.out.println("5 - Stampa riepilogo");
				System.out.println("6 - Termina programma");
				System.out.println("7- ordina i veicoli per anno");

				scelta = input.nextInt();
				input.nextLine();

				switch (scelta) {

				case 1:
					inserisciAuto();
					break;

				case 2:
					inserisciFurgone();
					break;

				case 3:
					inserisciMoto();
					break;

				case 4:
					liberaPosto();
					break;

				case 5:
					stampaRiepilogo();
					break;

				case 6:
					input.close();
					System.out.println("***GRAZIE PER AVER USATO GARAGE MANAGER***");
					break;
				case 7: ordinaPerAnno();
				}

			} catch (InputMismatchException e) {
				System.out.println("Seleziona un carattere valido!");
				input.next();
			}
		} while (scelta != 6);

	}

	private static void ordinaPerAnno() {
		Collections.sort(garage);
		System.out.println(garage);
			
		
	}

	private static void inserisciAuto() {

		Auto auto = new Auto();

		System.out.println("***Inserimento auto***");
		System.out.println("Marca: ");
		auto.setMarca(input.nextLine());
		System.out.println("Anno: ");
		auto.setAnno(input.nextInt());
		input.nextLine();
		System.out.println("Cilindrata: ");
		auto.setCilindrata(input.nextInt());
		input.nextLine();
		System.out.println("Porte: ");
		auto.setPorte(input.nextInt());
		input.nextLine();
		System.out.println("Alimentazione");
		auto.setAlimentazione(input.nextLine());
		System.out.println("");

		garage.add(auto);

		System.out.println("Auto parcheggiata");
		System.out.println("");

	}

	private static void inserisciFurgone() {

		Furgone furgone = new Furgone();

		System.out.println("***Inserimento furgone***");
		System.out.println("Marca: ");
		furgone.setMarca(input.nextLine());
		System.out.println("Anno: ");
		furgone.setAnno(input.nextInt());
		input.nextLine();
		System.out.println("Cilindrata: ");
		furgone.setCilindrata(input.nextInt());
		input.nextLine();
		System.out.println("Capacità: ");
		furgone.setCapacita(input.nextInt());
		input.nextLine();
		System.out.println("");

		garage.add(furgone);

		System.out.println("Furgone parcheggiato!");
		System.out.println("");

	}

	private static void inserisciMoto() {

		Moto moto = new Moto();

		System.out.println("***Inserimento moto***");
		System.out.println("Marca: ");
		moto.setMarca(input.nextLine());
		System.out.println("Anno: ");
		moto.setAnno(input.nextInt());
		input.nextLine();
		System.out.println("Cilindrata: ");
		moto.setCilindrata(input.nextInt());
		input.nextLine();
		System.out.println("Tempi: ");
		moto.setTempi(input.nextInt());
		input.nextLine();
		System.out.println("");

		garage.add(moto);

		System.out.println("Moto parcheggiata!");
		System.out.println("");

	}

	private static void liberaPosto() {

		if (!garage.isEmpty()) {
			for (Veicolo v : garage) {
				System.out.println(garage.indexOf(v) + 1 + " : " + v);
			}
			System.out.println("***Scegli posto da liberare***");
			int nextInt = input.nextInt();
			input.nextLine();
			garage.remove(nextInt - 1);

			System.out.println("Posto liberato!");
			System.out.println("");
		} else {
			System.out.println("***Il garage è vuoto***");
		}
	}

	private static void stampaRiepilogo() {

		if (!garage.isEmpty()) {
			System.out.println("***Riepilogo garage***");
			for (Veicolo v : garage) {
				System.out.println(v);
			}
			System.out.println("");
		} else {
			System.out.println("***Il garage è vuoto***");
		}
	}
}
