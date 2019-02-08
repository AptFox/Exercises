/*
 * Prompt: Write code to remove duplicates from an unsorted list
 */

package main.java.ChapterTwo.Q1;

import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicatesFromUnsortedLinkedList {
	public static List<Integer> removeDuplicates(List<Integer> inputList){
		int intitalListSize = inputList.size()-1;
		List<Integer> uniqueElements = new LinkedList<Integer>();
		for(int i=0; i < intitalListSize; i++ ) {
			if(uniqueElements.contains(inputList.get(i))) {
				inputList.remove(i);
				i=0;
			}
			else {
				uniqueElements.add(inputList.remove(i));
			}
		}
		return inputList;
	}
}
