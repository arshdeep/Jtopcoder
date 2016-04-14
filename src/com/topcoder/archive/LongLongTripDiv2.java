package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LongLongTripDiv2 {
	public 	String isAble(long D, int T, int B) {
		// Bx + T - x = D
		long x = D - T;
		int y = B - 1;

		if (x >= 0 && x % y == 0) {
			x = x / y;
			if (B * x <= D) {
				return "Possible";
			}
		}
		return "Impossible";
	}
	@Test
	public void test() {
		assertTrue(isAble(10,10,3).equals("Possible") );
		assertTrue(isAble(120, 10, 11).equals("Impossible") );
		assertTrue(isAble(1000,100,10).equals("Possible") );
		assertTrue(isAble(50,100,2).equals("Impossible") );
		assertTrue(isAble(10,6,3).equals("Possible") );
	}
}
