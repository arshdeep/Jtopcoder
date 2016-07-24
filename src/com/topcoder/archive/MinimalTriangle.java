package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MinimalTriangle {
	public double maximalArea(int length) {
		return ( (double)length * (double)length * Math.sin(Math.toRadians(120)) ) / 2;
	}
	
	@Test
	public void test() {
		assertTrue( maximalArea(100000) == 4.330127018922194E9);
	}
}
