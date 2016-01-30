package isValidIdentifier;

public class IdentifierChecker {
	public static boolean isValid(String idn) {

		if (idn == null || idn.length() < 1) {
			return false;
		}

//		if (idn.substring(0, 1).matches("[a-zA-Z_$]") && idn.substring(1, idn.length() - 1).matches("[a-zA-Z0-9_$]*")) {
//			return true;
//		} else {
//			return false;
//		}
		
		if (idn.matches("[a-zA-Z_$]{1}[a-zA-Z_$0-9]*")) {
			return true;
		} else {
			return false;
		}

	}
}