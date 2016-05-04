package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GerrymanderEasy {
	double getmax(int[] A, int[] B, int K) {
		double res = 0;
		
		int[][] dp1 = new int[A.length][A.length];
		int[][] dp2 = new int[A.length][A.length];
		for (int len = 0; len < A.length; ++len ) {
			dp1[len][len] = A[len];
			dp2[len][len] = B[len];
		}		

		for (int len = 1; len < A.length; ++len ) {
			for ( int i = 0, j = len; j < A.length; ++i, ++j) {
				dp1[i][j] += dp1[i][j-1] + A[j];
				dp2[i][j] += dp2[i][j-1] + B[j];
				if (dp1[i][j] != 0) {
					res = Math.max(res, (double)dp2[i][j]/(double)dp1[i][j]);
				}
			}
		}

		return res;
	}
	@Test
	public void test() {
		assertTrue( getmax(new int[]{5,1,2,7}, new int[]{4,0,2,2}, 2) == 0.75 );
	}
}
