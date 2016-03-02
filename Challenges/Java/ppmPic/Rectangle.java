package ppmPic;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends AbstractShape {

	public Rectangle(int red, int green, int blue, int xStartPos, int yStartPos, int xEndPos, int yEndPos) {
		super(red, green, blue, xStartPos, yStartPos, xEndPos, yEndPos);

		this.setxEndPos(xStartPos + xEndPos);
		this.setyEndPos(yStartPos + yEndPos);
	}

	@Override
	public List<String> getPositions() {

		List<String> positions = new ArrayList<>();

		for (int i = getyStartPos(); i < getyEndPos(); i++) {
			for (int j = getxStartPos(); j < getxEndPos(); j++) {
				positions.add(i + " " + j);
			}
		}

		return positions;
	}

}
