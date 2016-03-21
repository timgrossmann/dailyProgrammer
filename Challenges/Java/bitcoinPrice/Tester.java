package bitcoinPrice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

public class Tester {
	public static void main(String[] args) {

		Map<String, Bitcoin> items = new HashMap<String, Bitcoin>();

		try {

			Gson gson = new Gson();
			URL url = new URL("http://api.bitcoincharts.com/v1/markets.json");
			StringBuilder temp = new StringBuilder();

			Scanner scanner = new Scanner(url.openStream());
			while (scanner.hasNext()) {
				temp.append(scanner.nextLine());
			}

			scanner.close();

			String[] parts = temp.substring(1, temp.length()).split("}");

			for (int i = 1; i < parts.length; i++) {
				parts[i] = parts[i].substring(1, parts[i].length()).trim();
			}

			for (int i = 0; i < parts.length - 1; i++) {
				parts[i] += "}";
				items.put(String.valueOf(i), gson.fromJson(parts[i], Bitcoin.class));
			}

			List<Bitcoin> bitcoins = new ArrayList<>();

			items.forEach((a, b) -> {
				if (b.getSymbol() != null && b.getHigh() != null && b.getLow() != null) {
					bitcoins.add(b);
				}
			});

			Collections.sort(bitcoins, (a, b) -> {
				int tem = a.getCurrency().compareTo(b.getCurrency());
				if (tem == 0) {
					return (int) (a.getHigh() - b.getHigh());
				} else {
					return tem;
				}
			});

			File desktop = new File(System.getProperty("user.home"), "Desktop/bitcoinPrice.txt");

			BufferedWriter bw = new BufferedWriter(new FileWriter(desktop));

			String header = String.format("%15s  ||  %19s  ||  %19s  ||  %19s  ||  %19s  ||  %24s%n", "Source:",
					"HighestSell:", "LowestSell:", "HighestBid:", "LowestAsk:", "Total Trade:");

			bw.write(header);

			String last = "";
			for (Bitcoin b : bitcoins) {

				if (!b.getCurrency().equals(last)) {
					for (int i = 0; i < 145; i++) {
						bw.write("=");
					}
					bw.write("\n");
				}
				last = b.getCurrency();
				bw.write(b.toString());
			}

			bw.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
