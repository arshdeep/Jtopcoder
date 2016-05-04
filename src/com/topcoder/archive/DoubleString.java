package com.topcoder.archive;

public class DoubleString {
	public String check(String S)
	{
		int len = S.length();
		
		if (len > 1) {
			int mid = len / 2;
			if (S.substring(0, mid).compareTo(S.substring(mid)) == 0 ) {
				return "square";
			}
		}
		return "not square";
	}
	
}
