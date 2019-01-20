import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		List<Integer> unsortedList = new ArrayList<Integer>(Arrays.asList(3,44,38,5,47,15,36,26,27,2,46,4,19,50,48));
		List<Integer> sortedList =  mergeSort(unsortedList);
		System.out.println(sortedList);
	}
	
	
	public static List<Integer> mergeSort(List<Integer> intList) {
		int arraySize = intList.size();
		if(arraySize ==1) {
			return intList;
		}
		int indexOfMiddleValue = arraySize/2;
		List<Integer> leftList = createSubList(intList, indexOfMiddleValue-1, false);
		List<Integer> rightList = createSubList(intList, indexOfMiddleValue, true);
		return merge(mergeSort(leftList), mergeSort(rightList));

	}
	
	public static List<Integer> createSubList(List<Integer> oldList, Integer splitIndex, boolean countingUp){
		List<Integer> newList = new ArrayList<Integer>();
		if(countingUp) {
			for(int i = splitIndex; i < oldList.size(); i++ ) {
				newList.add(oldList.get(i));
			}
		}else {
			for(int i = splitIndex; i > -1; i--) {
				newList.add(oldList.get(i)); 
			}
		}
		return newList;
	}
	
	public static List<Integer> merge (List<Integer> leftList, List<Integer> rightList){
		List<Integer> mergedList = new ArrayList<Integer>();	
		leftList.addAll(rightList);
		Collections.sort(leftList);
		for(int value : leftList) {
			mergedList.add(value);
		}
		return mergedList;
	}
	

}
