package com.topcoder;

import static org.junit.Assert.*;

import org.junit.Test;
/*http://community.topcoder.com/stat?c=problem_statement&pm=13885*/

public class BalancedSubstrings {
	public int countSubstrings(String s) {
		int len = s.length();
		int ans = 0;
		
		for (int i = 0; i < len; ++i) {
			int count = 0, sum = 0;

			for (int j = i; j < len; ++j) {
				if ( s.charAt(j) == '1' ) {
					sum += j;
					++count;
				}
				
				if ( count == 0 || sum % count == 0 ) {
					++ans;
				}
			}
		}
		return ans;
	}

	@Test
	public void test() {
		assertTrue( countSubstrings("10010100010110010100111111111111111100001010100101001") == 422 );
		assertTrue( countSubstrings("1010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010") == 3126250 );
		assertTrue( countSubstrings("011") == 4 );
		assertTrue( countSubstrings("10111") == 10 );
		assertTrue( countSubstrings("00000") == 15 );
		assertTrue( countSubstrings("0000001000000") == 91 );
		assertTrue( countSubstrings("100110001001") == 49 );
	}	
}

