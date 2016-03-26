package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoinsGameEasy {
	int deltaX[] = {1, -1, 0, 0};
	int deltaY[] = {0, 0, -1, 1};
	String[] board;
	int h;
	int w;
	
	int solve(int n, int x1, int y1, int x2, int y2) {
		if (n > 10) {
			return n;
		}
		if (x1 < 0 || x1 >= h || y1 < 0 || y1 >= w) {
			if (x2 >= 0 && x2 < h && y2 >= 0 && y2 < w) {
				return n;
			}
			else {
				return Integer.MAX_VALUE;
			}
		}
		else if (x2 < 0 || x2 >= h || y2 < 0 || y2 >= w) {
			if (x1 >= 0 && x1 < h && y1 >= 0 && y1 < w) {
				return n;
			}
			else {
				return Integer.MAX_VALUE;
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 4; ++i) {
			int x11 = x1 + deltaY[i];
			int y11 = y1 + deltaX[i];
			int x22 = x2 + deltaY[i];
			int y22 = y2 + deltaX[i];
			boolean c1 = true;
			boolean c2 = true;
			if (x11 >= 0 && x11 < h && y11 >= 0 && y11 < w && this.board[x11].charAt(y11) == '#') {
				x11 = x1;
				y11 = y1;
				c1 = false;
			}
			if (x22 >= 0 && x22 < h && y22 >= 0 && y22 < w && this.board[x22].charAt(y22) == '#') {
				x22 = x2;
				y22 = y2;
				c2 = false;
			}
			
			if (c1 || c2)
				res = Math.min(res, solve(n + 1, x11, y11, x22, y22));
		}
		
		return res;
	}

	public int minimalSteps(String[] board) {
		this.board = board;
		this.w = board[0].length();
		this.h = board.length;
		
		int res = 0;
		int x1 = -1;
		int y1 = -1;
		int x2 = -1;
		int y2 = -1;

		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				if (board[i].charAt(j) == 'o') {
					if (x1 == -1) {
						x1 = i;
						y1 = j;
					}
					else if (x2 == -1) {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
		
		res = solve(0, x1, y1, x2, y2);
		return res <= 10 ? res : -1;
	}
	
	@Test
	public void test() {
		assertTrue( minimalSteps(new String[]{".#", 
				 ".#", 
				 ".#",
				 "o#",
				 "o#",
				 "##"}) == 4 );
		assertTrue( minimalSteps(new String[]{"oo"}) == 1 );
		assertTrue( minimalSteps(new String[]{"..",
				 "..",
				 "..",
				 "o#",
				 "o#",
				 "##"}) == 3 );
		assertTrue( minimalSteps(new String[]{"###",
				 ".o.",
				 "###",
				 ".o.",
				 "###"}) == -1 );
		assertTrue( minimalSteps(new String[]{"###",
				 ".o.",
				 "#.#",
				 ".o.",
				 "###"}) == 3 );
		assertTrue( minimalSteps(new String[]{"###########",
				 "........#o#",
				 "###########",
				 ".........o#",
				 "###########"}) == 10 );
		assertTrue( minimalSteps(new String[]{"############",
				 ".........#o#",
				 "############",
				 "..........o#",
				 "############"}
					) == -1 );
	}
}
