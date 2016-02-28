package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JumpFurther {

	public int furthest(int N, int badStep) {
		int sum = 0;
		int res = 0;
		
		for (int i = 0; i <= N; ++i) {
			sum += i;
			if (sum == badStep) {
				res = -1;
				break;
			}
			else if (sum > badStep) {
				break;
			}
		}
		
		return res + (N * (N + 1)) / 2;
	}
	@Test
	public void test(){
		assertTrue( furthest(1313, 5858) == 862641);
		
		assertTrue( furthest(2, 1) == 2);
		assertTrue( furthest(3,3) == 5);
		assertTrue( furthest(2, 2) == 3);
	}

}
