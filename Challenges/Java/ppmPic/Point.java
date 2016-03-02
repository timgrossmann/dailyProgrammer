package ppmPic;

import java.util.ArrayList;
import java.util.List;

public class Point extends AbstractShape {

	public Point(int red, int green, int blue, int xStartPos, int yStartPos, int xEndPos, int yEndPos) {
		super(red, green, blue, xStartPos, yStartPos, xEndPos, yEndPos);
	}

	@Override
	public List<String> getPositions() {
		List<String> temp = new ArrayList<>();
		temp.add(getyStartPos() + " " + getxStartPos());
		return temp;
	}

}
