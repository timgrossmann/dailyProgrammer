package humanReadableTime;

public class HumanReadableTime {
	public static String makeReadable(int seconds) {

		return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
		
//		int hours = 0;
//		int minutes = 0;
//		int finSeconds = 0;
//
//		hours = seconds / 60 / 60;
//		minutes = seconds / 60 - (hours * 60);
//		finSeconds = seconds - (minutes * 60) - (hours * 60 * 60);
//
//		String outPutString = "";
//
//		if (hours == 0) {
//			outPutString += "00";
//		} else if (hours < 10) {
//			outPutString += "0" + hours;
//		} else {
//			outPutString += hours;
//		}
//
//		outPutString += ":";
//
//		if (minutes == 0) {
//			outPutString += "00";
//		} else if (minutes < 10) {
//			outPutString += "0" + minutes;
//		} else {
//			outPutString += minutes;
//		}
//
//		outPutString += ":";
//
//		if (finSeconds == 0) {
//			outPutString += "00";
//		} else if (finSeconds < 10) {
//			outPutString += "0" + finSeconds;
//		} else {
//			outPutString += finSeconds;
//		}
//
//		return outPutString;
	}
}