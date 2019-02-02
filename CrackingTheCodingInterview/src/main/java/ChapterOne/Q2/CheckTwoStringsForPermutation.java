package main.java.ChapterOne.Q2;

public class CheckTwoStringsForPermutation {

	public static boolean checkForPermutations(String strOne, String strTwo) {
		boolean isPermutation = true;
		if (strOne.length() != strTwo.length()) {
			return false;
		}
		char[] chars = strOne.toCharArray();
		for(char ch : chars) {
			if(!strTwo.contains(ch+"")) {
				isPermutation = false;
				break;
			}
		}
		return isPermutation;
	}
}
