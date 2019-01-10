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
		int leftIndex = 0;
		int rightIndex = 0;
		List<Integer> mergedList = new ArrayList<Integer>(); 
		while(leftIndex < leftList.size() && rightIndex < rightList.size()) {
			//The problem lives here one the elements always gets dropped because 
			//one side of the while statement becomes false after adding an element to the mergedList
			//I need a way of adding both elements. 
			//due to the dropping this method currently keeps dropping values until only the largest remains. 
			if(leftList.get(leftIndex) > rightList.get(rightIndex)) {
				mergedList.add(leftList.get(leftIndex));
				leftIndex++;
			}else {
				mergedList.add(rightList.get(rightIndex));
				rightIndex++;
			}
		}
		return mergedList;
	}
	

}
