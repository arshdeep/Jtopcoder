package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MonstersValley2 {
	int[] dread;
	int[] price;
	
	int solve(int idx, long sum, int cost) {
		if (idx == dread.length) {
			return cost;
		}
		
		if (sum >= dread[idx]) {
			int without = solve(idx + 1, sum, cost);
			int with = solve(idx + 1, sum + dread[idx], cost + price[idx]);
			
			return Math.min(without, with);
		}
		else {
			return solve(idx + 1, sum + dread[idx], cost + price[idx]);
		}
	}

	public int minimumPrice(int[] dread, int[] price) {
		this.dread = dread;
		this.price = price;
		int res =  solve(0, 0, 0);
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( minimumPrice(new int[]{5216, 12512, 613, 1256, 66, 17202, 30000, 23512, 2125, 33333},
				new int[]{2, 2, 1, 1, 1, 1, 2, 1, 2, 1}) == 5);
		assertTrue( minimumPrice(new int[]{200, 107, 105, 206, 307, 400}, new int[]{1, 2, 1, 1, 1, 2}) == 2);
		assertTrue( minimumPrice(new int[]{1, 2, 4, 1000000000}, new int[]{1, 1, 1, 2}) == 5);
		assertTrue( minimumPrice(new int[]{8, 5, 10}, new int[]{1, 1, 2}) == 2);
	}	
}
