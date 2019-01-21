import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class LongestCommonSubsequenceTest {

	@Test
	public void testFindLongestCommonSubsequence1() {
		String S1 = "ABAZDC";
		String S2 = "BACBAD";
		String expected = "ABAD";
		String actual = LongestCommonSubsequence.findLongestCommonSubsequence(S1, S2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindLongestCommonSubsequence2() {
		String S1 = "AGGTAB";
		String S2 = "GXTXAYB";
		String expected = "GTAB";
		String actual = LongestCommonSubsequence.findLongestCommonSubsequence(S1, S2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindLongestCommonSubsequence3() {
		String S1 = "aaaa";
		String S2 = "aa";
		String expected = "aa";
		String actual = LongestCommonSubsequence.findLongestCommonSubsequence(S1, S2);
		assertEquals(expected, actual);
	}

}
