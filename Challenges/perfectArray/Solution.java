package perfectArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);
	private static List<Integer> wrongOddNums = new ArrayList<Integer>();
	private static List<Integer> wrongEvenNums = new ArrayList<Integer>();
	private static long swaps = 0;

	public static void main(String[] args) {

		int numOfInputs = getNumOfInputs();
		long[] inputs = new long[numOfInputs];

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

		for (int i = 0; i < wrongEvenNums.size(); i++) {
			swap(inputs, wrongEvenNums.remove(i), getSmallestValue(inputs));
			i--;
			swaps++;
		}

		for (int i = 0; i < inputs.length - 1; i++) {
			int smallest = getSmallest(inputs, i);

			if (inputs[smallest] < inputs[i]) {
				long temp = inputs[i];

				inputs[i] = inputs[smallest];
				inputs[smallest] = temp;
				swaps++;
			}
		}

		System.out.println(swaps);
		
		scanner.close();

	}

	private static int getSmallest(long[] inputs, int currIndex) {

		long smallest = Integer.MAX_VALUE;
		int smallestIndex = 0;

		for (int i = currIndex; i < inputs.length; i += 2) {
			if (inputs[i] < smallest) {
				smallest = inputs[i];
				smallestIndex = i;
			}
		}

		return smallestIndex;
	}

	private static void swap(long[] inputs, int wrongEvenIndex, int smallestOddIndex) {
		long temp = inputs[wrongEvenIndex];

		inputs[wrongEvenIndex] = inputs[smallestOddIndex];
		inputs[smallestOddIndex] = temp;

	}

	private static int getSmallestValue(long[] inputs) {

		long smallestValue = Integer.MAX_VALUE;
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