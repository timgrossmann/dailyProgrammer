package permutationPalindrome;

import java.util.HashMap;
import java.util.Map;

public class PermutPalindrome {

	public static boolean isPermutPalin(String input) {

		// char[] inputLetters = input.toCharArray();
		// boolean isEvenLength = input.length() % 2 == 0;
		// Map<Character, Integer> letters = new HashMap<Character, Integer>();
		// int numOfUneven = 0;
		//
		// for (int i = 0; i < inputLetters.length; i++) {
		//
		// if (!letters.containsKey(inputLetters[i])) {
		// letters.put(inputLetters[i], 1);
		// } else {
		// letters.replace(inputLetters[i], letters.get(inputLetters[i]) + 1);
		// }
		//
		// }
		//
		// for (char c : letters.keySet()) {
		// if (letters.get(c) % 2 != 0) {
		// numOfUneven++;
		// }
		// }
		//
		// if (isEvenLength) {
		// return numOfUneven == 0;
		// } else {
		// return numOfUneven == 1;
		// }

		boolean isEvenLength = input.length() % 2 == 0;
		int numOfUneven = 0;
		Map<Character, Boolean> letters = new HashMap<Character, Boolean>();

		for (int i = 0; i < input.length(); i++) {

			if (!letters.containsKey(input.charAt(i))) {
				letters.put(input.charAt(i), false);
			} else {
				letters.replace(input.charAt(i), !letters.get(input.charAt(i)));
			}

		}

		for (char c : letters.keySet()) {
			if (letters.get(c) == false) {
				numOfUneven++;

				if (numOfUneven > 1) {
					return false;
				}
			}
		}

		return isEvenLength ? numOfUneven == 0 : numOfUneven == 1;

	}

}
