package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FoxSequence {
	int getAp(int[] seq, int i, int j) {
		if (j - i + 1 < 2) {
			return seq[0];
		}
		int ap = seq[i + 1] - seq[i];
		
		for (int i1 = i + 2; i1 <= j; ++i1) {
			if (seq[i1] - seq[i1 - 1] != ap) {
				return Integer.MAX_VALUE;
			}
		}
		
		return ap;
	}
	public String isValid(int[] seq) {
		int i = 1;
		for (; i < seq.length; ++i) {
			int res = getAp(seq, 0, i);
			
			if (res == Integer.MAX_VALUE) {
				break;
			}
		}
		if (i == 0 || i == seq.length || getAp(seq, 0, i - 1) <= 0) {
			return "NO";
		}
		int i2 = i;
		for (; i2 < seq.length; ++i2) {
			int res = getAp(seq, i - 1, i2);
			if (res == Integer.MAX_VALUE) {
				break;
			}
		}
		if (i2 == i || i2 == seq.length || getAp(seq, i - 1, i2 - 1) >= 0) {
			return "NO";
		}
		
		int i3 = i2;
		for (; i3 < seq.length; ++i3) {
			if (seq[i3 - 1] != seq[i3]) {
				break;
			}
		}
		if (i3 == seq.length) {
			return "NO";
		}

		int i4 = i3;
		for (; i4 < seq.length; ++i4) {
			int res = getAp(seq, i3 - 1, i4);
			if (res == Integer.MAX_VALUE) {
				break;
			}
		}
		if (i4 == i3 || i4 == seq.length || getAp(seq, i3 - 1, i4 - 1) <= 0) {
			return "NO";
		}
		int i5 = i4;
		for (; i5 < seq.length; ++i5) {
			int res = getAp(seq, i4 - 1, i5);
			if (res == Integer.MAX_VALUE) {
				break;
			}
		}
		if (i5 == i4 || i5 != seq.length  || getAp(seq, i4 - 1, i5 - 1) >= 0) {
			return "NO";
		}

		return "YES";
	}
	@Test
	public void test() {
		assertTrue(isValid(new int[]{3,6,9,1,9,5,1}).equals("YES"));
		assertTrue(isValid(new int[]{1,2,3,2,1,2,3,2,1,2,3,2,1}).equals("NO"));
		assertTrue(isValid(new int[]{1,3,4,3,1,1,1,1,3,4,3,1}).equals("NO"));
		assertTrue(isValid(new int[]{1,3,5,7,5,3,1,1,1,3,5,7,5,3,1}).equals("YES"));
	}
}
