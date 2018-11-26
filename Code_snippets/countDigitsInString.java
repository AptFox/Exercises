/*
 * countDigitsInString.java
 * 
 * A simple program that prompts the user for a string and counts the characters in that string that are digits between 0 and 9. 
 * 
 * @author AptFox
 * @version 20150924
 * 
 * 
 */



import java.util.Scanner;

public class countDigitsInString {

	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		boolean test ;
		int numberOfDigits = 0;
		System.out.println("Enter a string to count the digits in: ");
		String userString = in.nextLine();
		
		int i = 0;
		
		while ( i <= userString.length()-1){
			
			test = Character.isDigit(userString.charAt(i));
			if (test){
				numberOfDigits = numberOfDigits + 1;
			}
			i++;
			
		}
		System.out.println("Your string contains " + numberOfDigits +" digits.");
		System.out.println(i);
		in.close();
	}
	
}
