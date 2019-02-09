/*
 * Prompt: Write code to remove duplicates from an unsorted list
 */

package main.java.ChapterTwo.Q1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedLinkedList {
	public static List<Integer> removeDuplicates_Simple(List<Integer> inputList){
		Set<Integer> uniqueElements = new HashSet <Integer>();
		uniqueElements.addAll(inputList);
		
		List <Integer> listOfUniqueElms = new LinkedList<Integer>();
		listOfUniqueElms.addAll(uniqueElements);
		return listOfUniqueElms;
	}
	
	public static List<Integer> removeDuplicates_Complex(List<Integer> inputList){
		List <Integer> listOfUniqueElms = new LinkedList<Integer>();
		for(Integer i : inputList) {
			if(!listOfUniqueElms.contains(i)) {
				listOfUniqueElms.add(i);
			}
		}
		return listOfUniqueElms;
	}
}
