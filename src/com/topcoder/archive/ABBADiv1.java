package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ABBADiv1 {
	String canObtain(String initial, String target) {
		if (initial.equals(target))
			return "Possible";
		
		if (target.length() > initial.length()) {
			if (target.charAt(target.length() - 1) == 'A'
					&& canObtain(initial, target.substring(0, target.length() - 1) ).equals("Possible") ) {
				return "Possible";
			}
			
			if (target.charAt(0) == 'B'
					&& canObtain(initial, new StringBuffer(target.substring(1)).reverse().toString() ).equals("Possible") ) {
				return "Possible";
			}
		}
		
		return "Impossible";
	}
	
	@Test
	public void test() {
		assertTrue( canObtain("A", "BABA").equals("Possible") );
		assertTrue( canObtain("BAAAAABAA", "BAABAAAAAB").equals("Possible") );
		assertTrue( canObtain("A", "ABBA").equals("Impossible") );
		assertTrue( canObtain("AAABBAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB").equals("Possible") );
		assertTrue( canObtain("AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB").equals("Impossible") );
	}
}
