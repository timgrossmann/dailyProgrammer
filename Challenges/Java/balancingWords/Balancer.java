package balancingWords;

import java.util.HashMap;
import java.util.Map;

public class Balancer {

	// Describing the alphabet with a Map to get the Digits per Character
	private static final Map<Character, Integer> alphabet;
	//adding all the Digits in the alphabet with fitting values
	static {
		alphabet = new HashMap<Character, Integer>();
		alphabet.put('A', 1);
		alphabet.put('B', 2);
		alphabet.put('C', 3);
		alphabet.put('D', 4);
		alphabet.put('E', 5);
		alphabet.put('F', 6);
		alphabet.put('G', 7);
		alphabet.put('H', 8);
		alphabet.put('I', 9);
		alphabet.put('J', 10);
		alphabet.put('K', 11);
		alphabet.put('L', 12);
		alphabet.put('M', 13);
		alphabet.put('N', 14);
		alphabet.put('O', 15);
		alphabet.put('P', 16);
		alphabet.put('Q', 17);
		alphabet.put('R', 18);
		alphabet.put('S', 19);
		alphabet.put('T', 20);
		alphabet.put('U', 21);
		alphabet.put('V', 22);
		alphabet.put('W', 23);
		alphabet.put('X', 24);
		alphabet.put('Y', 25);
		alphabet.put('Z', 26);
	}

	/**
	 * Checking all possible middlePoints of the word to check if there is a
	 * BalancePoint
	 * 
	 * @param word
	 *            - Word to be checked
	 */
	public static void balanceWord(String word) {
		
		// Variable declaration
		char[] wordInChars = word.toCharArray();
		boolean charsLeft = true;
		int X = 0;

		// Main ProgramLoop
		while (charsLeft) {

			// Getting the middle Value of the inputString
			int mid = wordInChars.length / 2 + X;

			// Calculating the Values for the left and right side
			int valueLeft = getLeftSide(mid, wordInChars);
			int valueRight = getRightSide(mid, wordInChars);

			// Checking if the Balancepoint is already found
			if (valueLeft == valueRight) {
				charsLeft = false;
				System.out.printf("The Balancepoint of %s is %s \n", word, wordInChars[mid - 1]);
				System.out.printf("%s %s %s - %d \n", word.substring(0, mid - 1), wordInChars[mid - 1],
						word.substring(mid), valueRight);
				System.out.println("----------");
				
			} else if (mid == 0 || mid == word.length()) {
				charsLeft = false;
				System.err.println("No Balance Point found!");
				System.err.println("----------");
			}

			// Changing the midpoint
			if (X == 0 || X < 0) {
				X *= -1;
				X++;
			} else {
				X *= -1;
			}
		}

	}

	
	/**
	 * Calculates the Sum of the left side from the middle point
	 * 
	 * @param mid
	 *            - Current middlePoint of the word
	 * @param wordInChars
	 *            - The Word in Chars
	 * @return - the product of all summed up CharacterValues
	 */
	private static int getLeftSide(int mid, char[] wordInChars) {

		// Vars for the returnValue and the current Distance from the middle
		// Point
		int result = 0;
		int distance = 1;

		// Looping to sum up all the Products of each Character till the first
		// letter in the Word
		for (int i = mid - 1; i > 0; i--) {
			int product = distance * alphabet.get(wordInChars[i - 1]);
			result += product;
			distance++;
		}
		return result;
	}

	/**
	 * Calculates the Sum of the right side from the middle point
	 * 
	 * @param mid
	 *            - Current middlePoint of the word
	 * @param wordInChars
	 *            - The Word in Chars
	 * @return - the product of all summed up CharacterValues
	 */
	private static int getRightSide(int mid, char[] wordInChars) {

		// Vars for the returnValue and the current Distance from the middle
		// Point
		int result = 0;
		int distance = 1;

		// Looping to sum up all the Products of each Character till the first
		// letter in the Word
		for (int i = mid + 1; i <= wordInChars.length; i++) {
			int product = distance * alphabet.get(wordInChars[i - 1]);
			result += product;
			distance++;
		}

		return result;
	}

}
