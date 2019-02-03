package test.java.kata.pencil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
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
	
	@Before
	void setup() {
		//move pencil object creation to here
	}
	
	//write a string of text on a sheet of paper
	@Test
	void whenPencilIsPassedAStringItReturnsThatString() {
		Pencil pencil = new Pencil();
		assertEquals("ABC",  pencil.write("ABC"));
	}
	
	//append string to existing text on paper

}
