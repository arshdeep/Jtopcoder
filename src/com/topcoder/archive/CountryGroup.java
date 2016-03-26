package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CountryGroup {
	public int solve(int[] a) {
		int res = 0;
		int i = 0;
		int n = a.length;
		
		while (i < n) {
			++res;
			int t = a[i++];
			int c = t - 1;
			while (c > 0) {
				if (i >= n || a[i++] != t)
					return -1;
				--c;
			}
			
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( solve(new int[]{3,3}) == -1 );
		assertTrue( solve(new int[]{4,4,4,4,1,1,2,2,3,3,3}) == 5 );
		assertTrue( solve(new int[]{2,1,2,2,1,2}) == -1 );
		assertTrue( solve(new int[]{2,2,3,3,3}) == 2 );
		assertTrue( solve(new int[]{1,1,1,1,1}) == 5 );
	}
}
