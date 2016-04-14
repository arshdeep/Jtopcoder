package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TaroFriends {
	public int getNumber(int[] coordinates, int X) {
		int res = Integer.MAX_VALUE;
		int[] t = new int[coordinates.length];
		Arrays.sort(coordinates);
		for (int i = 0; i < coordinates.length; ++i) {
			t[i] = coordinates[i];
		}
		for (int i = 0; i < coordinates.length; ++i) {
			for (int j = 0; j < i; ++j) {
				t[j] += X;
			}
			for (int j = i; j < coordinates.length; ++j) {
				t[j] -= X;
			}
			Arrays.sort(t);
			res = Math.min(res, t[coordinates.length - 1] - t[0]);
			for (int j = 0; j < coordinates.length; ++j) {
				t[j] = coordinates[j];
			}
			
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue(getNumber(new int[]{-100000000, 100000000}, 100000000) == 0 );
		assertTrue(getNumber(new int[]{4, 7, -7}, 5) == 4 );
		assertTrue(getNumber(new int[]{-3, 0, 1}, 3) == 3 );
	}
}
