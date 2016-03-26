package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuadraticLaw {
	public long getTime(long d)
	{
		long lo = 0;
		long hi = (long) Math.sqrt(d) + 1;
		
		while (lo < hi) {
			long mid = lo + (hi - lo + 1) / 2;

			if ( (d - mid*mid - mid) >= 0) 
				lo = mid;
			else
				hi = mid - 1;
		}
		return lo;
	}
	
	@Test
	public void test1()
	{
		assertTrue( getTime(1000000000000000000L) == 999999999L );
		assertTrue( getTime(31958809614643170L) == 178770270L );
		assertTrue( getTime(1) == 0 );
		assertTrue( getTime(2) == 1 );
		assertTrue( getTime(5) == 1 );
		assertTrue( getTime(6) == 2 );
		assertTrue( getTime(7) == 2 );
	}
}
