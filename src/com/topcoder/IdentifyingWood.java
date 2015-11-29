package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdentifyingWood {
	int subseq(String s, String t, int i, int j) {
		if (i < 0 || j < 0)
			return 0;
		
		if (s.charAt(i) == t.charAt(j))
			return 1 + subseq(s, t, i - 1, j - 1);
		
		return Math.max(subseq(s, t, i, j - 1), subseq(s, t, i - 1, j));
	}
	public String check(String s, String t)
	{
		int len = subseq(s, t, s.length() - 1, t.length() - 1);
		return len == t.length() ? "Yep, it's wood." : "Nope.";
	}
	
	@Test
	public void test1()
	{
		assertTrue( check("string", "longstring").equals("Nope.") );
	}
}
