package application;


public class CipherMaker {

	public static String encipherSimple(String input) {

		if (!input.equals("")) {

			char[] charsInInput = input.toCharArray();

			int randomNum = Math.abs(
					(int) (Math.random() * 100 + (Math.random() * 10) - (Math.random() * 10) * (Math.random() * 10)));
			while (randomNum < 10) {
				randomNum = Math.abs((int) (Math.random() * 100 + (Math.random() * 10)
						- (Math.random() * 10) * (Math.random() * 10)));
			}

			for (int i = 0; i < charsInInput.length; i++) {
				int temp = (int) charsInInput[i];
				charsInInput[i] = (char) (temp + randomNum);
			}

			String numTemp = Integer.toString(randomNum);
			int num1 = (int) ((char) Integer.parseInt(numTemp.substring(0, 1))) + 1;
			int num2 = (char) Integer.parseInt(numTemp.substring(1, 2)) + 1;
			String temp = num1 + new String(charsInInput) + num2;
			return new String(temp);
		} else {
			return input;
		}

	}

	public static String decipherSimple(String input) {

		if (!input.equals("") && Character.isDigit(input.charAt(0))) {

			char[] charsInInput = input.toCharArray();
			char[] tempAr = { charsInInput[0], charsInInput[charsInInput.length - 1] };

			int num1 = Integer.parseInt(Character.toString(tempAr[0])) - 1;
			int num2 = Integer.parseInt(Character.toString(tempAr[1])) - 1;

			int tempNum = Integer.parseInt(new String(num1 + "" + num2));

			char[] finalAr = new char[charsInInput.length - 2];
			for (int i = 1; i <= finalAr.length; i++) {
				finalAr[i - 1] = charsInInput[i];
				int temp = (int) finalAr[i - 1];
				finalAr[i - 1] = (char) (temp - tempNum);
			}

			return new String(finalAr);
		} else {
			return input;
		}
	}

	public static String encipherCesar(String input) {

		String[] lineSplit = input.split("\n");
		String output = "";

		for (int k = 0; k < lineSplit.length; k++) {
			String[] textSplit = lineSplit[k].split(" ");

			for (int i = 0; i < textSplit.length; i++) {
				char[] temp = textSplit[i].toCharArray();

				for (int j = 0; j < temp.length; j++) {
					if (Character.isLetter(temp[j]) || Character.isDigit(temp[j])) {
						int tempASCII = temp[j];
						tempASCII += 3;
						if (tempASCII > 90 && Character.isUpperCase(temp[j])
								|| tempASCII > 122 && Character.isLowerCase(temp[j])) {
							tempASCII -= 26;
						} else if (Character.isDigit(temp[j]) && tempASCII > 57) {
							tempASCII -= 10;
						}
						temp[j] = (char) tempASCII;
					}
				}
				output += new String(temp) + " ";
			}
			output.trim();
			output += "\n";
		}
		return output.trim();
	}

	public static String decipherCesar(String input) {

		String[] lineSplit = input.split("\n");
		String output = "";

		for (int k = 0; k < lineSplit.length; k++) {
			String[] textSplit = lineSplit[k].split(" ");

			for (int i = 0; i < textSplit.length; i++) {
				char[] temp = textSplit[i].toCharArray();

				for (int j = 0; j < temp.length; j++) {
					if (Character.isLetter(temp[j]) || Character.isDigit(temp[j])) {
						int tempASCII = temp[j];
						tempASCII -= 3;
						if (tempASCII < 65 && Character.isUpperCase(temp[j])
								|| tempASCII < 97 && Character.isLowerCase(temp[j])) {
							tempASCII += 26;
						} else if (Character.isDigit(temp[j]) && tempASCII < 48) {
							tempASCII += 10;
						}
						temp[j] = (char) tempASCII;
					}
				}
				output += new String(temp) + " ";
			}
			output.trim();
			output += "\n";
		}
		return output.trim();
	}

