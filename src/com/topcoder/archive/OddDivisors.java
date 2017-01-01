package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OddDivisors {
	long getodd(long x) {
		long n = (x + 1)/ 2;
		
		return n * n;
	}
	long solve(long n) {
		if (n <= 2) return n;
		if ( (n & 1) != 0)
			return solve((n - 1) /2) + getodd(n);
		else {
			return solve(n/2) + getodd(n - 1);
		}
	}
	public long findSum(int N) {
		long res = solve(N);
		
		return res;
	}
	@Test
	public void test() {
		assertTrue(findSum(777) == 201537);
		assertTrue(findSum(7) == 21);
	}
	
}
