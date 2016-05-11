package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HyperKnight {
	public long countCells(int a, int b, int numRows, int numColumns, int k) {
		long res = 0;
		int dx[] = {a, a, -a, -a, b, b, -b, -b};
		int dy[] = {b, -b, b, -b, a, -a, a, -a};
		long[] dp = new long[256];
		
		for (int mask = 255; mask > 0; --mask) {
			int n = 0;
			int left = 0, right = 0, top = 0, bottom = 0;
			for (int i = 0; i < 8; ++i) {
				if ( (mask & (1 << i)) != 0 ) {
					++n;
					if (dx[i] > 0) {
						right = Math.max(right, dx[i]);
					}
					else {
						left = Math.max(left, -dx[i]);
					}
					if (dy[i] < 0) {
						top = Math.max(top, -dy[i]);
					}
					else {
						bottom = Math.max(bottom, dy[i]);
					}
				}
			}
			
			dp[mask] = (numRows - left - right) * (numColumns - top - bottom);
			
			for (int mask2 = mask + 1; mask2 < 256; ++mask2) {
				if ( (mask2 & mask) == mask ) {
					dp[mask] -= dp[mask2];
				}
			}
			
			if (k == n) {
				res += dp[mask];
			}
		}
		return res;
	}
	@Test
	public void test() {
		assertTrue( countCells(2,1,8,8,4) == 20 );

	}
}
