package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FoldingPaper2 {
	int INF = 1000000000;
	int go(int x, int y) {
		if (x < y) {
	        return INF;
	    }
	    if (x == y) {
	        return 0;
	    }
	    return 1 + go(x - Math.min(x/2, x - y) , y);
	}
	public int solve(int W, int H, int A) {
		int ret = INF;
		for (int w = A; w >= 1; --w) {
			if (A % w == 0) {
				ret = Math.min(ret, go(W, w) + go(H, A / w));
			}
		}
			
		
		return ret >= INF ? -1 : ret;
	}
	
	@Test
	public void test() {
		assertTrue( solve(5,3,12) == 1 );
		assertTrue( solve(2,2,3) == -1 );
		assertTrue( solve(127,129,72) == 8 );
	}
}
