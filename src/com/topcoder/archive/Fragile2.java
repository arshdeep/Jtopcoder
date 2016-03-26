package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class Fragile2 {
	boolean [][] visit;
	boolean dfs(boolean [][]dfs, int idx, int a, int b) {
		if (visit[idx][idx])
			return false;
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(idx);
		
		while(!stk.isEmpty()) {
			int top = stk.pop();
			if (visit[top][top])
				continue;
			
			visit[top][top] = true;
			
			for (int i = 0; i < dfs[0].length; ++i) {
				if (i != a && i != b && !visit[top][i] && dfs[top][i]) {
					visit[top][i] = true;
					visit[i][top] = true;
					stk.push(i);
				}
			}
		}
		return true;
	}

	public int countPairs(String[] graph) {
		int res = 0;
		boolean[][] aux = new boolean[graph.length][graph[0].length()];

		for (int i = 0; i < graph.length; ++i) {
			for (int j = 0; j < graph[0].length(); ++j) {
				if (graph[i].charAt(j) == 'Y') {
					aux[i][j] = true;
				}
			}
		}
		
		visit = new boolean[graph.length][graph[0].length()];
		int cc = 0;
		for (int i = 0; i < graph.length; ++i) {
			if (dfs(aux, i, -1, -1)) {
				++cc;
			}
		}

		
		for (int i = 0; i < graph.length; ++i) {
			for (int j = i + 1; j < graph[0].length(); ++j) {
				visit = new boolean[graph.length][graph[0].length()];
				int temp = 0;
				for (int k = 0; k < graph.length; ++k) {
					if (k != i && k != j && !visit[k][k] && dfs(aux, k, i, j)) {
						++temp;
					}
				}
				if (temp > cc) {
					++res;
				}
			}
		}

		return res;
	}
	
	@Test
	public void test(){
		assertTrue( countPairs(new String[] {"NYNN", "YNYN", "NYNY", "NNYN"}) == 3 );
		assertTrue( countPairs(new String[] {"NYNNNN", "YNYNNN", "NYNNNN", "NNNNYN", "NNNYNY", "NNNNYN"}) == 5 );
		assertTrue( countPairs(new String[] {"NNNYNNYNNNNNNNYYNNNY", "NNNNNNNNYNNNNNNNNNNN", "NNNNNNNNNNNNNNNNNNNN", "YNNNNNNNNNYNNNNNNNNN", "NNNNNNNYNNNNNYNNNNYN",
				 "NNNNNNNNNNNNNNNNYNNY", "YNNNNNNNNNNNNYYYNYNN", "NNNNYNNNNNNNNYYNNNNN", "NYNNNNNNNYNNNNNNNNNN", "NNNNNNNNYNNNYNNNNNYN",
				 "NNNYNNNNNNNNNNYNNNNN", "NNNNNNNNNNNNNNNNNNNN", "NNNNNNNNNYNNNNNNNYNN", "NNNNYNYYNNNNNNNNNNNN", "YNNNNNYYNNYNNNNNNNNN",
				 "YNNNNNYNNNNNNNNNYNNN", "NNNNNYNNNNNNNNNYNYNN", "NNNNNNYNNNNNYNNNYNNN", "NNNNYNNNNYNNNNNNNNNN", "YNNNNYNNNNNNNNNNNNNN"}) == 42 );
	}
}
