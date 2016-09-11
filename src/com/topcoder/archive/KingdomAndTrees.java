package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KingdomAndTrees {
	boolean check(int[] in, int x) {
		int prev = 0;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] + x <= prev) {
				return false;
			}
			prev = Math.max(prev + 1, in[i] - x);
		}
		
		return true;
	}
	public int minLevel(int[] heights) {
		int lo = 0;
		int hi = (int) 1e9;
		
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			
			if (check(heights, mid)) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	@Test
	public void test() {
		assertTrue(minLevel(new int[]{9,5,11}) == 3);
		assertTrue(minLevel(new int[]{5,8}) == 0);
		assertTrue(minLevel(new int[]{1, 1, 1, 1, 1}) == 4);
	}	
}
