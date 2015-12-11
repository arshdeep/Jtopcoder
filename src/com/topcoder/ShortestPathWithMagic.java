package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class ShortestPathWithMagic {
	class Node implements Comparable<Node> {
		int index;
		double dist;
		int magic;
		public Node(int index, double dist, int magic) {
			this.index = index;
			this.dist = dist;
			this.magic = magic;
		}
		@Override
		public int compareTo(Node o) {
			if (this.dist < o.dist)
				return -1;
			else if (this.dist > o.dist)
				return 1;
			return 0;
		}

		
	}
	public double getTime(String[] dist, int k)
	{
		int n = dist.length;
		int m = dist[0].length();
		int [][]graph = new int[n][m];
		boolean visited[][][] = new boolean[51][51][51];
		
		for (int i = 0; i < dist.length; ++i) {
			for (int j = 0, size = dist[i].length(); j < size; ++j) {
				graph[i][j] = (int)(dist[i].charAt(j) - '0');
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.add( new Node(0, 0, k) );
		double res = Double.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			Node top = pq.poll();
			
			if (top.index == 1) {
				res = Math.min(res, top.dist);
			}

			for (int i = 0; i < m; ++i) {
				if (i == top.index || visited[i][top.index][top.magic] || visited[top.index][i][top.magic]) continue;
				
				if (top.magic >= 1) {
					pq.add(new Node(i, top.dist + (double)graph[top.index][i]/(double)2.0, top.magic - 1));
					visited[top.index][i][top.magic - 1] = true;
					visited[i][top.index][top.magic - 1] = true;
				}

				visited[top.index][i][top.magic] = true;
				visited[i][top.index][top.magic] = true;
				pq.add(new Node(i, top.dist + (double)graph[top.index][i], top.magic));
			}
		}
		return res;
			
	}
	
	@Test
	public void test() {
		assertTrue( getTime( new String[]{"094", "904", "440"}, 2) == 4.0 );
		assertTrue( getTime( new String[]	{"0949243810922254666", "9019601912008107196", "4103046990576418474", "9930167464143461097", "2601098137140184870", "4046901947593881379", "3167810600950839631", "8994196081220156531", "1196340800176005144", "0204770100926889082", "9051159219001622912", "2074495272007777236", "2863030066170070572", "2144188108670004932", "5016883508277008931", "4781419659270480267", "6140836510925992048", "6979773348137336400", "6647091142262217800"}, 14) == 0.0 );
	}
}
