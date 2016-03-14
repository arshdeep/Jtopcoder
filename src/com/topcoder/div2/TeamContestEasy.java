package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TeamContestEasy {
	public int worstRank(int[] strength) {
		int res = 0;
		Arrays.sort(strength, 0, 3);
		int sum = strength[2] + strength[1];
		int n = strength.length;
		Arrays.sort(strength, 3, n);
		
		int s = 2 + (n - 3)/ 3;
		int e = n - 1;
		
		while (s < n && e >= 0 && s < e) {
			if (strength[s] + strength[e] > sum) {
				++res;
				++s;
				--e;
			}
			else {
				++s;
			}
		}

		return 1 + res;
	}
	
	@Test
	public void test() {
		assertTrue( worstRank(new int[]{2,2,1,1,3,1,3,2,1,3,1,2,1,2,1}) == 4);
		assertTrue( worstRank(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}) == 1);
		assertTrue( worstRank(new int[]{5, 7, 3, 5, 7, 3, 5, 7, 3}) == 2);
		assertTrue( worstRank(new int[]{45,72,10,42,67,51,33,21,8,51,17,72}) == 3);
	}
}
