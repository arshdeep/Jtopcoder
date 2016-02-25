package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FoxAndGo {
	boolean[][] visited;
	
	void dfs(String[] board, int i, int j) {
		int w = board[0].length();
		int h = board.length;

		if (i < 0 || i >= h || j < 0 || j >= w) {
			return;
		}

		if (visited[i][j] || board[i].charAt(j) == 'x') {
			return;
		}
		visited[i][j] = true;
		dfs(board, i - 1, j);
		dfs(board, i + 1, j);
		dfs(board, i, j - 1);
		dfs(board, i, j + 1);
	}
	
	int cal(String[] board) {
		int res = 0;
		visited = new boolean[board.length][board[0].length()];
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length(); ++j) {
				if ( !visited[i][j] && board[i].charAt(j) == '.' ) {
					dfs(board, i, j);
				}
			}
		}
		
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length(); ++j) {
				if ( !visited[i][j] && board[i].charAt(j) == 'o' ) {
					++res;
				}
			}
		}
		
		return res;
	}

	public int maxKill(String[] board) {
		int res = Integer.MIN_VALUE;
		
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length(); ++j) {
				char[] str = board[i].toCharArray();

				if ( str[j] == '.' ) {
					str[j] = 'x';
					board[i] = String.valueOf(str);
					res = Math.max(res, cal(board));
					str[j] = '.';
					board[i] = String.valueOf(str);
				}
			}
		
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( maxKill(new String[]{".xoxo",
				 "ooxox",
				 "oooxx",
				 "xoxox",
				 "oxoox"}) == 13);
		
		assertTrue( maxKill(new String[]{".......",
				 ".......",
				 ".......",
				 "xxxx...",
				 "ooox...",
				 "ooox...",
				 "ooox..."}) == 9);
		
		assertTrue( maxKill(new String[]{".......",
				 "..xx...",
				 ".xooox.",
				 ".oxxox.",
				 ".oxxxo.",
				 "...oo..",
				 "......."}) == 4);
		

		
		assertTrue( maxKill(new String[]{".....",
				 "..x..",
				 ".xox.",
				 ".....",
				 "....."}) == 1);
		
		assertTrue( maxKill(new String[]{"ooooo",
				 "xxxxo",
				 "xxxx.",
				 "xxxx.",
				 "ooooo"}) == 6);
	}
}
