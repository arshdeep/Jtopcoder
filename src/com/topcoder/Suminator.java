package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class Suminator {
	int[] program;
	long solve(long x) {
		Stack<Long> stk = new Stack<Long>();
		
		for (int i = 0; i < program.length*2; ++i) {
			stk.push(0L);
		}
		
		for (int i = 0; i < program.length; ++i) {
			if (program[i] == 0 || (program[i] == -1 && x == 0) ) {
				stk.push(stk.pop() + stk.pop());
			}
			else if (program[i] == -1) {
				stk.push(x);
			}
			else {
				stk.push((long) program[i]);
			}
		}

		return stk.peek();
	}

	public int findMissing(int[] program, int wantedResult) {
		this.program = program;
		
		if (solve(0) == wantedResult ) {
			return 0;
		}
		
		if (solve((long)1e9) == wantedResult ) {
			return (int)1e9;
		}
		
		long lo = 0;
		long hi = (long)1e9;
		
		while (lo < hi) {
			long mid = lo + (hi - lo + 1) / 2;
			
			if (solve(mid) > wantedResult) {
				hi = mid - 1;
			}
			else {
				lo = mid;
			}
		}

		return (int)(lo > wantedResult || (lo == 0 || lo == (long)1e9) ? -1 : lo);
	}
	
	@Test
	public void test() {
		assertTrue(findMissing(new int[]{-1}, 1) == 1 );
		assertTrue(findMissing(new int[]{7, -1, 3, 0}, 3) == -1 );
		assertTrue(findMissing(new int[]{1000000000, 1000000000, 1000000000,  1000000000, -1, 0, 0, 0, 0}, 1000000000) == -1 );
		assertTrue(findMissing(new int[]{-1, 7, 3, 0, 1, 2, 0, 0}, 13) == 0 );
		assertTrue(findMissing(new int[]{100, 200, 300, 0, 100, -1}, 600) == 0 );
		assertTrue(findMissing(new int[]{7,-1,0}, 10) == 3 );
	}
}
