package com.topcoder;

import static org.junit.Assert.*;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=13782*/
public class MutaliskEasy {
	public int minimalAttacks(int[] x) {
		int[][] attacks = { {9,3,1}, {3,9,1}, {3,1,9}, {9,1,3}, {1,9,3}, {1,3,9} };
		int[][][] dp = new int[61][61][61];
		
		for (int i = 0; i < 61; ++i) {
			for (int j = 0; j < 61; ++j) {
				for (int k = 0; k < 61; ++k) {
					if ( i == 0 && j == 0 && k == 0 ) continue;
					
					dp[i][j][k] = Integer.MAX_VALUE;
					for (int n = 0, size = attacks.length; n < size; ++n) {
						int x1 = Math.max(0, i - attacks[n][0]);
						int x2 = Math.max(0, j - attacks[n][1]);
						int x3 = Math.max(0, k - attacks[n][2]);
						dp[i][j][k] = Math.min(dp[i][j][k], 1 + dp[x1][x2][x3]);
					}
				}
			}
 		}
		
		int x1 = 0, y = 0, z = 0;
		
		x1 = x[0];
		if (x.length > 1)
			y = x[1];
		if (x.length > 2)
			z = x[2];
		
		return dp[x1][y][z];
	}
	
	@Test
	public void test() {
		assertTrue( minimalAttacks(new int[]{12,10,4}) == 2 );
		assertTrue( minimalAttacks(new int[]{54,18,6}) == 6 );
		assertTrue( minimalAttacks(new int[]{55,60,53}) == 13 );
		assertTrue( minimalAttacks(new int[]{1,1,1}) == 1 );
		assertTrue( minimalAttacks(new int[]{60,40}) == 9 );
		assertTrue( minimalAttacks(new int[]{60}) == 7 );
		assertTrue( minimalAttacks(new int[]{14, 16, 22}) == 4 );
	}
}
