package com.topcoder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/* http://community.topcoder.com/stat?c=problem_statement&pm=13958&rd=16514 */
public class LuckyCycle {
	List<Edge>[] edges;
	Boolean[] visited;
	int count4;
	int count7;
	
	
	public int[] getEdge(int[] edge1, int[] edge2, int[] weight) {
		int len = edge1.length + 1;
		edges = new List[len];
		
		for (int idx = 0; idx < len; ++idx) {
			edges[idx] = new ArrayList<Edge>();
		}
		for (int idx = 0; idx < edge1.length; ++idx) {
			edges[edge1[idx] - 1].add(new Edge(edge1[idx] - 1, edge2[idx] - 1, weight[idx]));
			edges[edge2[idx] - 1].add(new Edge(edge2[idx] - 1, edge1[idx] - 1, weight[idx]));
		}
		
		for (int i = 0; i <= edge1.length; ++i) {
			for (int j = i + 1; j <= edge1.length; ++j) {
				count4 = 0;
				count7 = 0;
				visited = new Boolean[len];
				Arrays.fill(visited, false);
				dfs(i, j, 0, 0);
				if ((count4 + count7) % 2 == 1 && Math.abs(count4 - count7) == 1 && (count4 + count7) > 1) {
					int[] res = new int[3];
					res[0] = i + 1;
					res[1] = j + 1;
					if (count4 < count7) {
                        res[2] = 4;
                    } else if (count7 < count4) {
                        res[2] = 7;
                    }
					return res;
				}
			}
		}
		return new int[0];
	}
	
	private void dfs(int u, int v, int c4, int c7) {
		visited[u] = true;
		if (u == v) {
			count4 = c4;
			count7 = c7;
			return;
		}
		ArrayList<Edge> e = (ArrayList<Edge>) edges[u];

		for(int idx = 0, len = e.size(); idx < len; ++idx) {
			Edge edge = e.get(idx);
			if (!visited[edge.v]) {
				if (edge.w == 7) {
					dfs(edge.v, v, c4, c7 + 1);
				}
				else if (edge.w == 4) {
					dfs(edge.v, v, c4 + 1, c7);
				}
			}
		}
	}
	
	@Test
	public void test1() {
		int e1[] = {1};
		int e2[] = {2};
		int w[] = {4};
		int r[] = {};
		
		assertTrue(Arrays.equals(getEdge(e1, e2, w), r));
	}	
	@Test
	public void test2() {
		int e1[] = {1, 3, 2, 4};
		int e2[] = {2, 2, 4, 5};
		int w[] = {4, 7, 4, 7};
		int r[] = {1, 5, 7 };
		
		assertTrue(Arrays.equals(getEdge(e1, e2, w), r));
	}	
	@Test
	public void test3() {
		int e1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int e2[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int w[] = {4, 4, 4, 4, 4, 4, 7, 7, 7, 7, 7, 7};
		int r[] = {1, 12, 7 };
		
		assertTrue(Arrays.equals(getEdge(e1, e2, w), r));
	}	
	@Test
	public void test4() {
		int e1[] = {1, 2, 3, 5, 6};
		int e2[] = {2, 3, 4, 3, 5};
		int w[] = {4, 7, 7, 7, 7};
		int r[] = {1, 4, 4 };
		
		assertTrue(Arrays.equals(getEdge(e1, e2, w), r));
	}	
}

class Edge {
	public int u, v, w;
	public Edge(int s, int e, int weight) {
		u = s;
		v = e;
		w = weight;
	}
}