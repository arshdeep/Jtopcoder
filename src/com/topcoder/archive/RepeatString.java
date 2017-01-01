package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RepeatString {
	char[] sub1;
	char[] sub2;
	Integer dp[][];
	int solve(int i, int j) {
		if (i == 0) {
			return j;
		}
		else if (j == 0) {
			return i;
		}
		if (dp[i][j] != null) {
			return dp[i][j];
		}
		if (sub1[i - 1] == sub2[j - 1]) {
			return dp[i][j] = solve(i - 1, j - 1);
		}
		else {
			return dp[i][j] = Math.min(solve(i - 1, j - 1), Math.min(solve(i, j - 1), solve(i - 1, j))) + 1;
		}
	}
	public int minimalModify(String s) {
		int res = s.length();
		for (int len = 0; len <= s.length(); ++len) {
			sub1 = s.substring(0, len).toCharArray();
			sub2 = s.substring(len).toCharArray();
			dp = new Integer[s.length()][s.length()];
			res = Math.min(res, solve(sub1.length, sub2.length));
		}
		return res;
	}
	@Test
	public void test() {
		assertTrue(minimalModify("adibggggbbbcacaigedaaakaaegnabaefhjqbbcabdadaiadel") == 18);
		assertTrue(minimalModify("ggigachtomjggadceabiubhjdeoedamkanhcjbk") == 18);
		assertTrue(minimalModify("cbvpgogbpapnfbohhogcaalbhfbani") == 13);
		assertTrue(minimalModify("aaaaaaaaaaaaaaaaaaaa") == 0);
		assertTrue(minimalModify("x") == 1);
		assertTrue(minimalModify("repeatstring") == 6);
		assertTrue(minimalModify("adam") == 1);
	}
}
