package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Sunnygraphs2 {
	boolean[] visited;
	int[] in;
	boolean isCycle;

	long getCycle(int start, int idx, long count) {
		if (visited[idx]) {
			isCycle = idx == start;
			return count;
		}
		visited[idx] = true;
		return getCycle(start, in[idx], count + 1);
	}

	public long count(int[] a) {
		this.visited = new boolean[a.length];
		this.in = a;

		this.in = a;

		long res = 1;
		long cc = 0;
		boolean[] visit = new boolean[a.length];
		
		for (int i = 0; i < a.length; ++i) {
			if (!visit[i]) {
				long t = getCycle(i, i, 0);
				
				if (isCycle) {
					++cc;
					res *= ((1L << t) - 1);
					for (int j = 0; j < visit.length; ++j) {
						visit[j] |= visited[j];
					}
				}
				this.visited = new boolean[a.length];
				isCycle = false;
			}
		}
		long noncycles = 0;
		for (boolean b : visit) {
			if (!b) {
				++noncycles;
			}
		}
		res *= (1L << noncycles );
		if (cc == 1) {
			++res;
		}
		
		return res;
	}
	@Test
	public void test() {
		assertTrue(count(new int[]{29,34,40,17,16,12,0,40,20,35,5,13,27,7,29,13,14,39,42,9,30,38,27,40,34,33,42,20,29,42,12,29,30,21,4,5,7,25,24,17,39,32,9}) == 6184752906240L );
		assertTrue(count(new int[]{9,2,0,43,12,14,39,25,24,3,16,17,22,0,6,21,18,29,34,35,23,43,28,28,20,11,5,12,31,24,8,13,17,10,15,9,15,26,4,13,21,27,36,39}) == 17317308137473L );
		assertTrue(count(new int[]{1,0}) == 4 );
		assertTrue(count(new int[]{1,0}) == 4 );
		assertTrue(count(new int[]{1,0,0}) == 7 );
		assertTrue(count(new int[]{2,3,0,1,0,4,5,2,3}) == 288 );
		assertTrue(count(new int[]{2,3,0,1,0}) == 18 );
		assertTrue(count(new int[]{2,3,0,1}) == 9 );
	}
}
