package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DropCoins {
	public int getMinimum(String[] board, int K) {
		int n = board.length;
		int m = board[0].length();
		int[][] coins = new int[n + 1][m + 1];

		for (int i = 1; i <= n; ++i) {
			String str = board[i - 1];
			for (int j = 1; j <= str.length(); ++j) {
				coins[i][j] = coins[i - 1][j] + coins[i][j - 1] - coins[i - 1][j - 1];
				if (str.charAt(j - 1) == 'o') {
					coins[i][j] += 1;
				}
				
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= m; ++i) {
			for (int i1 = i; i1 <= m; ++i1) {
				for (int j = 1; j <= n; ++j) {
					for (int j1 = j; j1 <= n; ++j1) {
						int left = i - 1;
						int right = (m - i1);
						int top = j - 1;
						int bottom = (n - j1);
						int tcount = coins[j1][i1] - coins[j - 1][i1] - coins[j1][i - 1] + coins[j - 1][i - 1];
						
						if (tcount == K) {
							res = Math.min(res, left + right + top + bottom + Math.min(left, right) + Math.min(top, bottom)); 
						}

					}
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	@Test
	public void test() {
		assertTrue(getMinimum(new String[]{"o"},
				1) == 0);
		assertTrue(getMinimum(new String[]{"...."
				,".oo."
				,".oo."
				,"...."},
				3) == -1);
		assertTrue(getMinimum(new String[]{".....o"
				,"......"
				,"oooooo"
				,"oooooo"
				,"......"
				,"o....."},
				12) == 3);
		assertTrue(getMinimum(new String[]{".o.."
				,"oooo"
				,"..o."},
				3) == 2);
	}
}
