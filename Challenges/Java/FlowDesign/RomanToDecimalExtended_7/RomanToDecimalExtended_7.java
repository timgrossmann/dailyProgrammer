package grossmann.tim.FlowDesign.RomanToDecimalExtended_7;

public class RomanToDecimalExtended_7 {

	public static void main(String[] args) {
		String romanNumber = args[0];

		char[] singleRomanChars = romanNumber.toCharArray();
		checkForValidRoman(singleRomanChars, () -> convertRomanToLatin(singleRomanChars),
				(errorMessage) -> printError(errorMessage));

	}

	private static void printError(String errorMessage) {
		System.out.println(errorMessage);
	}

	private static void printNumber(String romanNumber, int finalDec) {
		System.out.println(romanNumber + " -> " + finalDec);
	}

	private static void convertRomanToLatin(char[] singleRomanChars) {
		String romanNumber = new String(singleRomanChars);
		int[] singleDecInt = convertRomanDigitsToArabicNumbers(singleRomanChars);
		singleDecInt = applyNegationRule(singleDecInt);
		int finalDec = sum(singleDecInt);

		printNumber(romanNumber, finalDec);
	}

	private static void checkForValidRoman(char[] singleRomanChars, IValidRoman valid, IInvalidRoman invalid) {
		validateSyntax(singleRomanChars, () -> validateSemantic(singleRomanChars, () -> valid.call(),
				(errorMessage) -> printError(errorMessage)), (errorMessage) -> printError(errorMessage));
	}

	private static void validateSyntax(char[] singleRomanChars, IValidRoman valid, IInvalidRoman invalid) {
		if (new String(singleRomanChars).matches("[IVXLCDM]+")) {
			valid.call();
		} else {
			invalid.call("Syntax error.");
		}
	}

	private static void validateSemantic(char[] singleRomanChars, IValidRoman valid, IInvalidRoman invalid) {
		String romanWord = new String(singleRomanChars);

		if (romanWord.contains("IL") || romanWord.contains("IC") || romanWord.contains("ID") || romanWord.contains("IM")
				|| romanWord.contains("XD") || romanWord.contains("XM")) {
			invalid.call("Semantic error.");
		} else {
			valid.call();
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

	private static int[] convertRomanDigitsToArabicNumbers(char[] singleRomanChars) {

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
			}

		}

		return arabicDigits;
	}

}
