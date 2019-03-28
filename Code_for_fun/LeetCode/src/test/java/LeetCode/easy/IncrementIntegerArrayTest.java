package test.java.LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.LeetCode.easy.IncrementIntegerArray;

class IncrementIntegerArrayTest {

	@Test
	void test_NormalNum() {
		int[] num = {1,3,2,4};
		int[] expected = {1,3,2,5};
		int[] actual = IncrementIntegerArray.incrementArrayNum(num);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	@Test
	void test_GrowingNum() {
		int[] num = {9,9,9};
		int[] expected = {1,0,0,0};
		int[] actual = IncrementIntegerArray.incrementArrayNum(num);
		assertTrue(Arrays.equals(expected, actual));
	}

}
