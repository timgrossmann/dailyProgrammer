package asciiCastle;

public class Tester {

	public static void main(String[] args) {
		
//		String[][] building = {{" ", " ", " ", "*", " ", " "},{" ", " ", "*", "*", "*", " "},{"*", "*", "*", "*", "*", "*"}};

		
		String[][] building2 = {{" ", " ", "*", " ", " ", " ", " "},{" ", " ", "*", "*", " ", " ", " "},{" ", "*", "*", "*", "*", " ", " "},{"*", "*", "*", "*", "*", "*", "*"}};

		
		Castleizer.makeCastle(building2);
	}
	
}
