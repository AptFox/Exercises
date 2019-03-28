package test.java.LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.LeetCode.medium.StoneGame;

class StoneGameTest {

	@Test
	void test_AlexWins() {
		int[] piles = {5,3,4,5};
		boolean result = StoneGame.stoneGame(piles);
		assertTrue(result);
	}
	
	@Test
	void test_LeeWins() {
		int[] piles = {1,100,2};
		boolean result = StoneGame.stoneGame(piles);
		assertFalse(result);
	}
}
