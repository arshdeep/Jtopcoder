package com.topcoder;

import java.util.LinkedList;

public class PriorityQueue {
	public int findAnnoyance(String S, int[] a)
	{
		LinkedList<Integer> pq = new LinkedList<Integer>();
		
		pq.add(0);
		int res = 0;
		
		for (int i = 1; i < S.length(); ++i) {
			if (S.charAt(i) == 'b') {
				for(int e : pq) {
					res += a[e];
				}
				pq.addFirst(i);
			}
			else {
				pq.addLast(i);
			}
		}
		
		return res;
	}

}
