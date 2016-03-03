package grossmann.tim.FlowDesign.Kassenbuch_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileProvider {

	public static void writeEntryToFile(Entry entry) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("booking.csv"), true))) {

			bw.write(entry.getDate().format(DateTimeFormatter.ofPattern("d.M.yyyy")) + "," + entry.getType() + ","
					+ entry.getAmount());
			bw.write("\n");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Entry[] readEntriesFromFile() {

		try (BufferedReader br = new BufferedReader(new FileReader(new File("booking.csv")))) {

			List<Entry> entryList = new ArrayList<>();

			String readLine;
			while ((readLine = br.readLine()) != null && !readLine.equals("")) {

				String[] parts = readLine.split(",");

				entryList.add(new Entry(LocalDate.parse(parts[0], DateTimeFormatter.ofPattern("d.M.yyyy")), parts[1],
						Double.parseDouble(parts[2])));
			}

			Entry[] entries = new Entry[entryList.size()];

			for (int i = 0; i < entryList.size(); i++) {
				entries[i] = entryList.get(i);
			}

			return entries;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
