package yourOrderPlease;

public class Order {
	public static String order(String words) {

		String outputString = "";

		if (words == null || words.length() == 0) {
			return outputString;
		}

		String[] splitWords = words.split(" ");
		String[] numbers = new String[splitWords.length];

		for (int i = 0; i < splitWords.length; i++) {

			String endNumber = "";

			char[] numberArray = splitWords[i].toCharArray();

			if (numberArray.length > 0) {
				for (char c : numberArray) {
					if (Character.isDigit(c)) {
						endNumber += c;
					}
				}
				int intEndNumber = Integer.parseInt(endNumber) - 1;
				numbers[intEndNumber] = splitWords[i];
			}
		}

		for (String s : numbers) {
			outputString += s + " ";
		}

		return outputString.trim();
	}
}