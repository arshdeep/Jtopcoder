package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoubleOrOneEasy {

	public int minimalSteps(int a, int b, int newA, int newB)
	{
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 31; ++i) {
			long d1 = newA - 1L* a * (1<<i);
			long d2 = newB - 1L* b * (1<<i);
			
			if (d1 != d2) continue;
			if (d1 < 0) continue;
			int count = i;
			for (long j = i; j >= 0; --j) {
				long amount = d1 / (1L<<j);
				count += amount;
				d1 -= (1L<<j) * amount;
			}
			res = Math.min(res, count);
		}
		
		if (res == Integer.MAX_VALUE)
			return -1;
		
		return res;
	}
	@Test
	public void test(){
		//assertTrue( minimalSteps(100, 1000, 101, 1001) == 1);
		assertTrue( minimalSteps(100, 1000, 202, 2002) == 2);
		assertTrue( minimalSteps(2, 2, 1, 1) == -1);
	}
}
