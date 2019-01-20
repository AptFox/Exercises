import java.util.ArrayList;
import java.util.List;

/*
 * Write a function that takes two strings, S1 & S2
 * and returns the longest common subsequence of S1 & S2
 * 
 * Ex:
 * "ABAZDC", "BACBAD" -> "ABAD"
 * "AGGTAB", "GXTXAYB" -> "GTAB"
 * "aaaa", "aa" -> "aa"
 *  
 */

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String S1 = "ABAZDC";
		String S2 = "BACBAD";
		
		List<String> subSequences = new ArrayList<String>();
		for(int i = 0; i < S1.length(); i++ ) {
			String subStringOfS1 = S1.substring(i);
			subSequences.add(findSubsequence(subStringOfS1, S2, 0));
		}
		int longestStringIndex = findLongestStringInList(subSequences);
		System.out.println(subSequences.get(longestStringIndex));
	}
	
	public static String findSubsequence(String S1, String S2, int startingIndex) {
		// return when substring of S2 is empty
		if(S2.isEmpty() || startingIndex > S1.length()-1) {
			return S2;
		}
		
		// Take a char of S1
		char charOfS1 = S1.charAt(startingIndex);
		// Find that char in S2
		int indexOfCharInS1 = S2.indexOf(charOfS1);
		// Take substring of S2 at position of found char,
		String subStringOfS2 = S2.substring(indexOfCharInS1);
		// increase index of S1
		// repeat

		return findSubsequence(S1, subStringOfS2, startingIndex++);
		
	}
	
	public static int findLongestStringInList(List<String> substringList) {
		int indexOfLongestStringInList = 0;
		int longestStringLength = 0;
		
		for(int i = 0 ; i< substringList.size(); i++) {
			if(substringList.get(i).length() > longestStringLength) {
				longestStringLength = substringList.get(i).length();
				indexOfLongestStringInList = i;
			}
		}
		
		return indexOfLongestStringInList;
	}

}
