package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StrIIRec {
//	String solve(String ss, int minInv, String minStr) {
//		if (ss.equals("")) {
//			return "";
//		}
//		else {
//			for (int i = 0; i < ss.length(); ++i) {
//				if (minStr.length() > 0 && minStr.charAt(0) > ss.charAt(i)) {
//					continue;
//				}
//				int newInv = Math.max(minInv - i, 0);
//				int nn = ss.length() - 1;
//				if (nn * (nn - 1) / 2 >= newInv) {
//					String str = ss.substring(0, i) + ss.substring(i + 1);
//					String minStrNew = "";
//					if (minStr.length() > 0 && minStr.charAt(0) == ss.charAt(i)) {
//						minStrNew = minStr.substring(1);
//					}
//					String ret = ss.charAt(i) + solve(str, newInv, minStrNew);
//					return ret;
//				}
//			}
//		}
//		return "";
//	}
	int countInversions(String str) {
		int inv = 0;
		for (int i = 0; i < str.length(); ++i) {
			for (int j = 0; j < str.length(); ++j) {
				if (i < j && str.charAt(j) < str.charAt(i)) {
					++inv;
				}
			}
		}
		
		return inv;
	}
	String getnext(String str) {
		char[] s = str.toCharArray();
		
		for (int i = str.length() - 2; i >= 0; --i) {
			for (int j = str.length() - 1; j >= 0; --j) {
				if (j > i && s[i] < s[j]) {
					char ch = s[i];
					s[i] = s[j];
					s[j] = ch;
					return String.valueOf(s);
				}
			}
		}
		
		return str;
	}
	String recovstr(int n, int minInv, String minStr) {
		
		for (int i = 0; i < n; ++i) {
			if (!minStr.contains(String.valueOf((char)('a' + i)))) {
				minStr += String.valueOf((char)('a' + i));
			}
		}
		while(countInversions(minStr) < minInv) {
			minStr = getnext(minStr);
		}
		
		return minStr;
	}
	
	@Test
	public void test() {
		assertTrue( recovstr(2,1, "ab").equals("ba") );
		assertTrue( recovstr(11,55, "debgikjfc").equals("kjihgfedcba") );
		assertTrue( recovstr(9,1, "efcdgab").equals("efcdgabhi") );
	}
}
