package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnsealTheSafe {
	int[][] pad = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9},
			{0,-1, -1}
	};
	Long[][][] visit = new Long[4][4][31];
	
	long go(int i, int j, int N) {
		if (i < 0 || j < 0 || i > 3 || j > 2 || N < 0) {
			return 0;
		}
		
		if (pad[i][j] == - 1) {
			return 0;
		}
		if (visit[i][j][N] != null) {
			return visit[i][j][N];
		}
		long ans = N == 1 ? 1 : 0;
		
		ans += go(i - 1, j , N - 1);
		ans += go(i, j - 1, N - 1);
		ans += go(i + 1, j, N - 1);
		ans += go(i, j + 1, N - 1);
		
		return visit[i][j][N] = ans;
	}
	public long countPasswords(int N) {
		long ans = 0;
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (pad[i][j] != -1) {
					ans += go(i, j, N);
				}
			}
		}
		
		return ans;
	}
	
	@Test
	public void test() {
		assertTrue( countPasswords(25) == 768478331222L );
		assertTrue( countPasswords(3) == 74 );
		assertTrue( countPasswords(2) == 26 );
	}
}
