package asciiCastle;

public class Castleizer {

	private static String building[][];
	private static StringBuilder test = new StringBuilder();

	public static void makeCastle(String[][] building) {

		Castleizer.building = new String[building.length * 3][building[building.length - 1].length * 5];

		for (int i = 0; i < building.length; i++) {
			drawCastlePart(building[i], i);
		}

		drawFloor(building[building.length - 1]);

		System.out.println();
		makeArray();
		arrayTrim();
		print();

		trimCols();
		print();

		trimMids();
		print();
		
		removeHorLines();
		print();
	}
	
	private static void removeHorLines() {
		
		String[][] temp = new String[building.length][building[0].length];
		
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				temp[i][j] = new String(building[i][j]);
			}
		}
		
		
		for(int i = 2; i < building.length - 2; i++) {
			for(int j = 0; j < building[i].length; j++) {
				if(!building[i-1][j].equals("|") && (building[i-2][j].equals("-") || building[i-2][j].equals("+")) && building[i+2][j].equals("-")) {
					temp[i][j] = " ";
				}
			}
		}
		
		building = temp;
		
	}

	private static void trimMids() {
		for (int i = 1; i < building.length - 1; i++) {
			for (int j = 2; j < building[i].length - 1; j++) {
				if (building[i][j - 2].equals("-") && building[i][j].equals("+") && building[i][j + 2].equals("-")) {
					building[i + 1][j] = " ";
				}
			}
			for(int j = 2; j < building[i].length - 2; j++) {
				if (building[i][j].equals("+") && !building[i - 1][j].equals("|") && !building[i + 1][j].equals("|")) {
					building[i][j] = "-";
				}
			}
		}
		
		for(int j = 2; j < building[0].length - 2; j++) {
			if(building[building.length - 1][j].equals("+") && building[building.length - 1][j - 2].equals("-") && building[building.length - 1][j + 2].equals("-")) {
				building[building.length - 1][j] = "-";
			}
		}
	}

	private static void trimCols() {
		for (int i = 1; i < building.length; i++) {
			for (int j = 1; j < building[i].length - 1; j++) {
				if (building[i][j].equals("+") && building[i][j + 1].equals("+")) {
					if (j < building[0].length / 2 - 3) {
						removeCol(j);
					} else {
						removeCol(j + 1);
					}
				}
			}
		}
	}

	private static void removeCol(int col) {
		for (int i = 0; i < building.length; i++) {
			building[i][col] = "";
		}
	}

	private static void arrayTrim() {

		int trimIndex = 0;

		for (int i = 0; i < building.length; i++) {
			for (int j = 0; j < building[i].length; j++) {
				if (building[i][j] == null) {
					trimIndex = i;
					break;
				}
			}
			if (trimIndex != 0) {
				break;
			}
		}

		String[][] newBuilding = new String[trimIndex][building[0].length];

		for (int i = 0; i < newBuilding.length; i++) {
			newBuilding[i] = building[i];
		}

		Castleizer.building = newBuilding;

	}

	private static void drawCastlePart(String[] part, int row) {

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < part.length; j++) {
				switch (i) {
				case 0:
					if (part[j].equals(" ")) {
						System.out.print("     ");
						test.append("     ");
					} else {
						System.out.print("+---+");
						test.append("+---+");
					}
					break;
				case 1:
					if (part[j].equals(" ")) {
						System.out.print("     ");
						test.append("     ");
					} else {
						System.out.print("|   |");
						test.append("|   |");
					}
					break;
				}
			}
			System.out.println();
			test.append("\n");
		}

	}

	private static void drawFloor(String[] floor) {
		for (String s : floor) {
			if (s.equals(" ")) {
				System.out.print("     ");
				test.append("     ");
			} else {
				System.out.print("+---+");
				test.append("+---+");
			}
		}
	}

	private static void makeArray() {
		String[] lines = test.toString().split("\\n");
		for (int i = 0; i < lines.length; i++) {
			char[] charsInS = lines[i].toCharArray();

			for (int j = 0; j < charsInS.length; j++) {
				building[i][j] = String.valueOf(charsInS[j]);
			}
		}
	}

	private static void print() {
		for (String[] s : building) {
			for (String c : s) {
				if (c != null) {
					System.out.print(c);
				} else {

				}
			}
			System.out.println();
		}
	}

}
