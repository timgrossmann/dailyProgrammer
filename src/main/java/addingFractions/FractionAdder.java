package addingFractions;

import java.util.ArrayList;

public class FractionAdder {

	public static void addFractions(String[] fractionsArray) {

		ArrayList<Integer> nennerList = new ArrayList<Integer>();
		ArrayList<Integer> zaehlerList = new ArrayList<Integer>();

		long mulNenner = 1;
		long mulZaehler = 0;

		for (String s : fractionsArray) {
			String[] temp = s.split("/");
			zaehlerList.add(Integer.parseInt(temp[0]));
			nennerList.add(Integer.parseInt(temp[1]));
		}

		for (int i : nennerList) {
			mulNenner *= i;
		}
		
		for (int i = 0; i < zaehlerList.size(); i++) {
			mulZaehler += zaehlerList.get(i) * (mulNenner / nennerList.get(i));
		}
		
		long gdc = getCommonDivisor(mulZaehler, mulNenner);
		
		System.out.printf("%d/%d", mulZaehler / gdc, mulNenner / gdc);		
		
	}

	private static long getCommonDivisor(long a, long b) {

		if (a == 0) {
			return b;
		}

		while (b != 0) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
		
	}

}
