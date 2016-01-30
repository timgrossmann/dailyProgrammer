package weightForWeight;

public class Tester {
	
	public static void main(String[] args) {
		
		System.out.println(WeightSort.orderWeight("103 123 4444 99 2000"));
		System.out.println(WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
		System.out.println(WeightSort.orderWeight("59544965313"));
		System.out.println(WeightSort.orderWeight("1"));
		System.out.println(WeightSort.orderWeight(""));
		System.out.println(WeightSort.orderWeight(new String()));
		System.out.println(WeightSort.orderWeight("2 200 20 2000"));
		
		
		
	}

}
