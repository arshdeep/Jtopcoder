package com.topcoder.archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class Procrastination {
	public long findFinalAssignee(long n) {
		long i;
		for (i = 2; i * i <= n; ++i) {
			if (n % i == 0 && n / i > 1) {
				++n;
			}
			else if (n % i == 1 && n / i > 1) {
				--n;
			}
		}
		
		for (long j = n/i; j > 1; --j) {
			if (n % j == 0 && n / j > 1) {
				++n;
			}
			else if (n % j == 1 && n / j > 1) {
				--n;
			}
		}
		return n;
	}
	@Test
	public void test() {
		assertTrue( findFinalAssignee(3) == 3 );
		assertTrue( findFinalAssignee(8) == 11 );
		assertTrue( findFinalAssignee(20) == 20 );
		assertTrue( findFinalAssignee(196248) == 196259 );
		assertTrue( findFinalAssignee(5587021440L) == 5587021440L );
		assertTrue( findFinalAssignee(10000000000L) == 10000000003L );
	}
}
