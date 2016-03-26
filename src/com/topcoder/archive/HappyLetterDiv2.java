package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HappyLetterDiv2 {
	public char getHappyLetter(String letters) {
		int []dp = new int[26];
		
		for (int i = 0; i < letters.length(); ++i) {
			dp[letters.charAt(i) - 'a'] += 1;
		}
		int ans = -1;
		int n = letters.length();
		for (int i = 0; i < 26; ++i) {
			if ( n - dp[i] < dp[i]) {
				ans = i;
			}
		}
		
		if (ans == -1) return '.';
		return (char) ('a' + ans);
	}
	
	@Test
	public void test(){
		assertTrue( getHappyLetter("aacaaa") == 'a');
		assertTrue( getHappyLetter("dcdjx") == '.');
		assertTrue( getHappyLetter("aabc") == '.');
		assertTrue( getHappyLetter("ivddiddvivdbiiidiiddiiii") == '.');
		assertTrue( getHappyLetter("oyyyoowoooofwjoooooffyyooo") == 'o');
		
		
	}	

}
