package brokenKeyboard;

import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter the number of lines you want to commit...");
		int numOfLines = scanner.nextInt();
		scanner.nextLine();
		
		String[] inputLines = new String[numOfLines];
		
		for(int i = 0; i < numOfLines; i++) {
			
			inputLines[i] = scanner.nextLine();
			
		}
		
		scanner.close();
		
		System.out.println();
		
		BrokenKeyboardSearch.getWords(inputLines);
		
		System.out.println();

		BrokenKeyboardSearchUpdated.getWords(inputLines);
		
		
	}

}
