package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

public class PalindromePrime {
	public int count(int L, int R)
	{
		int res = 0;
		for (int i = L; i <= R; ++i) {
			if (BigInteger.valueOf(i).isProbablePrime(100)) {
				String s1 = (new Integer(i)).toString();
				if (s1.equals(new StringBuilder(s1).reverse().toString())) {
					++res;
				}
			}
		}
		return res;
	}
	@Test
	public void test(){
		assertTrue( count(1,3) == 2 );
		assertTrue( count(11,15) == 1 );
	}
}
