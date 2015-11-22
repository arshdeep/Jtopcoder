package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CandleTimerEasy {
	List<ArrayList<Integer>> graph;
	int[][] weight;
	public 	int differentTime(int[] A, int[] B, int[] len) {
		int n = A.length + 1;
		graph = new ArrayList<ArrayList<Integer>>();
		weight = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			Arrays.fill(weight[i], Integer.MAX_VALUE);
			graph.add(new ArrayList<Integer>());
		}
		
		Set<Integer> diffTimes = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; ++i) {
			len[i] *= 2;
			
			int v1 = A[i];
			int v2 = B[i];
			for (int j = 0; j < 2; ++j) {
				ArrayList<Integer> al = graph.get(v1);

				al.add(v2);
				weight[v1][v2] = len[i];
				//swap
				v1 = v1 ^ v2;
				v2 = v1 ^ v2;
				v1 = v1 ^ v2;
			}
		}
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		
		for (int i = 0; i < n; ++i) {
			if (graph.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		
		for (int mask = 1, size = leaves.size(); mask < (1 << size); ++mask) {
			int[] dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			ArrayList<Integer> queue = new ArrayList<Integer>();
			int[] parent = new int[n];
			Arrays.fill(parent, -1);
			
			for (int i = 0; i < size; ++i) {
				if ( (mask & (1 << i)) != 0) {
					int id = leaves.get(i);
					queue.add(id);
					dist[id] = 0;
				}
			}
			
			int max = 0;
			while (!queue.isEmpty()) {
				int sm = 0;
				for (int i = 1; i < queue.size(); ++i) {
					if (dist[queue.get(sm)] > dist[queue.get(i)]) {
						sm = i;
					}
				}
				
				int x = queue.get(sm);
				queue.remove(sm);
				max = Math.max(max, dist[x]);
				
				for (int y : graph.get(x)) {
					if (dist[y] > dist[x] + weight[x][y]) {
						parent[y] = x;
						dist[y] = dist[x] + weight[x][y];
						if (!queue.contains(y)) {
							queue.add(y);
						}
					}
				}
			}
			
			// inner point
			for (int i = 0; i < A.length; ++i) {
				int x = dist[A[i]];
				int y = dist[B[i]];
				
				if (x < y) {
					int t = x;
					x = y;
					y = t;
				}
				
				if (parent[A[i]] != B[i] && parent[B[i]] != A[i] && (x - y) <= len[i]) {
					max = Math.max(max, x + (len[i] - (x - y)) / 2);
				}
			}
			diffTimes.add(max);
		}
		return diffTimes.size();
	}
	
	@Test
	public void test1()
	{
		assertTrue( differentTime(new int[] {0,1}, new int[] {1,2}, new int[]{10,1}) == 2 );
		assertTrue( differentTime(new int[] {0,0,0}, new int[] {1,2,3}, new int[]{1,1,1}) == 2 );
		assertTrue( differentTime(new int[] {0,0,0}, new int[] {1,2,3}, new int[]{1,2,3}) == 4 );
	}
}
