package com.topcoder.archive;

public class StringTransform {
	public String isPossible(String s, String t)
	{
		if (!s.equalsIgnoreCase(t)) {
			boolean[] visit = new boolean[26];
			
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) != t.charAt(i)) {
					if (!visit[t.charAt(i) - 'a']) {
						return "Impossible";
					}
				}
				visit[s.charAt(i) - 'a'] = true;
			}
		}
		return "Possible";
	}
}
