package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DivFreed2 {
	static final int mod = 1_000_000_007;
	public int count(int n, int k) {
		long res = 0;
		long dp[][] = new long[n + 1][k + 1];

		for (int i = 0 ; i <= k; ++i) {
			dp[1][i] = 1;
		}
		
		for (int t = 2; t <= n; ++t) {
			long sum = 0;
			for (int i = 1; i <= k; ++i) {
				sum = (sum + dp[t - 1][i] ) %mod;
			}
			for (int i = 1; i <= k; ++i) {
				dp[t][i] = (int)sum;
				for (int j = i*2; j <= k; j+=i) {
					dp[t][i] = (dp[t][i] - dp[t - 1][j]);
				}
			}
		}
		
		for (int i = 1 ; i <= k; ++i) {
			res = (res + dp[n][i]) % mod;
		}

		return (int)res;
	}
	@Test
	public void test() {
		assertTrue( count(10,100000) == 526882214 );
		assertTrue( count(1,107) == 107 );
		assertTrue( count(9,1) == 1 );
		assertTrue( count(2,2) == 3 );
	}
}
