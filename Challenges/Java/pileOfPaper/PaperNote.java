package pileOfPaper;

public class PaperNote {
	
	private int numOfNote;
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	
	public PaperNote(int numOfNote, int xPos, int yPos, int width, int height) {
		this.numOfNote = numOfNote;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}


	public int getNumOfNote() {
		return numOfNote;
	}


	public int getxPos() {
		return xPos;
	}


	public int getyPos() {
		return yPos;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
	
	

}
