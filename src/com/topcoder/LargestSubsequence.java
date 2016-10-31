package com.topcoder;

public class LargestSubsequence {
	public String getLargest(String s)
	{
		if (s.length() == 0) {
			return "";
		}
		int idx = 0;
		
		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(idx) < s.charAt(i)) {
				idx = i;
			}
		}
		
		String sub = s.substring(idx + 1);
		
		return s.charAt(idx) + getLargest(sub);
	}
	
	
}
