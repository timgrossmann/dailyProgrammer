package falloutHackingGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FalloutGame {

	private static final int numOfRounds = 4;
	private static final ThreadLocalRandom random = ThreadLocalRandom.current();
	private static List<String> listOfEnable;
	private List<String> listOfPossibleWords = new ArrayList<>();
	private List<String> listOfWords = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);
	private boolean wonGame = false;
	private String hackWord;

	public FalloutGame() {
		try {
			listOfEnable = Files.readAllLines(Paths.get("enable1.txt"));
		} catch (IOException e) {
		}
	}

	public void playGame(int difficulty) {
		System.out.println();

		initializeGameParts(difficulty);

		printPosWords();

		hackWord = listOfWords.get(random.nextInt(0, listOfWords.size()));

		for (int i = 0; i < numOfRounds; i++) {
			System.out.println();
			System.out.println("You have " + (numOfRounds - i) + " Guesses left...");
			System.out.print("Your Guess?: ");
			String guess = scanner.nextLine().toUpperCase();
			wonGame = checkGuess(guess);
			if (wonGame) {
				break;
			}
		}

		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
		}
		
		if (wonGame) {
			System.err.println();
			System.err.println("Unlocked, you won!");
			System.err.println("    Game Over!    ");
		} else {
			System.err.println();
			System.err.println("You lost. Game Over!");
			System.err.println("The word was: " + hackWord);
		}
		System.err.println("*----------------*");
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		System.out.println();
		System.out.println("Do you want to play again?...(y/n)");

		if (scanner.nextLine().toUpperCase().equals("Y")) {
			restartGame();
		}

	}

	private void restartGame() {
		listOfPossibleWords.clear();
		listOfWords.clear();
		wonGame = false;
		playGame(Tester.getDifficulty());
	}

	private boolean checkGuess(String guess) {

		int guessLength = guess.length();
		int rightChars = 0;

		for (int i = 0; i < guessLength; i++) {
			if (guess.charAt(i) == hackWord.charAt(i)) {
				rightChars++;
			}
		}

		System.out.println(rightChars + " of " + hackWord.length() + " correct!");

		if (rightChars == hackWord.length()) {
			return true;
		} else {
			return false;
		}

	}

	private void printPosWords() {
		for (String s : listOfWords) {
			System.out.println(s);
		}
	}

	private void initializeGameParts(int difficulty) {

		int minWords = 5;
		int minWordLenght = 4;
		int maxWords = 0;
		int maxWordLength = 0;

		switch (difficulty) {
		case 1:
			maxWords = 7;
			maxWordLength = 8;
			break;
		case 2:
			maxWords = 12;
			maxWordLength = 12;
			break;
		case 3:
			minWords = 8;
			minWordLenght = 6;
			maxWords = 12;
			maxWordLength = 12;
			break;
		case 4:
			minWords = 10;
			minWordLenght = 8;
			maxWords = 14;
			maxWordLength = 14;
			break;
		case 5:
			minWords = 11;
			minWordLenght = 10;
			maxWords = 15;
			maxWordLength = 15;
			break;
		}

		int words = random.nextInt(minWords, maxWords + 1);
		int wordLength = random.nextInt(minWordLenght, maxWordLength + 1);

		generateWordList(words, wordLength);

	}

	private void generateWordList(int words, int wordLength) {

		for (String s : listOfEnable) {
			if (s.matches("[a-z]{" + wordLength + "}")) {
				listOfPossibleWords.add(s);
			}
		}

		while (listOfWords.size() < words) {
			listOfWords.add(listOfPossibleWords.get(random.nextInt(0, listOfPossibleWords.size())).toUpperCase());
		}

	}

}
