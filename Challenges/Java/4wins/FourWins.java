package hdm_Stuttgart.fourWins;

import java.util.Scanner;

public class FourWins {

	private static String[][] playField = new String[6][7];
	private static boolean playerOne = true;
	private static boolean gameOver = false;
	private static int row;
	private static final Scanner scanner = new Scanner(System.in);
	private static int round = 0;
	private static String winner;

	public static void startGame() {

		initialize();
		printField();
		System.out.println();

		while (!gameOver) {

			if (playerOne) {
				System.out.println("Player (X)'s turn.");
			} else {
				System.out.println("Player (O)'s turn.");
			}

			row = playGame();

			if (playerOne) {
				playerOne = false;
				inputStone(row, "(X)");
			} else {
				playerOne = true;
				inputStone(row, "(O)");
			}

			printField();

			waiting();

			if (round > 5) {
				gameOver = checkGame();
			}
			round++;

			if (gameOver) {
				System.err.printf("Game Over!%nThe Winner is %s!%n", winner);
				
				waiting();
				
				System.out.printf("%nDo you want to play again?...(y/n)");
				String temp = scanner.nextLine();
				if (temp.equals("y")) {
					System.out.println("------------------------------");

					waiting();

					gameOver = false;
					System.out.println();
					System.out.println();
					initialize();

					waiting();

					printField();
					System.out.println();
				}
			}

			System.out.println();

		}

	}

	private static boolean checkGame() {

		if (round >= 42) {
			return full();
		}

		boolean checkWin = checkWin();

		if (checkWin) {
			return true;
		}

		return false;
	}

	private static void waiting() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	
	private static boolean checkWin() {

		String[][] combinations = getComb();
		int pOneFields = 0;
		int pTwoFields = 0;

		for (int i = 0; i < combinations.length; i++) {
			pTwoFields = 0;
			pOneFields = 0;

			for (int j = 0; j < combinations[i].length; j++) {
				if (combinations[i][j].equals("(O)")) {
					pTwoFields++;
					pOneFields = 0;
				} else if (combinations[i][j].equals("(X)")) {
					pOneFields++;
					pTwoFields = 0;
				} else {
					pTwoFields = 0;
					pOneFields = 0;
				}

				if (pTwoFields == 4) {
					winner = "(O)";
					return true;
				} else if (pOneFields == 4) {
					winner = "(X)";
					return true;
				}
			}

		}

		return false;
	}

	private static String[][] getComb() {

		String[][] temp = new String[25][7];

		// horizontal rows
		temp[0] = playField[0];
		temp[1] = playField[1];
		temp[2] = playField[2];
		temp[3] = playField[3];
		temp[4] = playField[4];
		temp[5] = playField[5];

		// vertical columns
		temp[6] = new String[] { playField[0][0], playField[1][0], playField[2][0], playField[3][0], playField[4][0],
				playField[5][0] };
		temp[7] = new String[] { playField[0][1], playField[1][1], playField[2][1], playField[3][1], playField[4][1],
				playField[5][1] };
		temp[8] = new String[] { playField[0][2], playField[1][2], playField[2][2], playField[3][2], playField[4][2],
				playField[5][2] };
		temp[9] = new String[] { playField[0][3], playField[1][3], playField[2][3], playField[3][3], playField[4][3],
				playField[5][3] };
		temp[10] = new String[] { playField[0][4], playField[1][4], playField[2][4], playField[3][4], playField[4][4],
				playField[5][4] };
		temp[11] = new String[] { playField[0][5], playField[1][5], playField[2][5], playField[3][5], playField[4][5],
				playField[5][5] };
		temp[12] = new String[] { playField[0][6], playField[1][6], playField[2][6], playField[3][6], playField[4][6],
				playField[5][6] };

		// diagonal left to right bottom
		temp[13] = new String[] { playField[2][0], playField[3][1], playField[4][2], playField[5][3] };
		temp[14] = new String[] { playField[1][0], playField[2][1], playField[3][2], playField[4][3], playField[5][4] };
		temp[15] = new String[] { playField[0][0], playField[1][1], playField[2][2], playField[3][3], playField[4][4],
				playField[5][5] };
		temp[16] = new String[] { playField[0][1], playField[1][2], playField[2][3], playField[3][4], playField[4][5],
				playField[5][6] };
		temp[17] = new String[] { playField[0][2], playField[1][3], playField[2][4], playField[3][5], playField[4][6] };
		temp[18] = new String[] { playField[0][3], playField[1][4], playField[2][5], playField[3][6] };

		// diagonal right to left bottom
		temp[19] = new String[] { playField[2][6], playField[3][5], playField[4][4], playField[5][3] };
		temp[20] = new String[] { playField[1][6], playField[2][5], playField[3][4], playField[4][3], playField[5][2] };
		temp[21] = new String[] { playField[0][6], playField[1][5], playField[2][4], playField[3][3], playField[4][2],
				playField[5][1] };
		temp[22] = new String[] { playField[0][5], playField[1][4], playField[2][3], playField[3][2], playField[4][1],
				playField[5][0] };
		temp[23] = new String[] { playField[0][4], playField[1][3], playField[2][2], playField[3][1], playField[4][0] };
		temp[24] = new String[] { playField[0][3], playField[1][2], playField[2][1], playField[3][0] };

		return temp;
	}

	private static boolean full() {
		int c = 0;

		for (int i = 0; i < playField[0].length; i++) {
			if (playField[0][i].equals("(O)") || playField[0][i].equals("(X)")) {
				c++;
			}
		}

		if (c == 7) {
			return true;
		} else {
			return false;
		}
	}

	private static void inputStone(int row, String player) {

		row = row - 1;

		if (playField[5][row].equals("---")) {
			playField[5][row] = player;
		} else if (playField[4][row].equals("---")) {
			playField[4][row] = player;
		} else if (playField[3][row].equals("---")) {
			playField[3][row] = player;
		} else if (playField[2][row].equals("---")) {
			playField[2][row] = player;
		} else if (playField[1][row].equals("---")) {
			playField[1][row] = player;
		} else if (playField[0][row].equals("---")) {
			playField[0][row] = player;
		} else if (playField[0][row].equals("(X)") || playField[0][row].equals("(O)")) {
			if (player.equals("(O)")) {
				playerOne = false;
			} else {
				playerOne = true;
			}
			placeFull();
		}

	}

	private static void placeFull() {
		System.err.println("Column already full!");
	}

	private static int playGame() {

		System.out.println("Please input the column you want to Place your Stone...");

		String temp = scanner.nextLine();

		while (!temp.matches("[1-7]")) {
			temp = scanner.nextLine();
		}

		int row = Integer.parseInt(temp);

		return row;
	}

	private static void initialize() {

		System.err.println("4 Wins! A simple Implementation.");

		System.err.println();

		for (int i = 0; i < playField.length; i++) {
			for (int j = 0; j < playField[i].length; j++) {
				playField[i][j] = "---";
			}
		}
	}

	private static void printField() {
		System.out.printf("| %d | %d | %d | %d | %d | %d | %d |", 1, 2, 3, 4, 5, 6, 7);
		System.out.println();
		for (int i = 0; i < playField.length; i++) {
			System.out.print("|");
			for (int j = 0; j < playField[i].length; j++) {
				System.out.print(playField[i][j]);
				if (j != playField[i].length - 1) {
					System.out.print("+");
				}
			}
			System.out.print("|");
			System.out.println();
		}
	}

}
