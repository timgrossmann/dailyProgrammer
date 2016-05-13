package boyerMooreSteps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoyerMoore {

	
	public static void main(String[] args) {
		
		String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String[] inAlph = alph.toUpperCase().split("");
		
		String input = new String("BABCBACBABCBA");
		String[] inArr = input.toUpperCase().split("");	
		
		Map<String, Integer> lastOcc = getLastOcc(inAlph, input);
		
		List<Integer> suff = getSuff(inArr);
		
		List<Integer> unsafe = getMatchUnsafe(suff);
		
		List<Integer> safe = getMatchSafe(unsafe, inArr, input);
		
		
		print(inArr, lastOcc, suff, unsafe, safe);
		
	}
	
	
	private static List<Integer> getMatchSafe(List<Integer> unsafe, String[] inArr, String input) {
		
		List<Integer> out = new ArrayList<>();
		int currSub = 0;
		
		for(int i = unsafe.size() - 1; i >= 0; i--) {
			if(unsafe.get(i) != inArr.length) {
				out.add(0, unsafe.get(i));
			} else {
				
				int pos = unsafe.size() - 1 - i;
				for(int j = 1; j <= pos; j++) {
			
					if(input.substring(i, input.length()).contains(input.substring(0, j))) {
						currSub  += 1;
					} else {
						break;
					}
				}

				out.add(0, inArr.length - currSub);
				currSub = 0;
			}
		}
		
		return out;
	}


	private static List<Integer> getMatchUnsafe(List<Integer> suff) {
		
		List<Integer> out = new ArrayList<>();
		int currInd;
		
		
		for(int i = 0; i < suff.size(); i++) {
			
			currInd = suff.lastIndexOf(i + 1);
			
			if(currInd != -1) {
				out.add(suff.size() - 1 - currInd);
			} else {
				out.add(suff.size());
			}
			
		}
		
		Collections.reverse(out);
		return out;
	}


	private static List<Integer> getSuff(String[] inArr) {
		
		List<Integer> out = new ArrayList<>();
		String[] curr;
		int currMatching = 0;
		
		for(int i = 0; i < inArr.length; i++) {
			
			curr = new String[i + 1];
			for(int j = 0; j < curr.length; j++) {
				curr[j] = inArr[j];
			}

			for(int j = 0; j < curr.length; j++) {
				if(curr[curr.length - j - 1].equals(inArr[inArr.length - j - 1])) {
					currMatching++;
				} else {
					break;
				}
			}
			
			out.add(currMatching);
			currMatching = 0;
		}
		return out;
	}


	private static Map<String, Integer> getLastOcc(String[] inAlph, String input) {
		
		Map<String, Integer> out = new HashMap<>();
		
		for(int i = 0; i < inAlph.length; i++) {
			
			if(!input.contains(inAlph[i])) {
				out.put(inAlph[i], input.length());
			} else {
				out.put(inAlph[i], (input.length() - input.lastIndexOf(inAlph[i]) - 1));
			}	
		}
		
		return out;
	}


	private static void print(String[] inArr, Map<String, Integer> lastOcc, List<Integer> suff, List<Integer> unsafe, List<Integer> safe) {
		
		System.out.print("alpha: ");
		for(String s : lastOcc.keySet()) {
			System.out.printf("%3s", s);
		}
		System.out.println();
		System.out.print("laOcc: ");
		for(String s : lastOcc.keySet()) {
			System.out.printf("%3d", lastOcc.get(s));
		}
		System.out.println();
		System.out.println();
		
		
		System.out.print("patte: ");
		for(String s : inArr) {
			System.out.printf("%3s", s);
		}
		System.out.println();
		
		System.out.print("index: ");
		for(int i = 0; i < inArr.length; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		System.out.println();
		
		System.out.print("suffx: ");
		for(int i : suff) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		System.out.println();
		
		System.out.print("usafe: ");
		for(int i : unsafe) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		System.out.print("match: ");
		for(int i : safe) {
			System.out.printf("%3d", i);
		}
	}


}
