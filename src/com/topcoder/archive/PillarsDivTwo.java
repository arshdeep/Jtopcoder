package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PillarsDivTwo {
	public double maximalLength(int[] height, int w) {
		int n = height.length;
		double dp[][] = new double[n][101];
		
		for (int i = 1; i < n; ++i) {
			int h = height[i];
			int ph = height[i - 1];
			
			for (int j = h; j >= 1; --j) {
				for (int k = ph; k >= 1; --k) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.sqrt( w*w + (k - j)*(k - j) ));
				}
			}
			
		}
		
		double res = dp[n - 1][0];
		
		for (int i = 1; i <= height[n - 1]; ++i) {
			res = Math.max(res, dp[n - 1][i]);
		}
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( maximalLength(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}, 100) == 6895.085278660454 );
		assertTrue( maximalLength(new int[]{1,1,1,1}, 100) == 300.0 );
		assertTrue( maximalLength(new int[]{2,1,1,2}, 1) == 3.82842712474619 );
		assertTrue( maximalLength(new int[]{100,2,100,2,100}, 4) == 396.32310051270036 );
		assertTrue( maximalLength(new int[]{3,3,3}, 2) == 5.656854249492381 );
	}
}
