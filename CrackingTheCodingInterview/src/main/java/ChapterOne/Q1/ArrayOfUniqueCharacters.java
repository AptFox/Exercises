/*
 * Prompt: Implement an algorithm to determine if a string has all unique characters
 */
package main.java.ChapterOne.Q1;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfUniqueCharacters {
	public static boolean checkForUnique(String tString) {
		boolean stringIsUnique = true;
		char[] chars = tString.toCharArray();
		List<Character> charsAlreadySeen = new ArrayList<Character>();
		for(char ch : chars) {
			if(charsAlreadySeen.contains(ch)) {
				stringIsUnique = false;
				break;
			}else {
				charsAlreadySeen.add(ch);
			}
		}
		return stringIsUnique;
	}
}
