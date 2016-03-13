package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CuttingBitString {
	boolean isPower5(String str) {
		if (str.length() == 0 || str.charAt(0) == '0')
			return false;
		long no = Long.parseLong(str, 2);
		long n = (long)(Math.log(no) / Math.log(5));
		return Math.pow(5, n) == no;
	}
	int solve(String str, int s) {
		int res = Integer.MAX_VALUE;
		
		if (s >= str.length())
			return 0;
		
		for (int i = s; i < str.length(); ++i) {
			String sub = str.substring(s, i + 1);
			
			if (isPower5(sub)) {
				int t = solve(str, i + 1);
				
				if (t != Integer.MAX_VALUE) {
					res = Math.min(t + 1, res);
				}
			}
		}
		return res;
	}
	public int getmin(String S) {
		int res = solve(S, 0);
		
		return res != Integer.MAX_VALUE ? res : -1;
	}
	
	@Test
	public void test(){
		assertTrue(getmin("1011111011011111011011111011011111011011111011111") == 29 );
		assertTrue(getmin("11111011111101111111011111101111111111111101111111") == 20 );
		assertTrue(getmin("1101100011010111001001101011011100010111011110101") == 1 );
		assertTrue(getmin("1000101011") == -1 );
		assertTrue(getmin("111011100110101100101110111") == 5);
		assertTrue(getmin("101101101") == 3);
		assertTrue(getmin("1111101") == 1);
	}	
}
