package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConnectingCars {
	public long minimizeCost(int[] positions, int[] lengths) {
		long minCost = Long.MAX_VALUE;
		
		for (int i = 0, size = positions.length; i < size; ++i) {
			for (int j = i + 1; j < size; ++j) {
				if (positions[i] > positions[j]) {
					int temp = positions[i];
					positions[i] = positions[j];
					positions[j] = temp;
					
					temp = lengths[i];
					lengths[i] = lengths[j];
					lengths[j] = temp;
				}
			}
		}
		
		for (int i = 0, size = positions.length; i < size; ++i) {
			long count = 0;
			long left = 0, right = 0;
			long delta = 0;
			left = positions[i];
			for (int j = i - 1; j >= 0; --j) {
				delta = left - (positions[j] + lengths[j]);
				left = positions[j] + delta;
				count += delta;
			}
			
			delta = 0;
			right = positions[i] + lengths[i];
			for (int j = i + 1; j < size; ++j) {
				delta = positions[j] - right;
				count += delta;
				right += lengths[j];
			}
			
			minCost = Math.min(count, minCost);
		}		
		
		return minCost;
	}
	
	@Test
	public void test() {
	    assertTrue( minimizeCost(new int[] {1, 3, 10, 20}, new int[] {2, 2, 5, 3}) == 15 );
	}	
}
