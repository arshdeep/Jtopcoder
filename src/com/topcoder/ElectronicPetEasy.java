package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class ElectronicPetEasy {
	public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < t1; ++i) {
			if (!hs.contains(st1 + i * p1) )
				hs.add(st1 + + i * p1);
		}
		
		for (int i = 0; i < t2; ++i) {
			if (!hs.contains(st2 + i * p2) )
				hs.add(st2 + i * p2);
			else
				return "Difficult";
		}
		
		return "Easy";
	}
	
	@Test
	public void test1()
	{
		assertTrue( isDifficult(3, 3, 3, 5, 2, 3).equals("Difficult") );
	}
}
