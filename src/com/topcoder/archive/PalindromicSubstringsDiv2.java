package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromicSubstringsDiv2 {
	char[] in;
	boolean dp[][];
//	boolean isPlaindrome(int i, int j) {
//		Boolean res = dp[i][j];
//		
//		if (res != null)
//			return res;
//		
//		if (i == j) {
//			dp[i][j] = true;
//		}
//		else if (in[i] == in[j - 1]) {
//			if (i < j - 1)
//				dp[i][j] = isPlaindrome(i + 1, j - 1);
//			else dp[i][j] = true;
//				
//		}
//		else {
//			dp[i][j] = false;
//		}
//		return dp[i][j];			
//	}
//	public int countEx(String[] S1, String[] S2) {
//		String str = "";
//		for (String s : S1) {
//			str += s;
//		}
//		for (String s : S2) {
//			str += s;
//		}
//		in = str.toCharArray();
//		
//		int count = str.length();
//
//		dp = new Boolean[count + 1][count + 1];
//
//		count = 0;
//		
//		for (int len  = 1; len <= str.length(); ++len) {
//			for (int i = 0, j = len; j <= str.length(); ++i, ++j) {
//				if (isPlaindrome(i, j)) {
//					++count;
//				}
//			}
//		}
//		
//		return count;
//	}
	public int count(String[] S1, String[] S2) {
		String str = "";
		for (String s : S1) {
			str += s;
		}
		for (String s : S2) {
			str += s;
		}
		in = str.toCharArray();
		
		int count = str.length();
		dp = new boolean[count][count];

		count = 0;
		for (int len  = 0; len < str.length(); ++len) {
			dp[len][len] = true;
			++count;
		}		
		for (int len  = 2; len <= str.length(); ++len) {
			for (int i = 0, j = len - 1; j < str.length(); ++i, ++j) {
				if (len == 2) {
					dp[i][j] = in[i] == in[j];
				}
				else if (in[i] == in[j] && dp[i + 1][j - 1]) {
					dp[i][j] = true;
				}
				if (dp[i][j]) {
					++count;
				}
			}
			
		}
		return count;
	}
	@Test
	public void test() {
		assertTrue( count(new String[]{"a","a",""}, new String[]{"a"}) == 6);
		assertTrue( count(new String[]{"zaz"}, new String[]{}) == 4);
	}
}
