package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DivisorsPower {
	long cal(long n) {
		long divCount = 0;
		for (long i = 1; i <= n; ++i) {
			if (n % i == 0) {
				++divCount;
			}
		}
		
		return (long) Math.pow(n, divCount);
	}
	public long findArgument(long n) {
		long lo = 0;
		long hi = n;
		
		while (lo < hi) {
			long mid = lo + (hi - lo) / 2;

			if (cal(mid) <= n) {
				hi = mid;
			}
			else {
				lo = mid;
			}
		}
		return lo == n ? -1 : lo;
	}
	@Test
	public void test(){
//		assertTrue( findArgument(4) == 2);
//		assertTrue( findArgument(10) == -1);
		assertTrue( findArgument(64) == 4);
	}	
}
