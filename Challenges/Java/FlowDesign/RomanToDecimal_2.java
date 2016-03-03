package grossmann.tim.FlowDesign;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RomanToDecimal_2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String romanNumber = scanner.nextLine();
		scanner.close();

		char[] singleRomanChars = romanNumber.toCharArray();
		try {
			int[] singleDecInt = convertRomanDigitsToArabicNumbers(singleRomanChars);
			singleDecInt = applyNegationRule(singleDecInt);
			int finalDec = sum(singleDecInt);

			System.out.println(romanNumber + " -> " + finalDec);

		} catch (InputMismatchException e) {
			System.out.println("Wrong Input");
		}

	}

	private static int sum(int[] singleDecInt) {

		int sum = 0;
		for (int i : singleDecInt) {
			sum += i;
		}

		return sum;
	}

	private static int[] applyNegationRule(int[] singleDecInt) {

		for (int i = 0; i < singleDecInt.length - 1; i++) {
			if (singleDecInt[i + 1] > singleDecInt[i]) {
				singleDecInt[i] = singleDecInt[i] * -1;
			}
		}

		return singleDecInt;
	}

	private static int[] convertRomanDigitsToArabicNumbers(char[] singleRomanChars) throws InputMismatchException {

		int[] arabicDigits = new int[singleRomanChars.length];

		for (int i = 0; i < singleRomanChars.length; i++) {
			switch (singleRomanChars[i]) {
			case 'I':
				arabicDigits[i] = 1;
				break;
			case 'V':
				arabicDigits[i] = 5;
				break;
			case 'X':
				arabicDigits[i] = 10;
				break;
			case 'L':
				arabicDigits[i] = 50;
				break;
			case 'C':
				arabicDigits[i] = 100;
				break;
			case 'D':
				arabicDigits[i] = 500;
				break;
			case 'M':
				arabicDigits[i] = 1000;
				break;
			default:
				throw new InputMismatchException();

			}

		}

		return arabicDigits;
	}

}
