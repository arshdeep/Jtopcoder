package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BadVocabulary {
	public int count(String badPrefix, String badSuffix, String badSubstring, String[] vocabulary) {
		int res = 0;
		
		for (String str : vocabulary) {
			if (str.startsWith(badPrefix)) {
				++res;
			}
			else if (str.endsWith(badSuffix)) {
				++res;
			}
			else if (str.length() > 2) {
				if (str.substring(1, str.length() - 1).contains(badSubstring)) {
					++res;
				}
			}
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( count("bug","bug","bug", new String[]{"buggy", "debugger", "debug"}) == 3);
	}
}
