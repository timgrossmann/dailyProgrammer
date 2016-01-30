package palindromicNums;

public class Palindrom {

	public static void makePalindromic(long input) {

		long inputNumber = input;
		long number = input;
		int rounds = 0;
		boolean isPalin = false;

		//checking for numbers like 11
		isPalin = checkForPalin(input);
		
		
		
		while (!isPalin) {

			// adding 1 to the rounds
			rounds++;

			// adds the reversed number
			number = addReverse(number);

			// addding the reverse of the input
			input += number;

			// reassigning the added value to the number
			number = input;

			// checking if the thing is already a palindrom
			isPalin = checkForPalin(number);

		}
		
		System.out.printf("%d gets Palindromic after %d step(s): %d", inputNumber, rounds, number);

	}

	/**
	 * checking if the number already is a palindrom
	 * 
	 * @param isPalin
	 * @return
	 */
	private static boolean checkForPalin(long number) {

		long tester = number;
		long temp = 0;

		// reversing the number
		while (number != 0) {
			temp = temp * 10;
			temp = temp + number % 10;
			number = number / 10;
		}

		// checking for equality
		if (temp == tester) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Method to reverse the actual number
	 * 
	 * @param number
	 * @return
	 */
	private static long addReverse(long number) {
		long temp = 0;

		// reversing the number
		while (number != 0) {
			temp = temp * 10;
			temp = temp + number % 10;
			number = number / 10;
		}

		return temp;
	}
}
