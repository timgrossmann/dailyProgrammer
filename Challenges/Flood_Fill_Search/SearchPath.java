import java.util.ArrayList;
import java.util.List;

public class SearchPath {

	private static String[][] maze;
	private static String[][] finalPath;
	private static Coordinate startPoint;
	private static Coordinate endPoint;
	private static List<Coordinate> points = new ArrayList<>();
	private static int moveFields;

	public static void getPath(String[] maze) {

		SearchPath.maze = new String[maze.length][maze.length];
		SearchPath.finalPath = new String[maze.length][maze.length];
		moveFields = 2;

		for (int i = 0; i < maze.length; i++) {
			char[] parts = maze[i].toCharArray();

			List<Character> temp = new ArrayList<>();

			for (char c : parts) {
				temp.add(c);
			}

			for (int j = 0; j < maze.length; j++) {
				if (j % 2 != 0) {
					String tempString = "";

					for (int k = 0; k < 3; k++) {
						tempString += temp.remove(0);
					}
					SearchPath.maze[i][j] = tempString;
					SearchPath.finalPath[i][j] = tempString;

				} else {

					String tempInput = String.valueOf(temp.remove(0));

					SearchPath.maze[i][j] = tempInput;
					SearchPath.finalPath[i][j] = tempInput;
				}

			}
		}

		print(SearchPath.maze);

		searchStart();

		// System.out.println(startPoint);
		// System.out.println(endPoint);
		System.out.println();

		points.add(endPoint);

		flood(points, 1);

		/*------print Maze with Numbers-------*/
//		print(SearchPath.maze);

		printPath(startPoint, Integer.MAX_VALUE);
		
		print(SearchPath.finalPath);

	}

	private static void printPath(Coordinate p, int currValue) {

		Coordinate minValuePoint = null;
		
		for (int i = 0; i < 4; i++) {

			switch (i) {
			case 0: // up
				if (p.y > (moveFields - 1) && maze[p.y - 1][p.x].equals("   ") && !(maze[p.y - moveFields][p.x].equals(" z ") || maze[p.y - moveFields][p.x].equals(" x "))
						&& Integer.parseInt(maze[p.y - moveFields][p.x].trim()) < currValue) {
					currValue = Integer.parseInt(maze[p.y - moveFields][p.x].trim());
					minValuePoint = new Coordinate(p.x, p.y - moveFields);
				}
				break;
			case 1: // right
				if (p.x < (maze.length - 1 - (moveFields - 1)) && maze[p.y][p.x + 1].equals(" ") && !(maze[p.y][p.x + moveFields].equals(" z ") || maze[p.y][p.x + moveFields].equals(" x "))
						&& Integer.parseInt(maze[p.y][p.x + moveFields].trim()) < currValue) {
					currValue = Integer.parseInt(maze[p.y][p.x + moveFields].trim());
					minValuePoint = new Coordinate(p.x + moveFields, p.y);
				}
				break;
			case 2: // down
				if (p.y < (maze.length - 1 - (moveFields - 1)) && maze[p.y + 1][p.x].equals("   ") && !(maze[p.y + moveFields][p.x].equals(" z ") || maze[p.y + moveFields][p.x].equals(" x "))
						&& Integer.parseInt(maze[p.y + moveFields][p.x].trim()) < currValue) {
					currValue = Integer.parseInt(maze[p.y + moveFields][p.x].trim());
					minValuePoint = new Coordinate(p.x, p.y + moveFields);
				}
				break;
			case 3: // left
				if (p.x > (moveFields - 1) && maze[p.y][p.x - 1].equals(" ") && !(maze[p.y][p.x - moveFields].equals(" z ") || maze[p.y][p.x - moveFields].equals(" x ")) 
						&& Integer.parseInt(maze[p.y][p.x - moveFields].trim()) < currValue) {
					currValue = Integer.parseInt(maze[p.y][p.x - moveFields].trim());
					minValuePoint = new Coordinate(p.x - moveFields, p.y);
				}
				break;
			}

		}
		
		

		if (minValuePoint != null) {
			finalPath[minValuePoint.y][minValuePoint.x] = " # ";
//			print(SearchPath.finalPath);
			printPath(minValuePoint, currValue);
		}

		

	}

	private static void flood(List<Coordinate> points, int value) {

		List<Coordinate> newPoints = new ArrayList<>();
		// toDo

		for (int i = 0; i < points.size(); i++) {

			Coordinate point = points.get(i);
			// System.out.println(point);

			for (int j = 0; j < 4; j++) {

				switch (j) {
				case 0: // up

					if (point.y > 0 + (moveFields - 1) && maze[point.y - moveFields][point.x].equals("   ")
							&& maze[point.y - 1][point.x].equals("   ")) {
						if (value < 10) {
							maze[point.y - moveFields][point.x] = " " + value + " ";
						} else if (value > 99) {
							maze[point.y - moveFields][point.x] = "" + value;
						} else {
							maze[point.y - moveFields][point.x] = " " + value;
						}
						newPoints.add(new Coordinate(point.x, point.y - moveFields));
						// System.out.println("up");
					}
					break;
				case 1: // right
					if (point.x < (maze.length - 1 - (moveFields - 1))
							&& maze[point.y][point.x + moveFields].equals("   ")
							&& maze[point.y][point.x + 1].equals(" ")) {
						if (value < 10) {
							maze[point.y][point.x + moveFields] = " " + value + " ";
						} else if (value > 99) {
							maze[point.y][point.x + moveFields] = "" + value;
						} else {
							maze[point.y][point.x + moveFields] = " " + value;
						}

						newPoints.add(new Coordinate(point.x + moveFields, point.y));
						// System.out.println("right");
					}
					break;
				case 2: // down
					if (point.y < (maze.length - 1 - (moveFields - 1))
							&& maze[point.y + moveFields][point.x].equals("   ")
							&& maze[point.y + 1][point.x].equals("   ")) {
						if (value < 10) {
							maze[point.y + moveFields][point.x] = " " + value + " ";
						} else if (value > 99) {
							maze[point.y + moveFields][point.x] = "" + value;
						} else {
							maze[point.y + moveFields][point.x] = " " + value;
						}

						newPoints.add(new Coordinate(point.x, point.y + moveFields));
						// System.out.println("down");
					}
					break;
				case 3: // left
					if (point.x > 0 + (moveFields - 1) && maze[point.y][point.x - moveFields].equals("   ")
							&& maze[point.y][point.x - 1].equals(" ")) {
						if (value < 10) {
							maze[point.y][point.x - moveFields] = " " + value + " ";
						} else if (value > 99) {
							maze[point.y][point.x - moveFields] = "" + value;
						} else {
							maze[point.y][point.x - moveFields] = " " + value;
						}

						newPoints.add(new Coordinate(point.x - moveFields, point.y));
						// System.out.println("left");
					}
					break;
				}
				// System.out.println();

			}
		}

		// print();

		points.clear();
		if (!newPoints.isEmpty()) {
			points.addAll(newPoints);
			// for (Coordinate p : points) {
			// System.out.print(p + " - ");
			// }

			// System.out.println();
			// System.out.println();

			flood(points, value + 1);
		}

	}

	private static void searchStart() {

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j].equals(" x ")) {
					startPoint = new Coordinate(j, i);
				} else if (maze[i][j].equals(" z ")) {
					endPoint = new Coordinate(j, i);
				}
			}
		}

	}

	private static void print(String[][] maze) {
		for (String[] s : maze) {
			for (String s2 : s) {
				System.out.print(s2);
			}
			System.out.println();
		}
	}

}
