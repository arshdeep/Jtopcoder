package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class LittleElephantAndIntervalsDiv2 {
	public int getNumber(int M, int[] L, int[] R) {
		HashSet<String> hs = new HashSet<String>();
		
		for (int mask = 0; mask < (1<<L.length); ++mask) {
			char[] buf = new char[M];
			
			Arrays.fill(buf, 'W');
			for (int i = 0; i < L.length; ++i) {
				if ((mask & (1 <<i)) != 0) {
					Arrays.fill(buf, L[i] - 1, R[i], 'B');
				}
				else {
					Arrays.fill(buf, L[i] - 1, R[i], 'W');
				}

			}
			hs.add(String.valueOf(buf));
		}
		return hs.size();		

	}
	@Test
	public void test(){
		assertTrue( getNumber(3, new int[]{1,1,2}, new int[]{3,1,3}) == 4);
		assertTrue( getNumber(42, new int[]{5, 23, 4, 1, 15, 2, 22, 26, 13, 16},
				new int[]{30, 41, 17, 1, 21, 6, 28, 30, 15, 19}) == 512);

		assertTrue( getNumber(4, new int[]{1,2,3}, new int[]{1,2,3}) == 8);
	}
}	
