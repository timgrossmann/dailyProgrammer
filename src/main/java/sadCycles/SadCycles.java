package sadCycles;

public class SadCycles {

	public static void sadCycles(int base, int hochZahl) {

		int currCombination = base;
		int[] results = new int[64];
		int counter = 0;
		boolean isLoop = false;

		while (!isLoop) {

			int[] splittedNums = getParts(currCombination);

			currCombination = getNewBase(splittedNums, hochZahl);
			isLoop = checkLooped(currCombination, results, counter);
			results[counter] = currCombination;

			if (!isLoop) {
				counter++;
			}
		}

		printResult(results, counter);

	}

	
	private static void printResult(int[] results, int counter) {
		int[] finalRes = new int[counter];
		int index = 0;

		for (int i = 0; i < counter; i++) {
			if (results[i] == results[counter]) {
				index = i;
				break;
			}
		}

		for (int i = index; i < counter; i++) {
			finalRes[i - index] = results[i];
			System.out.print(finalRes[i - index] + ", ");
		}

	}

	
	private static boolean checkLooped(int currCombination, int[] results,
			int counter) {

		if (currCombination == 1) {
			return true;
		} else {

			for (int i = 0; i < counter; i++) {

				if (results[i] == currCombination) {
					return true;
				}

			}

		}

		return false;

	}

	
	private static int getNewBase(int[] comb, int hochZahl) {
		int newBase = 0;
		int tempZahl = 1;

		for (int i = 0; i < comb.length; i++) {

			for (int j = 0; j < hochZahl; j++) {

				tempZahl *= comb[i];

			}

			newBase += tempZahl;
			tempZahl = 1;
		}

		return newBase;
	}

	private static int[] getParts(int number) {
		int counter = 0;
		int[] temp = new int[10];

		while (number > 0) {

			temp[counter] = number % 10;
			counter++;
			number /= 10;

		}

		int[] valCom = new int[counter];

		for (int i = counter - 1; i >= 0; i--) {
			valCom[i] = temp[i];
		}

		return valCom;
	}

}
