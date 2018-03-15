package it.accenture.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileArray {

	final static int SLOT = 5;

	final static String PATH = "sommaArray.txt";

	public static void main(String args[]) throws IOException {

		riempiSalva();
		stampa();
		// readFile();
	}

	private static void riempiSalva() {

		Scanner input = new Scanner(System.in);

		int arrayA[] = new int[SLOT];
		int arrayB[] = new int[SLOT];

		for (int i = 0; i < arrayA.length; i++) {
			System.out.print("A - inserisci " + (i + 1) + "° numero:");
			arrayA[i] = input.nextInt();
		}

		for (int i = 0; i < arrayB.length; i++) {
			System.out.print("B - inserisci " + (i + 1) + "° numero:");
			arrayB[i] = input.nextInt();
		}
		input.close();

		try {
			File file = new File(PATH);

			if (file.exists())
				System.out.println("Il file " + PATH + " esiste");
			else if (file.createNewFile())
				System.out.println("Il file " + PATH + " è stato creato");
			else
				System.out.println("Il file " + PATH + " non può essere creato");

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < SLOT; i++) {

				bw.write((arrayA[i] + arrayB[i]) + " ");
			}
			System.out.println("Il file è stato compilato.");
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void stampa() {

		int[] arrayT = new int[SLOT];
		int i = 0;
		String string = "";

		try {
			FileReader fr = new FileReader(PATH);
			BufferedReader br = new BufferedReader(fr);

			while (string != null) {
				string = br.readLine();
				if (string != null) {
					String[] split = string.split(" ");
					for (int y = 0; y < split.length; y++) {
						arrayT[i] = Integer.parseInt(split[y].trim());
						i++;
					}
				}
			}

			for (i = 0; i < arrayT.length; i++)
				System.out.print(arrayT[i] + " ");

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private static void readFile() throws IOException {

		try {
			FileReader f = new FileReader(PATH);
			BufferedReader br = new BufferedReader(f);

			String string;

			while (true) {
				string = br.readLine();
				if (string == null)
					break;
				System.out.println(string);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
