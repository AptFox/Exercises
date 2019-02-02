/*
 * Prompt: Write a method to replace all spaces in a string with '%20'
 */
package main.java.ChapterOne.Q3;

import java.util.Arrays;

public class urlGenerator {
	public static String urlifyOne(String str) {
		return str.trim().replace(" ", "%20");
	}
	//Implementing method using char array
	public static String urlifyTwo(String str) {
		char[] chars = str.toCharArray();
		int indexOfStringStart = 0;
		int indexOfStringEnd = chars.length-1;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] != ' ') {
				indexOfStringStart = i;
				break;
			}
		}
		for(int i = chars.length-1; i > 0; i--) {
			if(chars[i] != ' ') {
				indexOfStringEnd = i;
				break;
			}
		}
		char[] trimmedStringArr = Arrays.copyOfRange(chars, indexOfStringStart, indexOfStringEnd+1);
		StringBuilder sb = new StringBuilder();
		for(char ch : trimmedStringArr) {
			if(ch == ' ') {
				sb.append("%20");
			}else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
