package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XMarksTheSpot {
	public int countArea(String[] board) {
		int[] x = new int[21];
		int[] y = new int[21];
		int idx = 0;
		int dx1 = 50, dy1 = 50, dx2 = 0, dy2 = 0;
		
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length(); ++j) {
				if (board[i].charAt(j) == '?') {
					x[idx] = i;
					y[idx] = j;
					++idx;
				}
				else if (board[i].charAt(j) == 'O') {
					dx1 = Math.min(dx1, i);
					dx2 = Math.max(dx2, i);
					dy1 = Math.min(dy1, j);
					dy2 = Math.max(dy2, j);
				}
			}
		}
		
		int res = 0;
		for (int i = 0; i < (1 <<idx); ++i) {
			int dxx1 = dx1, dyy1 = dy1, dxx2 = dx2, dyy2 = dy2;
			for (int j = 0; j < idx; ++j) {
				if ((i & (1<<j)) != 0) {
					dxx1 = Math.min(dxx1, x[j]);
					dxx2 = Math.max(dxx2, x[j]);
					dyy1 = Math.min(dyy1, y[j]);
					dyy2 = Math.max(dyy2, y[j]);
				}
			}
			res += (dxx2 - dxx1 + 1) * (dyy2 - dyy1 + 1); 
		}
		
		return res;
	}
	@Test
	public void test() {
		assertTrue(countArea(new String[]{"?.",
				".O"}) == 5);
		assertTrue(countArea(new String[]{"???",
				"?O?",
				"???"}) == 1952);
	}

}
