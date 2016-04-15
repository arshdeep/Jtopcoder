package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.PriorityQueue;

import org.junit.Test;

public class DoubleWeights {
	class state implements Comparable<state>{
		int row;
		int weight1;
		int weight2;
		public state(int a, int b, int c) {
			this.row = a;
			this.weight1 = b;
			this.weight2 = c;
		}

		@Override
		public int compareTo(state arg0) {
			// TODO Auto-generated method stub
			return (this.weight1 * this.weight2) - (arg0.weight1 * arg0.weight2);
		}
	}
	public int minimalCost(String[] weight1, String[] weight2)
	{
		PriorityQueue<state> pq = new PriorityQueue<state>();
		int w = weight1[0].length();
		pq.add(new state(0, 0, 0));
		boolean[] visited = new boolean[weight1.length];
		while (!pq.isEmpty()) {
			state top = pq.poll();
			
			if (visited[top.row]) {
				continue;
			}
			if (top.row == 1) {
				return top.weight1 * top.weight2;
			}
			visited[top.row] = true;
			for (int j = 0; j < w; ++j) {
				if (weight1[top.row].charAt(j) != '.') {
					pq.add(new state(j, top.weight1 + Integer.valueOf(weight1[top.row].charAt(j) - '0'), top.weight2 + Integer.valueOf(weight2[top.row].charAt(j) - '0') ) );
				}
			}
		}
		return -1;
	}
	
	@Test
	public void test(){
		assertTrue( minimalCost(new String[]{"...................2", "..5.................", ".5.7................", "..7.9...............", "...9.6..............", "....6.7.............", ".....7.2............", "......2.6...........", ".......6.7..........", "........7.9.........", ".........9.2........", "..........2.8.......", "...........8.8......", "............8.4.....", ".............4.7....", "..............7.6...", "...............6.8..", "................8.1.", ".................1.2", "2.................2."}
		, new String[] {"...................2", "..5.................", ".5.7................", "..7.9...............", "...9.6..............", "....6.7.............", ".....7.2............", "......2.6...........", ".......6.7..........", "........7.9.........", ".........9.2........", "..........2.8.......", "...........8.8......", "............8.4.....", ".............4.7....", "..............7.6...", "...............6.8..", "................8.1.", ".................1.2", "2.................2."}) == 11236 );
		assertTrue( minimalCost(new String[]{"..14",
				 "..14",
				 "11..",
				 "44.."}, new String[]{"..94",
						 "..94",
						 "99..",
						 "44.."}) == 36 );
		assertTrue( minimalCost(new String[]{"..14",
				 "..94",
				 "19..",
				 "44.."}, new String[]{"..94",
						 "..14",
						 "91..",
						 "44.."}) == 64 );
	}
}
