package com.topcoder;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=13751&rd=16515*/

public class GoodString {
	public String isGood(String s)
	{
		while ( s.contains("ab") ) {
			 s = s.replaceAll("ab", "");
		}
		return s.isEmpty() ? "Good" : "Bad";
	}
	
	@Test
	public void test() {
	    assertTrue(isGood("aabb").equals("Good"));
	    assertTrue(isGood("aab").equals("Bad"));
	    assertTrue(isGood("aabb").equals("Good"));
	    assertTrue(isGood("ababab").equals("Good"));
	    assertTrue(isGood("abaababababbaabbaaaabaababaabbabaaabbbbbbbb").equals("Bad"));
	    assertTrue(isGood("aaaaaaaabbbaaabaaabbabababababaabbbbaabbabbbbbbabb").equals("Good"));
	    assertTrue(isGood("baabbbbabbabbababaaabbaaaabbabbbbaaabbaaaaaaababbb").equals("Bad"));
	    assertTrue(isGood("abaababababbaabbaaaabaababaabbabaaabbbbbbb").equals("Good"));
	}
}
