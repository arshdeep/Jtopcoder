package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TheNumberGameDivTwo {
	Boolean[] memo;
	boolean solve(int n) {
		if (memo[n] != null) {
			return memo[n];
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int i = 2; i <= (int)Math.sqrt(n) + 1; ++i) {
			if (n % i == 0 && i != n) {
				al.add(i);
			}
		}
		
		for (int d : al) {
			if (!solve(n - d)) {
				return memo[n] = true;
			}
		}
		
		return memo[n] = false;
	}
	public String find(int n) {
		memo = new Boolean[n + 1];

		solve(n);

		return memo[n] ? "John" : "Brus";
	}
	
	@Test
	public void test() {
		assertTrue( find(6).equals("John") );
		assertTrue( find(128).equals("Brus") );
		assertTrue( find(747).equals("Brus") );
		
		assertTrue( find(2).equals("Brus") );
		
	}
}
