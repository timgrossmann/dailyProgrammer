package emasSupercomputer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tester {

	private static List<Integer> crossAreas = new ArrayList<Integer>();
	private static boolean going = true;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[][] gameField = new String[scanner.nextInt()][scanner.nextInt()];
		scanner.nextLine();

		for (int i = 0; i < gameField.length; i++) {
			String temp = scanner.nextLine();

			for (int j = 0; j < temp.length(); j++) {
				gameField[i][j] = Character.toString(temp.charAt(j));
			}
		}

		scanner.close();

		// removing impossible fields
		try {
			gameField = blockOuterParts(gameField);
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		boolean going = true;

		while (going) {

			int before = crossAreas.size();

			going = false;

			gameField = searchCross(gameField);

			if (before < crossAreas.size()) {
				going = true;
			}

		}

		int out = 1;

		Collections.sort(crossAreas);

		if(crossAreas.size() >= 2) {
			out *= crossAreas.get(crossAreas.size() - 1);
			out *= crossAreas.get(crossAreas.size() - 2);
		} else if(crossAreas.size() == 1) {
			out *= crossAreas.get(0);
		} else {
			out = 0;
		}
		
		System.out.println(out);
	}

	private static String[][] searchCross(String[][] gameField) {

		boolean crossFound = false;
		int posY = 0;
		int posX = 0;
		int area = 0;
		boolean next = true;

		for (int i = 1; i < gameField.length - 1; i++) {

			for (int j = 1; j < gameField[0].length - 1; j++) {

				if (gameField[i][j].equals("G") && gameField[i - 1][j].equals("G") && gameField[i + 1][j].equals("G")
						&& gameField[i][j - 1].equals("G") && gameField[i][j + 1].equals("G")) {
					gameField[i][j] = "B";
					gameField[i - 1][j] = "B";
					gameField[i + 1][j] = "B";
					gameField[i][j - 1] = "B";
					gameField[i][j + 1] = "B";
					crossFound = true;
					posY = i;
					posX = j;
					area = 5;
					next = false;
					break;
				}

			}

			if (!next) {
				break;
			}
		}

		if (crossFound) {
			try {

				int k = 1;

				while (true) {
					if (gameField[posY - 1 - k][posX].equals("G") && gameField[posY + 1 + k][posX].equals("G")
							&& gameField[posY][posX - 1 - k].equals("G") && gameField[posY][posX + 1 + k].equals("G")) {
						area += 4;
						gameField[posY - 1 - k][posX] = "B";
						gameField[posY + 1 + k][posX] = "B";
						gameField[posY][posX - 1 - k] = "B";
						gameField[posY][posX + 1 + k] = "B";
						k++;
					} else {
						break;
					}
				}

			} catch (IndexOutOfBoundsException e) {
			}
		}

		if (area != 0) {
			crossAreas.add(area);
		}

		return gameField;

	}

	private static String[][] blockOuterParts(String[][] gameField) throws ArrayIndexOutOfBoundsException {

		gameField[0][0] = "B";
		gameField[gameField.length - 1][0] = "B";
		gameField[0][gameField[0].length - 1] = "B";
		gameField[gameField.length - 1][gameField[0].length - 1] = "B";

		/* Search upper Row */
		for (int i = 1; i < gameField[0].length - 1; i++) {
			if (gameField[1][i].equals("B")) {
				gameField[0][i] = "B";
			}
		}

		/* Search last Row */
		for (int i = 1; i < gameField[0].length - 1; i++) {
			if (gameField[gameField.length - 2][i].equals("B")) {
				gameField[gameField.length - 1][i] = "B";
			}
		}

		/* Search left Row */
		for (int i = 1; i < gameField.length - 1; i++) {
			if (gameField[i][1].equals("B")) {
				gameField[i][0] = "B";
			}
		}

		/* Search right Row */
		for (int i = 1; i < gameField.length - 1; i++) {
			if (gameField[i][gameField[0].length - 2].equals("B")) {
				gameField[i][gameField[0].length - 1] = "B";
			}
		}

		return gameField;
	}

}
