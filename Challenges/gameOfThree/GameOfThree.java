package gameOfThree;

public class GameOfThree {

	private static int number;
	private static int operation;

	public static void playGame(int number) {

		GameOfThree.number = number;

		while (GameOfThree.number != 1) {
			if (GameOfThree.number % 3 != 0) {
				operation = getFittingOperation();
			} else {
				operation = 0;
			}
			printCurr(operation);
			GameOfThree.number = (GameOfThree.number + operation) / 3;
		}
		
		System.out.println(1);

	}

	private static int getFittingOperation() {
		return ((number - 1) % 3 == 0) ? -1 : 1;
	}

	private static void printCurr(int operation) {
		System.out.println(number + " " + operation);
	}

}
