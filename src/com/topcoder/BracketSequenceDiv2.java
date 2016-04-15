package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BracketSequenceDiv2 {
	Integer dp[][];
	public int rec(String s, int last, int open) {
		if (dp[last + 1][open] != null) {
			return dp[last + 1][open];
		}
		int res = open == 0 ? 1 : 0;

		int nextl = last + 1;
		while (nextl < s.length() && s.charAt(nextl) != '(')
			++nextl;
		if (nextl < s.length())
			res = (res + rec(s, nextl, open + 1)) % 1000000007;
		if (open > 0) {
			int nextr = last + 1;
			while (nextr < s.length() && s.charAt(nextr) != ')')
				++nextr;
			if (nextr < s.length())
				res = (res + rec(s, nextr, open - 1)) % 1000000007;
			
		}
		return dp[last + 1][open] = res;
	}
	public int count(String s) {
		dp = new Integer[101][101];
		return rec(s, -1, 0) - 1;
	}
	@Test
	public void test(){
		assertTrue(count("()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()") == 122826009);
		assertTrue(count("()()()()()()()()(())))(()()()()))())") == 364675);
		assertTrue(count("(())(") == 2);
	}
	
}
