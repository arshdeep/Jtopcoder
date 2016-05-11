package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class RGBStreet {
	public int estimateCost(String[] houses) {
		int min = Integer.MAX_VALUE;
		int n = houses.length;
		
		int in[][] = new int[n][3];
		int idx= 0;
		
		for (String str : houses) {
			String[] vals = str.split(" ");
			in[idx][0] = Integer.parseInt(vals[0], 10);
			in[idx][1] = Integer.parseInt(vals[1], 10);
			in[idx][2] = Integer.parseInt(vals[2], 10);
			++idx;
		}
		int dp[][] = new int[n][3];
		for (int i = 1; i < n; ++i) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		dp[0][0] = in[0][0];
		dp[0][1] = in[0][1];
		dp[0][2] = in[0][2];
		
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < 3; ++j) {
				for (int k = 0; k < 3; ++k) if (k != j) {
					dp[i][j] = Math.min(dp[i][j], in[i][j] + dp[i - 1][k]);
				}
			}
		}
		for (int i = 0; i < 3; ++i) {
			min = Math.min(min, dp[n - 1][i]);
		}
		
		return min;
	}
	
	@Test
	public void test() {
		assertTrue( estimateCost(new String[]{"26 40 83", "49 60 57", "13 89 99"}) == 96 );
		assertTrue( estimateCost(new String[]{"1 100 100", "100 100 100", "1 100 100"}) == 102 );
		assertTrue( estimateCost(new String[]{"1 100 100", "100 1 100", "100 100 1"}) == 3 );

	}	
}
