package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ThreeIncreasing {
	public int minEaten(int a, int b, int c)
	{
		if (a < b && b < c) {
			return 0;
		}

		int res = 0;
		int newB = b;
		if (b >= c) {
			newB = (c - 1);
			int t = (b - newB);
			if ((c - 1) <= 1) {
				return -1;
			}
			res += t;
		}
		if (a >= newB) {
			int t = (a - (newB - 1));
			
			if ((newB - 1) <= 0) {
				return -1;
			}
			res += t;
		}
		
		return res;
	}
	@Test
	public void test() {
		assertTrue(minEaten(20,3,30) == 18);
		assertTrue(minEaten(1,3,3) == 1);
		assertTrue(minEaten(5,6,6) == 2);
		assertTrue(minEaten(6, 1, 3000) == -1);
	}
}
