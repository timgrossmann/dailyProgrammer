package daysOfCode30;

import java.util.Scanner;

public class Solution6 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	int numOfLines = scanner.nextInt();
    	scanner.nextLine();
    	
    	String[] output = new String[numOfLines];
    	
    	for(int i = 0; i < numOfLines; i++) {
    		int dez = scanner.nextInt();
    		
    		output[i] = getBinary(dez);
    	}
    	
    	for(String s : output) {
    		System.out.println(s);
    	}
    	
    	scanner.close();
    }
    
    private static String getBinary(int dez) {
    	StringBuilder output = new StringBuilder();
    	
    	while(dez != 0) {
    		output.append(dez % 2);
    		dez /= 2;
    	}
    	
    	return output.reverse().toString();
    }
}
