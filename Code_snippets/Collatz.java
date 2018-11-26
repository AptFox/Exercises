/*
 * Collatz.java
 * 
 * A program that takes and integer and calculates it based on Collatz Conjecture. It finds the length of the sequence between the given number and 1. 
 * 
 * For any number, if it's even the program divides it by two and for any odd number the program multiplies the number by three and adds one. 
 * 
 * It continues to repeat these steps until the program reaches one. 
 * 
 * The program then outputs the number of steps that it had to take to reach 1. 
 * 
 * @author AptFox
 * @version 20150919
 * 
 * 
 */



import java.util.Scanner;


public class Collatz {
  public static void main(String[] args) {
  
    int sequenceLength = 1;
    int x = 0;
    Scanner in = new Scanner (System.in);
    
    System.out.println(" Enter the number: ");
    x = in.nextInt();
    
    while (x != 1) {
    
      if (x % 2 == 0) {
      
      x = x/2;
      sequenceLength = 1 + sequenceLength;
      
      }
      else {
      
      x = (x * 3) + 1;
      sequenceLength = 1 + sequenceLength;
      
      
      }
      
      
    }
    System.out.println(sequenceLength);
    in.close();
  }
}