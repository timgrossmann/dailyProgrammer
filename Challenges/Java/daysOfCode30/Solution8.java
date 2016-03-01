package daysOfCode30;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Palindrome {
    //Write your code here
	
	Queue<Character> queue = new LinkedList<>();
	Deque<Character> stack = new ArrayDeque<>();

	void pushCharacter(char ch) {
		//: Pushes a character onto a stack.
		stack.push(ch);
	}
	
	void enqueueCharacter(char ch) {
		//: Enqueues a character in a queue.
		queue.add(ch);
	}
	
	char popCharacter() {
		//: Pops and returns the top character.
		return stack.pop();
	}
	
	char dequeueCharacter() {
		return queue.poll();
	}
	
}



public class Solution8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // read the string s.
        String s = sc.nextLine();
        
        // create the Palindrome class object p.
        Palindrome p = new Palindrome();
        char arr[]=s.toCharArray();//Converting string to a character array
        // push all the characters of string s to stack.
        for (char c : arr) {
            p.pushCharacter(c);
        }
        
        // enqueue all the characters of string s to queue.
        for (char c : arr) {
            p.enqueueCharacter(c);
        }
        
        boolean f = true;
        
        // pop the top character from stack.
        // dequeue the first character from queue.
        // compare both the characters.
        for (int i = 0; i < s.length(); i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                f = false;                
                break;
            }
        }
        
        // finally print whether string s is palindrome or not.
        if (f) {
            System.out.println("The word, "+s+", is a palindrome.");
        } else {
            System.out.println("The word, "+s+", is not a palindrome.");
        }
    }
}
