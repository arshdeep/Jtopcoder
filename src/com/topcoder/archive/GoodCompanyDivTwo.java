package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class GoodCompanyDivTwo {
	public int countGood(int[] superior, int[] workType) {
		int res = 0;
		HashSet<Integer> rs = new HashSet<Integer>();
		for (int i = 0; i < superior.length; ++i) {
			HashSet<Integer> hs = new HashSet<Integer>();
			
			hs.add(workType[i]);

			boolean flag = true;
			for (int j = 1; j < superior.length; ++j) {
				if (superior[j] == i) {
					if (!hs.contains(workType[j])) {
						hs.add(workType[j]);
					}
					else {
						flag = false;
						break;
					}
				}
			}
			
			if (flag) {
				++res;
				rs.add(i);
			}
		}
		Arrays.sort(superior);
		return res;
	}
	
	@Test
	public void test(){
		assertTrue( countGood(new int[]{-1,0}, new int[]{1, 2}) == 2 );
		assertTrue( countGood(new int[]{-1,0}, new int[]{1, 1}) == 1 );
		assertTrue( countGood(new int[]{-1, 0, 1, 1}, new int[]{1, 4, 3, 2}) == 4 );
		assertTrue( countGood(new int[]{-1, 0, 0, 1, 1, 3, 0, 2, 0, 5, 2, 5, 5, 6, 1, 2, 11, 12, 10, 4, 7, 16, 10, 9, 12, 18, 15, 23, 20, 7, 4},
					new int[]{4, 6, 4, 7, 7, 1, 2, 8, 1, 7, 2, 4, 2, 9, 11, 1, 10, 11, 4, 6, 11, 7, 2, 8, 9, 9, 10, 10, 9, 8, 8}) == 27 );
	}
}	
