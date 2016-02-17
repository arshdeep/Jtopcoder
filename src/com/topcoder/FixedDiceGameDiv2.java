package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FixedDiceGameDiv2 {
	public double getExpectation(int a, int b) {
		double exp = 0.0;
		double pw = 0.0;
		for (int x = 1; x <= a; ++x) {
			for (int y = 1; y <= b; ++y) {
				if ( x > y ) {
					pw += 1.0 / (a * b);
				}
			}
		}
		for (int x = 1; x <= a; ++x) {
			for (int y = 1; y <= b; ++y) {
				if ( x > y ) {
					exp += x / (a * b * pw);
				}
			}
		}
		return exp;
	}
	
	@Test
	public void test(){
		assertTrue( getExpectation(2, 2) == 2.0);
		assertTrue( getExpectation(4, 2) == 3.2);
		assertTrue( getExpectation(3, 3) == 2.6666666666666665);
	}
}
