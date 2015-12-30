package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class IncrementingSequence {
	public String canItBeDone(int k, int[] A) {
		Arrays.sort(A);

		for (int i = 1; i <= A.length; ++i) {
			boolean flag = false;
			for (int k1 = 0; k1 < A.length; ++k1) {
				if (A[k1] != -1 && i >= A[k1] && ((i - A[k1]) % k) == 0 ) {
					flag = true;
					A[k1] = -1;
					break;
				}
			}
			if (!flag) return "IMPOSSIBLE";
		}
		return "POSSIBLE";
	}
	
	@Test
	public void test(){
		assertTrue( canItBeDone(3, new int[]{1,2,3,4}).equals("POSSIBLE"));
		assertTrue( canItBeDone(5, new int[]{2,2}).equals("IMPOSSIBLE"));
		assertTrue( canItBeDone(2, new int[]{1,1,1,1,1,1,2,2,2,2,2,2}).equals("POSSIBLE"));

		assertTrue( canItBeDone(9, new int[]{1,2,3,1,4,5,6,7,9,8}).equals("POSSIBLE"));
	}	
}
