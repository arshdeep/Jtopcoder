package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class TomekPhone {
	class state implements Comparable<state> {
		int ks;
		int level;
		public state(int a, int b) {
			ks = a;
			level = b;
		}
		@Override
		public int compareTo(state o) {
			// TODO Auto-generated method stub
			if (this.level != o.level) {
				return this.level - o.level;
			}
			
			return 0;
		}
		
	}
	long accumulate(int[] in) {
		long sum = 0;
		
		for (int no : in) {
			sum += no;
		}
		
		return sum;
	}
	public int minKeystrokes(int[] frequencies, int[] keySizes) {
		if (frequencies.length > accumulate(keySizes)) {
			return -1;
		}
		int res = 0;
		
		Arrays.sort(frequencies);
		PriorityQueue<state> pq = new PriorityQueue<state>();
		for (int no : keySizes) {
			pq.add(new state(no, 1));
		}
		
		for (int i = frequencies.length - 1; i >= 0; --i) {
			if (!pq.isEmpty()) {
				state top = pq.poll();
				
				res += top.level * frequencies[i];
				
				if (top.level + 1 <= top.ks) {
					pq.add(new state(top.ks, top.level + 1));
				}
			}
		}
		return res;
	}
	@Test
	public void test(){
		assertTrue( minKeystrokes(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50},
				new int[]{10,10,10,10,10,10,10,10}) == 3353 );
		assertTrue( minKeystrokes(new int[]{100,1000,1,10}, new int[]{50}) == 1234 );
		assertTrue( minKeystrokes(new int[]{11,23,4,50,1000,7,18}, new int[]{3,1,4}) == 1164 );
		assertTrue( minKeystrokes(new int[]{7,3,4,1}, new int[]{2,2}) == 19 );
	}
}