	public static String encipherVigenere(String input, String code) {

		int moveNum = 0;
		int tempMove = 0;
		char[] charsInCode = code.toCharArray();

		String[] lineSplit = input.split("\n");
		String output = "";

		for (int k = 0; k < lineSplit.length; k++) {
			String[] textSplit = lineSplit[k].split(" ");

			for (int i = 0; i < textSplit.length; i++) {
				char[] temp = textSplit[i].toCharArray();

				for (int j = 0; j < temp.length; j++) {
					if (Character.isLetter(temp[j])) {
						int tempASCII = temp[j];

						if (Character.isUpperCase(charsInCode[moveNum])) {
							tempMove = charsInCode[moveNum] - 65;
						} else if (Character.isLowerCase(charsInCode[moveNum])) {
							tempMove = charsInCode[moveNum] - 97;
						}
						tempASCII += tempMove;
						moveNum++;
						if (moveNum > charsInCode.length - 1) {
							moveNum = 0;
						}
						if (tempASCII > 90 && Character.isUpperCase(temp[j])
								|| tempASCII > 122 && Character.isLowerCase(temp[j])) {
							tempASCII -= 26;
						}
						temp[j] = (char) tempASCII;
					}
				}
				output += new String(temp) + " ";
			}
			output.trim();
			output += "\n";
		}
		return output.trim();
	}

	public static String decipherVigenere(String input, String code) {

		int moveNum = 0;
		int tempMove = 0;
		char[] charsInCode = code.toCharArray();

		String[] lineSplit = input.split("\n");
		String output = "";

		for (int k = 0; k < lineSplit.length; k++) {
			String[] textSplit = lineSplit[k].split(" ");

			for (int i = 0; i < textSplit.length; i++) {
				char[] temp = textSplit[i].toCharArray();

				for (int j = 0; j < temp.length; j++) {
					if (Character.isLetter(temp[j])) {
						int tempASCII = temp[j];

						if (Character.isUpperCase(charsInCode[moveNum])) {
							tempMove = charsInCode[moveNum] - 65;
						} else if (Character.isLowerCase(charsInCode[moveNum])) {
							tempMove = charsInCode[moveNum] - 97;
						}
						tempASCII -= tempMove;
						moveNum++;
						if (moveNum > charsInCode.length - 1) {
							moveNum = 0;
						}
						if (tempASCII < 65 && Character.isUpperCase(temp[j])
								|| tempASCII < 97 && Character.isLowerCase(temp[j])) {
							tempASCII += 26;
						}
						temp[j] = (char) tempASCII;
					}
				}
				output += new String(temp) + " ";
			}
			output.trim();
			output += "\n";
		}
		return output.trim();
	}

	public static String encipherRC4(String input, int m) {

		String finalByteCode = "";
		int counter = 0;
		int[] numbers = getRandomNumbers(input.length(), m);

		for (char c : input.toCharArray()) {
			String temp = toByteCode(((int) c ^ numbers[counter++]) % 255);
			finalByteCode += temp;
		}

		return finalByteCode;
	}

	public static String decipherRC4(String input, int m) {

		String temp = toTextBack(input, m);

		return temp;
	}

	private static String toByteCode(int ascii) {

		StringBuilder bin = new StringBuilder("");

		while (ascii != 0) {
			bin.insert(0, ascii % 2);
			ascii = (int) (ascii / 2.0);
		}

		while (bin.length() < 8) {
			bin.insert(0, "0");
		}

		return bin.toString();
	}

	private static String toTextBack(String finalByteCode, int m) {

		int temp;
		String[] splitted = finalByteCode.split("(?<=\\G........)");
		String out = "";
		
		int[] numbers = getRandomNumbers(splitted.length, m);

		for (int j = 0; j < splitted.length; j++) {
			char[] tempChar = splitted[j].toCharArray();

			int tempLetter = 0;

			for (int i = 0; i < tempChar.length; i++) {
				temp = (int) (Character.getNumericValue(tempChar[i]) * Math.pow(2, (tempChar.length - 1 - i)));
				tempLetter += temp;
			}
			out += (char) ((tempLetter ^ numbers[j]) % 255);
		}

		return out;
	}

	private static int[] getRandomNumbers(int charLength, int m) {

		int x = 1;
		int a = 2;
		int c = 3;

		int[] numbers = new int[charLength];

		for (int i = 0; i < numbers.length; i++) {
			int temp = ((a * x + c) % m);
			x = temp;
			numbers[i] = temp;
		}

		return numbers;
	}

}
