package test.java.ChapterTwo.Q5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import main.java.ChapterTwo.Q5.SumLists;

class SumListsTest {
	
	/*
	 * EX:
	 * Input: (7->1->6) + (5->9->2). That is 617 + 295
	 * Output: 2->1->9. That is 912.
	 */
	@Test
	void testFindSumOfReversedLinkedLists() {
		LinkedList<Integer> firstList = new LinkedList<Integer>(Arrays.asList(7,1,6));
		LinkedList<Integer> secondList = new LinkedList<Integer>(Arrays.asList(5,9,2));
		LinkedList<Integer> expected = new LinkedList<Integer>(Arrays.asList(2,1,9));
		LinkedList<Integer> actual =SumLists.findSumOfReversedLinkedLists(firstList, secondList);
		assertEquals(expected,actual);
	}

}
