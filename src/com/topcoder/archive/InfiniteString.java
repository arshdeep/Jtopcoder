package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InfiniteString {
	public String equal(String s, String t) {
		/*if (s.length() > t.length()) {
			String temp = new String(s);
			s = new String(t);
			t = new String(temp);
		}
		
		int i = 0;
		for (; i + s.length() <= t.length();) {
			String sub = t.substring(i, i + s.length());
			
			if (!sub.equals(s)) {
				return "Not equal";
			}
			i += s.length();
		}
		
		if (i < t.length()) {
			String sub = t.substring(t.length() - s.length());
			if (!sub.equals(s)) {
				return "Not equal";
			}
		}*/
		
		String o1 = new String(s);
		String o2 = new String(t);
		
		while (s.length() != t.length()) {
			if (s.length() < t.length())
				s += o1;
			else 
				t += o2;
		}
		return s.equals(t) ? "Equal" : "Not equal";
	}
	
	@Test
	public void test()
	{
		assertTrue( equal("ab", "abab").equals("Equal") );
		assertTrue( equal("abc", "bca").equals("Not equal") );
		assertTrue( equal("ababab", "abab").equals("Equal") );
	}
}
