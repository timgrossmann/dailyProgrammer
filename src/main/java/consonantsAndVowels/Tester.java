package consonantsAndVowels;

public class Tester {
	
	public static void main(String[] args) {

		RandomWordGen.genRandomWord("cvcvcc");
		RandomWordGen.genRandomWord("cVcvCc");
		RandomWordGen.genRandomWord("CcvV");
		RandomWordGen.genRandomWord("cvcvccvcvcvcvcvcvcvcccvccCcvCVv");
		
		System.out.println();
		
		RandomWordGen.genRandomWord("cvcvccvfsdcvcvcvcvcvcvcccvccCcvCVv");
		
		
		
	}

}
