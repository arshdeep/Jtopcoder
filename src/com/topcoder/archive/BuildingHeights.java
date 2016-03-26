package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class BuildingHeights {
	public int minimum(int[] heights) {
		int res[] = new int[heights.length + 1];

		Arrays.fill(res, Integer.MAX_VALUE);
		Arrays.sort(heights);
		res[1] = 0;
		
		for (int i = heights.length - 1; i >= 0; --i) {
			int c = 0;
			for (int k = i - 1; k >= 0; --k) {
				c += heights[i] - heights[k];
				
				res[i - k + 1] = Math.min(c, res[i - k + 1]);
			}
		}
		
		int xor = res[2];
		
		for (int  i = 3; i < res.length; ++i) {
			xor ^= res[i];
		}
		
		return xor;
	}
	
	@Test
	public void test1()
	{
		assertTrue( minimum(new int[]{1, 5, 4, 3, 8}) == 22 );
		assertTrue( minimum(new int[]{990, 20, 2359, 1667, 51, 2455, 1659, 1093, 2015, 205, 656, 752, 1760, 1594, 857,
				 2033, 1868, 1932, 2408, 1518, 91, 2220, 1696, 1552, 933, 143, 1888, 1261, 2298, 1975,
				 929, 2139, 1994, 2139, 158, 896, 2093, 1816, 841, 459, 2020, 1496, 63, 131, 589, 919,
				 1015, 1308, 350, 922, 326, 1792, 641, 2021, 843, 425, 1015, 231, 1685, 2165, 1057,
				 1465, 655, 550, 1103, 812, 297, 2048, 1479, 1137, 6, 2350, 1484, 1420, 1332, 925, 2338,
				 1198, 2232, 1539, 2119, 57, 830, 1611, 929, 525, 888}) == 56068 );
		assertTrue( minimum(new int[]{3, 4, 1, 6, 8, 1}) == 21 );
	}
}
