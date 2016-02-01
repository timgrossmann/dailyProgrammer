package hdm_Stuttgart.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	private static String[][] playField = new String[3][3];
	private static Scanner scanner = new Scanner(System.in);
	private static boolean isPOne = true;
	private static boolean againstComp = false;
	private static boolean gameOver = false;
	private static int round = 0;
	private static String winner = "None";
	private static boolean[] statements;

	public static void gamePlay() {

		System.out.println("Please type in Enemy type...(Player or Computer)");
		String enemy = scanner.nextLine().toLowerCase();

		while (true) {
			if (enemy.equals("player") || enemy.equals("computer")) {
				break;
			} else {
				System.out.println("Please insert a valid Enemy!");
				enemy = scanner.nextLine().toLowerCase();
			}

		}

		if (enemy.equals("computer")) {
			againstComp = true;
		} else {
			againstComp = false;
		}

		startGame();

	}

	public static void startGame() {

		initialize();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		printField();

		while (!gameOver) {
			getInput();
			switchPlayer();
			printField();
			System.out.println();
			round++;
			if (round >= 5) {
				gameOver = checkGame();
			}

			if (gameOver) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.err.printf("Winner is %s%n", winner);
				System.err.println("Do you want to play again?... (y or n)");
				if (scanner.nextLine().equals("y")) {
					gamePlay();
					gameOver = false;
				} else {
					System.err.println("Game Over!");
				}
			}
		}

	}

	private static boolean checkGame() {

		statements = new boolean[] {
				(playField[0][0].equals(playField[0][1]) && playField[0][1].equals(playField[0][2])),
				(playField[1][0].equals(playField[1][1]) && playField[1][1].equals(playField[1][2])),
				(playField[2][0].equals(playField[2][1]) && playField[2][1].equals(playField[2][2])),
				(playField[0][0].equals(playField[1][0]) && playField[1][0].equals(playField[2][0])),
				(playField[0][2].equals(playField[1][2]) && playField[1][2].equals(playField[2][2])),
				(playField[0][1].equals(playField[1][1]) && playField[1][1].equals(playField[2][1])),
				(playField[0][0].equals(playField[1][1]) && playField[1][1].equals(playField[2][2])),
				(playField[0][2].equals(playField[1][1]) && playField[1][1].equals(playField[2][0])) };

		for (int i = 0; i < statements.length; i++) {
			if (statements[i]) {
				switch (i) {
				case 0:
					if (!playField[0][0].equals(" ")) {
						winner = playField[0][0];
						return true;
					}
					break;
				case 1:
					if (!playField[1][0].equals(" ")) {
						winner = playField[1][0];
						return true;
					}
					break;
				case 2:
					if (!playField[2][0].equals(" ")) {
						winner = playField[2][0];
						return true;
					}
					break;
				case 3:
					if (!playField[0][0].equals(" ")) {
						winner = playField[0][0];
						return true;
					}
					break;
				case 4:
					if (!playField[0][2].equals(" ")) {
						winner = playField[0][2];
						return true;
					}
					break;
				case 5:
					if (!playField[0][1].equals(" ")) {
						winner = playField[0][1];
						return true;
					}
					break;
				case 6:
					if (!playField[0][0].equals(" ")) {
						winner = playField[0][0];
						return true;
					}
					break;
				case 7:
					if (!playField[0][2].equals(" ")) {
						winner = playField[0][2];
						return true;
					}
					break;
				default:
					break;
				}
			}
		}
		if (round == 9) {
			return true;
		} else {
			return false;
		}
	}

	private static void switchPlayer() {
		if (isPOne) {
			isPOne = false;
		} else {
			isPOne = true;
		}
	}

	private static void getInput() {

		if (!againstComp) {

			if (isPOne) {
				System.out.println("Player (X) please enter a Position... Format:Y/X");
			} else {
				System.out.println("Player (O) please enter a Position... Format:Y/X");
			}

			String position = scanner.nextLine();

			if (!position.matches("[1-3]/[1-3]")) {
				System.err.println("Please Input a valid Position...");
				getInput();
			} else {

				String[] positions = position.split("/");

				int[] posInt = { Integer.parseInt(positions[0]) - 1, Integer.parseInt(positions[1]) - 1 };

				if (playField[posInt[0]][posInt[1]].equals("X") || playField[posInt[0]][posInt[1]].equals("O")) {
					System.err.println("Place already taken...");
					getInput();
				} else {
					if (isPOne) {
						playField[posInt[0]][posInt[1]] = "X";
					} else {
						playField[posInt[0]][posInt[1]] = "O";
					}
				}
			}
		} else {

			if (isPOne) {
				System.out.println("Player (X) please enter a Position... Format:Y/X");

				String position = scanner.nextLine();

				if (!position.matches("[1-3]/[1-3]")) {
					System.err.println("Please Input a valid Position...");
					getInput();

				} else {
					String[] positions = position.split("/");

					int[] posInt = { Integer.parseInt(positions[0]) - 1, Integer.parseInt(positions[1]) - 1 };

					if (playField[posInt[0]][posInt[1]].equals("X") || playField[posInt[0]][posInt[1]].equals("O")) {
						System.err.println("Place already taken...");
						getInput();
					} else {
						playField[posInt[0]][posInt[1]] = "X";
					}
				}

			} else {
				System.out.println("Computer (O)'s turn, please wait...");
				playField = KI.makeTurn(playField);
			}

		}
	}

	private static void initialize() {
		System.err.println("TicTacToe - A simple Version!");
		round = 0;
		winner = "None";

		for (int i = 0; i < playField.length; i++) {
			for (int j = 0; j < playField[i].length; j++) {
				playField[i][j] = " ";
			}
		}

	}

	private static void printField() {
		for (int i = 0; i < playField.length; i++) {
			System.out.println("-------------");
			System.out.print("|");
			for (int j = 0; j < playField[i].length; j++) {
				System.out.printf("%2s ", playField[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("-------------");

	}

}
