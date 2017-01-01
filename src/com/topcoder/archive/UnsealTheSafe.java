package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnsealTheSafe {
	int[][] pad = {{1,2,3},
			{4,5,6},
			{7,8,9},
			{0, -1, -1}};
	int dx[] = {1, -1, 0, 0};
	int dy[] = {0 , 0, 1, -1};
	Long[][] dp = new Long[11][50];
	long solve(int i, int j, int n) {
		if (pad[i][j] == -1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (dp[pad[i][j]][n] != null) {
			return dp[pad[i][j]][n];
		}
		long res = 0;
		for (int ii = 0; ii < 4; ++ii) {
			int nx = i + dx[ii];
			int ny = j + dy[ii];
			
			if (nx >= 0 && nx < pad.length && ny >= 0 && ny < pad[0].length) {
				res += solve(nx, ny, n - 1);
			}
		}
		
		return dp[pad[i][j]][n] = res;
	}
	public long countPasswords(int N) {
		long res = 0;
		for (int i = 0; i < pad.length; ++i) {
			for (int j = 0; j < pad[0].length; ++j) {
				if (pad[i][j] != -1) {
					long r = solve(i , j, N);
					//System.out.println(r);
					res += r;
				}
			}
		}
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue(countPasswords(30) == 145419506315214L);
		assertTrue(countPasswords(25) == 768478331222L);
		assertTrue(countPasswords(24) == 269294999646L);
		assertTrue(countPasswords(15) == 21460630);
	}
}
