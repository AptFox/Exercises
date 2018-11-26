
public class SelectionSort {

	public static void main(String[] args) {
		//create array
		int unsortedArr[] = {9,8,7,6,5,4,3,2,1,11,54,1,47,12};
		//loop through array starting at 0
		for(int i = 0; i <unsortedArr.length -1 ; i++) {
			//locate the smallest element after the current index
			int indexOfSmallestValue =  findTheIndexOfSmallestElement(unsortedArr, i);
			//assign that element to the beginning of the subArray
			int temp = unsortedArr[indexOfSmallestValue];
			unsortedArr[indexOfSmallestValue] = unsortedArr[i];
			unsortedArr[i] = temp;
		}
		System.out.println("Sorted List: ");
		for(int i : unsortedArr) {
			System.out.print(i+", ");
		}
		
	}
	
	public static int findTheIndexOfSmallestElement(int unsortedArr[], int startingPos) {
		// Find the index of the minimum Element 
		int indexOfSmallestValue = startingPos;
		for(int i = startingPos; i < unsortedArr.length-1; i++) {
			if(unsortedArr[i] < unsortedArr[startingPos]) {
				indexOfSmallestValue = i;
			}
		}
		return indexOfSmallestValue;
	}

}
