package humanReadableTime;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println(HumanReadableTime.makeReadable(0));
		System.out.println(HumanReadableTime.makeReadable(5));
		System.out.println(HumanReadableTime.makeReadable(60));
		System.out.println(HumanReadableTime.makeReadable(86399));
		System.out.println(HumanReadableTime.makeReadable(359999));

	}
	
}

