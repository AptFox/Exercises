package test.java.ChapterTwo.Q3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.ChapterTwo.Q3.RemoveNodeFromLinkedList;

class RemoveNodeFromLinkedListTest {

	@Test
	void testRemoveNode() {
		List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		List<Integer> expected = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,8,9));
		Integer nodeToRemove = 7;
		RemoveNodeFromLinkedList.removeNode(nodeToRemove, inputList);
		assertEquals(expected, inputList);
	}

}
