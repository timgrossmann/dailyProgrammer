package lumberJackPile;

import java.util.Random;
import java.util.Scanner;

public class LumberJackPile {

	private static int[][] woodPiles;
	private static int numOfWoods;
	private static Scanner input = new Scanner(System.in);
	private static int grid;
	private static final Random random = new Random();

	/**
	 * Constructor
	 */
	public LumberJackPile() {
		woodPiles = new int[1][1];
		numOfWoods = 0;
	}

	/**
	 * Getting input and starting prog
	 */
	public static void start() {

		System.out.println("Number of Piles ? (n = n/n)");

		// initializing Array
		grid = input.nextInt();
		input.nextLine();
		woodPiles = new int[grid][grid];

		System.out.println("Number of woodpieces ?");
		// Asking for the number of woods
		numOfWoods = input.nextInt();

		// randomlyn filling the pile
		randomFill();

		// printing out the Curr piles
		printPiles();

		// Adding the actual new woodpieces
		addWoods();

		// printing out the Curr piles
		printPiles();

	}

	/**
	 * adding the input woods
	 */
	private static void addWoods() {

		int logsToAdd = numOfWoods;
		int currMin = 0;

		while (logsToAdd > 0) {

			for (int i = 0; i < woodPiles.length; i++) {
				for (int j = 0; j < woodPiles[i].length; j++) {

					if (woodPiles[i][j] == currMin && logsToAdd > 0) {

						woodPiles[i][j]++;
						logsToAdd--;

					}

				}

			}
			currMin++;
		}
	}

	/**
	 * Fills in some of the piles
	 */
	private static void randomFill() {

		for (int i = 0; i < woodPiles.length; i++) {
			for (int j = 0; j < woodPiles[i].length; j++) {
				woodPiles[i][j] = random.nextInt(7);
			}
		}
	}

	/**
	 * Method for printing out the curr pile
	 */
	private static void printPiles() {

		System.out.println("--------");
		for (int i = 0; i < woodPiles.length; i++) {
			for (int j = 0; j < woodPiles[i].length; j++) {
				System.out.printf("%2d", woodPiles[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------");

	}

}
