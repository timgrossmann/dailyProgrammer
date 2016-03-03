package grossmann.tim.FlowDesign.Kassenbuch_8;

public class CMDParser {

	public void parseArguments(String[] args, Runnable onAdd, Runnable onList) {
		switch (args[0]) {
		case "add":
			onAdd.run();
		case "list":
			onList.run();
		}
	}

}
