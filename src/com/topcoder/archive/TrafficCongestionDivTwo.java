package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrafficCongestionDivTwo {
	long[] dp;
	public long theMinCars(int treeHeight) {
		dp = new long[treeHeight + 3];
		dp[0] = dp[1] = 1;
		
		for (int i = 2; i <= treeHeight; ++i) {
			dp[i] = 1;
			for (int j = i - 2; j >= 0; --j) {
				dp[i] += 2 * dp[j];
			}
		}

		return dp[treeHeight];
	}
	
	@Test
	public void test() {
		assertTrue( theMinCars(2) == 3);

		assertTrue( theMinCars(3) == 5);
		assertTrue( theMinCars(1) == 1);
		assertTrue( theMinCars(10) == 683);
		assertTrue( theMinCars(60) == 768614336404564651L);
		
	}
}
