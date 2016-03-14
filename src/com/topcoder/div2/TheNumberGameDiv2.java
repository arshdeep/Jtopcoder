package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

public class TheNumberGameDiv2 {
	class state {
		public int a;
		public int steps;
		public state(int a, int b) {
			this.a = a;
			this.steps = b;
		}
	}
	public int minimumMoves(int A, int B) {
		LinkedList<state> bfs = new LinkedList<state>();
		
		bfs.add(new state(A, 0));
		HashSet<Integer> visited = new HashSet<Integer>();
		
		while (!bfs.isEmpty()) {
			state top = bfs.pollFirst();
			
			if (visited.contains(top.a)) {
				continue;
			}
			if (top.a == B) {
				return top.steps;
			}
			visited.add(top.a);
			
			bfs.add(new state(top.a/10, top.steps + 1));
			int rev = Integer.parseInt( new StringBuffer(String.valueOf(top.a)).reverse().toString() );
			bfs.add(new state(rev, top.steps + 1));
		}
		
		
		return -1;
	}
	
	@Test
	public void test() {
		assertTrue( minimumMoves(5244, 25) == 3 );
		assertTrue( minimumMoves(125, 12) == 1 );
		assertTrue( minimumMoves(125, 52) == 2 );
		assertTrue( minimumMoves(125, 25) == 3 );
		assertTrue( minimumMoves(218181918, 9181) == 6 );
		assertTrue( minimumMoves(25, 5) == 2 );
	}
}
