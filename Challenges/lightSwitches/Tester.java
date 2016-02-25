package lightSwitches;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

public class Tester {

	public static void main(String[] args) {

		Instant start = Instant.now();
		
		Path path = Paths.get("src/main/java/lightSwitches/switches1.txt");
		int out = LightSwitches.lightSwitching(path);
		System.out.println(out);
		
		path = Paths.get("src/main/java/lightSwitches/switches2.txt");
		out = LightSwitches.lightSwitching(path);
		System.out.println(out);

		path = Paths.get("src/main/java/lightSwitches/switches3.txt");
		out = LightSwitches.lightSwitching(path);
		System.out.println(out);

		Instant end = Instant.now();

		Duration dur = Duration.between(start, end);

		System.out.println();
		System.out.println(dur.getSeconds() + "," + String.valueOf(dur.toMillis()).substring(2) + "s");

	}

}
