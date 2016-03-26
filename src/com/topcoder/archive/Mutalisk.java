package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=13761*/
public class Mutalisk {
	int[] x;
	boolean can(int t) {
		boolean [][][] dp = new boolean[t + 1][t + 1][t + 1];
		
		dp[t][t][t] = true;
		for (int n = 1; n <= x.length; ++n) {
			boolean [][][] next = new boolean[t + 1][t + 1][t + 1];
			boolean found = false;
			
			for (int i = 0; i <= t; ++i ) {
				for (int j = 0; j <= t; ++j) {
					for (int k = 0; k <= t; ++k) {
						if (!dp[i][j][k]) continue;
						
						for ( int u9 = 0; u9 <= i && u9 * 9 <= x[n - 1] + 9; ++u9 ) {
							for ( int u3 = 0; u3 <= j && u9 * 9 + u3 * 3 <= x[n - 1] + 12; ++u3 ) {
								int u1 = Math.max(0, x[n - 1] - u9 * 9 - u3 * 3);
								
								if (u9 + u3 + u1 <= t && u1 <= k) {
									next[i - u9][j - u3][k - u1] = true;
									found = true;
								}
							}
						}
					}
				}
			}
			if (!found) return false;
			dp = next;
		}
		
		return true;
	}
	
	public int minimalAttacks(int[] x) {
		this.x = x;
		
		int lo = 0;
		int hi = 93;
		
		while ( lo < hi ) {
			int mid = lo + (hi - lo) / 2;
			
			if (can(mid))
				hi = mid;
			else
				lo = mid + 1;
		}
		
		return lo;
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
		assertTrue( minimalAttacks(new int[]{60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60}) == 93 );
		assertTrue( minimalAttacks(new int[]{24, 51, 36, 7, 41, 24, 11, 22, 13, 56, 52, 58, 16, 54}) == 36 );
		assertTrue( minimalAttacks(new int[]{10, 57, 19, 22, 45, 48, 21, 29, 8, 49, 18, 51, 48, 31, 23, 4, 20}) == 39 );
	}
	
}
