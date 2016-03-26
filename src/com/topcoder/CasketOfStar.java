package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class CasketOfStar {
	int[] weight;
	int[][] dp;
	int solve(int i, int j) {
		if (i + 1 == j) return 0;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int res = 0;
		for (int k = i + 1; k < j; ++k) {
			res = Math.max(res, weight[i] * weight[j] + solve(i, k) + solve(k, j) );
		}
		
		return dp[i][j] = res;
	}
	public int maxEnergy(int[] weight) {
		this.weight = weight;
		int n = weight.length;
		dp = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; ++i)
			Arrays.fill(dp[i], -1);
		return solve(0, weight.length - 1);
	}
	@Test
	public void test(){
		assertTrue( maxEnergy(new int[]{917, 918, 940, 955, 988, 964, 945, 931, 930, 992, 930, 931, 997, 998, 957, 951, 968, 962, 996, 956, 987, 952, 943, 942, 984, 930, 922, 919, 920, 992, 953, 950, 965, 993, 940, 926, 947, 978, 921, 982}) == 36321482 );
		assertTrue( maxEnergy(new int[]{7, 50, 8, 1, 5}) == 335 );
		assertTrue( maxEnergy(new int[]{1000, 1, 1000, 2, 1000, 4, 1000, 500, 2, 2}) == 5504000 );
		assertTrue( maxEnergy(new int[]{363, 28, 691, 60, 764, 927, 541, 427, 173, 737}) == 3592727 );
		assertTrue( maxEnergy(new int[]{100, 3, 1, 2, 100}) == 10400 );
		assertTrue( maxEnergy(new int[]{1,1,1,1,1,1,1,1,1,1}) == 8 );
		assertTrue( maxEnergy(new int[]{477,744,474,777,447,747,777,474}) == 2937051 );
		assertTrue( maxEnergy(new int[]{2,2,7,6,90,5,9}) == 1818 );
		assertTrue( maxEnergy(new int[]{100,2,1,3,100}) == 10400 );
		assertTrue( maxEnergy(new int[]{1,2,3,4}) == 12 );
	}
}
