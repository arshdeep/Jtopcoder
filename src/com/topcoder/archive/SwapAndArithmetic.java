package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class SwapAndArithmetic {
	boolean isConstAP(ArrayList<Integer> al, int[] x) {
		if (al.size() < 2) {
			return true;
		}
		int one = Math.abs(al.get(0) - al.get(1));
		
		for (int i = 2; i < al.size(); ++i) {
			if (Math.abs(al.get(i - 1) - al.get(i)) != one) {
				return false;
			}
		}
				
		return true;
	}
	public String able(int[] x)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int i : x) {
			al.add(i);
		}
		Collections.sort(al);
		
		if (isConstAP(al, x)) {
			return "Possible";
		}
				
		return "Impossible";
	}
	
	@Test
	public void test() {
		assertTrue(able(new int[]{7,3,11,5,1,9}).equals("Possible"));
	}


}
