package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumbersChallenge {
	public int MinNumber(int[] S) {
		int n = S.length;
		boolean[] dp = new boolean[1000000 * 20 + 1];
		
		for (int mask  = 0; mask <= (1 << n); ++mask) {
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				if ((mask & (1 << i)) != 0) {
					sum += S[i];
				}
			}
			dp[sum] = true;
		}
		
		int res = 1;
		
		while (dp[res++]);
		
		return res - 1;
	}
	
	@Test
	public void test() {
		assertTrue( MinNumber(new int[] {5, 1, 2}) == 4);
		assertTrue( MinNumber(new int[] {2, 1, 4}) == 8);
		assertTrue( MinNumber(new int[] {2, 1, 2, 7}) == 6);
		assertTrue( MinNumber(new int[] {94512, 2, 87654, 81316, 6, 5, 6, 37151, 6, 139, 1, 36, 307, 1, 377, 101, 8, 37, 58, 1}) == 1092);
		assertTrue( MinNumber(new int[] {883, 66392, 3531, 28257, 1, 14131, 57, 1, 25, 88474, 4, 1, 110, 6, 1769, 220, 442, 7064, 7, 13}) == 56523);
	}
}
