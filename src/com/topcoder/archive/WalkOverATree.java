package com.topcoder.archive;

import static org.junit.Assert.*;

import org.junit.Test;
/*http://community.topcoder.com/stat?c=problem_statement&pm=13955&rd=16515*/

public class WalkOverATree {
	int maxNodesVisited(int[] parent, int L) {
		int maxDepth = 0;
		int len = parent.length + 1;
		
		for (int idx = 1; idx < len; ++idx) {
			int count = 1;
			int i = idx;
			while (parent[i - 1] != 0) {
				i = parent[i - 1];
				++count;
			}
			maxDepth = Math.max(maxDepth, count);
		}
		
		if ( maxDepth >= L )
			return L + 1;
		
		return Math.min(len, maxDepth + 1 + (L - maxDepth) / 2);
	}
	
	@Test
	public void test1() {
		int in[] = {0, 0};
		
		assertTrue(maxNodesVisited(in, 2) == 2);
		assertTrue(maxNodesVisited(in, 3) == 3);
	}
	@Test
	public void test2() {
		int in[] = {0, 1, 2, 3};
		
		assertTrue(maxNodesVisited(in, 2) == 3);
	}
	@Test
	public void test3() {
		int in[] = {0,0,0,0,2,4,2,3,1};
		
		assertTrue(maxNodesVisited(in, 1) == 2);
	}
	@Test
	public void test4() {
		int in[] = {0,0,0,1,1,3,5,1,4,5,2,2,10,5,10,10,11,13,8,3,18,15,20,20,23,8,11,26,4};
		
		assertTrue(maxNodesVisited(in, 26) == 17);
	}
	@Test
	public void test5() {
		int in[] = {0, 0, 2, 0};
		
		assertTrue(maxNodesVisited(in, 100) == 5);
	}
	@Test
	public void test6() {
		int in[] = {0, 0, 2};
		
		assertTrue(maxNodesVisited(in, 4) == 4);
	}	
}
