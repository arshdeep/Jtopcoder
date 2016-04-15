package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CasketOfStarEasy {
	int[] weight;
	int solve(int mask) {
		int n = weight.length;

		int res = 0;
		for (int i = 1; i < n - 1; ++i) if ((mask & (1 << i)) == 0) {
			int left = -1;
			for (int j = i - 1; j >= 0; --j) {
				if ( (mask & (1 << j)) == 0) {
					left = weight[j];
					break;
				}
			}
			
			int right = -1;
			for (int j = i + 1; j < n; ++j) {
				if ( (mask & (1 << j)) == 0) {
					right = weight[j];
					break;
				}
			}
			res = Math.max(res, left * right + solve(mask | (1 << i)));
		}
		
		return res;
	}
	public int maxEnergy(int[] weight) {
		this.weight = weight;
		
		return solve(0);
	}
	@Test
	public void test(){
		assertTrue( maxEnergy(new int[]{7, 50, 8, 1, 5}) == 335 );
		assertTrue( maxEnergy(new int[]{1000, 1, 1000, 2, 1000, 4, 1000, 500, 2, 2}) == 5504000 );
		assertTrue( maxEnergy(new int[]{363, 28, 691, 60, 764, 927, 541, 427, 173, 737}) == 3592727 );
		assertTrue( maxEnergy(new int[]{100, 3, 1, 2, 100}) == 10400 );
		assertTrue( maxEnergy(new int[]{1,1,1,1,1,1,1,1,1,1}) == 8 );
		assertTrue( maxEnergy(new int[]{477,744,474,777,447,747,777,474}) == 2937051 );
		assertTrue( maxEnergy(new int[]{2,2,7,6,90,5,9}) == 1818 );
		assertTrue( maxEnergy(new int[]{100,2,1,3,100}) == 10400 );
		assertTrue( maxEnergy(new int[]{1,2,3,4}) == 12 );
	}
}
