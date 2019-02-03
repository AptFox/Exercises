package test.java.kata.pencil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.kata.pencil.Pencil;

class PencilTest {
	private Pencil pencil;
	
	@BeforeEach
	public void setup() {
		pencil = new Pencil();
	}
	
	/*
	 * Write
	 */
	
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
	
	/*
	 * Point Degradation
	 */
	//When a pencil is created, it can be provided with a value for point durability.
	@Test
	public void pencilCanBeCreatedWithAValueForDurability() {
		Pencil degradingPencil = new Pencil(10);
		assertEquals(10, degradingPencil.getDurability());
	}
}
