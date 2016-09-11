package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BallsSeparating {
	public int minOperationsBrute(int[] red, int[] green, int[] blue) {
		int min = 1<<30;
		int n = red.length;
		
		if (n < 3) {
			return -1;
		}
		for (int i = 0 ; i < n; ++i) {
			for (int j = 0; j < n; ++j) if (j != i) {
				for (int k = 0; k < n; ++k) if (k != i && k != j) {
					int cc = red[j] + blue[j] + green[i] + blue[i] + red[k] + green[k];
					int rc = 0;
					for (int ii = 0; ii < n; ++ii) if (ii != i && ii != j && ii != k) {
						rc = green[ii] + blue[ii];
						rc = Math.min(rc, red[ii] + blue[ii]);
						rc = Math.min(rc, red[ii] + green[ii]);
						cc += rc;
					}
					min = Math.min(min, cc);
				}
			}
		}
		
		return min;
	}
	Integer[][] memo;
	int n;
	int[][] colors;
	int solve(int mask, int i) {
		if (i == n) {
			return mask == 7 ? 0 : (1<<28);
		}
		
		if (memo[mask][i] != null) {
			return memo[mask][i];
		}
		int res = Integer.MAX_VALUE;
		for (int j = 0; j < 3; ++j) {
			int cost = colors[(j + 1) % 3][i] + colors[(j + 2) % 3][i];
			
			res = Math.min(res, solve(mask | (1 << j), i + 1) + cost);
		}
		
		return memo[mask][i] = res;
	}
	public int minOperations(int[] red, int[] green, int[] blue) {
		colors = new int[][]{red, green, blue};
		memo = new Integer[1<<3][red.length];
		n = red.length;
		int color = 0;

		for (int j = 0; j < 3; ++j) {
			for (int i = 0; i < n; ++i) {
				if (colors[j][i] > 0) {
					color |= (1<<j);
				}
			}
		}
		
		if (n < Integer.bitCount(color)) {
			return -1;
		}
		
		return solve(0, 0);
	}
	@Test
	public void test() {
		assertTrue(minOperations(new int[]{7, 12, 9, 9, 7}, new int[]{7, 10, 8, 8, 9}, new int[]{8, 9, 5, 6, 13}) == 77);
		assertTrue(minOperations(new int[]{4, 6, 5, 7}, new int[]{7, 4, 6, 3}, new int[]{6, 5, 3, 8}) == 37);
		assertTrue(minOperations(new int[]{1,1,1}, new int[]{1,1,1}, new int[]{1,1,1}) == 6);
	}	
}
