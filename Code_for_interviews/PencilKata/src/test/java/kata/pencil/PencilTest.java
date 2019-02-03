package test.java.kata.pencil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.kata.pencil.Pencil;

class PencilTest {
	private Pencil pencil;
	
	@BeforeEach
	public void setup() {
		pencil = new Pencil(35);
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
	
	 //The pencil writes spaces after durability reached zero. 
	@Test
	public void whenPencilDurabilityRunsOutSpacesAreWrittenForEachChar() {
		Pencil degradingPencil = new Pencil(10);
		assertEquals("0123456789      ", degradingPencil.write("0123456789ABCDEF"));
	}
	
	//Writing spaces should not affect durability
	@Test
	public void whenPencilWritesSpacesDurabilityDoesNotDecrease() {
		Pencil degradingPencil = new Pencil(10);
		degradingPencil.write("     ");
		assertEquals(10, degradingPencil.getDurability());
	}
	
	//Writing newlines should not affect durability
	@Test
	public void whenPencilWritesNewLinesDurabilityDoesNotDecrease() {
		Pencil degradingPencil = new Pencil(10);
		degradingPencil.write("\n\n");
		assertEquals(10, degradingPencil.getDurability());
	}
	
	//Lowercase letters should degrade the pencil point by a value of one
	@Test
	public void whenPencilWritesLowerCaseDurabilityDecreasesByOne() {
		Pencil degradingPencil = new Pencil(10);
		degradingPencil.write("abc");
		assertEquals(7, degradingPencil.getDurability());
	}
	
	//capital letters should degrade the pencil point by two
	@Test
	public void whenPencilWritesUpperCaseDurabilityDecreasesByTwo() {
		Pencil degradingPencil = new Pencil(10);
		degradingPencil.write("ABC");
		assertEquals(4, degradingPencil.getDurability());
	}
	
	@Test
	public void whenPencilWritesUpperCaseDurabilityDecreasesByTwo_MixedCaseExample() {
		Pencil degradingPencil = new Pencil(4);
		assertEquals("text", degradingPencil.write("text"));
		degradingPencil = new Pencil(4);
		assertEquals("Tex ", degradingPencil.write("Text"));
	}
	
	/*
	 * Sharpen
	 */
	@Test
	public void whenPencilIsSharpenedDurabilityReturnsToPreviousLevel() {
		Pencil degradingPencil = new Pencil(3);
		degradingPencil.write("abc");
		degradingPencil.sharpen();
		assertEquals(3, degradingPencil.getDurability());
	}
	
	
	//A pencil should also be created with an initial length value.
	@Test
	public void pencilCanBeCreatedWithAlengthValue() {
		Pencil lengthyPencil = new Pencil(10,10);
		assertEquals(10, lengthyPencil.getLength());
	}
	
	//The pencil's length is reduced by one each time it is sharpened.
	@Test
	public void pencilLengthIsReducedByOneWhenSharpened() {
		Pencil lengthyPencil = new Pencil(10,10);
		lengthyPencil.sharpen();
		assertEquals(9, lengthyPencil.getLength());
	}
	
	
	//When a pencil's length is zero, then sharpening it no longer restores its point durabliity.
	@Test
	public void whenPencilLengthIsZeroSharpeningDoesNotRestoreDurability() {
		Pencil lengthyPencil = new Pencil(10,0);
		lengthyPencil.write("abc");
		lengthyPencil.sharpen();
		assertEquals(7,lengthyPencil.getDurability());
	}
	
	/*
	 * Erase
	 */
	@Test
	public void pencilCanEraseAStringFromAnotherString() {
		String expected = "How much wood would a woodchuck chuck if a woodchuck could       wood?"; 
		String actual = pencil.erase("chuck", "How much wood would a woodchuck chuck if a woodchuck could chuck wood?");
		assertEquals(expected, actual);
	}
	
	/*
	 * Eraser Degradation
	 */
	//When a pencil is created, it can be provided with a value for eraser durability.
	@Test
	public void pencilCanBeCreatedWithAValueForEraserDruability() {
		Pencil eraserDegradingPencil = new Pencil(10,10,10);
		assertEquals(10, eraserDegradingPencil.getEraserDurability());
	}
	
	//all characters except for white space should degrade the eraser by a value of one.
	@Test
	public void whenEraseIsCalledOnWhiteSpaceEraserDurabilityDoesNotDecrease() {
		Pencil eraserDegradingPencil = new Pencil(10,10,10);
		eraserDegradingPencil.erase("     ", "AAAAA     AAAAA");
		assertEquals(10,eraserDegradingPencil.getEraserDurability());
	}
}
