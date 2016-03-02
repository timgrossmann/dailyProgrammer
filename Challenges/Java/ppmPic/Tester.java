package ppmPic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		Scanner scanner;
		try {
			scanner = new Scanner(new File("src/main/java/ppmPic/input1.txt"));

			int width = scanner.nextInt();
			int height = scanner.nextInt();
			scanner.nextLine();

			List<String> input = new ArrayList<>();

			while (scanner.hasNext()) {
				input.add(scanner.nextLine());
			}

			scanner.close();

			Picture picture = new Picture(width, height, "P3");

			List<AbstractShape> shapes = new ArrayList<>();

			for (String command : input) {

				String[] parts = command.split(" ");

				int red = Integer.parseInt(parts[1]);
				int green = Integer.parseInt(parts[2]);
				int blue = Integer.parseInt(parts[3]);
				int xStartPos = Integer.parseInt(parts[4]);
				int yStartPos = Integer.parseInt(parts[5]);

				switch (parts[0]) {
				case "point":
					AbstractShape point = new Point(red, green, blue, xStartPos, yStartPos, 0, 0);
					shapes.add(point);
					break;
				case "line":
					AbstractShape line = new Line(red, green, blue, xStartPos, yStartPos, Integer.parseInt(parts[6]),
							Integer.parseInt(parts[7]));
					shapes.add(line);
					break;
				case "rect":
					AbstractShape rect = new Rectangle(red, green, blue, xStartPos, yStartPos,
							Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
					shapes.add(rect);
					break;
				}

			}

			for (AbstractShape shape : shapes) {
				picture.addShapeToArray(shape);
			}

			System.out.println(picture.getFileContent());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
