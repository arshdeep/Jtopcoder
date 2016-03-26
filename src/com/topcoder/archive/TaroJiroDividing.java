package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class TaroJiroDividing {
	public int getNumber(int A, int B) {
		int res = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(A);
		
		while ((A % 2) == 0) {
			A /= 2;
			hs.add(A);
		}

		while ((B % 2) == 0) {
			if (hs.contains(B)) {
				++res;
			}
			B /= 2;
		}
		if (hs.contains(B)) {
			++res;
		}
		
		return res;
	}
	@Test
	public void test(){
		assertTrue( getNumber(8, 4) == 3 );
	}
}
