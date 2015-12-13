package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaroJiroGrid {
	int getCount(String[] grid, int c) {
		int res = 1;

		int count = 1;
		for (int r = 1; r < grid.length; ++r) {
			if (grid[r].charAt(c) == grid[r - 1].charAt(c)) {
				res = Math.max(res, ++count);
			}
			else {
				count = 1;
			}
				
		}
		return res;
	}
	
	boolean isValid(String[] grid) {
		int n = grid.length;
		
		for (int c = 0; c < grid[0].length(); ++c) {
			if (getCount(grid, c) > n / 2) {
				return false;
			}
		}
		
		return true;
	}
	public int getNumber(String[] grid) {
		if (isValid(grid)) {
			return 0;
		}
		for (int r = 0; r < grid.length; ++r) {
			for (char ch = 'B'; ch <= 'W'; ch += 'W' - 'B') {
				String[] copyg = grid.clone();
				StringBuffer rowB = new StringBuffer(copyg[r]);

				for (int c = 0; c < grid[0].length(); ++c) {
					rowB.setCharAt(c, ch);
				}
				copyg[r] = rowB.toString();
				if (isValid(copyg)) {
					return 1;
				}
			}
		}
		
		return 2;
	}
	@Test
	public void test(){
		assertTrue( getNumber(new String[] {"WB",
				 "BB"}) == 1 );
		assertTrue( getNumber(new String[] {"WB",
		 "WW"}) == 1 );
		assertTrue( getNumber(new String[] {"WB",
				 "WB"}) == 2 );
		assertTrue( getNumber(new String[] {"WBBW",
				 "WBWB",
				 "WWBB",
				 "BWWW"}) == 2 );
	}
}
