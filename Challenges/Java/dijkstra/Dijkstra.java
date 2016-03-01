import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Dijkstra {

	private static ArrayList<String> list;
	private static WayPoint[] points;
	private static int[][] distValues;
	private static WayPoint startPoint;

	public static void getShortDist(ArrayList<String> list) {

		Dijkstra.list = list;

		distValues = new int[list.size()][list.size()];

		for (int i = 0; i < list.size(); i++) {

			String[] temp = list.get(i).split(" ");

			for (int j = 0; j < list.size(); j++) {
				distValues[i][j] = Integer.parseInt(temp[j]);
			}
		}

		initPoints();
		setUpStart(points[0]);

		searchShortestPaths(startPoint);

//		printPath(points[8]);
		
		printPath(points[points.length - 1]);  //Point b in graph

		// printOut();

		Instant end = Instant.now();

		System.out.println(Duration.between(Tester.start, end).toMillis() + "ms");

	}

	private static void printPath(WayPoint endPoint) {

		WayPoint previousPoint = endPoint.prePoint;

		String path = "" + endPoint.id;

		while (previousPoint != points[0]) {

			path += "->" + previousPoint.id;
			previousPoint = previousPoint.prePoint;

		}

		path += "->" + startPoint.id;
		path += " | Lenght: " + endPoint.currValue;

		System.out.println(path);

	}

	private static void searchShortestPaths(WayPoint startPoint) {

		expandPoints(startPoint);

		while (!checkForNotRemoved()) {

			int lowestPointNum = getIdxOfLP();

			expandPoints(points[lowestPointNum]);

		}

	}

	private static int getIdxOfLP() {

		int temp = Integer.MAX_VALUE;
		int lowestIntIdx = 0;

		for (WayPoint p : points) {

			if (p.currValue < temp && !p.removed) {
				temp = p.currValue;
				lowestIntIdx = p.id;
			}

		}

		return lowestIntIdx;
	}

	private static boolean checkForNotRemoved() {

		for (WayPoint p : points) {
			if (!p.removed) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unused")
	private static void printOut() {
		for (WayPoint p : points) {
			if (p.prePoint != null) {
				System.out.println(p.toString());
			}
		}
	}

	private static void setUpStart(WayPoint p) {
		p.currValue = 0;
		p.prePoint = p;
		startPoint = p;
	}

	private static void expandPoints(WayPoint point) {

		for (int i = 0; i < list.size(); i++) {

			if (distValues[point.id][i] != 0) {

				if (points[i].currValue > point.currValue + distValues[point.id][i]) {

					points[i].currValue = point.currValue + distValues[point.id][i];
					points[i].prePoint = point;

				}

			}

		}

		point.removed = true;

	}

	private static void initPoints() {

		Dijkstra.points = new WayPoint[list.size()];

		for (int i = 0; i < list.size(); i++) {
			points[i] = new WayPoint(i);
		}

	}

}
