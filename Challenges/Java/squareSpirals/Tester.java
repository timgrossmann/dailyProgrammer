package squareSpirals;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean isUneven = false;
		int size;

		do {
			System.out.println("Please insert an uneven number for the size of the Field!");
			size = scanner.nextInt();
			scanner.nextLine();

			if (size % 2 != 0) {
				isUneven = true;
			}

		} while (isUneven == false);

		SquareSpiral.create(size);

		String input;
		
		while (true) {
			System.out.println("Insert the Number or Coord you want to get the Position from...");
			
			input = scanner.nextLine();
			
			try {
				SquareSpiral.getPosForNum(Integer.parseInt(input));
			} catch(NumberFormatException e) {
				SquareSpiral.getPosForCoor(input);
			}
			
		}

	}

}
