package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrySail {
	public int get(int[] strength)
	{
		int max = 0;
		int n = strength.length;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) if (i != j) {
				int xor = 0;
				for (int k = 0; k < n; ++k) if (i != k && k != j) {
					xor ^= strength[k];
				}
				max = Math.max(max, strength[i] + strength[j] + xor);
			}
		}

		return max;
	}
	@Test
	public void test() {
		assertTrue(get(new int[]{114,51,4,191,9,81,0,89,3}) == 470);
	}	
}
