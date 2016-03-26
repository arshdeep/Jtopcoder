package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CatAndRat {
	public double getTime(int R, int T, int Vrat, int Vcat) {
		if (Vrat >= Vcat)
			return -1.0;

		return Math.min(Math.PI * R, T * Vrat) / (Vcat - Vrat);
	}
	
	@Test
	public void test1()
	{
		assertTrue( getTime(10, 1, 1, 1) == -1.0 );
		assertTrue( getTime(10, 1, 1, 2) == 1.0 );
		assertTrue( getTime(1000, 1000, 1, 1000) == 1.001001001001001 );
		assertTrue( getTime(1, 1000, 1, 2) == 3.141592653589793 );
	}
}
