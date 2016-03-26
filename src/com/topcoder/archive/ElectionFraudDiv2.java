package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ElectionFraudDiv2 {
	public String IsFraudulent(int[] percentages) {
		int sum = 0;
		int count = 0;
		for (int no : percentages) {
			if (sum > 0) {
				++count;
			}
			sum += no;
		}
		
		if (sum == 100) {
			return "NO";
		}
		if (sum > 100) {
			if (sum - count *0.5 > 100) {
				return "NO";
			}

		}
		else {
			if (sum + count *0.5 > 100) {
				return "NO";
			}
		}
		return "YES";
	}
	
	@Test
	public void test() {
		assertTrue( IsFraudulent(new int[]{40, 0, 33, 28}).equals("NO") );
		assertTrue( IsFraudulent(new int[]{34, 34, 34}).equals("YES") );
		assertTrue( IsFraudulent(new int[]{12, 12, 12, 12, 12, 12, 12, 12}).equals("YES") );
		assertTrue( IsFraudulent(new int[]{13, 13, 13, 13, 13, 13, 13, 13}).equals("NO") );
		assertTrue( IsFraudulent(new int[]{0, 1, 100}).equals("NO") );
		assertTrue( IsFraudulent(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8}).equals("NO") );
	}
}
