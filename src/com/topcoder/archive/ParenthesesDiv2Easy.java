package com.topcoder.archive;

public class ParenthesesDiv2Easy {
	public int getDepth(String s)
	{
		int open = 0;
		int res = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				++open;
			}
			else if (s.charAt(i) == ')') {
				--open;
			}
			res = Math.max(res, open);
		}
		
		return res;
	}
}
