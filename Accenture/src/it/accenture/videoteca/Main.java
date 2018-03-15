package it.accenture.videoteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner in = new Scanner(System.in);

	private static List<Film> filmDisponibili = new ArrayList<>();

	private static List<Film> filmNoleggiati = new ArrayList<>();

	public static void main(String[] args) {

		popolaListFilm();

		System.out.println("***NOLEGGIO***");

		boolean exit = false;

		do {
			try {
				System.out.println("------------------");
				System.out.println("1 - Noleggia film");
				System.out.println("2 - Restituisci film");
				System.out.println("3 - I miei film");
				System.out.println("4 - Termina programma");

				int scelta = in.nextInt();
				in.nextLine();

				switch (scelta) {

				case 1:
					noleggiaFilm();
					break;

				case 2:
					restituisciFilm();
					break;

				case 3:
					stampaFilmNoleggiati();
					break;

				case 4:
					System.out.println("***ARRIVEDERCI***");
					exit = true;
					break;

				default:
					System.out.println("Seleziona un numero valido!");
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Seleziona un numero valido!");
			} catch (InputMismatchException e) {
				System.out.println("Seleziona un carattere valido!");
				in.next();
			}
		} while (!exit);

	}

	private static void popolaListFilm() {

		Film f1 = new Film("Revenant - Redivivo", 2016);
		Film f2 = new Film("Scarface", 1984);
		Film f3 = new Film("Quei bravi ragazzi", 1990);
		Film f4 = new Film("Kill Bill", 2003);
		Film f5 = new Film("Pulp Fiction", 1994);

		Attore a1 = new Attore("Leonardo", "Di caprio");
		Attore a2 = new Attore("Al", "Pacino");
		Attore a3 = new Attore("Robert", "De Niro");
		Attore a4 = new Attore("Uma", "Thurman");
		Attore a5 = new Attore("Samuel Lee", "Jackson");
		Attore a6 = new Attore("John", "Travolta");
		Attore a7 = new Attore("Ray", "Liotta");

		Regista r1 = new Regista("Alejandro González", "Iñárritu");
		Regista r2 = new Regista("Brian", "De Palma");
		Regista r3 = new Regista("Martin", "Scorsese");
		Regista r4 = new Regista("Quentin", "Tarantino");

		Categoria c1 = new Categoria("Drammatico");
		Categoria c2 = new Categoria("Thriller");

		f1.setRegista(r1);
		f1.setCategoria(c1);
		f1.getListAttori().add(a1);
//		esempio di relazione bidirezionale
//		r1.getListFilm().add(f1);
//		c1.getListFilm().add(f1);
//		a1.getListFilm().add(f1);
		f2.setRegista(r2);
		f2.setCategoria(c1);
		f2.getListAttori().add(a2);
		f3.setRegista(r3);
		f3.setCategoria(c1);
		f3.getListAttori().add(a3);
		f3.getListAttori().add(a5);
		f3.getListAttori().add(a7);
		f4.setRegista(r4);
		f4.setCategoria(c2);
		f4.getListAttori().add(a4);
		f5.setRegista(r4);
		f5.setCategoria(c2);
		f5.getListAttori().add(a5);
		f5.getListAttori().add(a6);

		filmDisponibili.add(f1);
		filmDisponibili.add(f2);
		filmDisponibili.add(f3);
		filmDisponibili.add(f4);
		filmDisponibili.add(f5);

	}

	private static void noleggiaFilm() {
		System.out.println("------------------");
		if (filmDisponibili.isEmpty()) {
			System.out.println("Film esauriti...Riprova tra un pò!");
			return;
		}
		int index = 1;
		for (Film film : filmDisponibili) {
			System.out.println(index + " - " + film);
			index++;
		}
		System.out.println("");
		System.out.println("Seleziona il film da noleggiare, o premi 0 per tornare al menu principale");
		int el = in.nextInt();
		in.nextLine();
		if (el == 0)
			return;

		Film film = filmDisponibili.remove(el - 1);
		filmNoleggiati.add(film);

		System.out.println("Film noleggiato: " + film.getTitolo());
	}

	private static void restituisciFilm() {
		System.out.println("------------------");
		if (filmNoleggiati.isEmpty()) {
			System.out.println("Non hai film da restituire!");
			return;
		}
		int index = 1;
		for (Film f : filmNoleggiati) {
			System.out.println(index + " - " + f);
			index++;
		}
		System.out.println("");
		System.out.println("Seleziona il film da restituire, o premi 0 per tornare al menu principale");
		int el = in.nextInt();
		in.nextLine();
		if (el == 0)
			return;

		Film f = filmNoleggiati.remove(el - 1);

		filmDisponibili.add(f);

		System.out.println("Film restituito: " + f.getTitolo());
	}

	private static void stampaFilmNoleggiati() {
		System.out.println("------------------");
		if (filmNoleggiati.isEmpty()) {
			System.out.println("Non hai film in noleggio!");
			return;
		}
		filmNoleggiati.forEach(System.out::println);
	}

}
