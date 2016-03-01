package palindromes;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please input the number of Strings...");

		String input = "";
		
		int strings = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < strings; i++) {
			System.out.print(i + ":");
			input += scanner.nextLine();
		}

		SearchPalindrome.checkForPalindrome(input);
		
		scanner.close();
		
		System.out.println();

		System.out.println();

		System.out.println();
		
		SearchPalindromeSec.checkForPalin(input);
		
	}

}
