package manglingSentences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mangler {

	/**
	 * Taking the Text apart with the spaces
	 * 
	 * @param s For intput String
	 */
	public static void mangleUp(String s) {

		String[] strings = s.split(" ");

		String finalString = "";

		for (int i = 0; i < strings.length; i++) {
			if (i == strings.length - 1) {
				finalString += getNewText(strings[i]);
			} else {
				finalString += getNewText(strings[i]) + " ";
			}
		}

		System.out.printf("Your old Text was: %s \nThe sorted Text  : %s ", s, finalString);

	}

	/**
	 * Sorting the seperated textes and returning the completely restored version
	 * @param s
	 * @return
	 */
	private static String getNewText(String s) {

		int[] upperCase = new int[s.toCharArray().length];
		int upperCounter = 0;

		int[] index = new int[s.toCharArray().length];
		int counter = 0;

		char[] symbols = new char[s.toCharArray().length];
		int charCounter = 0;

		char[] testChars = s.toCharArray();

		for (int i = 0; i < testChars.length; i++) {

			if (Character.isLetter(testChars[i])) {
				if (Character.isUpperCase(testChars[i])) {
					testChars[i] = Character.toLowerCase(testChars[i]);
					upperCase[upperCounter++] = i;
				}

			} else {
				index[counter++] = i;
				symbols[charCounter++] = testChars[i];
			}

		}

		Arrays.sort(testChars);

		List<Character> liste = new ArrayList<Character>();

		for (int i = 0; i < testChars.length; i++) {
			liste.add(testChars[i]);
		}

		for (int i = 0; i < counter; i++) {
			liste.remove(0);
		}

		for (int i = 0; i < counter; i++) {
			liste.add(index[i], symbols[i]);
		}

		for (int i = 0; i < upperCounter; i++) {
			Character temp = liste.get(upperCase[i]);
			liste.set(upperCase[i], Character.toUpperCase(temp));
		}

		String result = "";

		for (Character c : liste) {
			result += c;
		}

		return result;

	}

}
