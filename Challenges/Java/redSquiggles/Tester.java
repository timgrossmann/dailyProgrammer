package redSquiggles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tester {
	public static void main(String[] args) throws IOException {

		
		RedSquiggler tester = new RedSquiggler();
		
		tester.checkWords(Files.readAllLines(Paths.get("words.txt")));
		
		
	}
}
