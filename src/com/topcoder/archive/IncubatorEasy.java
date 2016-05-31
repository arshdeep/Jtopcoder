package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IncubatorEasy {
	String[] love;
	boolean[] visited;
	
	void dfs(int idx) {
		if (visited[idx]) {
			return;
		}
		visited[idx] = true;
		
		for (int i = 0; i < love.length; ++i) {
			if (love[idx].charAt(i) == 'Y') {
				dfs(i);
			}
		}
	}
	
	public int maxMagicalGirls(String[] love) {
		int n = love.length;
		this.love = love;
		int res = 0;

		for (int mask = 1; mask < (1<<n); ++mask) {
			visited = new boolean[n];
			boolean[] magical = new boolean[n];
			for (int i = 0; i < n; ++i) {
				if ((mask & (1<<i)) != 0) {
					magical[i] = true;
				}
			}	
			int temp = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if ((magical[i] || visited[i]) && love[i].charAt(j) == 'Y') {
						dfs(j);
					}
				}
			}
	
			for (int i = 0; i < n; ++i) {
				if (magical[i] && !visited[i]) {
					++temp;
				}
			}			
			res = Math.max(res, temp);
		}

		return res;
	}
	
	@Test
	public void test() {
		assertTrue( maxMagicalGirls(new String[]{"YNNNN", "NNNYN", "NNNNN", "YNNNN", "NYNNN"}) == 2 );
		assertTrue( maxMagicalGirls(new String[]{"Y"}) == 0 );
		assertTrue( maxMagicalGirls(new String[]{"NNNNN","NNNNN","NNNNN","NNNNN","NNNNN"}) == 5 );
		assertTrue( maxMagicalGirls(new String[]{"NNNNN","NYNNN","NYNYN","YNYNN","NNNNN"}) == 2 );
		assertTrue( maxMagicalGirls(new String[]{"NNYNN","NNYNN","NNNYY","NNNNN","NNNNN"}) == 2 );
		assertTrue( maxMagicalGirls(new String[]{"NYN", "NNY", "NNN"}) == 1 );
		assertTrue( maxMagicalGirls(new String[]{"NY","NN"}) == 1 );
	}	
}
