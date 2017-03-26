package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Permatchd2 {
	int vertex;
	int edges;
	String[] graph;
	boolean visited[];

	void dfs(int i)
	{
		if (visited[i]) {
			return;
		}
		++vertex;
		visited[i] = true;
		
		for (int j = 0; j < graph[i].length(); ++j) {
			if (graph[i].charAt(j) == 'Y') {
				++edges;
				if (!visited[j])
					dfs(j);
			}
		}
	}

	public int fix(String[] graph)
	{
		this.graph = graph;
		this.visited = new boolean[graph.length];
		int res = 0;
		for (int i = 0; i < graph.length; ++i) {
			this.vertex = 0;
			this.edges = 0;
			if (visited[i]) {
				continue;
			}
			dfs(i);
			
			if ( ((this.edges/2) & 1) == 1 && vertex * (vertex - 1) == edges && graph.length == vertex) {
				return -1;
			}
			
			if ((this.edges/2 & 1) == 1) {
				++res;
			}
			
		}
		
		return res;
	}

	@Test
	public void test()
	{
		assertTrue(fix(new String[]{
				 "NYY",
				 "YNY",
				 "YYN"}) == -1 );
		assertTrue(fix(new String[]{"NYY",
				 "YNN",
				 "YNN"}) == 0 );
		assertTrue(fix(new String[]{"NYN",
				 "YNN",
				 "NNN"}) == 1 );
	}
}
