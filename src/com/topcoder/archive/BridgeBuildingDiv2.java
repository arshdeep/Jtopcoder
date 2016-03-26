package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class BridgeBuildingDiv2 {
	public int minDiameter(int[] a, int[] b, int K) {
		final int INF = 1000000;
		int res = INF;
		int n = a.length + 1;

		for (int mask = 0, msize = (1 << n); mask < msize; ++mask) {
			if (Integer.bitCount(mask) == K) {
				int [][]dp = new int[n * 2][n * 2];
				
				for (int i = 0, size = n * 2; i < size; ++i) {
					Arrays.fill(dp[i], INF);
				}
				
				for (int j = 0; j < n; ++j) {
					if ((mask & (1 << j)) != 0) {
						dp[j][j + n] = 0;
						dp[j + n][j] = 0;
					}
				}
				
				for (int j = 0; j < n - 1; ++j) {
					dp[j][j + 1] = a[j];
					dp[j + 1][j] = a[j];
				}
				
				for (int j = 0; j < n - 1; ++j) {
					dp[j + n][j + n + 1] = b[j];
					dp[j + n + 1][j + n] = b[j];
				}
				int maxWidth = 0;
				for (int  k = 0; k < 2*n; ++k) {
					for (int  i = 0; i < 2 *n; ++i) {
						for (int j = 0; j < 2*n; ++j) {
							dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
						}
					}
				}
				for (int  i = 0; i < 2*n; ++i) {
					for (int  j = i + 1; j < 2 *n; ++j) {
						maxWidth = Math.max(maxWidth, dp[i][j]);
					}
				}
				res = Math.min(res, maxWidth);
			}
		}		
		
		return res;
	}
	
	@Test
	public void test()
	{

		assertTrue( minDiameter(new int[]{2,1,1,1,2}, new int[]{1,9,1,9,1}, 4) == 6 );
		assertTrue( minDiameter(new int[]{1,50,1,50,1,50,1,50}, new int[]{50,1,50,1,50,1,50,1}, 9) == 8 );
		assertTrue( minDiameter(new int[]{50,10,15,31,20,23,7,48,5,50}, new int[]{2,5,1,8,3,2,16,11,9,1}, 3) == 124 );
	}
}
