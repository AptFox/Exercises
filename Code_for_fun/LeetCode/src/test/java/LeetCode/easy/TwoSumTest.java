package test.java.LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.LeetCode.easy.TwoSum;

class TwoSumTest {

	@Test
	void testTwoSum() {
		int[] inputArr = new int[] {3,2,4};
		int target = 6;
		int[] expectedArr = new int[] {1,2};
		int[] actualArr = TwoSum.twoSum(inputArr, target);
		assertEquals(Arrays.toString(expectedArr), Arrays.toString(actualArr));
	}

}
