package com.topcoder.archive;

public class AlternatingString {
	public int maxLength(String s)
	{
		int len = 1;
		
		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				++len;
			}
			else {
				len = 1;
			}
		}
		
		return len;
	}

}
