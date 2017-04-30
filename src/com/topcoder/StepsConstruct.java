package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

public class StepsConstruct {
	int x[] = {1, 0, -1, 0};
	int y[] = {0, 1, 0, -1};
	String xy[] = {"D", "R", "U", "L"};
	class state {
		int x;
		int y;
		int steps;
		String result;
		public state(int a, int b, int c, String res) {
			this.x = a;
			this.y = b;
			this.steps = c;
			this.result = res;
		}
	}
	public String construct(String[] board, int k) {
		int n  = board.length;
		int m = board[0].length();
		LinkedList<state> bfs = new LinkedList<state>();
		boolean[][][] visit = new boolean[n][m][k+1];
		if (board[0].charAt(0) == '#' || board[n - 1].charAt(m - 1) == '#') {
			return "";
		}

		bfs.add(new state(0, 0, 0, ""));

		while (!bfs.isEmpty()) {
			state top = bfs.pollLast();
			visit[top.x][top.y][top.steps] = true;
			
			if (top.steps == k && top.x == n - 1 && top.y == m - 1) {
				return top.result;
			}
			if (top.steps >= k) {
				continue;
			}
			for (int i = 0; i < 4; ++i) {
				int nx = top.x + x[i];
				int ny = top.y + y[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (board[nx].charAt(ny) != '#' && !visit[nx][ny][top.steps + 1]) {
						visit[nx][ny][top.steps + 1] = true;
						bfs.add(new state(nx, ny, top.steps + 1, top.result + xy[i]));
					}
				}
			}
		}
		
		return "";
	}
	@Test
	public void test() {
		assertTrue(construct(new String[]{".#...",
 ".#.#.",
 ".#.#.",
 ".#.#.",
 "...#."}, 16).equals("DDDDRRUUUURRDDDD"));
		assertTrue(construct(new String[]{"...................................", "....................##.............", ".........................#.........", "...................................", ".......#.....#..............#......", "................#..................", "...............##..................", "............#.#....................", "#..................................", "..##...................#...........", ".#.................................", "...................#...............", "......#...................#........", "...................................", ".................#.................", "...................................", "....#..............................", "................#..........#.......", "...................................", "...............#...................", "...................................", "......#......#.....................", ".#........#........................", "................#..................", "...................................", "...................................", ".................................##", "...#............#.#................", "#.............................#....", "...................................", "............#......................", "..#.................#..............", "................#..................", "...................................", "................#..................", "...................................", "...................................", "...................................", ".................................#.", ".........#.........................", ".............................#.....", ".................................#.", "...................................", "..............................#..#.", "...................................", "..#................................", "....#.............#........#.......", ".................#................."}, 1788).equals(""));
	}
}