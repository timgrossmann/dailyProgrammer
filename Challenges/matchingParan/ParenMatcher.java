package matchingParan;

public class ParenMatcher {

	public static int getMatchingParen(String input, int startIndex) {

		if (input.charAt(startIndex) != '(' && input.charAt(startIndex) != ')') {
			return 0;
		}

		int currParen = 1;
		int closingParenPos = 0;

		switch (input.charAt(startIndex)) {
		case '(':
			for (int i = startIndex + 1; i < input.length(); i++) {

				char temp = input.charAt(i);

				if (temp == '(') {
					currParen++;
				} else if (temp == ')') {
					currParen--;
					if (currParen == 0) {
						closingParenPos += i;
						break;
					}
				}

			}
			break;
		case ')':
			for (int i = startIndex - 1; i < input.length(); i--) {

				char temp = input.charAt(i);

				if (temp == ')') {
					currParen++;
				} else if (temp == '(') {
					currParen--;
					if (currParen == 0) {
						closingParenPos += i;
						break;
					}
				}

			}
			break;
		}

		return closingParenPos;
	}

}
