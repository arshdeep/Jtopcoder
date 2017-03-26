package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SellingFruits {
	int x;
	int f; int d; int p;
	boolean can(long days) {
		long delta = 0;
		if (days > f) {
			delta = days - f;
		}
		
		long cost = d - delta*p;
		
		if (cost < 0) {
			return false;
		}
		
		return cost >= days * x;
	}
	public int maxDays(int x, int f, int d, int p)
	{
		this.x = x;
		this.f = f;
		this.d = d;
		this.p = p;
		int lo = 0;
		int hi = d;
		
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
		assertTrue(maxDays(15000000,100,2000000000,1) == 133);
		assertTrue(maxDays(2,17,20,1) == 10);
		assertTrue(maxDays(3, 5, 100,10) == 11);
	}

}
