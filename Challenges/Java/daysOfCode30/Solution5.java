package daysOfCode30;

import java.util.Scanner;

public class Solution5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// Take Input
		
		String[] temp = sc.nextLine().split(" ");
		
		int gcd = find_gcd(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		System.out.println(gcd);
	}

	static int find_gcd(int a, int b) {
		
		if(a == b) {
			return a;
		} else {
			return find_gcd((Math.max(a, b) - Math.min(a, b)), Math.min(a, b));
		}
		
	}
}