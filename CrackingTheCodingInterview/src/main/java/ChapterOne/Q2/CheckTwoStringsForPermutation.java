package main.java.ChapterOne.Q2;

import java.util.Arrays;

public class CheckTwoStringsForPermutation {

	public static boolean checkForPermutations(String strOne, String strTwo) {
		if (strOne.length() != strTwo.length()) {
			return false;
		}
		char[] charsOne = strOne.toCharArray();
		char[] charsTwo = strTwo.toCharArray();
		Arrays.sort(charsOne);
		Arrays.sort(charsTwo);
		return Arrays.equals(charsOne, charsTwo);
	}
}
