package grossmann.tim.FlowDesign;

import java.util.Scanner;

public class ROT13_4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String actualInput = scanner.nextLine();
		scanner.close();

		converToRot13(actualInput);
	}

	private static void converToRot13(String actualInput) {
		actualInput = actualInput.toUpperCase();
		String inputWithoutUmlauts = replaceUmlauts(actualInput);
		char[] singleChars = inputWithoutUmlauts.toCharArray();
		char[] encodedChars = rotateChars(singleChars);

		printOut(encodedChars);
	}

	private static char[] rotateChars(char[] singleChars) {

		int[] asciiValues = getAsciiValues(singleChars);
		int[] shiftedAsciis = shiftBy13(asciiValues);
		char[] encodedChars = convertToEncodedChars(shiftedAsciis);

		return encodedChars;
	}

	private static char[] convertToEncodedChars(int[] shiftedAsciis) {

		char[] encodedChars = new char[shiftedAsciis.length];

		for (int i = 0; i < shiftedAsciis.length; i++) {
			encodedChars[i] = (char) shiftedAsciis[i];
		}

		return encodedChars;
	}

	private static int[] shiftBy13(int[] asciiValues) {

		int[] shiftedAsciis = new int[asciiValues.length];

		for (int i = 0; i < asciiValues.length; i++) {

			if (asciiValues[i] > 64 && asciiValues[i] < 91) {
				shiftedAsciis[i] = asciiValues[i] + 13;
				if (shiftedAsciis[i] > 90) {
					shiftedAsciis[i] -= 26;
				}
			}

		}

		return shiftedAsciis;
	}

	private static int[] getAsciiValues(char[] singleChars) {

		int[] asciiValues = new int[singleChars.length];

		for (int i = 0; i < singleChars.length; i++) {
			asciiValues[i] = (int) singleChars[i];
		}

		return asciiValues;
	}

	private static String replaceUmlauts(String actualInput) {
		String inputWithoutUmlauts = actualInput;

		inputWithoutUmlauts = inputWithoutUmlauts.replaceAll("Ä", "AE");
		inputWithoutUmlauts = inputWithoutUmlauts.replaceAll("Ö", "OE");
		inputWithoutUmlauts = inputWithoutUmlauts.replaceAll("Ü", "UE");
		inputWithoutUmlauts = inputWithoutUmlauts.replaceAll("ß", "SS");

		return inputWithoutUmlauts;
	}

	private static void printOut(char[] encodedChars) {
		String output = new String(encodedChars);
		System.out.println(output);
	}

}
