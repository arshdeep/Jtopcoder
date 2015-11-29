package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BuildingHeightsEasy {

	public int minimum(int M, int[] heights) {
		int res = Integer.MAX_VALUE;
		
		for (int i = 0; i < heights.length; ++i) {
			for (int j = i + 1; j < heights.length; ++j) {
				if (heights[i] < heights[j]) {
					int temp = heights[i];
					heights[i] = heights[j];
					heights[j] = temp;
				}
			}
		}
		for (int i = 1; i <= 50; ++i) {
			int count = 0;
			int newBuilt = 0;
			
			for (int j = 0; j < heights.length && count < M; ++j) {
				if (heights[j] == i) {
					++count;
				}
				else if (heights[j] <= i) {
					++count;
					newBuilt += i - heights[j];
				}
			}
			if (count == M)
				res = Math.min(newBuilt, res);
		}
		
		return res;
	}
	
	@Test
	public void test1()
	{
		assertTrue( minimum(2, new int[]{1, 2, 1, 4, 3}) == 0 );
		assertTrue( minimum(3, new int[]{1, 3, 5, 2, 1}) == 2 );
		assertTrue( minimum(1, new int[]{43, 19, 15}) == 0 );
		assertTrue( minimum(3, new int[]{19, 23, 9, 12}) == 15 );
		assertTrue( minimum(12, new int[]{25, 18, 38, 1, 42, 41, 14, 16, 19, 46, 42, 39, 38, 31, 43, 37, 26, 41, 33, 37, 45, 27, 19, 24, 33, 11, 22, 20, 36, 4, 4}) == 47 );

	}
}
