package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import model.TuringMachine;

public class Main {

	static TuringMachine turingMachine;
	private static final String ARCHIVO_NOMBRE = "data" + File.separator + "input.txt";

	public static void main(String[] args) throws IOException {

		BufferedWriter out = null;
		BufferedWriter bw = null;
		out = new BufferedWriter(new FileWriter("data" + File.separator + "resultado.txt"));
		BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_NOMBRE));
		long inicio = System.currentTimeMillis();
		String input = null;
		input = br.readLine();

		while (input != null) {

			turingMachine = new TuringMachine();

			int nextInstruction = 0;
			char head;
			char action;
			char character;

			while (nextInstruction < input.length()) {
		
				head = (input.charAt(nextInstruction));
				action = (input.charAt(nextInstruction + 1));

				if (action == '0') {
					out.write(turingMachine.read(head));
					out.newLine();
					
					nextInstruction += 2;
				} else if (action == '1') {
					character = (input.charAt(nextInstruction + 2));
					if (head == '0') {
						turingMachine.addFirst(character);
					} else if (head == '1') {
						turingMachine.addMedium(character);
					} else if (head == '2') {
						turingMachine.addLast(character);
					}
					nextInstruction += 3;
					

				} else if (action == '2') {
					turingMachine.remove(head);
					nextInstruction += 2;
				} else {
					System.out.println("Accion Invalida " + action);
				}
			}

			long fin = System.currentTimeMillis() / 1000;
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(fin + " milliseconds");
			input = br.readLine();
		}
		br.close();
		out.close();
		bw.close();
	}
}
