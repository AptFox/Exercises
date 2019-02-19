import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class TestBoxScanner {
	@Test
	public void whenABoxIDDoesntContainALetterThatAppearsTwiceThenDoubleLetterCountIsZero() {
		BoxCounter boxCounter = new BoxCounter();
		String boxLabel = "abcdef";
		int expected = 0;
		boxCounter.CountLetters(boxLabel);
		assertEquals(expected,boxCounter.doubleLetterCount);
	}
	
	@Test
	public void whenABoxIDDoesntContainALetterThatAppearsThriceThenTripleLetterCountIsZero() {
		BoxCounter boxCounter = new BoxCounter();
		String boxLabel = "abcdef";
		int expected = 0;
		boxCounter.CountLetters(boxLabel);
		assertEquals(expected,boxCounter.tripleLetterCount);
	}
	
	@Test
	public void whenABoxIDContainsALetterThatAppearsTwiceThenDoubleLetterCountIsOne() {
		BoxCounter boxCounter = new BoxCounter();
		String boxLabel = "abcdee";
		int expected = 1;
		boxCounter.CountLetters(boxLabel);
		assertEquals(expected,boxCounter.doubleLetterCount);
	}
	
	@Test
	public void whenABoxIDContainsALetterThatAppearsThriceThenTripleLetterCountIsOne() {
		BoxCounter boxCounter = new BoxCounter();
		String boxLabel = "abcccd";
		int expected = 1;
		boxCounter.CountLetters(boxLabel);
		assertEquals(expected,boxCounter.tripleLetterCount);
	}
	
	@Test
	public void whenABoxIDContainsLetterThatAppearBothTwiceAndThriceThenEachCountIsOne() {
		BoxCounter boxCounter = new BoxCounter();
		String boxLabel = "bababc";
		int expected = 1;
		boxCounter.CountLetters(boxLabel);
		assertEquals(expected,boxCounter.doubleLetterCount);
		assertEquals(expected,boxCounter.tripleLetterCount);
	}
	
	@Test
	public void whenABoxIDContainsTwoInstancesOfALetterThatAppearThriceThenTripleCountIsOne() {
		BoxCounter boxCounter = new BoxCounter();
		String boxLabel = "ababab";
		int expected = 1;
		boxCounter.CountLetters(boxLabel);
		assertEquals(expected,boxCounter.tripleLetterCount);
	}
}
