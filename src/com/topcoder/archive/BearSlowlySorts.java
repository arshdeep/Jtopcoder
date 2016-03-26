package com.topcoder.archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class BearSlowlySorts {
	public int minMoves(int[] w) {
		int res = 0;
		boolean isSorted = true;
		int min = w[0];
		int max = w[0];
		int n = w.length;
		
		for (int i = 1; i < w.length; ++i) {
			if (w[i - 1] > w[i]) {
				isSorted = false;
			}
			min = Math.min(min, w[i]);
			max = Math.max(max, w[i]);
		}
		
		if (isSorted)
			return res;
		
		if (w[n - 1] == min && max == w[0] && w[0] > w[1] && w[n - 1] < w[n - 2])
			res = 3;
		else if (w[n - 1] == min)
			res = 2;
		else if (w[0] == min || w[n - 1] == max)
			res = 1;
		else
			res = 2;
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( minMoves(new int[] {2,6,8,5}) == 1);
		assertTrue( minMoves(new int[] {4,3,1,6,2,5}) == 2);
		assertTrue( minMoves(new int[] {93,155,178,205,213,242,299,307,455,470,514,549,581,617,677}) == 0);
		assertTrue( minMoves(new int[] {50,20,30,40,10}) == 3);
		assertTrue( minMoves(new int[] {234,462,715,596,906,231,278,223,767,925,9,526,369,319,241,354,317,880,5,696}) == 2);
	}
}
