package main.java.findOptimalRoute;
import java.util.ArrayList;
import java.util.List;

public class FindOptimalRoute
{
    public static List<List<Integer>> optimalUtilization(int maxTravelDist, 
                                    List<List<Integer>> forwardRouteList,
                                    List<List<Integer>> returnRouteList)
	{
	   List<List<Integer>> pairForLpr = new ArrayList<List<Integer>>();
	   Integer lpr = 0; // largest possible route
	    for(int i = 0; i<forwardRouteList.size()-1; i++){
	        Integer fwdRouteId = forwardRouteList.get(i).get(0);
            Integer fwdRouteDist = forwardRouteList.get(i).get(1);
            
            for(int j = 0; j<returnRouteList.size()-1; j++){
                Integer retRouteId = returnRouteList.get(j).get(0);
                Integer retRouteDist = returnRouteList.get(j).get(1);
                Integer currentComb = fwdRouteDist + retRouteDist;
                if(currentComb > lpr && currentComb <= maxTravelDist){
                    lpr = currentComb;
                    List<Integer> lprList = new ArrayList<Integer>();
                    lprList.add(fwdRouteId);
                    lprList.add(retRouteId);
                    pairForLpr.add(0, lprList);
                }
            }
	    }
        return pairForLpr;
    }
}
