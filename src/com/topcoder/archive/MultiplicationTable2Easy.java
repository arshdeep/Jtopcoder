package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class MultiplicationTable2Easy {
	public String isGoodSet(int[] table, int[] t)
	{
		int n = (int) Math.sqrt(table.length);
		Arrays.sort(t);
		for (int i = 0; i < t.length; ++i) {
			for (int j = 0; j < t.length; ++j) {
				int val = table[t[i] * n + t[j]];
				
				if (Arrays.binarySearch(t, val) < 0) {
					return "Not Good";
				}
			}
		}
		return "Good";
	}
	
	@Test
	public void test(){
		assertTrue( isGoodSet(new int[]{1,1,1,1,
				 2,2,2,2,
				 3,3,3,3,
				 0,0,0,0},new int[]{0, 1,2,3}).equals("Good"));
		assertTrue( isGoodSet(new int[]{1,1,2,3,
				 1,0,3,2,
				 2,0,1,3,
				 1,2,3,0},new int[]{0}).equals("Good"));
		assertTrue( isGoodSet(new int[]{0,1,2,3,
				 1,2,3,0,
				 2,3,0,1,
				 3,0,1,2},new int[]{0}).equals("Good"));
		assertTrue( isGoodSet(new int[]{1,1,1,1,
				 2,2,2,2,
				 3,3,3,3,
				 0,0,0,0},new int[]{0,1,2, 3}).equals("Good"));
		assertTrue( isGoodSet(new int[]{2,2,2,2,2,2,
				 2,2,2,2,2,2,
				 2,2,2,2,2,2,
				 2,2,2,2,2,2,
				 2,2,2,2,2,2,
				 2,2,2,2,2,2},new int[]{0,1,3,4,5}).equals("Not Good"));
		assertTrue( isGoodSet(new int[]{1, 1, 2, 3,
				 1, 0, 2, 3,
				 3, 3, 0, 3,
				 2, 2, 2, 0},new int[]{0,1}).equals("Good"));
	}
}
