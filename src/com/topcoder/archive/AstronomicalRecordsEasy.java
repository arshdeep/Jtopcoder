package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class AstronomicalRecordsEasy {
	public int minimalPlanets(int[] A, int[] B) {

		int res = A.length  + B.length;
				
		for (int i = 0; i < A.length; ++i) {
			int p = A[i];
			for (int j = 0; j < B.length; ++j) {
				int q = B[j];
				HashSet<Integer> hs = new HashSet<Integer>();

				for (int no : A) {
					hs.add(no * q);
				}
				for (int no : B) {
					hs.add(no * p);
				}
				res = Math.min(res, hs.size());

			}
		}
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( minimalPlanets(new int[]{1,2,3,4}, new int[]{2,4,6,8}) == 4 );
		assertTrue( minimalPlanets(new int[]{1,2,3,5,6,8,9}, new int[]{2,4,5,6,7,8,9}) == 9 );
		assertTrue( minimalPlanets(new int[]{200,500}, new int[]{100,200,300,400,600,700,800,900}) == 9 );
		assertTrue( minimalPlanets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, new int[]{6,7,8,9,10,11,12,13,14,15}) == 15 );
		
		assertTrue( minimalPlanets(new int[]{1,2,3,4}, new int[]{6,7,8,9}) == 6 );
	}
}
