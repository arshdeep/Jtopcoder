package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SegmentsAndPoints {
	public String isPossible(int[] p, int[] l, int[] r) {
		Arrays.sort(p);
		
		for (int  i = 0 ; i < l.length; ++i) {
			for (int j = i + 1; j < l.length; ++j) {
				if (r[i]> r[j]) {
					int t = l[i];
					l[i] = l[j];
					l[j] = t;
					
					t = r[i];
					r[i] = r[j];
					r[j] = t;
				}
			}
		}
		
		boolean seen[] = new boolean[l.length];
		
		for (int  i = 0 ; i < p.length; ++i) {
			boolean match = false;
			for (int j = 0; j < l.length; ++j) {
				if (!seen[j] && l[j] <= p[i] && r[j] >= p[i]) {
					seen[j] = true;
					match = true;
					break;
				}
			}
			
			if (!match) {
				return "Impossible";
			}
		}
		
		for (boolean b : seen) {
			if (!b) {
				return "Impossible";
			}
		}
		
		return "Possible";
	}
	@Test
	public void test() {
		assertTrue( isPossible(new int[]{0, 1, 2}, new int[]{0, 0, 1}, new int[]{1, 2, 1}).equals("Possible") );
		assertTrue( isPossible(new int[]{1,2}, new int[]{0,0}, new int[]{1,3}).equals("Possible") );
	}	
}
