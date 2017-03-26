package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AlphabetOrderDiv2 {
	public String isOrdered(String[] words)
	{
		boolean[][] graph = new boolean[26][26];
		
		for (String str : words) {
			for (int ii = 0; ii < str.length(); ++ii) {
				for (int i = ii + 1; i < str.length(); ++i) {
					graph[str.charAt(ii) - 'a'][str.charAt(i) - 'a'] = true;
				}
			}
		}
		for (int k = 0; k < 26; ++k) {
			for (int i = 0; i < 26; ++i) {
				for (int j = 0; j < 26; ++j) if (i != j) {
					if (graph[i][k] && graph[k][j]) {
						graph[i][j] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < 26; ++i) {
			for (int j = 0; j < 26; ++j) if (i != j) {
				if (graph[i][j] && graph[j][i]) {
					return  "Impossible";
				}
			}
		}
		return "Possible";
	}
	
	@Test
	public void test() {
		assertTrue(isOrdered(new String[]{"ab","bc","ca"}).equals("Impossible"));
		assertTrue(isOrdered(new String[]{"single","round","match"}).equals("Possible"));

	}
}
