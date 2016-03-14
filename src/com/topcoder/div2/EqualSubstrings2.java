package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EqualSubstrings2 {
	public int get(String s) {
		int res = 0;
		int n = s.length();
		
		for (int len = 1; len <= n; ++len) {
			for (int i = 0; i + len <= n; ++i) {
				String sub = s.substring(i, i + len);

				for (int j = i + len; j + len <= n; ++j) {
					if (s.substring(j, j + len).equals(sub)) {
						++res;
					}
				}
			}
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( get("abcd") == 0 );
		assertTrue( get("aa") == 1 );
	}
}
