package perfectArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionBackup {

	//Testcase 14 - 2 1 40 5 7 6 9 8 2 3 10 11 31 4
	//Testcase 4 - 2 3 1 4
	//Testcase 6 - 4 3 9 8 6 5
	//Testcase 20 - 12 11 9 4 22 21 87 15 44 34 1 2 3 4 5 6 9 8 7 66
	
	private static final Scanner scanner = new Scanner(System.in);
	private static List<Integer> wrongOddNums = new ArrayList<Integer>();
	private static List<Integer> wrongEvenNums = new ArrayList<Integer>();
	private static int swaps = 0;

	public static void main(String[] args) {

		System.out.println("Enter");
		int numOfInputs = getNumOfInputs();
		int[] inputs = new int[numOfInputs];

		String input = getInput();

		String[] singleIns = input.split(" ");

		for (int i = 0; i < numOfInputs; i++) {
			inputs[i] = Integer.parseInt(singleIns[i].trim());
		}

		for (int i = 0; i < numOfInputs; i++) {
			if (inputs[i] % 2 != 0 && (i + 1) % 2 == 0) {
				wrongOddNums.add(i);
			} else if (inputs[i] % 2 == 0 && (i + 1) % 2 != 0) {
				wrongEvenNums.add(i);
			}
		}

		for (int i : inputs) {
			System.out.println(i);
		}

		System.out.println();

		for (int i = 0; i < wrongEvenNums.size(); i++) {
			swap(inputs, wrongEvenNums.remove(i), getSmallestValue(inputs));
			i--;
			swaps++;
		}

		for (int i : inputs) {
			System.out.println(i);
		}
		
		System.out.println("swaps = " + swaps);

		System.out.println();

		for (int i = 0; i < inputs.length - 1; i++) {
			int smallest = getSmallest(inputs, i);

			if (inputs[smallest] < inputs[i]) {
				int temp = inputs[i];

				inputs[i] = inputs[smallest];
				inputs[smallest] = temp;
				swaps++;
			}
		}

		for (int i : inputs) {
			System.out.println(i);
		}
		
		System.out.println("swaps = " + swaps);

	}

	private static int getSmallest(int[] inputs, int currIndex) {

		int smallest = Integer.MAX_VALUE;
		int smallestIndex = 0;

		for (int i = currIndex; i < inputs.length; i += 2) {
			if (inputs[i] < smallest) {
				smallest = inputs[i];
				smallestIndex = i;
			}
		}

		return smallestIndex;
	}

	private static void swap(int[] inputs, int wrongEvenIndex, int smallestOddIndex) {
		int temp = inputs[wrongEvenIndex];

		inputs[wrongEvenIndex] = inputs[smallestOddIndex];
		inputs[smallestOddIndex] = temp;

	}

	private static int getSmallestValue(int[] inputs) {

		int smallestValue = Integer.MAX_VALUE;
		int lastLowest = 0;

		for (int i = 0; i < wrongOddNums.size(); i++) {
			if (inputs[wrongOddNums.get(i)] < smallestValue) {
				smallestValue = inputs[wrongOddNums.get(i)];
				lastLowest = i;
			}
		}

		return wrongOddNums.remove(lastLowest);
	}

	private static String getInput() {
		return scanner.nextLine();
	}

	private static int getNumOfInputs() {

		int numOfInputs = scanner.nextInt();
		scanner.nextLine();

		if (numOfInputs < 2) {
			numOfInputs = getNumOfInputs();
		}

		return numOfInputs;
	}
}