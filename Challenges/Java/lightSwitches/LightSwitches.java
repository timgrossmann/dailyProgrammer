package lightSwitches;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LightSwitches {

	public static int lightSwitching(Path path) {

		try {

			List<String> temp = Files.readAllLines(path);
			boolean[] switches = new boolean[Integer.parseInt(temp.get(0))];
			temp = temp.subList(1, temp.size());

			temp.stream().forEach(a -> {
				String[] values = a.split(" ");

				int value1 = Integer.parseInt(values[0]);
				int value2 = Integer.parseInt(values[1]);

				if (value1 > value2) {
					int tempVal = value1;
					value1 = value2;
					value2 = tempVal;
				}

				for (int j = value1; j < value2 + 1; j++) {
					switches[j] = !switches[j];
				}
			});

			// Scanner scanner = new Scanner(path);
			// boolean[] switches = new boolean[scanner.nextInt()];
			//
			// while (scanner.hasNextInt()) {
			//
			// int value1 = scanner.nextInt();
			// int value2 = scanner.nextInt();
			//
			// if (value1 > value2) {
			// int temp = value1;
			// value1 = value2;
			// value2 = temp;
			// }
			//
			// for (int j = value1; j < value2 + 1; j++) {
			// switches[j] = !switches[j];
			// }
			//
			// }
			//
			// scanner.close();

			int output = 0;

			for (boolean b : switches) {
				if (b) {
					output++;
				}
			}
			return output;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
