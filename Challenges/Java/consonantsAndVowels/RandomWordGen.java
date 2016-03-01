package consonantsAndVowels;

import java.util.Random;

public class RandomWordGen {

	private static final Random random = new Random();
	private static final char[] letters = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's',
			't', 'v', 'w', 'x', 'y', 'z' };
	private static final char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

	public static void genRandomWord(String string) {

		String output = "";
		boolean error = false;

		char[] charsInString = string.toCharArray();

		for (int i = 0; i < charsInString.length; i++) {
			switch (Character.toLowerCase(charsInString[i])) {
			case 'c':
				if (Character.isUpperCase(charsInString[i])) {
					output += Character.toUpperCase(letters[random.nextInt(letters.length)]);
				} else {
					output += letters[random.nextInt(letters.length)];
				}

				break;
			case 'v':
				if (Character.isUpperCase(charsInString[i])) {
					output += Character.toUpperCase(vowels[random.nextInt(vowels.length)]);
				} else {
					output += vowels[random.nextInt(vowels.length)];
				}
				break;
			default:
				error = true;
				break;
			}

		}
		if (!error) {
			System.out.println(output);
		} else {
			System.out.println("Error!");
		}
	}

}
