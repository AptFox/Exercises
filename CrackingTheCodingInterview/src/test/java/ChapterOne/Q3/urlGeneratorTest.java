package test.java.ChapterOne.Q3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ChapterOne.Q3.urlGenerator;

class urlGeneratorTest {

	@Test
	void testUrlifyOne() {
		String expected = "Mr%20John%20Smith";
		String actual = urlGenerator.urlifyOne("Mr John Smith        ");
		assertEquals(expected,actual);
	}
	
	@Test
	void testUrlifyTwo() {
		String expected = "Mr%20John%20Smith";
		String actual = urlGenerator.urlifyTwo("Mr John Smith        ");
		assertEquals(expected,actual);
	}
	
	@Test
	void testUrlifyTwo_PaddingBeginningAndEnd() {
		String expected = "Mr%20John%20Smith";
		String actual = urlGenerator.urlifyTwo("                      Mr John Smith        ");
		assertEquals(expected,actual);
	}
	
	@Test
	void testUrlifyTwo_PaddingBeginning() {
		String expected = "Mr%20John%20Smith";
		String actual = urlGenerator.urlifyTwo("                      Mr John Smith");
		assertEquals(expected,actual);
	}

}
