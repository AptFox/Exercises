package main.java.ChapterTwo.Q5;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Prompt:
 * You have two numbers represented by a LinkedList,
 * Where each node contains a single digit.
 * The digits are stored in reverse order, 
 * such that the 1s digit is at the head of the list.
 * 
 * Write a function that adds the two numbers and returns the sum as a linked list
 * 
 * EX:
 * Input: (7->1->6) + (5->9->2). That is 617 + 295
 * Output: 2->1->9. That is 912.
 */
public class SumLists {
	
	public LinkedList<Integer> findSumOfReversedLinkedLists(LinkedList<Integer> firstList, LinkedList<Integer> secondList) {
		Integer firstNum = convertReversedListToInteger(firstList);
		Integer secondNum = convertReversedListToInteger(secondList);
		Integer sumNum = firstNum+secondNum;
		return convertIntegerToReversedLinkedList(sumNum);
	}
	
	private Integer convertReversedListToInteger(LinkedList<Integer> list) {
		Integer foundInt = null;
		Iterator<Integer> listIterator = list.descendingIterator();
		String tmpString = "";
		while(listIterator.hasNext()) {
			tmpString+=listIterator.next();
		}
		foundInt = Integer.parseInt(tmpString);
		return foundInt;
	}
	
	private LinkedList<Integer> convertIntegerToReversedLinkedList(Integer num){
		LinkedList<Integer> reversedList = new LinkedList<Integer>();
		String numString = num.toString();
		String[] numStringArr = numString.split("");
		for(int i = numStringArr.length-1; i > 0; i++) {
			Integer tmpInt = Integer.parseInt(numStringArr[i]);
			reversedList.add(tmpInt);
		}
		return reversedList;
	}

}
