package diagonalMaze;

public class Diagonalizer {

	public static void makeDiagonal(String[][] horMaze) {

		print(horMaze);

		horMaze = changeStrings(horMaze);

		String[][] diaMaze = new String[horMaze.length * 2 - 1][horMaze.length];

		String[] rows = new String[horMaze.length * 2 - 1];
		String temp = "";

		int numOfSpaces = horMaze.length;

		int distance = checkDistance(horMaze);

		for (int i = 0; i < horMaze.length; i++) {

			temp = "";

			for (int j = 0; j < Math.abs(numOfSpaces - 1 - i); j++) {
				// System.out.print(" ");
				temp += " ";
				if (!horMaze[i][0].equals("+")) {
					j++;
				}

			}

			for (int k = 0; k <= i; k++) {
				// System.out.print(horMaze[i - k][k]);
				temp += horMaze[i - k][k];
			}
			rows[i] = temp;
			// System.out.println();
		}

		for (int i = 1; i < horMaze.length; i++) {

			temp = "";

			for (int j = numOfSpaces; j > horMaze.length - i; j--) {
				// System.out.print(" ");
				temp += " ";
				if (j % distance != 0) {
					j--;
				}
			}

			for (int k = horMaze.length - 1; k >= i; k--) {
				temp += horMaze[k][i + horMaze.length - k - 1];
				// System.out.print(horMaze[k][i + horMaze.length - k - 1]);
			}
			rows[horMaze.length + i - 1] = temp;
			// System.out.println();
		}

		diaMaze = getDiaMaze(diaMaze, rows);

		printDia(diaMaze);

	}

	private static int checkDistance(String[][] horMaze) {
		for (int i = 1; i < horMaze.length; i++) {
			if (horMaze[i][0].equals("+")) {
				if (i == 2) {
					return i;
				} else {
					return 3;
				}
			}
		}
		return 0;
	}

	private static void printDia(String[][] diaMaze) {
		boolean contains;
		for (int i = 0; i < diaMaze.length; i++) {
			contains = false;
			contains = checkContains(diaMaze[i]);

			if (!contains) {
				for (int j = 0; j < diaMaze[i].length; j++) {
					if (diaMaze[i][j] != null) {
						System.out.print(diaMaze[i][j]);
					}
				}
				System.out.println();
			}
		}
	}

	private static boolean checkContains(String[] row) {

		int numOfPlus = 0;

		for (String s : row) {

			if (s != null && s.equals("+")) {
				numOfPlus++;
			}
		}

		if (numOfPlus > 0) {
			return true;
		} else {
			return false;
		}
	}

	private static String[][] getDiaMaze(String[][] diaMaze, String[] rows) {

		for (int i = 0; i < diaMaze.length; i++) {
			char[] charsInRow = rows[i].toCharArray();

			for (int j = 0; j < charsInRow.length; j++) {
				diaMaze[i][j] = Character.toString(charsInRow[j]);
			}
		}
		return diaMaze;
	}

	private static String[][] changeStrings(String[][] horMaze) {
		for (int i = 0; i < horMaze.length; i++) {
			for (int j = 0; j < horMaze[i].length; j++) {
				if (horMaze[i][j].equals("-")) {
					horMaze[i][j] = "\\";
				} else if (horMaze[i][j].equals("|")) {
					horMaze[i][j] = "/";
				}
			}
		}
		return horMaze;
	}

	private static void print(String[][] horMaze) {
		for (int i = 0; i < horMaze.length; i++) {
			for (int j = 0; j < horMaze[i].length; j++) {
				System.out.print(horMaze[i][j]);
			}
			System.out.println();
		}
	}

}
