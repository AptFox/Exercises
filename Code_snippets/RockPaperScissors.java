/* 
 * Project04.java
 * 
 * A simple java program that plays rock, paper scissors with the user. 
 * 
 * It generates it's own response at random. 
 * 
 * @author AptFox
 * @version 20150923
 * 
 * 
 */



import java.util.Scanner;

public class Project04 {
	
	public static void main (String[] args){
		//initializing the scanner
		Scanner in = new Scanner(System.in);
		
		String computerChoice = "";
		
		//prompting for user input
		System.out.println("Please select one of [R/P/S]: ");
		String userChoice = in.nextLine().toUpperCase();
		
		//checking for invalid inputs and setting user input to variable
		if (userChoice.equals("S")){
			userChoice = "Scissors";
		}
		else if (userChoice.equals("R")){
			userChoice = "Rock";
		}
		else if (userChoice.equals("P")){
			userChoice = "Paper";
		}
		else{
			System.out.println("Invalid choice! Defaulting to Rock.");
			userChoice = "Rock";
			
		}
		
		//creating the random choice for the computer. 
		int computerNumber = (int)(Math.random()*3) +1;
		
		System.out.println(" You chose: " + userChoice);
		
		//Changing the computer's random choice into a selection
		if (computerNumber == 1){
			computerChoice = "Paper";
		}
		else if (computerNumber == 2){
			computerChoice = "Rock";
		}
		else {
			computerChoice = "Scissors";
		}
		
		
		System.out.println(" I chose: " + computerChoice);
		
		if ( userChoice == computerChoice){
			System.out.println("A Tie!");
		}
		else if(userChoice == "Rock" && computerChoice == "Paper"){
			System.out.println( "Paper beats rock - you lose!" );
		}
		else if(userChoice == "Rock" && computerChoice == "Scissors"){
			System.out.println( "Rock beats scissors - you win!" );
		}
		else if (userChoice == "Paper" && computerChoice == "Scissors"){
			System.out.println( "Scissors beats Paper - you lose!");
		}
		else if (userChoice == "Paper" && computerChoice == "Rock"){
			System.out.println( "Paper beats rock - you win!");
		}
		else if (userChoice == "Scissors" && computerChoice == "Rock"){
			System.out.println("Rock beats Scissors - you lose!");
		}
		else if (userChoice == "Scissors" && computerChoice == "Paper"){
			System.out.println("Scissors beats paper - you win!");
		}
		
		in.close();
	}

}
