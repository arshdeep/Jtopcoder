package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LastDigit {
	long check(long n) {
		long sum = 0;
		
		while(n > 0) {
			sum += n;
			n /= 10;
		}
		
		return sum;
		
	}
	public long findX(long S) {
		long hi = S;
		long lo = 0;
		
		while (lo < hi) {
			long mid = lo + (hi - lo) / 2;
			
			if (check(mid) >= S) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		
		return check(lo) == S ? lo : -1;
	}
	@Test
	public void test() {
		assertTrue(findX(565) == -1);
		assertTrue(findX(564) == 509);

	}
}
