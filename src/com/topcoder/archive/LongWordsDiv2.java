package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LongWordsDiv2 {
	int subsequence(char[] a, char[] b, int i, int j) {
		if (i < 0 || j < 0)
			return 0;
		
		if (a[i] == b[j]) {
			return 1 + subsequence(a, b, i - 1, j - 1);
		}
		return Math.max(subsequence(a, b, i - 1, j), subsequence(a, b, i, j - 1));
	}
	
	boolean isSubsequence(char [] a, char[] b) {
		return subsequence(a, b, a.length - 1, b.length - 1) == b.length;
	}
	public String find(String word) {
		for (char x = 'a'; x <= 'z'; ++x) {
			if (word.contains(String.valueOf(x)))
				return "Dislikes";
		}
		for (int i = 1; i < word.length(); ++i) {
			if (word.charAt(i - 1) == word.charAt(i)) {
				return "Dislikes";
			}
		}
		for (char x = 'A'; x <= 'Z'; ++x) {
			for (char y = 'A'; y <= 'Z'; ++y) {
				String b = String.valueOf(x) + String.valueOf(y);
				b += b;
				
				if (isSubsequence(word.toCharArray(), b.toCharArray()))
					return "Dislikes";
			}
		}
		
		return "Likes";
	}
	
	@Test
	public void test() {
		assertTrue( find("ABCBA").equals("Likes") );
		assertTrue( find("VAMOSGIMNASIA").equals("Dislikes") );
	}
}
