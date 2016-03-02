package ppmPic;

import java.util.List;

public abstract class AbstractShape {

	private int red;
	private int green;
	private int blue;

	private int xStartPos;
	private int yStartPos;
	private int xEndPos;
	private int yEndPos;

	public AbstractShape(int red, int green, int blue, int xStartPos, int yStartPos, int xEndPos, int yEndPos) {
		super();
		this.setRed(red);
		this.setGreen(green);
		this.blue = blue;
		this.xStartPos = xStartPos;
		this.yStartPos = yStartPos;
		this.xEndPos = xEndPos;
		this.yEndPos = yEndPos;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}
	
	public String getColor() {
		return String.format("%3d %3d %3d", getRed(), getGreen(), getBlue());
	}

	public int getxStartPos() {
		return xStartPos;
	}

	public void setxStartPos(int xStartPos) {
		this.xStartPos = xStartPos;
	}

	public int getyStartPos() {
		return yStartPos;
	}

	public void setyStartPos(int yStartPos) {
		this.yStartPos = yStartPos;
	}

	public int getxEndPos() {
		return xEndPos;
	}

	public void setxEndPos(int xEndPos) {
		this.xEndPos = xEndPos;
	}

	public int getyEndPos() {
		return yEndPos;
	}

	public void setyEndPos(int yEndPos) {
		this.yEndPos = yEndPos;
	}
	
	public abstract List<String> getPositions();

	@Override
	public String toString() {
		return "AbstractShape [red=" + red + ", green=" + green + ", blue=" + blue + ", xStartPos=" + xStartPos
				+ ", yStartPos=" + yStartPos + ", xEndPos=" + xEndPos + ", yEndPos=" + yEndPos + "]";
	}
	

}
