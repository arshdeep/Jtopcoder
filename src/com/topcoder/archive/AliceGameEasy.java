package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AliceGameEasy {
	long sum(long x) {
		return x * (x + 1L) / 2L;
	}
	public long findMinimumValue(long x, long y) {
		long lo = 0;
		long hi = 2L * (long) Math.sqrt(1000000000000L);
		
		while (lo < hi) {
			long mid = lo + (hi - lo) / 2L;
			
			if ( sum(mid) < (x + y) ) {
				lo = mid + 1;
			}
			else {
				hi = mid;
			}
		}
		if ( sum (lo) != (x + y) )
			return -1;
		
		int i = 0;
	    while (x > 0) {
	      x -= lo;
	      lo--;
	      i++;
	    }
	    return i;
	    
		/*
		long max = hi * (hi + 1) /2;
		for (int n = 0; n <= hi; ++n) {
			long s = n * (n + 1) / 2;
			long e = hi - n;
			
			e = e * (e + 1) / 2;
			
			if (s <= x && x <= max - e)
				return n;
		}
		return -1;*/
	}
	
	@Test
	public void test1()
	{
		assertTrue( findMinimumValue(0, 0) == 0 );
		assertTrue( findMinimumValue(7, 14) == 2 );
		assertTrue( findMinimumValue(7, 13) == -1 );
		assertTrue( findMinimumValue(10, 0) == 4 );
		assertTrue( findMinimumValue(932599670050L, 67400241741L) == 1047062 );
	}
}
