import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BowlingScoreCalculatorTest {
	
	BowlingScoreCalculator bsc = new BowlingScoreCalculator();
	
	@Test
	void testCalculateScore_AllStrikes() {
		String frameScores = "X X X X X X X X X X X X";
		int expectedScore = 300;
		int actualScore = bsc.ScoreGame(frameScores);
		assertEquals(expectedScore, actualScore);
	}
	
	void testCalculateScore_AllNines() {
		String frameScores ="9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";
		int expectedScore = 90;
		int actualScore = bsc.ScoreGame(frameScores);
		assertEquals(expectedScore, actualScore);
	}
	
	void testCalculateScore_FivesAndSpares() {
		String frameScores = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5";
		int expectedScore = 150;
		int actualScore = bsc.ScoreGame(frameScores);
		assertEquals(expectedScore, actualScore);
	}

}
