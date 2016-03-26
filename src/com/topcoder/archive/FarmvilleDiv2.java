package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FarmvilleDiv2
{
	public int minTime(int[] time, int[] cost, int budget)
	{
		int res = 0;
		
		for (int i = 0; i < cost.length; ++i) {
			for (int j = i + 1; j < cost.length; ++j) {
				if (cost[i] > cost[j]) {
					int t = time[i];
					time[i] = time[j];
					time[j] = t;
					
					t = cost[i];
					cost[i] = cost[j];
					cost[j] = t;
				}
			}
		}
		
		for (int i = 0; i < cost.length; ++i) {
			if (cost[i] <= budget) {
				if (cost[i] * time[i] <= budget) {
					budget = Math.max(0, budget - cost[i] * time[i]);
					time[i] = 0; 
				}
				else {
					time[i] -= Math.max(0, budget / cost[i]);
					budget = 0;
					break;
				}
				
			}

		}		
		for (int i = 0; i < cost.length; ++i) {
			res += time[i];
		}
		
		return res;
	}
	@Test
	public void test(){
		//assertTrue( minTime(new int[]{100}, new int[] {1}, 26) == 74 );
//		assertTrue( minTime(new int[]{1,2,3,4,5}, new int[] {5,4,3,2,1}, 15) == 6 );
		assertTrue( minTime(new int[]{100,100,100,100,100,100,100,100,100,100}, new int[] {2,4,6,8,10,1,3,5,7,9}, 5000) == 50 );

	}
}
