package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UpDownHiking
{
	int N;
	int A;
	int B;
	boolean can(int n) {
		int days = (n + A - 1) / A;
		int delta = N - days;
		
		if (delta > 0) {
			return delta * B >= n; 
		}
		
		return false;
	}
	public int maxHeight(int N, int A, int B)
	{
		this.N = N;
		this.A = A;
		this.B = B;
		int hi = N * A;
		int lo = 1;
		while (lo < hi) {
			int mid = lo + (hi - lo + 1) / 2;
			if (can(mid)) {
				lo = mid;
			}
			else {
				hi = mid - 1;
			}
		}
		
		return lo;
	}
	@Test
	public void test() {
		assertTrue(maxHeight(3, 10, 45) == 20);
		assertTrue(maxHeight(5, 40 , 30) == 80);
		assertTrue(maxHeight(3, 7, 10) == 10);
	}
}
