package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SplitIntoPairs {
	public int makepairs(int[] A, int X) {
		int res = 0;
		
		boolean[] dp = new boolean[A.length];
		Arrays.sort(A);
		for (int i = 0; i < A.length; ++i) if (!dp[i]) {
			long temp = X;
			int ii = -1;
			int jj = -1;
			for (int j = i + 1; j < A.length; ++j) if (i != j && !dp[j]) {
				long ll = 1L * A[i] * A[j];
				if (ll >= X) {
					if (temp <= ll) {
						temp = ll;
						ii = i;
						jj = j;
					}
				}
			}
			
			if (temp >= X && ii != -1 && jj != -1) {
				++res;
				dp[ii] = true;
				dp[jj] = true;
			}
			
		}
		
		return res;
	}
	@Test
	public void test(){
		assertTrue( makepairs(new int[]{2,-1}, -1) == 0);
		assertTrue( makepairs(new int[]{3,4,5,6,6,-6,-4,-10,-1,-9}, -2) == 4);
		assertTrue( makepairs(new int[]{5,-7,8,-2,-5,3}, -7) == 3);
	}	
}
