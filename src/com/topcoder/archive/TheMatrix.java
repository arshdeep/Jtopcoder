package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TheMatrix {
	public int MaxArea(String[] board) {
		int res = Integer.MIN_VALUE;
		int col = board[0].length();
		int row = board.length;
		int[][] dp = new int[row][col];
		
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				dp[i][j] = 1;
				
				for (int k = j + 1; k < col; ++k) {
					if (board[i].charAt(k - 1) == board[i].charAt(k)) break;
					dp[i][j] += 1;
				}
			}
		}
		
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				int min = dp[i][j];
				res = Math.max(res, min);
				for (int k = i + 1; k < row; ++k) {
					if (board[k].charAt(j) == board[k - 1].charAt(j)) break;
					min = Math.min(dp[k][j], min);
					
					res = Math.max(res, (k - i + 1) * min);
				}
			}
		}
		
		return res;
	}
	
	@Test
	public void test(){

		
		assertTrue( MaxArea(new String[]{"001",
				 "000",
		 "100"}
) == 2 );
		assertTrue( MaxArea(new String[]{"101", 
		 "010"}
) == 6 );		
		assertTrue( MaxArea(new String[]{"101", 
				 "011", 
				 "101", 
				 "010"}) == 8 );
	}
}
