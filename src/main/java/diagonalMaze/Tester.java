package diagonalMaze;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please insert number of Rows...");
		int numOfRows = scanner.nextInt();
		scanner.nextLine();

		if (numOfRows >= 10) {
			String[][] horMaze = new String[numOfRows][numOfRows];

			String[] rows = new String[numOfRows];

			for (int i = 0; i < horMaze.length; i++) {
				rows[i] = scanner.nextLine();
			}

			scanner.close();

			for (int i = 0; i < horMaze.length; i++) {

				char[] singleChars = rows[i].toCharArray();

				for (int j = 0; j < horMaze[i].length; j++) {
					horMaze[i][j] = Character.toString(singleChars[j]);
				}
			}

			Diagonalizer.makeDiagonal(horMaze);
		} else {

			switch (numOfRows) {
			case 1:

				String[][] horMaze = new String[11][11];

				String field = "+-+-+-+-+-+\n  |       |\n+ +-+-+ + +\n| |     | |\n+ + + + + +\n|   | |   |\n+-+-+ +-+-+\n|     |   |\n+ + +-+ + +\n| |     |  \n+-+-+-+-+-+";

				String[] rows = field.split("\\n");

				for (int i = 0; i < horMaze.length; i++) {
					char[] chars = rows[i].toCharArray();
					for (int j = 0; j < horMaze[i].length; j++) {
						horMaze[i][j] = Character.toString(chars[j]);
					}
				}

				Diagonalizer.makeDiagonal(horMaze);

				break;
			case 2:

				String[][] horMaze2 = new String[16][16];

				String field2 = "+--+--+--+--+--+\n      |     |  |\n      |     |  |\n+  +--+  +  +  +\n|     |  |  |  |\n|     |  |  |  |\n+--+  +  +  +  +\n|     |  |     |\n|     |  |     |\n+  +--+  +  +--+\n|        |     |\n|        |     |\n+--+--+--+--+  +\n|               \n|               \n+--+--+--+--+--+";

				String[] rows2 = field2.split("\\n");

				for (int i = 0; i < horMaze2.length; i++) {
					char[] chars = rows2[i].toCharArray();
					for (int j = 0; j < horMaze2[i].length; j++) {
						horMaze2[i][j] = Character.toString(chars[j]);
					}
				}

				Diagonalizer.makeDiagonal(horMaze2);

				break;
			case 3:
				
				

				String field3 = "+---+---+---+---+---+---+\n                        |\n                        |\n                        |\n+---+---+---+---+---+   +\n                        |\n                        |\n                        |\n+---+---+---+---+---+---+\n|                        \n|                        \n|                        \n+   +---+---+---+---+---+\n|                        \n|                        \n|                        \n+---+---+---+---+---+---+";

				String[] rows3 = field3.split("\\n");
				
				String[][] horMaze3 = new String[17][rows3[0].toCharArray().length];

				for (int i = 0; i < horMaze3.length; i++) {
					char[] chars = rows3[i].toCharArray();
					for (int j = 0; j < horMaze3[i].length; j++) {
						horMaze3[i][j] = Character.toString(chars[j]);
					}
				}

				Diagonalizer.makeDiagonal(horMaze3);
				
				break;
			}
		}

	}

}
