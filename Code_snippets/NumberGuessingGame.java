/*
 * Project05.java 
 * 
 * A program that generates a random number and plays a guessing game with the user based on the user's inputs. 
 * 
 * @author AptFox
 * @version 20150930
 * 
 */


import java.util.Scanner;

public class Project05 {
	
	public static void main (String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int randomNumber =(int)(Math.random()*100)+1;
		System.out.println("Enter a guess between 1 and 100: "); 
		
		
		int userInput = in.nextInt();
		
		while (userInput < 0 || userInput > 100){
			System.out.println("Your guess is out of range.  Pick a number between 1 and 100.");
			userInput = in.nextInt();
		}
			
		int count = 1;
		
		while (userInput != randomNumber){
			
			if (userInput > randomNumber){
				System.out.println ("Your guess was too high.  Try again.");
			}
			else if (userInput < randomNumber){
				System.out.println ("Your guess was too low.  Try again.");
			}
			else {
				System.out.println("Congratulations! Your guess was correct!");
				break;
			}
			System.out.println(" Enter a guess between 1 and 100: ");
			userInput = in.nextInt();
			while (userInput < 0 || userInput > 100){
				System.out.println("Your guess is out of range.  Pick a number between 1 and 100.");
				userInput = in.nextInt();
			}
			count++;
		}
		
		System.out.println("I had chosen " + randomNumber + " as the target number.");
		System.out.println("You guessed it in " + count + " tries.");
		
		if ( count == 1){
			System.out.println("That was lucky!");
		}
		else if ( count >= 2 && count <= 4){
			System.out.println("That was amazing!");
		}
		else if ( count == 5 || count == 6){
			System.out.println("That was good.");
		}
		else if (count == 7){
			System.out.println("That was OK.");
		}
		else if (count == 8 || count == 9){
			System.out.println("That was not very good.");
		}
		else {
			System.out.println("This just isn't your game.");
		}
		in.close();
	}

}
