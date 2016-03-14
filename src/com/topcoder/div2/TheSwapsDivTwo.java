package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TheSwapsDivTwo {
	public int find(int[] sequence) {
		int count = 0;
		boolean hasDub = false;
		for (int i = 0, n = sequence.length; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (sequence[i] != sequence[j]) {
					++count;
				}
				else hasDub = true;
			}
			
		}
		return count + (hasDub ? 1 : 0);
	}
	
	@Test
	public void test() {
		assertTrue( find(new int[]{1, 47}) == 1);
		assertTrue( find(new int[]{22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37}) == 319);
		assertTrue( find(new int[]{4, 7, 4}) == 3);
	}
}
