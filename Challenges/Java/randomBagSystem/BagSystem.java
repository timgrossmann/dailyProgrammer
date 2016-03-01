package randomBagSystem;

import java.util.LinkedList;
import java.util.Random;

public class BagSystem {

	private LinkedList<String> bag = new LinkedList<String>();
	private static final String[] pieces = { "O", "I", "S", "Z", "L", "J", "T" };
	private static Random random = new Random();

	public void generateGame(int numberOfTurns) {

		fillBag();
		
		for (int i = 0; i < numberOfTurns; i++) {
			if (bag.size() == 0) {
				fillBag();
				System.out.println();
			}
			System.out.print(bag.remove(random.nextInt(bag.size())));
		}

	}

	private void fillBag() {
		for (String s : pieces) {
			bag.add(s);
		}
	}

}
