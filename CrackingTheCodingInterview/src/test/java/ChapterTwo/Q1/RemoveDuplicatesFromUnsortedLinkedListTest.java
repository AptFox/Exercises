package test.java.ChapterTwo.Q1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.ChapterTwo.Q1.RemoveDuplicatesFromUnsortedLinkedList;

class RemoveDuplicatesFromUnsortedLinkedListTest {

	@Test
	void testRemoveDuplicates_Simple1() {
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(2,2,2,2,2,2,2,2));
		List<Integer> expected = new LinkedList<Integer>(Arrays.asList(2));
		List<Integer> actual = RemoveDuplicatesFromUnsortedLinkedList.removeDuplicates_Simple(inputList);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveDuplicates_Simple2() {
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(2,3,4,5,2,3,4,5));
		List<Integer> expected = new LinkedList<Integer>(Arrays.asList(2,3,4,5));
		List<Integer> actual = RemoveDuplicatesFromUnsortedLinkedList.removeDuplicates_Simple(inputList);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveDuplicates_Simple3() {
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(2,3,4,5,2,2,2,2,2,2,3,4,5));
		List<Integer> expected = new LinkedList<Integer>(Arrays.asList(2,3,4,5));
		List<Integer> actual = RemoveDuplicatesFromUnsortedLinkedList.removeDuplicates_Simple(inputList);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveDuplicates_Complex1() {
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(2,2,2,2,2,2,2,2));
		List<Integer> expected = new LinkedList<Integer>(Arrays.asList(2));
		List<Integer> actual = RemoveDuplicatesFromUnsortedLinkedList.removeDuplicates_Complex(inputList);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveDuplicates_Complex2() {
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(2,3,4,5,2,3,4,5));
		List<Integer> expected = new LinkedList<Integer>(Arrays.asList(2,3,4,5));
		List<Integer> actual = RemoveDuplicatesFromUnsortedLinkedList.removeDuplicates_Complex(inputList);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveDuplicates_Complex3() {
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(2,3,4,5,2,2,2,2,2,2,3,4,5));
		List<Integer> expected = new LinkedList<Integer>(Arrays.asList(2,3,4,5));
		List<Integer> actual = RemoveDuplicatesFromUnsortedLinkedList.removeDuplicates_Complex(inputList);
		assertEquals(expected, actual);
	}

}
