package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class Xylophone {
	public int countKeys(int[] keys)
	{
		HashSet<Character> hs = new HashSet<Character>();
		
		char[] ch = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		
		for(int i : keys) {
			hs.add(ch[(i - 1) % 7]);
		}
		
		return hs.size();
	}
	@Test
	public void test() {
		assertTrue(countKeys(new int[]{1,8,3}) == 2);
	}
}
