package com.topcoder;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Stack;

import org.junit.Test;

public class PrivateD2party {
	public int getCycle(int[] a, int idx) {
		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stk = new Stack<Integer>();
		
		stk.push(idx);
		
		while (!stk.isEmpty()) {
			int top = stk.pop();
			
			visited.add(top);
			
			if (a[top] != top) {
				if (visited.contains(a[top])) {
					return top;
				}
				stk.push(a[top]);
			}
		}
		return -1;
	}
	
	public 	int getsz(int[] a) {
		int cycles = 0;

		for (int i = 0, size = a.length; i < size; ++i) {
			int cycle = getCycle(a, i);
			if (cycle != -1) {
				++cycles;
				a[cycle] = cycle;
			}
		}
		return a.length - cycles;
	}
	
	@Test
	public void test() {
		assertTrue( getsz(new int[] {0, 1}) == 2 );
		assertTrue( getsz(new int[] {1, 0}) == 1 );
		assertTrue( getsz(new int[] {1, 0, 3, 2}) == 2 );
		assertTrue( getsz(new int[] {5, 2, 2, 4, 5, 0}) == 5 );
		assertTrue( getsz(new int[] {3, 2, 1, 0, 5, 4}) == 3 );
		assertTrue( getsz(new int[] {13, 1, 2, 6, 17, 17, 2, 18, 14, 14, 15, 7, 14, 15, 6, 8, 5, 5, 4, 2}) == 19 );
	}
}
