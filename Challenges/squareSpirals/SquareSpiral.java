package squareSpirals;

import java.util.HashMap;
import java.util.Map;

class Coordinate {
	int yPos;
	int xPos;

	Coordinate(int xPos, int yPos) {
		this.yPos = xPos;
		this.xPos = yPos;
	}

	@Override
	public String toString() {
		return "(" + (xPos + 1) + "/" + (int) Math.ceil((yPos + 1.0) / 2) + ")";
	}

}

public class SquareSpiral {

	private static String[][] field;
	private static Map<Integer, Coordinate> map = new HashMap<Integer, Coordinate>();
	private static int numberOfPos = 1;

	public static void create(int size) {

		field = new String[size * 2 - 1][size];

		for (int i = 0; i < field.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < field[i].length; j++) {
					field[i][j] = " + ";
				}
			} else {
				for (int j = 0; j < field[i].length; j++) {
					field[i][j] = "   ";
				}
			}
		}

		printField();

		int midPoint = (int) Math.ceil(size / 2.0);

		field[midPoint * 2 - 2][midPoint - 1] = " X-";

		printField();

		drawSpiral(midPoint);

		printField();

	}

	private static void printField() {

		for (int i = 0; i < field[1].length * 3; i++) {
			System.out.print("/");
		}
		System.out.println();

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}

	private static void drawSpiral(int midPoint) {

		String dir = "rechts";
		int[] currPos = { midPoint * 2 - 2, midPoint - 1 };
		map.put(numberOfPos++, new Coordinate(midPoint * 2 - 2, midPoint - 1));

		while (field[field.length - 1][field[0].length - 1].equals(" + ")) {

			switch (dir) {
			case "oben":
				currPos[0] -= 2;
				field[currPos[0] + 1][currPos[1]] = " | ";
				if (field[currPos[0]][currPos[1] - 1].equals(" + ")) {
					field[currPos[0]][currPos[1]] = "-X ";
					dir = "links";
					printField();
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
				} else {
					field[currPos[0]][currPos[1]] = " X ";
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
					// printField();
				}
				break;
			case "links":
				currPos[1]--;
				if (field[currPos[0] + 2][currPos[1]].equals(" + ")) {
					field[currPos[0]][currPos[1]] = " X-";
					dir = "unten";
					printField();
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
				} else {
					field[currPos[0]][currPos[1]] = "-X-";
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
					// printField();
				}
				break;
			case "unten":
				currPos[0] += 2;
				field[currPos[0] - 1][currPos[1]] = " | ";
				if (field[currPos[0]][currPos[1] + 1].equals(" + ")) {
					field[currPos[0]][currPos[1]] = " X-";
					dir = "rechts";
					printField();
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
				} else {
					field[currPos[0]][currPos[1]] = " X ";
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
					// printField();
				}
				break;
			case "rechts":
				currPos[1]++;
				if (field[currPos[0] - 2][currPos[1]].equals(" + ")) {
					field[currPos[0]][currPos[1]] = "-X ";
					dir = "oben";
					printField();
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
				} else {
					field[currPos[0]][currPos[1]] = "-X-";
					map.put(numberOfPos++, new Coordinate(currPos[0], currPos[1]));
					// printField();
				}
				break;
			}

		}

	}

	public static void getPosForNum(int number) {
		if (number <= map.size()) {
			System.out.println(map.get(number).toString());

			String temp = field[map.get(number).yPos][map.get(number).xPos];

			field[map.get(number).yPos][map.get(number).xPos] = "!X!";

			printField();

			field[map.get(number).yPos][map.get(number).xPos] = temp;

		} else {
			System.err.println("Please Insert a valid number!");
		}
	}

	public static void getPosForCoor(String coord) {
		
		for (Map.Entry<Integer, Coordinate> entry : map.entrySet()) {
		    Integer key = entry.getKey();
		    Coordinate value = entry.getValue();
		    
		    if(value.toString().equals(coord)) {
		    	System.out.println(key);
		    	
		    	String temp = field[value.yPos][value.xPos];
		    	
		    	field[value.yPos][value.xPos] = "!X!";

				printField();
				
				field[value.yPos][value.xPos] = temp;
		    }
		    
		    
		}
		
	}

}
