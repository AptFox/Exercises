/*
 * Prompt: Given two strings, write a method to decide if one is a permutation of the other
 */
package test.java.ChapterOne.Q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ChapterOne.Q2.CheckTwoStringsForPermutation;

class CheckTwoStringsForPermutationTest {

	@Test
	void testCheckForPermutations_ABC() {
		boolean expected = true;
		boolean actual = CheckTwoStringsForPermutation.checkForPermutations("ABC", "CBA");
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckForPermutations_123() {
		boolean expected = false;
		boolean actual = CheckTwoStringsForPermutation.checkForPermutations("123", "ABC");
		assertEquals(expected,actual);
	}
	
	@Test
	void testCheckForPermutations_DiffLength() {
		boolean expected = false;
		boolean actual = CheckTwoStringsForPermutation.checkForPermutations("ABCD", "CBA");
		assertEquals(expected,actual);
	}

}
