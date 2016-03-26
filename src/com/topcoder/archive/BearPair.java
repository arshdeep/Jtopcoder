package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BearPair {
	int solve(String s) {
		int res = -1;
		
		int i = 0;
		int j = s.length() - 1;
		
		while (i < s.length() && j >= 0) {
			if (s.charAt(i) != s.charAt(j)) {
				res = Math.max(res, Math.abs(j - i));
				break;
			}
			else {
				++i;
			}
		}
		return res;
	}
	public int bigDistance(String s)
	{
		return Math.max(solve(s), solve(new StringBuffer(s).reverse().toString()));
	}
	
	@Test
	public void test(){
		assertTrue( bigDistance(new StringBuffer("xxyyxyxyyyyyyxxxyxyxxxyxyxyyyyyxxxxxxyyyyyyyyxxxxx").reverse().toString()) == 47);
		
		assertTrue( bigDistance("abcba") == 3);
		assertTrue( bigDistance("bear") == 3);
	}
	
}
