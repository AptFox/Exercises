/*
Prompt: Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  
This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */

package main.java.LeetCode.medium;

import java.util.Arrays;

public class StoneGame {
    public static boolean stoneGame(int[] piles) {
        int A = 0;
        int L = 0;
        Arrays.sort(piles);
        for(int i=0; i < piles.length; i++){
            if(i%2==0){
                L+=piles[i];
            }else{
                A+=piles[i];
            }
        }
        return A>L;
    }
}
