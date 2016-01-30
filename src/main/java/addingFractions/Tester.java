package addingFractions;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many Fractions do you want do add?");
		String[] fractionsArray = new String[scanner.nextInt()];
		scanner.nextLine();
		
		System.out.println("Enter the fractions like 'X/Y'...");
		for(int i = 0; i < fractionsArray.length; i++) {
			fractionsArray[i] = scanner.nextLine().trim();
		}
		
		scanner.close();
		
		FractionAdder.addFractions(fractionsArray);
	
	}

}
