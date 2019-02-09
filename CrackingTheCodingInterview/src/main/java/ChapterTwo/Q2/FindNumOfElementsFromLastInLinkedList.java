/*
 * Prompt: implement an algorithm to find the kth to the last element in a singly linked list 
 */

package main.java.ChapterTwo.Q2;

import java.util.List;

public class FindNumOfElementsFromLastInLinkedList {
	public static Integer findKFromLast (int posFromLast, List<Integer> listToSearch) {
		int elementIndex = (listToSearch.size()-1)-posFromLast;
		return listToSearch.get(elementIndex);
	}
}
