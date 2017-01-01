package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class GridSortMax {
	String findMax(int n, int m, int[] grid) {
		int[] gRow = new int[n*m];
		int[] gCol = new int[n*m];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				int val = grid[i*m + j] - 1;
				
				gRow[val] = i;
				gCol[val] = j;
			}
		}
		
		int[] sRow = new int[n];
		int[] sCol = new int[m];
		Arrays.fill(sRow, -1);
		Arrays.fill(sCol, -1);
		int[] inRow = new int[n];
		int[] inCol = new int[m];
		Arrays.fill(inRow, -1);
		Arrays.fill(inCol, -1);

		StringBuffer ret = new StringBuffer();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				ret.append("0");
				int rr = gRow[i * m + j];
				int col = gCol[i * m + j];
				//number belongs to same row/col index
				
				if (sRow[i] >= 0 && sRow[i] != rr) continue;
				if (sCol[j] >= 0 && sCol[j] != col) continue;
				// make sure that element is placed without violations
				if (inRow[rr] >= 0 && inRow[rr] != i) continue;
				if (inCol[col] >= 0 && inCol[col] != j) continue;
				sRow[i] = rr;
				sCol[j] = col;
				inRow[rr] = i;
				inCol[col] = j;
				ret.setCharAt(ret.length() - 1, '1');
			}
		}
		
		return ret.toString();
	}
	@Test
	public void test() {
		assertTrue(findMax(2, 2, new int[]{ 2, 1, 3,4}).equals("1100"));
		assertTrue(findMax(6, 2, new int[]{3,9,
				 5,1,
				 10,6,
				 2,7,
				 8,11,
				 12,4}).equals("100000101010"));
	}
}
