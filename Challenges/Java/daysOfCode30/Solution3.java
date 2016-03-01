package daysOfCode30;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.*/
        
        Scanner scanner = new Scanner(System.in);
        
        int lines = scanner.nextInt();
        scanner.nextLine();
        
        String[] stringLines = new String[lines];
        
        for(int i = 0; i < lines; i++) {
        	stringLines[i] = scanner.nextLine();
        }
        
        for(int i = 0; i < lines; i++) {
        	String[] singleParts = stringLines[i].split(" ");
        	int[] ints = new int[singleParts.length];
        			
        	for(int j = 0; j < singleParts.length; j++) {
        		ints[j] = Integer.parseInt(singleParts[j]);
        	}

        	for(int k = 0; k < ints[2]; k++) {
    			System.out.print(ints[0] + calculate(k, ints[1]) + " ");
    		}
        	
        	System.out.println();
        	
        }
        
    }
    
    private static int calculate(int potenz, int multier) {
    
    	int sum = 0;
    	
    	if(potenz == 0) {
    		return (int) (sum + Math.pow(2, potenz) * multier);
    	} else {
    		sum = (int) (Math.pow(2, potenz) * multier);
    		sum += calculate(potenz -1, multier);
    	}
    	
    	return sum;
    }
}