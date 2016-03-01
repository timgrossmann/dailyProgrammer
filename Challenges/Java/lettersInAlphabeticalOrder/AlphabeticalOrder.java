package lettersInAlphabeticalOrder;

import java.util.ArrayList;
import java.util.Arrays;

public class AlphabeticalOrder {

	public static void testForOrder(String input) {

		char[] inputChars = input.toCharArray();

		Arrays.sort(inputChars);

		ArrayList<Character> inputCharList = new ArrayList<Character>();
		for (char c : inputChars) {
			inputCharList.add(0, c);
		}
		String tester = "";
		for (char c : inputCharList) {
			tester += c;
		}

		if (input.equals(new String(inputChars))) {
			System.out.printf("%s IN ORDER%n", input);
		} else if (input.equals(tester)) {
			System.out.printf("%s IN REVERSED ORDER%n", input);
		} else {
			System.out.printf("%s NOT IN ORDER%n", input);
		}

	}

}
