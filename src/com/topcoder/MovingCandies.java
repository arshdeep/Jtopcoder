package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.PriorityQueue;

import org.junit.Test;

public class MovingCandies {
	class State implements Comparable<State>{
		int x;
		int y;
		int len;
		int mark;
		public State(int a,int b,int c,int d) {
			x = a;
			y = b;
			len = c;
			mark = d;
		}
		@Override
		public int compareTo(State arg0) {
			// TODO Auto-generated method stub
			if (this.mark == arg0.mark) {
				return this.len - arg0.len;
			}
			return this.mark - arg0.mark;
		}
	}
	public int minMoved(String[] t) {
		PriorityQueue<State> bfs = new PriorityQueue<State>();
		bfs.add(new State(0,0,1,t[0].charAt(0) == '#' ? 0 : 1));
		boolean visit[][][] = new boolean[21][21][21];
		int[] x = {1, 0 , -1, 0};
		int[] y = {0 ,1 , 0, -1};
		int allowed = 0;
		
		for (int i = 0; i < t.length; ++i) {
			for (int j = 0; j < t[0].length(); ++j) {
				if (t[i].charAt(j) == '#') {
					++allowed;
				}
			}
		}
		while (!bfs.isEmpty()) {
			State top = bfs.poll();
			if (top.len > allowed || top.mark > allowed) {
				continue;
			}
			
			if (top.x == t.length - 1 && top.y == t[0].length() - 1) {
				return top.mark;
			}
			
			if (visit[top.x][top.y][top.len]) {
				continue;
			}
			visit[top.x][top.y][top.len] = true;
			
			for (int d = 0; d < 4; ++d) {
				int dx = top.x + x[d];
				int dy = top.y + y[d];
				
				if (dx >= 0 && dx < t.length && dy >= 0 && dy < t[0].length()) {
					int m = t[dx].charAt(dy) == '#' ? 0 : 1;
					bfs.add(new State(dx,dy, top.len + 1, top.mark + m));
				}
			}
		}
		return -1;
	}
	@Test
	public void test() {
		assertTrue(minMoved(new String[]{"#...###",
				"#...#.#",
				"##..#.#",
				".#....#"}) == 3);
	}
}
