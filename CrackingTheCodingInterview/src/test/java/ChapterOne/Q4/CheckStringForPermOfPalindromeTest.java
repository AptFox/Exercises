package test.java.ChapterOne.Q4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ChapterOne.Q4.CheckStringForPermOfPalindrome;

class CheckStringForPermOfPalindromeTest {

	@Test
	void testCheckPalindromePerm_TacoCat1() {
		String str = "tactcoa";
		boolean expected = true;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckPalindromePerm_TacoCat2() {
		String str = "tacocat";
		boolean expected = true;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckPalindromePerm_radar1() {
		String str = "radar";
		boolean expected = true;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckPalindromePerm_radar2() {
		String str = "draar";
		boolean expected = true;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckPalindromePerm_moom() {
		String str = "moom";
		boolean expected = true;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckPalindromePerm_mo12om() {
		String str = "mo12om";
		boolean expected = false;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckPalindromePerm_ABC() {
		String str = "ABC";
		boolean expected = false;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckPalindromePerm_mom() {
		String str = "1mom2";
		boolean expected = false;
		boolean actual = CheckStringForPermOfPalindrome.checkPalindromePerm(str);
		assertEquals(expected,actual);
	}

}
