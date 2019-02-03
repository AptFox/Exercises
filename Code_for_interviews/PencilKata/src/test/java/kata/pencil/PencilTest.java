package test.java.kata.pencil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.kata.pencil.Pencil;

class PencilTest {
	/*
	 * Write
	 * As a writer I want to be able use a pencil to write text on a sheet of paper so that I can better remember my thoughts
	 * When the pencil is instructed to write a string of text on a sheet of paper, the paper should reflect the text that was written.
	 * Text written by the pencil should always be appended to existing text on the paper. Thus, given a piece of paper with the text 
	 * "She sells sea shells", when a pencil is instructed to write " down by the sea shore" on the paper, the paper will then contain 
	 * the entire string (i.e. "She sells sea shells down by the sea shore").
	 */
	private Pencil pencil;
	
	@BeforeEach
	public void setup() {
		pencil = new Pencil();
	}
	
	//write a string of text on a sheet of paper
	@Test
	public void whenPencilIsPassedAStringItReturnsThatString() {		
		assertEquals("ABC",  pencil.write("ABC"));
	}
	
	//append string to existing text on paper
	@Test
	public void whenPencilTwoStringsItReturnsACombinedString() {
		assertEquals("She sells sea shells down by the sea shore",  pencil.append("She sells sea shells"," down by the sea shore"));
	}
}
