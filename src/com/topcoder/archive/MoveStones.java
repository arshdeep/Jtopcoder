package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MoveStones {
	public long go(int[] a, int[] b) {
		long res = 0;
		long need = 0;
		long sum = 0;
		for (int i = 0; i < a.length; ++i) {
			sum += a[i];
			sum -= b[i];
		}		

		if (sum != 0) {
			return -1;
		}
		for (int i = 0; i < a.length; ++i) {
			res += Math.abs(need);
			need = need + (a[i] - b[i]);
		}
		
		return res;
	}
	void reverse(int[] a, int idx) {
		int i = 0;
		int tail = idx;
		
		while (i < tail) {
			swap(a, tail, i);
			++i;
			--tail;
		}
		
		i = idx + 1;
		tail = a.length - 1;

		while (i < tail) {
			swap(a, tail, i);
			--tail;
			++i;
		}
		
		i = 0;
		tail = a.length - 1;
		while (i < tail) {
			swap(a, tail, i);
			--tail;
			++i;
		}

	}
	private void swap(int[] a, int tail, int i) {
		int temp = a[i];
		a[i] = a[tail];
		a[tail] = temp;
	}
	public long get(int[] a, int[] b) {
		long res = Long.MAX_VALUE;
		
		for (int i = 0; i < a.length; ++i) {
			res = Math.min(res, go(a, b));
			reverse(a, 0);
			reverse(b, 0);
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( get(new int[]{1000000000, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1000000000, 0, 0}) == 3000000000L );
		assertTrue( get(new int[]{0,5}, new int[]{5,0}) == 5 );
		assertTrue( get(new int[]{1, 2, 3}, new int[]{3, 1, 2}) == 2 );


	}	
}
