package daysOfCode30;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);

		int lines = scanner.nextInt();

		for (int i = 0; i < lines; i++) {
			for (int j = lines - 1; j > i; j--) {
				System.out.print(" ");
			}

			for (int j = 0; j <= i; j++) {
				System.out.print("#");
			}

			System.out.println();

		}

		scanner.close();

	}

}
