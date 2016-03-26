package com.topcoder.archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeStrings {
	public String getmin(String S, String A, String B) {
		String[][][] dp = new String[51][51][51];
		
		for (int i = S.length(); i >= 0; --i) {
			for (int j = A.length(); j >= 0; --j) {
				for (int k = B.length(); k >= 0; --k) {
					if (i == S.length()) {
						dp[i][j][k] = "";
					}
					else {
						dp[i][j][k] = "[invalid]";
						
						if ( (i < S.length() && j < A.length()) && ( S.charAt(i) == A.charAt(j) || S.charAt(i) == '?' ) ) {
							String x = dp[i + 1][j + 1][k] == null ? "" :dp[i + 1][j + 1][k];
							
							if ( !x.equals("[invalid]") ) {
								dp[i][j][k] = minString(A.charAt(j) + x, dp[i][j][k]);
							}
						}
						if ( (i < S.length() && k < B.length()) && ( S.charAt(i) == B.charAt(k) || S.charAt(i) == '?' ) ) {
							String x = dp[i + 1][j][k + 1] == null ? "" : dp[i + 1][j][k + 1];
							
							if ( !x.equals("[invalid]") ) {
								dp[i][j][k] = minString(B.charAt(k) + x, dp[i][j][k]);
							}
						}						
					}
				}
			}			
		}
		return dp[0][0][0].equalsIgnoreCase("[invalid]") ? "" : dp[0][0][0];
	}
	
	String minString(String s1, String s2) {
		return s1.compareTo(s2) > 0 ? s2 : s1;
	}
	@Test
	public void test1() {
		assertTrue( getmin("??CC??", "ABC", "BCC").equals("ABCCBC") );
		assertTrue( getmin("WHAT?", "THE", "WA").equals("") );
		assertTrue( getmin("???????????", "AZZAA", "AZAZZA").equals("AAZAZZAAZZA") );
		assertTrue( getmin("????K??????????????D???K???K????????K?????K???????",
				"KKKKKDKKKDKKDDKDDDKDKK",
				"KDKDDKKKDDKDDKKKDKDKKDDDDDDD").equals("KDKDKDKKKDDKDDKKKDKDKKDKDDDKDDDKKDKKKDKKDDKDDDKDKK") );
	}	
}
