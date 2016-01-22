package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class UndoHistory {
	public int minPresses(String[] lines) {
		int res = 0;
		HashSet<String> undo = new HashSet<String>();
		String result = "";
		for (int i = 0; i < lines.length; ++i) {
			String str = lines[i];
			
			if (str == result) {
				++res;
				continue;
			}
			int j = 0;
			for (; j <= str.length(); ++j) {
				if (!undo.contains(str.substring(0, j))) {
					break;
				}
			}
			j = Math.max(0, j - 1);
			res += result != "" ? 2 : 0;
			for (int k = j; k <= str.length(); ++k) {
				undo.add(str.substring(0, k));
			}
			if (j == 0)
				res += str.length();
			else {
				int delta = 100000;
				if (result.length() <= str.length() && str.substring(0, result.length()).equals(result)) {
					delta = str.length() - result.length();
				}
				res = Math.min(res + delta - 2, (res + str.length() - j));
			}

			res += 1; //enter
			result = str;
		}
		return res;
	}
	public int minPressesEx(String[] lines)
	  {
	    HashSet<String> prefixes = new HashSet<String>();
	    int ans = 0;
	    String prev = "";
	    for (String s : lines) {
	      int cur = s.length() + 3;
	      if (s.startsWith(prev)) {
	        cur = s.length() - prev.length() + 1;
	      }
	      for (int i = 1; i <= s.length(); ++i) {
	        if (prefixes.contains(s.substring(0, i))) {
	          cur = Math.min(cur, s.length() - i + 3);
	        }
	        prefixes.add(s.substring(0, i));
	      }
	      prev = s;
	      ans += cur;
	    }
	    return ans;
	  }
	@Test
	public void test() {
		assertTrue( minPresses( new String[]{"abcde", "abcde", "abcde"}) == 8 );
		assertTrue( minPresses( new String[]{"abbbabb", "abbaaaa", "abbaaa", "aabbbbb", "abbaaa"}) == 30 );
		assertTrue( minPresses( new String[]{"absolutely", "abs", "absolute"}) == 17 );
		assertTrue( minPresses( new String[]{"ba","a","a","b","ba"}) == 13 );
		assertTrue( minPressesEx( new String[]{"a","b"}) == 6 );
		assertTrue( minPresses( new String[]{"tomorrow", "topcoder"}) == 18 );
	}
}
