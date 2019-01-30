
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Prompt: 
 * 	Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, 
 * 	produces the total score for the game. 
 * 
 * 
 * Here are some things that the program will not do:
    We will not check for valid rolls.
    We will not check for correct number of rolls and frames.
    We will not provide scores for intermediate frames.

 */
public class BowlingScoreCalculator {
	
    Map<Character, Integer> scoreMap = new HashMap<Character, Integer>(){
    	{
    	put('X',10);
	    put('/',10);
    	}
    };
	
	public int ScoreGame(String line) {
		return ScoreGame(line.replaceAll("\\s", ""), 1);
	}
	
	public int ScoreGame(String line, Integer frame) {
		frame = frame == null ? 1 : frame;
		boolean onLastFrame = frame == 10;
		if(line.length() == 0) {
			return 0;
		}else if (line.length() == 1) {
			return convertCharToScore(line.charAt(0));
		}
		Character throwOne = line.charAt(0);
		Character throwTwo = line.charAt(1);
		Character throwThree;
		if(throwOne == 'X') {
			throwThree = line.charAt(2);
			if(onLastFrame) {
				return getScoreOfNextThrows(throwOne, throwTwo, throwThree);
			}else {
				return getScoreOfNextThrows(throwOne, throwTwo, throwThree)+ScoreGame(line.substring(1), frame++);
			}
		}
		else if(throwTwo == '/') {
			throwThree = line.charAt(2);
			if(onLastFrame) {
				return getScoreOfNextThrows(throwTwo, throwThree);
			}else {
				return getScoreOfNextThrows(throwTwo,throwThree)+ScoreGame(line.substring(2), frame++);
			}
		}
		else if (throwOne == '-') {
			return convertCharToScore(throwTwo)+ScoreGame(line.substring(1), frame++);
		}
		else if (throwTwo == '-') {
			return convertCharToScore(throwOne)+ScoreGame(line.substring(2), frame++);
		}
		else {
			return convertCharToScore(throwOne) + convertCharToScore(throwTwo) + ScoreGame(line.substring(2), frame++);
		}
		
		 
	}
	
	private int convertCharToScore(Character ch) {
		int score;
		if(Character.isDigit(ch)) {
			score = Character.getNumericValue(ch);
		}else {
			score = scoreMap.get(ch);
		}
		return score;
	}


	private int getScoreOfNextThrows(Character...bowls) {
		int frameScore = 0;
		if(bowls.length == 1) {
			return convertCharToScore(bowls[0]);
		}else {
			for(Character ch : bowls) {
				frameScore += convertCharToScore(ch);
			}
		}
		return frameScore;
	}
	




}
