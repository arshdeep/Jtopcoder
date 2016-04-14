package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BuildingTowersEasy {
	public int maxHeight(int N, int[] x, int[] t) {
		int dp[] = new int[N];
		
		for (int j = 0; j < N; ++j) {
			dp[j] = j;
		}

		int res = 0;
		
		for (int i = 0; i < x.length; ++i) {
			int num = x[i] - 1;
			int t1 = t[i];
			
			for (int j = 1; j < N; ++j) {
				dp[j] = Math.min(dp[j], t1 + Math.abs(num - j));
			}
		}
		
		for (int no : dp) {
			res = Math.max(res, no);
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( maxHeight(97638, new int[]{8,1749,4550,5388,6752,7089,9737,14891,16671,16821,17691,19753,24589,
				25348,30114,32213,34376,36467,37699,41490,44784,44893,57316,58275,58567,
				61122,61489,63195,64776,65905,68788,69908,72853,78152,78784,82779,84488,
				86277,88611,92793,93214,97583}, new int[]{16610,6,497,14,42892,31,79,1203,518,31147,597,7846,1396,8309,12,14,1148,
				433,23693,13,1939,244,19,46,27,611,412,10,27023,19141,34,15667,588,10,229,
				83,390,14,38441,16021,4,39386}) == 6343 );
		assertTrue( maxHeight(2718, new int[]{1,30,400,1300,2500}, new int[]{100000,100000,100000,100000,100000}) == 2717 );
		assertTrue( maxHeight(100000, new int[]{}, new int[]{}) == 99999 );
		assertTrue( maxHeight(10, new int[]{3,8}, new int[]{1,1}) == 3 );
	}
}
