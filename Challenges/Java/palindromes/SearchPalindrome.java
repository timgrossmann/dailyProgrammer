package palindromes;

public class SearchPalindrome {

	public static void checkForPalindrome(String input) {

		String[] s = input.split("\\W");

		String forward = "";

		for (String se : s) {
			forward += se.trim();
		}

		if (forward.toLowerCase().equals(reverse(forward))) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}

	}

	private static String reverse(String forward) {
		
		char[] tempChars = forward.toCharArray();
		
		char[] reversed = new char[tempChars.length];
		
		for(int i = tempChars.length - 1; i >= 0; i--) {
			reversed[reversed.length - i - 1] = tempChars[i];
		}

		return new String(reversed).toLowerCase();
	}

}
