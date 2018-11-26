public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {9,8,7,6,5,4,3,2,1};
		boolean arrIsNotSorted = true;
		while (arrIsNotSorted) {
			arrIsNotSorted = !bubble(arr);
		}
		System.out.println("Sorted List: ");
		for(int i : arr) {
			System.out.print(i+", ");
		}
	}
	
	private static boolean bubble(int arr[]){
		boolean swapWasNotCalled = true;
		if(arr.length > 1) {
			for(int i =0; i < arr.length-1 ; i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i);
					swapWasNotCalled = false;
				}
			}
		}
		return swapWasNotCalled;
	}

	private static void swap(int[] arr, int pos1) {
		int temp = arr[pos1+1];
		arr[pos1+1] = arr[pos1];
		arr[pos1] = temp;
	}

}
