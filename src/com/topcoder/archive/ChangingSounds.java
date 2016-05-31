package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChangingSounds {
	int[] changeIntervals;
	int maxLevel;
	Integer[][] dp;
	int memoCount;
	int solve(int k, int level) {
		if (level < 0 || level > maxLevel) {
			return -1;
		}
		if (k == changeIntervals.length) {
			return level;
		}
		if (dp[k][level] != null) {
			++memoCount;
			return dp[k][level];
		}
		return dp[k][level] = Math.max(solve(k + 1, level - changeIntervals[k]), solve(k + 1, level + changeIntervals[k]));
	}
	public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel) {
		this.changeIntervals = changeIntervals;
		this.maxLevel = maxLevel;
		this.memoCount = 0;
		dp = new Integer[changeIntervals.length + 1][maxLevel + 1];
		
		int res = solve(0, beginLevel);
		System.out.println(memoCount);
		return res;
	}
	@Test
	public void test() {
		assertTrue( maxFinal(new int[]{74,39,127,95,63,140,99,96,154,18,137,162,14,88}, 40, 243) == 238 );

		assertTrue( maxFinal(new int[]	{223, 333, 354, 364, 108, 90, 310, 168, 167, 179, 227, 496, 264, 331, 335, 208, 280, 150, 505, 29, 1, 89, 504, 22}, 452, 883) == 883 );
		assertTrue( maxFinal(new int[]{15, 2, 9, 10}, 8, 20) == -1 );

		
		assertTrue( maxFinal(new int[]{456, 103, 638, 634, 366, 337, 497, 410, 200, 590, 403, 447, 244, 427, 375, 389, 165, 536, 417, 121, 417, 460, 509, 425, 631, 456, 603, 355, 147, 40, 630, 425, 526, 92, 311, 522, 394, 544, 374, 549, 149, 487}, 595, 660) == -1 );

		assertTrue( maxFinal(new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500}, 500, 1000) == 500 );
		assertTrue( maxFinal(new int[]{15, 2, 9, 10}, 8, 20) == -1 );
		assertTrue( maxFinal(new int[]{5, 3, 7}, 5, 10) == 10 );
	}
}
