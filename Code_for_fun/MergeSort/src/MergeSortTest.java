import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testMergeSort1() {
		List<Integer> unsortedList = new ArrayList<Integer>(Arrays.asList(3,44,38,5,47,15,36,26,27,2,46,4,19,50,48));
		List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(2,3,4,5,15,19,26,27,36,38,44,46,47,48,50));
		List<Integer> returnedList =  MergeSort.mergeSort(unsortedList);
		assertTrue(expectedList.equals(returnedList));
	}
	
	@Test
	public void testMergeSort2() {
		List<Integer> unsortedList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> returnedList =  MergeSort.mergeSort(unsortedList);
		assertTrue(expectedList.equals(returnedList));
	}
	
	@Test
	public void testMergeSort3() {
		List<Integer> unsortedList = new ArrayList<Integer>(Arrays.asList(5,4,3,2,1));
		List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> returnedList =  MergeSort.mergeSort(unsortedList);
		assertTrue(expectedList.equals(returnedList));
	}


}
