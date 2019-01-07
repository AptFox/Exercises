import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		List<Integer> unsortedList = new ArrayList<Integer>(Arrays.asList(3,44,38,5,47,15,36,26,27,2,46,4,19,50,48));
		List<Integer> sortedList =  mergeSort(unsortedList);
		System.out.println(sortedList);
	}
	
	
	public static List<Integer> mergeSort(List<Integer> intList) {
		int arraySize = intList.size();
		List<Integer> leftList, rightList = new ArrayList<Integer>();
		
		if(arraySize > 1) {
			int indexOfMiddleValue = arraySize/2;
			leftList = mergeSort(intList.subList(0, indexOfMiddleValue));
			rightList = mergeSort(intList.subList(indexOfMiddleValue, arraySize-1));
		}else {
			return intList;
		}
		
		if(leftList.isEmpty() || rightList.isEmpty()) {
			leftList.addAll(rightList);
			return leftList;
		}else {
			for(int value : rightList) {
				int indexForValue = findIndexInList(value, leftList);
				leftList.add(indexForValue, value);
			}
		}
			
		return leftList;
	}
	
	//Take an integer and a list of integers
	//Returns the index where the integer should be placed in the list of integers. 
	public static int findIndexInList(int value, List<Integer> intList) {
		int index = 0;
		for(int listValue : intList) {
			if(value > listValue) {
				index = intList.indexOf(listValue);
				index++;
			}else if(value < listValue) {
				index = intList.indexOf(listValue);
				index--;
			}else if (value == listValue){
				index = intList.indexOf(listValue);
			}
		}
		if(index < 0) {
			index = 0;
		}
		if(index > intList.size() -1) {
			index = intList.size() -1;
		}
		return index;
	}

}
