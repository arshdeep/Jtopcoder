package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BracketSequenceDiv1 {
	int dp[][];
	public int count(String s) {
		int n = s.length();
		dp = new int[n + 1][n + 1];
		
		for (int len = 2; len <= n; ++len) {
			for (int i = 0, j = len - 1; j < n; ++i, ++j) {
				dp[i][j] = dp[i + 1][j];
				for (int k = i + 1; k <= j; ++k) {
					if (s.charAt(i) == '(' && s.charAt(k) == ')' || s.charAt(i) == '[' && s.charAt(k) == ']') {
						dp[i][j] += (dp[i + 1][k - 1] + 1) * (dp[k + 1][j] + 1);
					}
				}
			}
		}
		return dp[0][n - 1];
	}
	@Test
	public void test(){
		assertTrue(count("()()") == 4);
		assertTrue(count("())") == 2);
		assertTrue(count("()[]") == 3);
		assertTrue(count("())[]][]([]()]]()]]]") == 3854);

	}
}
