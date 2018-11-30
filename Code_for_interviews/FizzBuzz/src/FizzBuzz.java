/*Write a short program that prints each number from 1 to 100 on a new line. 

For each multiple of 3, print "Fizz" instead of the number. 

For each multiple of 5, print "Buzz" instead of the number. 

For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.*/
public class FizzBuzz {

	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			/*Solution uses the conditional or ternary operator to make decisions instead of if statements.
			  It's essentially one big assignment inside of a print statement. Whatever the return become is
			  what's printed to the console. 
			  
			   Logically it reads like this:
			   if "i" is divisible by 3 and 5 return "FizzBuzz"
			   else if "i" is divisible by 3 return "Fizz"
			   else if "i" is divisible by 5 return "Buzz"
			   else return int value of "i" with an empty string appended to cast to String */
			System.out.println(i%3==0 && i%5==0 ? "FizzBuzz" : i%3==0 ? "Fizz": i%5==0 ? "Buzz" : i+"");
		}

	}

}
