package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ForgetfulAddition {
	public int minNumber(String expression)
	{
		int len = expression.length() - 1;
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= len; ++i) {
			int a = Integer.parseInt(expression.substring(0, i));
			int b = Integer.parseInt(expression.substring(i));
			res = Math.min(res, a + b);
		}
		
		return res;
	}
	@Test
	public void test(){
		assertTrue( minNumber("22") == 4 );
	}
}
