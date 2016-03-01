package hdm_Stuttgart.linearCongruentialGenerator;

import java.util.Scanner;

public class App {

	static int x = 1;
	static int a = 2;
	static int c = 3;
	static int m = 11;
	static boolean contains = false;
	static String output;
	static int width = 1;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {

			width = 1;
			contains = false;

			System.err.println("Linear Congruential Generator... x = (a * x + c) % m");

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

			System.out.print("StartValue x = ");
			x = scanner.nextInt();
			System.out.print("MultiplikationValue a = ");
			a = scanner.nextInt();
			System.out.print("ConstantValue c = ");
			c = scanner.nextInt();
			System.out.print("ModuloValue m = ");
			m = scanner.nextInt();
			System.out.println();

			output = Integer.toString(x);

			while (!contains) {
				int temp = ((a * x + c) % m);
				output += " " + temp;
				x = temp;
				contains = checkForLoop(output);
				width++;
			}

			System.out.println("Values are: " + output);

			printGraph();

		}

	}

	private static boolean checkForLoop(String output) {

		String[] numbersOfO = output.split(" ");

		if (numbersOfO[0].equals(numbersOfO[numbersOfO.length - 1])) {
			return true;
		} else if (numbersOfO[numbersOfO.length - 2].equals(numbersOfO[numbersOfO.length - 1])) {
			return true;
		} else {
			return false;
		}
	}

	private static void printGraph() {
		String[] numbersString = output.split(" ");
		int[] numbers = new int[numbersString.length];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numbersString[i]);
		}

		String[][] field = new String[m][width];

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = "-----";
			}
		}

		int counter = 0;

		for (int i = 0; i < width; i++) {
			if (m != 1) {
				field[(m - 1) - numbers[i]][counter++] = "--X--";
			} else {
				System.err.println("Please input valid Values!");
			}
		}
		
		printField(field);

		System.out.println();
		System.out.println();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}

	}

	private static void printField(String[][] field) {

		int num = 0;

		for (int i = 0; i < field.length; i++) {
			System.out.printf("%3d|", ((m - 1) - num));
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
			num++;
		}

		System.out.print("   |");

		int num2 = 1;

		for (int i = 0; i < field[1].length; i++) {
			System.out.printf("%3d  ", num2++);
		}
	}
}
