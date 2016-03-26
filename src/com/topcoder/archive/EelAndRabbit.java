package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EelAndRabbit {
	public int getmax(int[] l, int[] t) {
		int res = 0;

		for (int i = 0; i < l.length; ++i) {
				int x = t[i];
				int y = t[i] + l[i];
				int count = 1;
				for (int k = 0; k < l.length; ++k) if (k != i) {
					int x2 = t[k];
					int y2 = t[k] + l[k];
					if ( (x <= x2 && x <= y2)
							|| (y <= x2 && y <= y2)) {
						++count;
					}
				}
				
				res = Math.max(res, count);
		}
		return res;
	}
	
	@Test
	public void test(){
		
		
//		assertTrue( getmax(new int[]{50, 51, 8, 41, 53, 34, 67, 59, 42, 64, 52, 20, 39, 71, 17, 59, 32, 65, 9, 49, 20, 72, 70},
//				new int[] {40, 52, 32, 0, 61, 55, 59, 42, 55, 61, 55, 23, 35, 22, 11, 22, 52, 65, 5, 28, 56, 6, 15}) == 21);
//		assertTrue( getmax(new int[]{2, 4, 3, 2, 2, 1, 10},
//							new int[] {2, 6, 3, 7, 0, 2, 0}) == 6);
		assertTrue( getmax(new int[]{1,1,1}, new int[] {2, 0,4}) == 2);
		assertTrue( getmax(new int[]{1}, new int[] {1}) == 1);
		assertTrue( getmax(new int[]{8, 2, 1, 10, 8, 6, 3, 1, 2, 5}, new int[] {17, 27, 26, 11, 1, 27, 23, 12, 11, 13}) == 7);
	}
}
