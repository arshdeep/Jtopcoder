package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GearsDiv2 {
	int solve(char[] str) {
		int count = 0;
		for (int i = 1; i < str.length; ++i) {
			if (str[i - 1] != ' ' && str[i - 1] == str[i]) {
				str[i] = ' ';
				++count;
			}
		}
		
		return count;
	}
	public int getmin(String Directions) {
		int n = Directions.length();
		int res = n;
		if (Directions.charAt(0) == Directions.charAt(n - 1)) {
			res = Math.min(res, solve(Directions.substring(1, n).toCharArray()) + 1);
			res = Math.min(res, solve(Directions.substring(0, n - 1).toCharArray()) + 1);
		}
		else {
			res = Math.min(res, solve(Directions.toCharArray()));
		}
		return res;

	}
	@Test
	public void test() {
		assertTrue(getmin("LRRRLRLLLRLRL") == 3);
		assertTrue(getmin("RRRRRRRLRRRRRRRLRLRLLRLRLRLRRLRLRLLLRLRLLRLLRRLRRR") == 14);
		assertTrue(getmin("LRLLRRLLLRRRLLLL") == 6);
		assertTrue(getmin("LRLR") == 0);
		assertTrue(getmin("RRR") == 2);
		assertTrue(getmin("LRRR") == 1);
	}	
	
}
