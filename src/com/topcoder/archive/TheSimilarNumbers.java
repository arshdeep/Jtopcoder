package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TheSimilarNumbers {
	public int find(int lower, int upper) {
		int count = 0;
		while (lower <= upper) {
			++count;
			lower = lower * 10 + 1;
		}
		return count;
	}
	@Test
	public void test() {
		assertTrue( find(5, 511) == 3);
		assertTrue( find(1, 10) == 1);
	}
}
