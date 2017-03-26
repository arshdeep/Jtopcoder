package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MinMaxMax {
	private class state implements Comparable<state> {
		int a;
		int b;
		public state(int i, int j) {
			a = i;
			b = j;
		}

		@Override
		public int compareTo(state arg0) {
			// TODO Auto-generated method stub
			return this.a - arg0.a;
		}
		
	}
	public long findMin(int[] a, int[] b, int[] w, int[] v) {
		state[] weights = new state[w.length];
		for (int i = 0; i < w.length; ++i) {
			weights[i] = new state(w[i], i);
		}
		state[] vertex = new state[v.length];
		for (int i = 0; i < v.length; ++i) {
			vertex[i] = new state(v[i], i);
		}
		Arrays.sort(weights);
		Arrays.sort(vertex);
		int n = v.length;
		long[][] dist = new long[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(dist[i], Long.MAX_VALUE);
		}

		for (int i = 0; i < n; ++i) {
			int parent[] = new int[n];
			boolean valid[] = new boolean[n];
			
			for (int ii = i; ii < n; ++ii) {
				valid[vertex[ii].b] = true;
			}
			for (int ii = 0; ii < n; ++ii) {
				parent[ii] = ii;
			}
			for (int j = 0; j < n; ++j) {
				int v1 = a[weights[j].b];
				int v2 = b[weights[j].b];
				if (parent[v1] == parent[v2] || !valid[v1] || !valid[v2]) continue;
				long cur = 1L * vertex[i].a * weights[j].a;
				ArrayList<Integer> l1 = new ArrayList<Integer>();
				ArrayList<Integer> l2 = new ArrayList<Integer>();
				
				for (int k = 0; k < n; ++k) {
					if (parent[k] == parent[v1]) {
						l1.add(k);
					}
					else if (parent[k] == parent[v2]) {
						l2.add(k);
					}
				}
				for (int ver1 : l1) {
					for (int ver2 : l2) {
						if (cur < dist[ver1][ver2]) {
							dist[ver1][ver2] = cur;
						}
						if (cur < dist[ver2][ver1]) {
							dist[ver2][ver1] = cur;
						}
					}
				}
				
				for (int ver2 : l2) {
					parent[ver2] = parent[v1];
				}
			}
		}
		long res = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (dist[i][j] != Long.MAX_VALUE)
					res += dist[i][j];
			}
		}
		
		return res;
	}
	public long findMinEx(int[] a, int[] b, int[] w, int[] v) {
		int n = v.length;
		long[][] adj = new long[n][n];
		long[][] dist = new long[n][n];
		state[] nodes = new state[v.length];
		for (int i = 0; i < v.length; ++i) {
			nodes[i] = new state(v[i], i);
		}
		Arrays.sort(nodes);
		for (int i = 0; i < n; ++i) {
			Arrays.fill(dist[i], Long.MAX_VALUE);
			Arrays.fill(adj[i], Long.MAX_VALUE);
		}
		
		for (int i = 0; i < a.length; ++i) {
			adj[b[i]][a[i]] = adj[a[i]][b[i]] = w[i];
		}
		
		for (int k1 = 0; k1 < n; ++k1) {
			int k = nodes[k1].b;
			for (int i = 0; i < n ; ++i) {
				for (int j = 0 ;j < n; ++j) {
					if (adj[i][k] != Long.MAX_VALUE && adj[k][j] != Long.MAX_VALUE) {
						adj[i][j] = Math.min(adj[i][j], Math.max(adj[i][k], adj[k][j]));
						dist[i][j] = Math.min(dist[i][j], 1L * adj[i][j] * Math.max(v[j], Math.max(v[i], v[k])));
					}
				}
			}
		}
		
		long res = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (dist[i][j] != Long.MAX_VALUE)
					res += dist[i][j];
			}
		}
		
		return res;
	}
	@Test
	public void test() {
		assertTrue(findMin(new int[]{0,0,1}, new int[]{1,2,2}, new int[]{100,1,1}, new int[]{1,1,100}) == 300);
		assertTrue(findMin(new int[]{0}, new int[]{1}, new int[]{5}, new int[]{3,6}) == 30);
		assertTrue(findMin(new int[]{0,0,1}, new int[]{1,2,2}, new int[]{10,11,12}, new int[]{6,5,4}) == 186);
		long res = findMin(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{1,2,3,4,5,6,7,8,9,10},
				new int[]{1000000,1,1000000,1,1000000,1,1000000,1,1000000,1},
				new int[]{1000000,1,1000000,1,1000000,1,1000000,1,1000000,1,1000000});
		assertTrue(res == 50000005000000L);
		assertTrue(findMin(new int[]{9,12,4,11,0,8,6,11,11,10,12,7,3,12,3,10,0,3,2,7,
				0,10,8,1,11,9,2,0,3,6,4,2,3,5,9,0,6}
		, new int[]{0,5,6,5,10,2,1,2,3,4,6,9,9,10,5,5,6,4,12,5,12,7,
				7,3,4,12,4,1,8,7,1,6,6,4,11,5,11}, new int[]{879651,656980,11,51564,206,420,917584,205,59290,3323,
						644,1,13243,84162,154,561242,1,190,10,136901,420623,
						353,573129,81,25,133670,72,528049,5,715560,82641,46,
						1,527672,923948,1,13}, new int[]{5,1829,51302,3026,4,14,5189,3,25289,2,2967,15994,6}) == 157740289L);
	}
}
