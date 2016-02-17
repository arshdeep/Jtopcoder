package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaroFillingAStringDiv2 {
	int ugliness(char[] in) {
		int res = 0;
		for (int i = 1; i < in.length; ++i) {
			if (in[i - 1] == in[i]) {
				++res;
			}
		}
		return res;
	}
	public int getNumber(String S) {
		int res = Integer.MAX_VALUE;
		
		for (char i = 'A'; i <= 'B'; ++i) {
			char[] str = S.toCharArray();
			
			if (str[0] == '?') str[0] = i;
			for (int j = 1; j < str.length; ++j) {
				if (str[j] == '?') {
					str[j] = str[j - 1] == 'A' ? 'B' : 'A';
				}
			}
			
			res = Math.min(res, ugliness(str));
		}

		return res;
	}
	@Test
	public void test(){
		assertTrue( getNumber("A??B???AAB?A???A") == 3 );
		assertTrue( getNumber("??AB?B?BABBBA?BAB?AA??B??A?B?BA?A?A?B") == 7 );
		assertTrue( getNumber("A?A") == 0 );
	}
}
