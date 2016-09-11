package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DivisibleSetDiv2 {
	public String isPossible(int[] b) {
		int sum = 2520; //lcm of 1-10
		int res = 0;
		
		for (int in : b) {
			res += (sum + in - 1) / in;
		}
		
		return res <= sum ? "Possible" : "Impossible";
	}
	@Test
	public void test() {
		assertTrue(isPossible(new int[]{3,3,3}).equals("Possible"));
		assertTrue(isPossible(new int[]{1,10}).equals("Impossible"));
		assertTrue(isPossible(new int[]{3,2}).equals("Possible"));
	}	

}
