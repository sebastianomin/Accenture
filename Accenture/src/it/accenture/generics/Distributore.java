package it.accenture.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distributore {

	private static List<Prodotto<Tabacchi>> listTabacchi;
	private static List<Prodotto<Snack>> listSnack;
	private static List<Prodotto<Bevande>> listBevande;
	private static List<Prodotto<Ricariche>> listRicariche;

	public static void main(String[] args) {

		System.out.println("***BENVENUTO***");

		riempiDistributore();

		slezionaProdotto();
	}

	private static void riempiDistributore() {

		listTabacchi = new ArrayList<>();
		listSnack = new ArrayList<>();
		listBevande = new ArrayList<>();
		listRicariche = new ArrayList<>();

		Prodotto<Tabacchi> p1 = new Prodotto<Tabacchi>(new Tabacchi("tabacco", "Marlboro Light", 5.9));
		Prodotto<Tabacchi> p2 = new Prodotto<Tabacchi>(new Tabacchi("sigarette", "Camel Blue", 5.0));
		Prodotto<Snack> p3 = new Prodotto<Snack>(new Snack("patatine", "SanCarlo", 1.2));
		Prodotto<Snack> p4 = new Prodotto<Snack>(new Snack("tramezzini", "prod. propria", 2.0));
		Prodotto<Bevande> p5 = new Prodotto<Bevande>(new Bevande("birra", "Heineken", 3.5));
		Prodotto<Bevande> p6 = new Prodotto<Bevande>(new Bevande("the", "San Benedetto", 2.5));
		Prodotto<Ricariche> p7 = new Prodotto<Ricariche>(new Ricariche("telefonica", "3", 10));
		Prodotto<Ricariche> p8 = new Prodotto<Ricariche>(new Ricariche("telefonica", "Tim", 10));

		listTabacchi.add(p1);
		listTabacchi.add(p2);
		listSnack.add(p3);
		listSnack.add(p4);
		listBevande.add(p5);
		listBevande.add(p6);
		listRicariche.add(p7);
		listRicariche.add(p8);

	}

	private static void slezionaProdotto() {

		while (true) {
			System.out.println("");
			System.out.println("Seleziona il prodotto");
			System.out.println("");
			System.out.println("1 - Tabacchi");
			System.out.println("2 - Snack");
			System.out.println("3 - Bevande");
			System.out.println("4 - Ricacriche");
			System.out.println("5 - Esci");

			Scanner scanner = new Scanner(System.in);

			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				int i = 1;
				for (Prodotto<Tabacchi> p : listTabacchi) {
					System.out.println(i + " - " + p.getProdotto());
					i++;
				}
				System.out.println("Seleziona il prodotto");
				int s = scanner.nextInt();
				scanner.nextLine();
				s = s - 1;
				System.out.println("");
				System.out.println("***Ecco il tuo prodotto : *** " + listTabacchi.get(s));

				break;
			case 2:
				i = 1;
				for (Prodotto<Snack> p : listSnack) {
					System.out.println(i + " - " + p.getProdotto());
					i++;
				}
				System.out.println("Seleziona il prodotto");
				s = scanner.nextInt();
				scanner.nextLine();
				s = s - 1;
				System.out.println("");
				System.out.println("***Ecco il tuo prodotto : *** " + listSnack.get(s));
                
				break;
			case 3:
				i = 1;
				for (Prodotto<Bevande> p : listBevande) {
					System.out.println(i + " - " + p.getProdotto());
					i++;
				}
				System.out.println("Seleziona il prodotto");
				s = scanner.nextInt();
				scanner.nextLine();
				s = s - 1;
				System.out.println("");
				System.out.println("***Ecco il tuo prodotto : *** " + listBevande.get(s));

				break;
			case 4:
				i = 1;
				for (Prodotto<Ricariche> p : listRicariche) {
					System.out.println(i + " - " + p.getProdotto());
					i++;
				}
				System.out.println("Seleziona il prodotto");
				s = scanner.nextInt();
				scanner.nextLine();
				s = s - 1;
				System.out.println("");
				System.out.println("***Ecco il tuo prodotto : *** " + listRicariche.get(s));

				break;
			case 5:
				System.out.println("");
				System.out.println("Arrivederci!");
				scanner.close();
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
}
