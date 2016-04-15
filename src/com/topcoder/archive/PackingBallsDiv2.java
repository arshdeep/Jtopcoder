package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PackingBallsDiv2 {
	int[][][] memo;
	int rec(int R, int G, int B) {
		R = Math.max(0, R);
		G = Math.max(0, G);
		B = Math.max(0, B);
		
		if (memo[R][G][B] != -1) {
			return memo[R][G][B];
		}
		if (R + G + B == 0) return 0;
		
		int res = 1 + rec(R - 1, G - 1, B - 1);
		
		if (R > 0) {
			res = Math.min(res, 1 + rec(R - 3, G, B));
		}
		if (G > 0) {
			res = Math.min(res, 1 + rec(R, G - 3, B));
		}
		
		if (B > 0) {
			res = Math.min(res, 1 + rec(R, G, B - 3));
		}
		
		memo[R][G][B] = res;
		
		return res;
	}
	public int minPacks(int R, int G, int B) {
		memo = new int[101][101][101];
		
		for (int i = 0; i < 101; ++i) {
			for (int j = 0; j < 101; ++j) {
				for (int k = 0; k < 101; ++k) {
					memo[i][j][k] = -1;
				}
			}
		}
		return rec(R,G,B);
	}

	
	@Test
	public void test(){
		assertTrue( minPacks(1,2,5) == 3);
		assertTrue( minPacks(6,7,8) == 8);
		assertTrue( minPacks(11,3,3) == 6);
		assertTrue( minPacks(17, 19, 20) == 19);
		assertTrue( minPacks(99, 3, 3) == 35);
		assertTrue( minPacks(99, 96, 1) == 66);
		assertTrue( minPacks(1, 1, 99) == 34);
		assertTrue( minPacks(99, 100, 100) == 100);
		assertTrue( minPacks(90, 99, 13	) == 68);
		assertTrue( minPacks(28, 88, 56) == 58);
		assertTrue( minPacks(1,1,1) == 1);
		assertTrue( minPacks(100,100,100) == 100);
		assertTrue( minPacks(78,53,64) == 66);
		assertTrue( minPacks(2,3,5) == 4); 
		assertTrue( minPacks(1,7,1) == 3); 
		assertTrue( minPacks(4,2,4) == 4); 
	}
}
