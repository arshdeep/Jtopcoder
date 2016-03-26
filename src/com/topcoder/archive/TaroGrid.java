package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaroGrid {
	public int getNumber(String[] grid) {
		int res = 1;
		for (int c = 0; c < grid[0].length(); ++c) {
			int count = 1;
			for (int r = 1; r < grid.length; ++r) {
				if (grid[r].charAt(c) == grid[r - 1].charAt(c)) {
					res = Math.max(res, ++count);
				}
				else {
					count = 1;
				}
					
			}
		}
		return res;
	}
	
	@Test
	public void test(){
		assertTrue( getNumber(new String[] {"WB",
		 "BW"}) == 1 );
		assertTrue( getNumber(new String[] {"BWBW",
				 "BBWB",
				 "WWWB",
				 "BWWW"}) == 3 );
	}
}
