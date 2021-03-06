package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;


public class MultiplicationTable2 {
	public int minimalGoodSet(int[] table) {
		int n = (int) Math.sqrt(table.length);
		int res = n;
		
		for (int i = 0; i < n; ++i) {
			HashSet<Integer> hs = new HashSet<Integer>();
			
			hs.add(i);
			while(true) {
				HashSet<Integer> hs2 = new HashSet<Integer>(hs);
				
				for (int j : hs2) {
					for (int k : hs2) {
						hs.add(table[j * n + k]);
					}
					
				}
				
				if (hs.size() == hs2.size()) {
					break;
				}
			}
			res = Math.min(res, hs.size());
		}
		
		return res;
	}
	@Test
	public void test(){
		assertTrue(minimalGoodSet(new int[]{1,1,1,1,
				 2,2,2,2,
				 3,3,3,3,
				 0,0,0,0}) == 4);
		assertTrue(minimalGoodSet(new int[]{0}) == 1);
		assertTrue(minimalGoodSet(new int[]{1,1,2,3,
				 1,0,3,2,
				 2,0,1,3,
				 1,2,3,0}) == 2);
		assertTrue(minimalGoodSet(new int[]{0,1,2,3,
				 1,2,3,0,
				 2,3,0,1,
				 3,0,1,2}) == 1);
	}	
}
