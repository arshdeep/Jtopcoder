package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class BoxesDiv2 {
	int getBox(int size) {
		boolean flag = true;

		while (flag) {
			flag = size != 0 && (size & (size - 1)) != 0;
			++size;
		}
		return size - 1;
	}

	public int findSize(int[] candyCounts) {
		Arrays.sort(candyCounts);
		ArrayList<Integer> dp = new ArrayList<Integer>();
		
		for (int i = candyCounts.length - 1; i >= 0; --i) {
			dp.add(getBox(candyCounts[i]));
		}

		while (dp.size() > 1) {
			int n = dp.size();
			Collections.sort(dp, Collections.reverseOrder());
			
			dp.set(n - 2, getBox(dp.get(n - 2) + dp.get(n - 1)) );
			dp.remove(n - 1);
		}
		return dp.get(0);
	}
	
	@Test
	public void test() {
		assertTrue( findSize(new int[]{8,8}) == 16 );
		assertTrue( findSize(new int[]{5,6}) == 16 );
		assertTrue( findSize(new int[]{1,7}) == 16 );
		assertTrue( findSize(new int[]{1,1,13,1,1}) == 32 );
		assertTrue( findSize(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32}) == 1024 );
		assertTrue( findSize(new int[]{725,479,359,963,465,706,146,282,828,962,492}) == 8192 );

	}
}
