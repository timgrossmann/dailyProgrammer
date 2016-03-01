package pileOfPaper;

public class Tester {
	
	public static void main(String[] args) {
		
		Canvas firstTry = new Canvas();
		
		firstTry.createCanvas(20, 10);
		
		firstTry.addPaperNote(new PaperNote(1, 5, 5, 10, 3));
		
		firstTry.addPaperNote(new PaperNote(2, 1, 2, 4, 3));
		
		firstTry.addPaperNote(new PaperNote(2, 7, 8, 5, 4));
		
		firstTry.addPaperNote(new PaperNote(3, 4, 2, 4, 4));
		
		firstTry.addPaperNote(new PaperNote(4, 10, 2, 8, 4));
		
		firstTry.addPaperNote(new PaperNote(9, 10, 2, 10, 4));
		
		firstTry.addPaperNote(new PaperNote(4, 12, 4, 8, 4));
		
		firstTry.print();
		
		firstTry.getNumOfNums();
		
		
		
		
//		Canvas secTry = new Canvas(100, 100);
//		
//		secTry.addPaperNote(new PaperNote(6, 1, 61, 69, 26));
//		secTry.addPaperNote(new PaperNote(1, 6, 58, 85, 8));
//		secTry.addPaperNote(new PaperNote(1, 88, 93, 4, 6));
//		secTry.addPaperNote(new PaperNote(7, 19, 84, 68, 1));
//		secTry.addPaperNote(new PaperNote(3, 80, 52, 8, 17));
//		secTry.addPaperNote(new PaperNote(5, 16, 56, 57, 12));
//		secTry.addPaperNote(new PaperNote(4, 58, 69, 22, 25));
//		
//		secTry.print();
//		
//		secTry.getNumOfNums();
		
		
	}

}
