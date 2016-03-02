package ppmPic;

import java.util.List;

public class Picture {

	private final String[][] grid;
	private final int width;
	private final int height;

	private final String header;

	public Picture(int width, int height, String header) {
		grid = new String[height][width];
		this.width = width;
		this.height = height;
		this.header = header;

		clearGrid();
	}

	public void clearGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = String.format("%3d %3d %3d", 0, 0, 0);
			}
		}
	}

	public String[][] getGrid() {
		return grid;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getHeader() {
		return header;
	}

	private String getGridAsString() {

		StringBuilder gridString = new StringBuilder();

		for (String[] sArr : grid) {
			for (String sString : sArr) {
				gridString.append(sString + "\t");
			}
			gridString.append("\n");
		}

		return gridString.toString();
	}

	public String getFileContent() {

		StringBuilder output = new StringBuilder();

		output.append(header + "\n");
		output.append(width + " " + height + "\n");
		output.append("255\n");

		output.append(getGridAsString());

		return output.toString();
	}

	public void addShapeToArray(AbstractShape shape) {

		List<String> pos = shape.getPositions();

		for (String position : pos) {

			String[] parts = position.split(" ");

			int xPos = Integer.parseInt(parts[0]);
			int yPos = Integer.parseInt(parts[1]);

			grid[yPos][xPos] = shape.getColor();

		}

	}

}
