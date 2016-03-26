package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PublicTransit {
	public int minimumLongestDistance(int R, int C) {
		int worstCase = 100;
		
		for (int a = 0; a < R*C; ++a) {
			for(int b = 0; b < R*C; ++b) {
				int x0 = a / C;
				int y0 = a % C;
				int x1 = b / C;
				int y1 = b % C;
				int res = 0;
				
				for (int i = 0; i < R*C; ++i) {
					for(int j = 0; j < R*C; ++j) {
						int x2 = i / C;
						int y2 = i % C;
						int x3 = j / C;
						int y3 = j % C;
						
						int manhattan0 = Math.abs(x3 - x2) + Math.abs(y3 - y2);
						int manhattan1 = Math.abs(x3 - x1) + Math.abs(y3 - y1) + Math.abs(x0 - x2) + Math.abs(y0 - y2);
						int manhattan2 = Math.abs(x3 - x0) + Math.abs(y3 - y0) + Math.abs(x1 - x2) + Math.abs(y1 - y2);
						
						res = Math.max(res, Math.min(manhattan0, Math.min(manhattan1, manhattan2)));
					}
				}
				
				worstCase = Math.min(worstCase, res);
			}
		}
		return worstCase;
	}
	
	@Test
	public void test() {
		assertTrue( minimumLongestDistance(4,1) == 1 );
		assertTrue( minimumLongestDistance(2,2) == 1 );
		assertTrue( minimumLongestDistance(5,3) == 4 );
		assertTrue( minimumLongestDistance(8,2) == 4 );
	}
}
