package test.java.ChapterOne.Q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ChapterOne.Q1.ArrayOfUniqueCharacters;

class ArrayOfUniqueCharactersTest {

	@Test
	void testCheckForUniqueWith123() {
		String tString = "123";
		boolean expected = true;
		boolean actual = ArrayOfUniqueCharacters.checkForUnique(tString);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckForUniqueWithABC() {
		String tString = "ABC";
		boolean expected = true;
		boolean actual = ArrayOfUniqueCharacters.checkForUnique(tString);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckForUniqueWithOneOneOne() {
		String tString = "111";
		boolean expected = false;
		boolean actual = ArrayOfUniqueCharacters.checkForUnique(tString);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckForUniqueWithLotsOfUniqueChars() {
		String tString = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*() {}[]-=<>,.?/`~";
		boolean expected = true;
		boolean actual = ArrayOfUniqueCharacters.checkForUnique(tString);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckForUniqueWithLotsOfNonUniqueChars() {
		String tString = "1234567891011121314151617181920ABCabc123321";
		boolean expected = false;
		boolean actual = ArrayOfUniqueCharacters.checkForUnique(tString);
		assertEquals(expected, actual);
	}

}
