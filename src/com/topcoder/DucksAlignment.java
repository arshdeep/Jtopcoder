package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class DucksAlignment {
	public int minimumTime(String[] grid) {
		int n = grid.length;
		int m = grid[0].length();
		
		ArrayList<Integer> dx = new ArrayList<Integer>();
		ArrayList<Integer> dy = new ArrayList<Integer>();
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0;j < m; ++j) {
				if (grid[i].charAt(j) == 'o') {
					dx.add(i);
					dy.add(j);
				}
			}
		}
		
		
		Collections.sort(dx);
		Collections.sort(dy);
		int size = dx.size();
		int res = (1<<30);
		for (int x = 0; x < n; ++x) {
			int rowCost = 0;
			for (int i = 0; i < dx.size(); ++i) {
				rowCost += Math.abs(dx.get(i) - x);
			}
			
			for (int y = 0; y + size <= m; ++y) {
				int colCost = 0;
				for (int j = 0; j < size; ++j) {
					colCost += Math.abs(dy.get(j) - (y + j));
				}
				res = Math.min(res, rowCost + colCost); 
			}
			
		}

		for (int x = 0; x < m; ++x) {
			int rowCost = 0;
			for (int i = 0; i < dx.size(); ++i) {
				rowCost += Math.abs(dy.get(i) - x);
			}
			
			for (int y = 0; y + size <= m; ++y) {
				int colCost = 0;
				for (int j = 0; j < size; ++j) {
					colCost += Math.abs(dx.get(j) - (y + j));
				}
				res = Math.min(res, rowCost + colCost); 
			}
			
		}		
		return res;
	}
	@Test
	public void test() {
		assertTrue(minimumTime(new String[]	
				{".........",
						 "....o....",
						 "........."}) == 0);
		assertTrue(minimumTime(new String[]	
				{"...o..........................",
						 "............................o.",
						 ".o............................",
						 "............o.................",
						 ".................o............",
						 "......................o.......",
						 "......o.......................",
						 "....o.........................",
						 "...............o..............",
						 ".......................o......",
						 "...........................o..",
						 ".......o......................"}) == 99);
		assertTrue(minimumTime(new String[]	
				{".o...",
						 "..o..",
						 "....o"}) == 3);
		assertTrue(minimumTime(new String[]	
				{"o..........",
						 "..o........",
						 ".......o...",
						 "...........",
						 "...........",
						 "...........",
						 "........o..",
						 "..........."}) == 16);
		assertTrue(minimumTime(new String[]	
				{".o",
				 "o."}) == 1);
	}
}
