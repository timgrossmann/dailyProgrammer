package palindromes;

public class SearchPalindromeSec {

	public static void checkForPalin(String input) {

		String[] temp = input.split("\\W");
		StringBuilder sentence = new StringBuilder("");

		for (String s : temp) {
			sentence.append(s.toLowerCase());
		}

		if (sentence.toString().equals(sentence.reverse().toString())) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}

	}

}
