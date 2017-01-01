package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RepeatStringEasy {
	String s;
	int[] ch;
	Integer[][] dp;

	int lcs(String s, String s2, int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (dp[i][j] != null) {
			return dp[i][j];
		}
		if (s.charAt(i - 1) == s2.charAt(j - 1)) {
			return dp[i][j] = 1+lcs(s, s2, i - 1, j - 1);
		}
		else {
			return dp[i][j] = Math.max(lcs(s, s2, i - 1, j), lcs(s, s2, i, j - 1));
		}
	}
	public int maximalLength(String s)
	{
		this.s = s;
		int ret = 0;
		for (int i = 1; i < s.length(); ++i) {
			dp = new Integer[s.length() + 1][s.length() + 1];
			dp[0][0] = 0;
			int t = lcs(s.substring(0, i), s.substring(i), i, s.substring(i).length());
			ret = Math.max(ret, 2*t);
		}
		return ret;
	}
	@Test
	public void test() {
		assertTrue(maximalLength("singing") == 6);
		assertTrue(maximalLength("fjkjsakljflkjakljjfiwoqjfioqwfoiqwjfiojq") == 16);
		assertTrue(maximalLength("kfkfbntjajgmaeaacahmikkdmfvriftzadddcb") == 12);
		assertTrue(maximalLength("aababbababbabbbbabbabb") == 18);
	}
}
