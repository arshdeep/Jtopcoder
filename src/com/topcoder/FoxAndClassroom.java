package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FoxAndClassroom {
	boolean visited[][];
	int n;
	int m;
	
	boolean go(int ii, int jj) {
		if (visited[ii][jj]) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (!visited[i][j]) {
						return false;
					}
				}
			}

			return true;
		}
		visited[ii][jj] = true;
		
		return go( (ii + 1) % n, (jj + 1) % m);
		
	}
	public String ableTo(int n, int m) {
		this.n = n;
		this.m = m;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				visited = new boolean[n][m];
				if (go(i, j))
					return "Possible";
			}
			
		}
		
		return "Impossible";
	}
	@Test
	public void test() {
		assertTrue( ableTo(2,2).equals("Impossible") );
		assertTrue( ableTo(2,3).equals("Possible") );
	}
}
