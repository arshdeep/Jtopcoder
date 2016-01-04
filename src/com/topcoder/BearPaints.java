package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BearPaints {
	public long maxArea(int W, int H, long M) {
		long res = 0;
		long pr = Math.min(((long)W* (long)H), M);
		
		for (long i = W; i >= 1; --i) {
			long r = pr / i;
			if (r <= H && r * i <= M)
				res = Math.max(res, r * i);
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( maxArea(3, 5, 14) == 12 );
		assertTrue( maxArea(4, 4, 10) == 9 );
		assertTrue( maxArea(1000000, 12345, 1000000000000L) == 12345000000L );
		assertTrue( maxArea(1000000,1000000, 720000000007L) == 720000000000L );
	}
}
