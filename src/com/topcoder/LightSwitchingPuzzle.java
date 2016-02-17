package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LightSwitchingPuzzle {
	public int minFlips(String state) {
		int res = 0;
		StringBuffer st = new StringBuffer(state);
		
		for (int i = 1; i <= st.length(); ++i) {
			if (st.charAt(i - 1) == 'Y') {
				++res;
				for (int j = i - 1; j < st.length(); j += i) {
					st.setCharAt(j, st.charAt(j) == 'Y' ? 'N' : 'Y');
				}
			}
		}
		return res;
	}
	
	@Test
	public void test(){
		assertTrue( minFlips("YYYYY") == 1);
	}
}
