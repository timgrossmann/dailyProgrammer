package texasHoldEm;

import java.util.Random;
import java.util.Scanner;

public class TexasHoldEm {

	// class Vars
	private static int deckLength = 52;
	private static int numOfPlayers;
	private static final char[] symbols = { '\u2665', '\u2666', '\u2663',
			'\u2660' };
	private static final String[] values = { "Ace", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "Jack", "Queen", "King" };
	private static Random random = new Random();
	private static Scanner scanner = new Scanner(System.in);
	

	/**
	 * Method to be called outside of the class Starts the game
	 */
	public static void startGame() {

		// Declaring needed Vars
		boolean isRightNum = false;
		String tempNumOfPlayers; // used for the testing if it is an int

		// First output
		System.out.println("How many Players? (2-8)");

		// Looping until user entered valid number
		while (!isRightNum) {

			// Getting user Input
			tempNumOfPlayers = scanner.nextLine();

			try {

				// checking if Parsable
				numOfPlayers = Integer.parseInt(tempNumOfPlayers);

				// Checking if the numOfPlayers is >=2
				if (numOfPlayers >= 2 && numOfPlayers <= 8) {
					// Printing communication
					System.out.printf(
							"Game starting with %d Computer Player/s ? %n",
							numOfPlayers - 1);
					System.out.println();
					System.out
							.println("<**//-----------------------------\\\\**>");
					// stopping the loop
					isRightNum = true;

					// running the actual Game
					runGame();

				} else {
					// Asking for another input
					System.out.println("Please input a number between 2-8!");
				}

				// catching the Problem if user enters a wrong input
			} catch (NumberFormatException exception) {
				System.out.println("Please input a number between 2-8!");
			}

		}

	}

	/**
	 * Main game Method
	 */
	private static void runGame() {

		// Create a Deck of 52 unique cards
		String[] cardDeck = createNewDeck();

		// shuffles the card deck (using Fisher–Yates shuffle)
		cardDeck = shuffleCards(cardDeck);

		// for (int i = 0; i < cardDeck.length; i++) {
		// System.out.println(cardDeck[i]);
		// }

		// dealing the card for each player and returning the new set of cards
		// without the dealt ones
		cardDeck = dealCards(cardDeck);
		
		//throw away 1 card
		burnCard();
		
		//dealing the flop
		doTheFlop(cardDeck);
		
		//throw away 1 card
		burnCard();
		
		//dealing the turn
		dealTurnRiver(cardDeck);
		
		//throw away 1 card
		burnCard();
		
		//dealing the river
		dealTurnRiver(cardDeck);

	}
	
	
	private static String[] dealTurnRiver(String[] cardDeck) {
		
		System.out.printf("%s %n", cardDeck[deckLength - 1]);
		removeCardFromDeck();
		
		return cardDeck;
	}
	
	/**
	 * dealing out the flop
	 * @param cardDeck
	 * @return
	 */
	private static String[] doTheFlop(String[] cardDeck) {
		
		System.out.println();
		System.out.println("Flop / Turn / River:");
		
		for(int i = 0; i < 3; i++) {
			System.out.printf("%s %n", cardDeck[deckLength - 1]);
			removeCardFromDeck();
		} 
		
		return cardDeck;
	}

	/**
	 * burning the top card
	 * @param cardDeck
	 * @return
	 */
	private static void burnCard() {
		
		removeCardFromDeck();
		
	}
	
	
	/**
	 * dealing the card for each player and returning the new set of cards
	 * without the dealt ones
	 * 
	 * @param cardDeck
	 * @return
	 */
	private static String[] dealCards(String[] cardDeck) {

		String ranCardOne;
		String ranCardTwo;

		for (int i = 0; i < numOfPlayers; i++) {

			ranCardOne = cardDeck[deckLength - 1];
			removeCardFromDeck();

			ranCardTwo = cardDeck[deckLength - 1];
			removeCardFromDeck();

			if (i == 0) {

				System.out.printf("Your Cards: %s // %s %n", ranCardOne,
						ranCardTwo);
				System.out.println();
				
			} else {

				System.out.printf("Player%d Cards: %s // %s %n", i, ranCardOne,
						ranCardTwo);
				
			}
			

		}

		return cardDeck;
	}

	private static void removeCardFromDeck() {
		deckLength--;
	}

	/**
	 * Creates a Deck of 52 unique cards
	 * 
	 * @return
	 */
	private static String[] createNewDeck() {

		// StringArray with the size of a card Deck
		String[] cardDeck = new String[52];
		int counter = 0;

		// creates a Card for every value and symbol
		for (int i = 0; i < symbols.length; i++) {
			for (int j = 0; j < values.length; j++) {
				cardDeck[counter] = values[j] + symbols[i];
				counter++;
			}
		}

		return cardDeck;
	}

	/**
	 * shuffles the card deck (using Fisher–Yates shuffle)
	 * 
	 * @param cardDeck
	 * @return
	 */
	private static String[] shuffleCards(String[] cardDeck) {

		// initializing the vars
		int cardsLeft = cardDeck.length;
		int ranNum;
		// temp to store the actual value in
		String tempNum;

		// while there are cards to sort
		while (cardsLeft > 0) {

			// getting a new random int
			ranNum = random.nextInt(cardsLeft);
			cardsLeft--;

			// saving the value of the latest position in the array
			tempNum = cardDeck[cardsLeft];
			// assigning the random numbered value to the last position
			cardDeck[cardsLeft] = cardDeck[ranNum];
			// assigning the value of the last position to the random position
			cardDeck[ranNum] = tempNum;

		}

		return cardDeck;
	}

}
