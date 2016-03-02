package ppmPic;

import java.util.ArrayList;
import java.util.List;

public class Line extends AbstractShape {

	public Line(int red, int green, int blue, int xStartPos, int yStartPos, int xEndPos, int yEndPos) {
		super(red, green, blue, xStartPos, yStartPos, xEndPos, yEndPos);
	}

	@Override
	public List<String> getPositions() {

		List<String> temp = new ArrayList<>();

		int dx = Math.abs(getxStartPos() - getxEndPos());
		int dy = Math.abs(getyStartPos() - getyEndPos());
		

		int d = 2 * dy - dx;
		
		temp.add(getyStartPos() + " " + getxStartPos());

		int x = getxStartPos();

		if (d > 0) {
			x++;
			d -= 2 * dy;
		}
		
		for (int i = getyStartPos() + 1; i <= getyEndPos(); i++) {
			temp.add(i + " " + x);
			d += 2 * dx;

			if (d > 0) {
				x++;
				d -= 2 * dy;
			}
		}

		return temp;
	}

}
