package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

public class FibonacciDiv2 {
	class state {
		public int steps;
		public long number;
		
		state(int s, long n) {
			steps = s;
			number = n;
		}
	}
	boolean isPerfectSquare(long x)
	{
		long s = (long) Math.sqrt(x);
	    return (s*s == x);
	}
	 
	// Returns true if n is a Fibinacci Number, else false
	boolean isFibonacci(long n)
	{
	    return isPerfectSquare(5*n*n + 4) ||
	           isPerfectSquare(5*n*n - 4);
	}
	public int find(int N) {
	
		LinkedList<state> bfs = new LinkedList<state>();
		int res = 0;
		bfs.add(new state(0, N));
		HashSet<Long> hs  = new HashSet<Long>();
		while (!bfs.isEmpty()) {
			state top = bfs.pollFirst();
			if (hs.contains(top.number))
				continue;
			
			hs.add(top.number);
			if (isFibonacci(top.number)) {
				res = top.steps;
				break;
			}
			
			bfs.offer(new state(top.steps + 1, top.number + 1));
			bfs.offer(new state(top.steps + 1, top.number - 1));
		}
		
		return res;
	}
	
	@Test(timeout=2000)
	//@Test
	public void test() {
		assertTrue( find(1) == 0 );
		assertTrue( find(13) == 0 );
		assertTrue( find(15) == 2 );
		assertTrue( find(19) == 2 );
		assertTrue( find(1000000) == 167960 );
	}
}
