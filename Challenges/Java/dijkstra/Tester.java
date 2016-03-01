import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;

public class Tester {
	
	public static Instant start;

	public static void main(String[] args) throws IOException {
		
		start = Instant.now();

		ArrayList<String> list = new ArrayList<String>();

		list = (ArrayList<String>) Files.readAllLines(Paths.get("adja.txt"));

		Dijkstra.getShortDist(list);

	}

}
