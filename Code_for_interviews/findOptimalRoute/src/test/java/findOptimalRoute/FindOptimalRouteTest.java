package test.java.findOptimalRoute;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.findOptimalRoute.FindOptimalRoute;

class FindOptimalRouteTest {

	@Test
	void testOptimalUtilization() {
		int maxTravelDist = 4000; //[2,2000]
		List<List<Integer>> forwardRouteList =  new ArrayList<List<Integer>>();// [1,2000]
		List<List<Integer>> returnRouteList = new ArrayList<List<Integer>>(); //[1,2000]
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		expected.add(Arrays.asList(1, 1));
		forwardRouteList.add(Arrays.asList(1, 2000));
		forwardRouteList.add(Arrays.asList(2, 1000));
		forwardRouteList.add(Arrays.asList(3, 500));
		forwardRouteList.add(Arrays.asList(4, 250));
		returnRouteList.add(Arrays.asList(1, 2000));
		returnRouteList.add(Arrays.asList(2, 200));
		List<List<Integer>> actual =FindOptimalRoute.optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList);
		assertEquals(expected, actual);
		//return a pair representing the largest path that doesn't go over max 
	}

}
