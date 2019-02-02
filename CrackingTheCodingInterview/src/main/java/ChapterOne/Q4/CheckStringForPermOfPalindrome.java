/*
 * Prompt: Given a string, write a function to check if it is a permutation of a palindrome
 */

package main.java.ChapterOne.Q4;

import java.util.Hashtable;

public class CheckStringForPermOfPalindrome {
	
	public static boolean checkPalindromePerm(String str) {
		boolean isPalPerm = true;
		boolean strIsEven = str.length() %2 == 0;
		Hashtable<Character, Integer> charsSeen = new Hashtable<Character, Integer>();
		for(char ch : str.toCharArray()) {
			if(charsSeen.get(ch) == null) {
				charsSeen.put(ch, 1);
			}
			else {
				charsSeen.replace(ch, charsSeen.get(ch)+1);
			}
		}
		if(strIsEven) {
			for(char ch: charsSeen.keySet()) {
				if(charsSeen.get(ch)%2 != 0) {
					isPalPerm = false;
				}
			}
		}
		else {
			int uniqueKeys = 0;
			for(char ch : charsSeen.keySet()) {
				if (charsSeen.get(ch) < 2) {
					uniqueKeys+=1;
				}
			}
			if(uniqueKeys >1) {
				isPalPerm = false;
			}
		}
		return isPalPerm;
	}

}
