
public class QuickSort {
	
	private static int partition(String  [] a, int   start, int    end) {
		  String pivot = a[start];
		  int  endOfLeft = start;
		  int  midIndex = (start+end)/2; 
		  swap(a,start,midIndex); 
		  for (int i=start+1; i<=end; i++) {
			  if (a[i].compareTo(pivot) <= 0) {
				  	endOfLeft=endOfLeft+1;
				  	swap(a,endOfLeft,i);
			  } 
		  } 
		  swap(a,start,endOfLeft);
		  return endOfLeft;
		}


		public static void quickSort(String [] a, int start, int end) {
		  if (start<end) {	// general case
		      int pivot = partition(a, start, end); 
		      // sort left sublist
		      	quickSort(a,start,pivot-1); 
		      // sort the right sublist 
		      	quickSort(a,pivot+1,end); 
		  } 
		}
		
		private static void swap(String[] a, int i, int j)
	    {
	    String temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	    }

}
