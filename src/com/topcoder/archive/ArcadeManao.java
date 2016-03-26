package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArcadeManao {
	String[] level;
	int coinRow;
	int coinColumn;
	int[] dx = {0,-1,0,1};
	int[] dy = {1, 0,-1,0};
	boolean visited[][];
	int h;
	int w;
	boolean isPossible(int x, int y, int len) {
		if (visited[x][y]) {
			return false;
		}
		if (x == coinRow - 1 && y == coinColumn - 1) {
			return true;
		}
		visited[x][y] = true;
		for (int i = 0; i < 4; ++i) {
			for (int l = 0; l <= len; ++l) {
				int newX = x + dx[i] * l;
				int newY = y + dy[i];
				
				if (newX >=0 && newX < h && newY >=0 && newY < w) {
					if (level[newX].charAt(newY) == 'X') {
						if (isPossible(newX, newY, len)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public int shortestLadder(String[] level, int coinRow, int coinColumn) {
		this.h = level.length;
		this.w = level[0].length();
		this.level = level;
		this.coinRow = coinRow;
		this.coinColumn = coinColumn;

		int s = 0;
		int e = h;
		
		while (s < e) {
			int mid = s + (e - s) / 2;
			this.visited = new boolean[h][w];
			
			if (isPossible(h - 1, 0, mid)) {
				e = mid;
			}
			else {
				s = mid + 1;
			}
		}
		return s;
	}
	
	@Test
	public void test() {
		assertTrue( shortestLadder(new String[]{"XXXXX.XXXXXXX.X..X.XX.XX.XX.XX.XX.X..X.", "..XX..XX.X...XXX.XX...XX.XX..XX..XX.XXX", "X.X....X.XXXXX...X.XXXX...X.X..XX...XXX", ".....X.X..X.X.XXX.XXXXX.X.X...XX.X.....", ".X.X.XX..X.X..XX..XXX..X....X.X.XX...X.", ".......X.XXX.....X..X.X.XXX..X...XXXX.X", ".X.....XXXX.XX.XXX...XXX..XX..XX.XXXX.X", "X....X.XXX..XX..XX.X.X...XX......X...XX", ".X..X.XXXX..X..X.....X....X...XX.X..X.X", "X.....X.X..XXXXX.XX..X....X..X.X.X...X.", "XXX.XX.XXXXX...XXX.XX.XXX..XXXX..XX.XXX", "X..XX.XX.XXXX..XX..XX.XX..X..X.XXXX.X.X", "X.X..XXX..X.X..XX..X..XX..X..X..X.XX..X", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"}, 8, 22) == 3 );				
		assertTrue( shortestLadder(new String[]{"..X.XXX.X", "X....X..X", "..X.XXXXX", ".X...XX.X", "X...X....", "..X.X..XX", "X.X..X..X", "XXXXXXXXX"}, 8, 4) == 0 );				
		assertTrue( shortestLadder(new String[]{"..X..",
				 ".X.X.",
				 "X...X",
				 ".X.X.",
				 "..X..",
				 "XXXXX"}, 1,3) == 4 );			
		assertTrue( shortestLadder(new String[]{"XXXXXXXXXX",
				 "...X......",
				 "XXX.......",
				 "X.....XXXX",
				 "..XXXXX..X",
				 ".........X",
				 ".........X",
				 "XXXXXXXXXX"}, 1,1) ==2 );		
		assertTrue( shortestLadder(new String[]{"XXXX",
				 "...X",
		 "XXXX"}, 1,1) == 1 );		
		assertTrue( shortestLadder(new String[]{"XXXX....",
												 "...X.XXX",
												 "XXX..X..",
												 "......X.",
												 "XXXXXXXX"}, 2, 4) == 2 );
	}
}
