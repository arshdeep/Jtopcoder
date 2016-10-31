package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SquareFreeString
{
	public String isSquareFree(String s)
	{
		for (int len = 2; len <= s.length(); ++len) {
			for (int i = 0, j = len; j <= s.length(); ++i, ++j) {
				String str = s.substring(i, j);
				int l = str.length();
				
				if (str.substring(0, l / 2).equals(str.substring(l/2))) {
					return "not square-free";
				}
				
			}
			
		}
		return "square-free";
	}
	
	@Test
	public void test() {
		assertTrue(isSquareFree("bobo").equals("not square-free"));
		assertTrue(isSquareFree("aydyamrbnauhftmphyrooyq").equals("not square-free"));
	}	
}
