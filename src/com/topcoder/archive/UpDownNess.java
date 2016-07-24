package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UpDownNess {
	Integer[][] dp;
	int limit = (int)(1e9 + 7);
	
	int go(int N, int K) {
		if (N == 1 && K == 0) {
			return 1;
		}
		
		if (dp[N][K] != null) {
			return dp[N][K];
		}
		
		int res = 0;

		for (int l = 0; l < N; ++l) {
			int r = N - l - 1;
			
			if (K >= l * r) {
				res =  (res + go(N - 1, K - (l * r))) % limit;
			}
		}
		
		return dp[N][K] = res % limit;
	}
	
	public int count(int N, int K) {
		dp = new Integer[N + 1][K + 1];
		
		int res = go(N, K);
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( count(4, 3) == 4 );
		assertTrue( count(3, 1) == 2 );
	}	
	
}
