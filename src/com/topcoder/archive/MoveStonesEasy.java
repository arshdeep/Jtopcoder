package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MoveStonesEasy {
	public int get(int[] a, int[] b) {
		int res = 0;
		
		int sum = 0;
		
		for (int i = 0;i < a.length; ++i) {
			sum += a[i];
		}
		for (int i = 0;i < b.length; ++i) {
			sum -= b[i];
		}
		if (sum != 0) {
			return -1;
		}
		int x = 0;
		for (int i = 0;i < a.length; ++i) {
			x += a[i] - b[i];
			
			res += Math.abs(x);
		}
		return res;
	}
	@Test
	public void test() {
		assertTrue( get(new int[]{280679, 91421, 806309, 427023, 279501, 112931, 879234, 944975, 917321, 40007, 397540, 562248, 589633, 348334, 357352},
				new int[]{279501, 879234, 562248, 40007, 944975, 357352, 91421, 427023, 397540, 917321, 112931, 589633, 806309, 280679, 348334}) == 5160778 );
		assertTrue( get(new int[]{0,3,0,1,0,0,3}, new int[]{0,2,0,3,0,0,2}) == 5 );
		assertTrue( get(new int[]{0,0,1}, new int[]{1,0,0}) == 2 );
		assertTrue( get(new int[]{1,2}, new int[]{2,1}) == 1 );

	}
}
