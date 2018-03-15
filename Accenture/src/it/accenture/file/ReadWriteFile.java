package it.accenture.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteFile {

	final static int slot = 5;

	public static void main(String args[]) throws IOException {

		leggiSalva();
		stampa();
	}

	public static void leggiSalva() throws IOException {

		Scanner input = new Scanner(System.in);

		int arrayA[] = new int[slot];
		int arrayB[] = new int[slot];

		for (int i = 0; i < arrayA.length; i++) {
			System.out.print("A - inserisci " + (i + 1) + "° numero:");
			arrayA[i] = input.nextInt();
		}

		for (int i = 0; i < arrayB.length; i++) {
			System.out.print("B - inserisci " + (i + 1) + "° numero:");
			arrayB[i] = input.nextInt();
		}

		try {
			PrintWriter writer = new PrintWriter(new FileWriter("sommaArray.txt"));

			for (int i = 0; i < slot; i++)
				writer.println(arrayA[i] + arrayB[i]);

			writer.flush();
			writer.close();
			input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void stampa() {

		int i = 0;
		String arrayT[] = new String[slot];
		String string = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("sommaArray.txt"));
			while (string != null) {
				string = reader.readLine();
				if (string != null) {
					arrayT[i] = string.trim();
					i++;
				}
			}

			for (i = 0; i < slot; i++)
				System.out.print(arrayT[i] + " ");

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
