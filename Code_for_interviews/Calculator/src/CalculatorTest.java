import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd_1() {
		int expected = 2;
		int a = 1;
		int b = 1;
		int actual = Calculator.add(a, b);
		assertEquals(expected,actual);
	}
	
	@Test
	void testSum_1() {
		List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
		int expected = 10;
		int actual = Calculator.sum(inputList);
		assertEquals(expected,actual);
	}
	
	@Test
	void testSumString_1() {
		String inputList = "0,1,2,3,4";
		int expected = 10;
		int actual = Calculator.sum(inputList);
		assertEquals(expected,actual);
	}
	
	@Test
	void testSumString_2() {
		String inputList = "0,1,2tacotacotacotaco,3,4";
		int expected = 8;
		int actual = Calculator.sum(inputList);
		assertEquals(expected,actual);
	}

}
