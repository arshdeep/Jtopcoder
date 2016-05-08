package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class NonDeterministicSubstring {
	public boolean isCorrect(String A, String B) {
		for (int i = 0; i < A.length(); ++i) {
			if (A.charAt(i) != '?' && B.charAt(i) != '?' && A.charAt(i) != B.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	public long ways(String A, String B) {
		if (A.length() < B.length()) {
			return 0;
		}
		HashSet<String> hs = new HashSet<String>();
		
		for (int i = 0, j = B.length(); j <= A.length(); ++i, ++j) {
			//System.out.println(A.substring(i, j));
			String sub = A.substring(i, j);
			
			if (!hs.contains(sub) && isCorrect(sub, B)) {
				hs.add(sub);
			}
		}
		
		return hs.size();
	}
	@Test
	public void test() {
		assertTrue( ways("00000000", "??0??0") == 1);
		assertTrue( ways("00010001", "??") == 3);
	}
}
