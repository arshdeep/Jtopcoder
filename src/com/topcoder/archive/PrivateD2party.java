package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class PrivateD2party {
	int dfs(int idx, int []a) {
		boolean seen[] = new boolean[a.length];
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(idx);
		while(!stk.isEmpty()) {
			int top = stk.pop();
			
			if (top != a[top]) {
				if (seen[top]) {
					return top;
				}
				seen[top] = true;
				stk.push(a[top]);
			}
			
		}
		return -1;
	}
	
	public int getsz(int[] a) {
		int min = 0;
		
		for (int i = 0; i < a.length; ++i) {
			int cycle = dfs(i, a);
			if (cycle != -1) {
				a[cycle] = cycle;
				++min;
			}
		}
		return a.length - min;
	}
	
	@Test
	public void test() {
		assertTrue( getsz(new int[]{0,1}) == 2 );
		assertTrue( getsz(new int[]{0, 4, 5, 1, 8, 1, 0, 0, 2, 8, 6, 0, 9}) == 12 );
		assertTrue( getsz(new int[]{3,2,1,0,5,4}) == 3 );
		assertTrue( getsz(new int[]{5,2,2,4,5,0}) == 5 );
		assertTrue( getsz(new int[]{1,0,3,2}) == 2 );
		assertTrue( getsz(new int[]{1,0}) == 1 );

	}
}
