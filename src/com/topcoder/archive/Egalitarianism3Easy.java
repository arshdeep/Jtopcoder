package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Egalitarianism3Easy {
	int[][] graph;
	public int maxCities(int n, int[] a, int[] b, int[] len) {
		int res = 0;
		graph = new int[n + 1][n + 1];
		
		for (int  i = 0; i <= n; ++i) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < a.length; ++i) {
			graph[a[i]][b[i]] = len[i];
			graph[b[i]][a[i]] = len[i];
		}
		
		//floyd warshall
		for (int k = 1, size = n + 1; k < size; ++k) {
			for (int i = 1; i < size; ++i) {
				for (int j = 1; j < size; ++j) {
					if (i != j && graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE)
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		for (int mask = 1; mask < (1 << (n + 1)); ++mask) {
			boolean valid = true;
			int subsetCount = 0;
			int x = -1;
			
			for (int  i = 1; i <= n; ++i) {
				if ( (mask & (1 << i)) != 0 ) {
					++subsetCount;
					
					for (int j = 1; j <= n && valid; ++j) if ( i != j ) {
						if ( (mask & (1 << j)) != 0 ) {
							if (x == -1) {
								x = graph[i][j];
							}
							else {
								if (graph[i][j] != x) {
									valid = false;
								}
							}
						}
					}
				}
			}
			
			if (valid) {
				res = Math.max(subsetCount, res);
			}
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( maxCities(4, new int[]{1,1,1}, new int[]{2,3,4},new int[]{1,1,1} ) == 3 );
		assertTrue( maxCities(6, new int[]{1,2,3,2,3}, new int[]{2,3,4,5,6},new int[]{2,1,3,2,3} ) == 3 );
		assertTrue( maxCities(1, new int[]{}, new int[]{},new int[]{} ) == 1 );
		assertTrue( maxCities(6, new int[]{6,6,6,5,5}, new int[]{2,5,1,3,4},new int[]{886,886,885,886,886} ) == 3 );
	}
}
