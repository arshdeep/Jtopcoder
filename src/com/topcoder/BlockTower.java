package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BlockTower {
	int[] blockHeights;
	
	int solve(int idx, boolean even) {
		if (idx >= blockHeights.length) {
			return 0;
		}
		
		int sum = 0;
		
		if ((blockHeights[idx] & 0x01) == 0 && even) {
			sum = Math.max(blockHeights[idx] + solve(idx + 1, even), blockHeights[idx] + solve(idx + 1, !even));
		}
		else if ((blockHeights[idx] & 0x01) != 0 && !even) {
			sum = blockHeights[idx] + solve(idx + 1, even);
		}
		else {
			sum = solve(idx + 1, even);
		}
		
		return sum;
	}
	public int getTallest(int[] blockHeights) {
		this.blockHeights = blockHeights;
		int res = 0;
		
		res = Math.max(solve(0, true), solve(0, false));		
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( getTallest(new int[]{49,2,49,2,49}) ==  147 );
		assertTrue( getTallest(new int[]{44,3,44,3,44,47,2,47,2,47,2}) ==  273 );
		assertTrue( getTallest(new int[]{4,7}) ==  11 );
	}
	
}
