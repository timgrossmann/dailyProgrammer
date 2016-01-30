package wordSnake;

import java.util.Random;

public class WordSnake {

	private static char[][] playField = new char[50][100];
	private static Random random = new Random();

	private static int dir = random.nextInt(2) + 1;
	private static int currVer = 0;
	private static int currHor = 0;

	public static void snakeIt(String text) {

		String[] splitted = text.split(" ");

		playField[0][0] = splitted[0].charAt(0);

		for (int i = 0; i < splitted.length; i++) {

			char[] currTemp = splitted[i].toCharArray();

			boolean isFree = true;

			switch (dir) {
			case 1:
				if (currHor + currTemp.length + 1 <= playField[i].length) {
					isFree = checkForFree(1, currTemp);
					if (isFree == true) {
						insertX(1, currTemp);
					} else {
						i--;
					}
				} else if (currHor - currTemp.length - 1 >= 0) {
					if (checkForFree(3, currTemp)) {
						insertX(3, currTemp);
					} else {
						i--;
					}
				} else {
					i--;
				}
				dir = (random.nextInt(2) + 1) * 2;
				break;
			case 2:
				if (currVer + currTemp.length + 1 <= playField.length) {
					isFree = checkForFree(2, currTemp);
					if (isFree == true) {
						insertX(2, currTemp);
					} else {
						i--;
					}

				} else if (currVer - currTemp.length - 1 >= 0) {
					if (checkForFree(4, currTemp)) {
						insertX(4, currTemp);
					} else {
						i--;
					}
				} else {
					i--;
				}
				dir = (int) ((random.nextInt(2) + 1) * 1.5);
				break;
			case 3:
				if (currHor - currTemp.length - 1 >= 0) {
					isFree = checkForFree(3, currTemp);
					if (isFree == true) {
						insertX(3, currTemp);
					} else {
						i--;
					}
				} else if (currHor + currTemp.length + 1 <= playField[i].length) {
					if (checkForFree(1, currTemp)) {
						insertX(1, currTemp);
					} else {
						i--;
					}
				} else {
					i--;
				}
				dir = (random.nextInt(2) + 1) * 2;
				break;
			case 4:
				if (currVer - currTemp.length - 1 >= 0) {
					isFree = checkForFree(4, currTemp);
					if (isFree == true) {
						insertX(4, currTemp);
					} else {
						i--;
					}
				} else if (currVer + currTemp.length + 1 <= playField.length) {
					if (checkForFree(2, currTemp)) {
						insertX(2, currTemp);
					} else {
						i--;
					}
				} else {
					i--;
				}
				dir = (int) ((random.nextInt(2) + 1) * 1.5);
				break;
			}

		}

		for (int i = 0; i < playField.length; i++) {
			for (int j = 0; j < playField[i].length; j++) {
				System.out.print(playField[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean checkForFree(int num, char[] currTemp) {

		int counter = 1;

		switch (num) {
		case 1:
			for (int i = 0; i < currTemp.length; i++) {
				if (playField[currVer][currHor + i] == '\u0000') {
					counter++;
				}

			}
			break;
		case 2:
			for (int i = 0; i < currTemp.length; i++) {
				if (playField[currVer + i][currHor] == '\u0000') {
					counter++;
				}
			}
			break;
		case 3:
			for (int i = 0; i < currTemp.length; i++) {
				if (playField[currVer][currHor - i] == '\u0000') {
					counter++;
				}
			}
			break;
		case 4:
			for (int i = 0; i < currTemp.length; i++) {
				if (playField[currVer - i][currHor] == '\u0000') {
					counter++;
				}
			}
			break;
		}

		if (counter == currTemp.length) {
			return true;
		} else {
			return false;
		}

	}

	private static void insertX(int num, char[] currTemp) {

		switch (num) {
		case 1:
			for (int j = 1; j < currTemp.length; j++) {
				playField[currVer][++currHor] = currTemp[j];
			}
			break;
		case 2:
			for (int j = 1; j < currTemp.length; j++) {

				playField[++currVer][currHor] = currTemp[j];

			}
			break;
		case 3:
			for (int j = 1; j < currTemp.length; j++) {

				playField[currVer][--currHor] = currTemp[j];

			}
			break;
		case 4:
			for (int j = 1; j < currTemp.length; j++) {

				playField[--currVer][currHor] = currTemp[j];

			}
			break;
		}

	}

}
