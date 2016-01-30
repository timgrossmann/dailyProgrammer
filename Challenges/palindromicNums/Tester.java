package palindromicNums;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Please Input the Number you want to make Palindromic:");
		long input = scanner.nextLong();
		
		Palindrom.makePalindromic(input);
		
		scanner.close();
		
	}

}
