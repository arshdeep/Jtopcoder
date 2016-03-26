package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class WinterAndCandies {
	
	public int getNumber(int[] type) {
		int res = 0;
		Arrays.sort(type);
		int dp[] = new int[type.length + 1];
		dp[0] = 1;
		
		int j = 0;
		for (int i = 1; i <= type.length; ++i) {
			int count = 0;
			while (j < type.length && type[j] == i ) {
				++j;
				++count;
			}
			
			dp[i] = count * dp[i - 1];
			
			res += dp[i];
		}

		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( getNumber(new int[]{1, 3, 2, 5, 7, 4, 5, 4}) == 9);
		assertTrue( getNumber(new int[]{24, 15, 42, 12, 4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2}) == 2);
		assertTrue( getNumber(new int[]{1, 1, 2}) == 4);
		assertTrue( getNumber(new int[]{1, 3, 2}) == 3);
	}
}
