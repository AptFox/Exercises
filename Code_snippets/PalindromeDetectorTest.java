import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeDetectorTest {

	@Test
	public void testIsPalindrome() {
		
		char [] arr = {}; 

		assertTrue(PalindromeDetector.isPalindrome(arr));
	}
	
	@Test
	public void testIsPalindrome2() {
		
		char [] arr = {'r','a','d','a','r'}; 

		assertTrue(PalindromeDetector.isPalindrome(arr));
	}
	
	@Test
	public void testIsPalindrome3() {
		
		char [] arr = {'r','a','d','a','n'}; 

		assertFalse(PalindromeDetector.isPalindrome(arr));
	}
	
	@Test
	public void testIsPalindrome4() {
		
		char [] arr = {'d','a','d'}; 

		assertTrue(PalindromeDetector.isPalindrome(arr));
	}
	
	@Test
	public void testIsPalindrome5() {
		
		char [] arr = {'A'}; 

		assertTrue(PalindromeDetector.isPalindrome(arr));
	}
	
	@Test
	public void testIsPalindrome6() {
		
		char [] arr = {'n','a','c','h','o'}; 

		assertFalse(PalindromeDetector.isPalindrome(arr));
	}
	
	@Test
	public void testIsPalindrome7() {
		
		char [] arr = {'t','a','c','o'}; 

		assertFalse(PalindromeDetector.isPalindrome(arr));
	}
	
	@Test
	public void testIsPalindrome8() {
		
		char [] arr = {'r','a','d','a','r', 's'}; 

		assertFalse(PalindromeDetector.isPalindrome(arr));
	}

}
