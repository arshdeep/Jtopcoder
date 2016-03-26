package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardEscapeDiv2
{
	String [] s;
	Boolean [][][]visited;
	
	boolean dfs(int x, int y, int k) {
		if (visited[x][y][k] != null)
			return visited[x][y][k];
		
		if (k == 0 || s[x].charAt(y) == 'E') {
			return false;
		}

		boolean flag = true;
		int x1[] = {0, -1, 0, 1};
		int y1[] = {-1, 0, 1, 0};
		
		for (int i = 0; i < 4; ++i) {
			if (x + x1[i] < 0 || x + x1[i] >= s.length || y + y1[i] < 0 || y + y1[i] >= s[0].length())
				continue;
			if (s[x + x1[i]].charAt(y + y1[i]) != '#') {
				flag = flag & dfs(x + x1[i], y + y1[i], k - 1);
			}
		}
		
		return visited[x][y][k] = !flag;
	}
	public String findWinner(String[] s, int k)
	{
		this.s = s;
		String ret = "Bob";
		visited = new Boolean[51][51][101];
		for (int i = 0; i < s.length; ++i) {
			for (int j = 0; j < s[0].length(); ++j) {
				if (s[i].charAt(j) == 'T') {
					if(dfs(i, j, k)) {
						ret = "Alice";
					}
					break;
				}
			}
		}
		return ret;
	}
	@Test
	public void test(){
		assertTrue( findWinner(new String[]{"T.#","#.E"}, 3).equals("Alice") );
		assertTrue( findWinner(new String[]{"TE"}, 50).equals("Alice") );

		assertTrue( findWinner(new String[]{".T."}, 1).equals("Alice") );
		assertTrue( findWinner(new String[]{"#E...","#...E", "E.T#.","..#.."}, 13).equals("Alice") );

	}

}
