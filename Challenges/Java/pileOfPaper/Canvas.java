package pileOfPaper;

import java.util.HashMap;

public class Canvas {

	private int[][] mainCanvas;
	private HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();

	public Canvas() {
		numbers.put(0, 0);
	}

	public Canvas(int height, int width) {
		this();
		createCanvas(height, width);
	}

	///////////////////////////////////////////////////

	public void createCanvas(int height, int width) {
		mainCanvas = new int[width][height];
	}

	public void addPaperNote(PaperNote paper) {

		numbers.put(paper.getNumOfNote(), 0);

		int maxHeight = paper.getyPos() + paper.getHeight();
		int maxWidth = paper.getWidth() + paper.getxPos();

		if (paper.getxPos() < mainCanvas[0].length && paper.getyPos() < mainCanvas.length) {

			if ((paper.getHeight() + paper.getyPos()) > mainCanvas.length) {
				maxHeight = mainCanvas.length;
			}
			if (paper.getWidth() + paper.getxPos() > mainCanvas[0].length) {
				maxWidth = mainCanvas[0].length;
			}
			for (int i = paper.getyPos(); i < maxHeight; i++) {
				for (int j = paper.getxPos(); j < maxWidth; j++) {
					mainCanvas[i][j] = paper.getNumOfNote();
				}
			}
		}

	}

	public void getNumOfNums() {

		for (int i = 0; i < mainCanvas.length; i++) {
			for (int j = 0; j < mainCanvas[i].length; j++) {
				numbers.put(mainCanvas[i][j], numbers.get(mainCanvas[i][j]) + 1);
			}
		}

		int[] myKeySet = new int[numbers.size()];

		int num = 0;

		for (int i : numbers.keySet()) {
			myKeySet[num++] = i;
		}

		for (int i = 0; i < myKeySet.length; i++) {
			if (numbers.get(myKeySet[i]) != 0) {
				System.out.println(myKeySet[i] + " " + numbers.get(myKeySet[i]));
			}
		}

		System.out.println();

	}

	public void print() {
		for (int[] i : mainCanvas) {
			for (int j : i) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
	}

}
