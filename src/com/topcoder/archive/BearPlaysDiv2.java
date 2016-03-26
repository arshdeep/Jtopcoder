package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

/* http://community.topcoder.com/stat?c=problem_statement&pm=13939 */
public class BearPlaysDiv2 {
	boolean[][] can;
		
	public String equalPiles(int A, int B, int C) {
		can = new boolean[1505][1505];
		int[] t = {A, B, C};
		int sum = A + B + C;

		if (sum % 3 == 0) {			
			LinkedList<int[]> bfs = new LinkedList<int[]>();
			
			bfs.push(t);
			
			while( !bfs.isEmpty() ) {
				int[] top = bfs.pollFirst();
			
				if (can[top[0]][top[1]]) continue;
				
				can[top[0]][top[1]] = true;

				if (can[sum/3][sum/3]) return "possible";
				
				for (int i = 0; i < 3; ++i) {
					for (int j = 0; j < 3; ++j) {
						if ( top[i] < top[j] ) {
							int[] t2 = { top[i] * 2, top[j] - top[i], top[3 - i - j]};

							bfs.offer(t2);
						}
					}
				}
			}
		}
		return "impossible";
	}
	
	@Test
	public void test1() {
		assertTrue( equalPiles(10, 15, 35).equalsIgnoreCase("possible") );
		assertTrue( equalPiles(1, 1, 2).equalsIgnoreCase("impossible") );
		assertTrue( equalPiles(4, 6, 8).equalsIgnoreCase("impossible") );
		assertTrue( equalPiles(18, 18, 18).equalsIgnoreCase("possible") );
		assertTrue( equalPiles(225, 500, 475).equalsIgnoreCase("possible") );
		assertTrue( equalPiles(280, 461, 411).equalsIgnoreCase("impossible") );
		assertTrue( equalPiles(	209, 406, 477).equalsIgnoreCase("impossible") );
		assertTrue( equalPiles(429, 231, 132).equalsIgnoreCase("possible") );
		assertTrue( equalPiles(245, 334, 400).equalsIgnoreCase("impossible") );
	}
}
