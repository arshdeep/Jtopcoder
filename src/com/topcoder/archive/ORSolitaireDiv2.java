package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ORSolitaireDiv2 {
	public int getMinimum(int[] numbers, int goal) {
		int n = numbers.length;
		int res = n;
		
		for (int i = 0; i < (1 << n); ++i) {
			int temp = 0;

			for (int j = 0; j < n; ++j) {
				if ( (i & (1<<j)) == 0 && ( (numbers[j] | goal) == goal)) {
					temp |= numbers[j];
				}
			}

			if (temp != goal) {
				res = Math.min(res, Integer.bitCount(i));
			}
		}
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( getMinimum(new int[]{5, 2, 4, 52, 62, 9, 8, 3, 1, 11, 6}, 11) == 3);
		assertTrue( getMinimum(new int[]{12571295, 2174218, 2015120}, 1) == 0);
		assertTrue( getMinimum(new int[]{1, 2, 4}, 7) == 1);
		assertTrue( getMinimum(new int[]{1, 2, 4, 7, 8}, 7) == 2);
	}
}
