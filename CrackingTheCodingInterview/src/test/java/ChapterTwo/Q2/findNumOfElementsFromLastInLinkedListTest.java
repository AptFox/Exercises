package test.java.ChapterTwo.Q2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.ChapterTwo.Q2.FindNumOfElementsFromLastInLinkedList;

class findNumOfElementsFromLastInLinkedListTest {
	
	@Test
	void testFind_ZeroFromLast() {
		int positionFromLast = 0;
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		Integer expected = 7;
		Integer actual = FindNumOfElementsFromLastInLinkedList.findKFromLast(positionFromLast, inputList);
		assertEquals(expected,actual);
	}

	@Test
	void testFind_1stFromLast() {
		int positionFromLast = 1;
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		Integer expected = 6;
		Integer actual = FindNumOfElementsFromLastInLinkedList.findKFromLast(positionFromLast, inputList);
		assertEquals(expected,actual);
	}
	
	@Test
	void testFind_2ndFromLast() {
		int positionFromLast = 2;
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		Integer expected = 5;
		Integer actual = FindNumOfElementsFromLastInLinkedList.findKFromLast(positionFromLast, inputList);
		assertEquals(expected,actual);
	}
	
	@Test
	void testFind_3rdFromLast() {
		int positionFromLast = 3;
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		Integer expected = 4;
		Integer actual = FindNumOfElementsFromLastInLinkedList.findKFromLast(positionFromLast, inputList);
		assertEquals(expected,actual);
	}

}
