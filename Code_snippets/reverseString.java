/*
 * reverseString.java
 * 
 * A simple program that reverses a string.
 * 
 * @author AptFox
 * @version 20150924
 * 
 */



import java.util.Scanner;

public class reverseString {
	
	public static void main (String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String userString = in.nextLine();
		int i = 0, j = 1;
		while ( i <= userString.length()-1 ){
			
			if (i == userString.length()){
				System.out.print(userString.charAt(userString.length()-userString.length()));
			}
			System.out.print(userString.charAt(userString.length()-j));
			i++;
			j++;
		}
		in.close();
		
	}

}
