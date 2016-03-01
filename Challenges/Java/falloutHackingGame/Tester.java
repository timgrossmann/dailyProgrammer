package falloutHackingGame;

import java.util.Scanner;

public class Tester {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.err.println("#*--Fallout Hacking Game Implementation--*#");
		System.err.println("|How to play:                             |");
		System.err.println("|Guess the chosen Word with the 4 Chances.|");
		System.err.println("|                                         |");
		System.err.println("|            *-Game Started!-*            |");
		System.err.println("#*---------------------------------------*#");

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

		int difficulty = getDifficulty();

		FalloutGame hackingGame = new FalloutGame();

		hackingGame.playGame(difficulty);
		scanner.close();

	}

	public static int getDifficulty() {

		String tempString = "";
		int temp = 0;

		System.out.println("Please enter a difficulty...(1-5)");

		tempString = scanner.nextLine();

		try {
			temp = Integer.parseInt(tempString);
		} catch (Exception e) {
			System.err.println("*-Wrong Input-*");
			System.out.println();
		}

		if (temp < 1 || temp > 5) {
			System.out.println();
			temp = getDifficulty();
		}

		return temp;
	}

}
