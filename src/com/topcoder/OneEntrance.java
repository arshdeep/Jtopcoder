package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OneEntrance {
	int count[];
	boolean graph[][];
	int n;
	int solve(int s) {
		int res = 0;
		if (count[s] == 0) {
			return 1;
		}
		
		for(int i = 0; i <= n; ++i) {
			if (i == s) continue;
			if (count[i] == 1) {
				for(int j = 0; j <= n; ++j) {
					if (graph[i][j]) {
						graph[i][j] = false;
						graph[i][j] = false;
						--count[i];
						--count[j];
						res += solve(s);
						graph[i][j] = true;
						graph[i][j] = true;
						++count[i];
						++count[j];
					}
				}
			}
		}
		return res;
	}
	public int count(int[] a, int[] b, int s) {
		n = a.length;
		if (n <= 1)
			return 1;
		count = new int[n + 1];
		graph = new boolean[n + 1][n + 1];
		
		for(int i = 0; i < n; ++i) {
			graph[a[i]][b[i]] = true;
			graph[b[i]][a[i]] = true;
			++count[a[i]];
			++count[b[i]];
		}
		
		return solve(s);
	}
	
	@Test
	public void test1()
	{
		assertTrue( count(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 0) == 1 );
		assertTrue( count(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2) == 3 );
		assertTrue( count(new int[]{0, 0, 0, 0}, new int[]{1, 2, 3, 4}, 0) == 24 );
		assertTrue( count(new int[]{7, 4, 1, 0, 1, 1, 6, 0}, new int[]{6, 6, 2, 5, 0, 3, 8, 4}, 4) == 896 );
	}
}
