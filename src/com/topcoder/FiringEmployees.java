package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FiringEmployees {
	int profit[];
	
	public int fire(int[] manager, int[] salary, int[] productivity) {
		profit = new int[manager.length + 1];
		
		for (int i = 0; i < manager.length; ++i) {
			profit[i + 1] = productivity[i] - salary[i];
		}
		
		for (int i = manager.length; i >= 0; --i) {
			int temp = 0;
			for (int j = 0; j < manager.length; ++j) {
				if (manager[j] == i) {
					temp = Math.max(profit[j + 1] + temp, temp); 
				}
			}
			profit[i] += temp;
		}
		
		return profit[0];
	}
	
	@Test
	public void test() {
		assertTrue( fire(new int[]{0,0,1,1,2,2},new int[]{1,1,1,2,2,2}, new int[]{2,2,2,1,1,1}) == 3);
		assertTrue( fire(new int[]{0,1,2,1,2,3,4,2,3},new int[]{5,3,6,8,4,2,4,6,7}, new int[]{2,5,7,8,5,3,5,7,9}) == 6);
		assertTrue( fire(new int[]{0,1},new int[]{1,10}, new int[]{5,5}) == 4);
		assertTrue( fire(new int[]{0,1,2,3},new int[]{4,3,2,1}, new int[]{2,3,4,5}) == 4);
		assertTrue( fire(new int[]{0,0,0},new int[]{1,2,3}, new int[]{3,2,1}) == 2);
	}
}
